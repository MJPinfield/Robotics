import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.nxt.comm.BTConnection;
import lejos.nxt.comm.Bluetooth;
import lejos.nxt.comm.NXTConnection;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

class Forklift {
	 //to be confirmed
	
	public static DifferentialPilot pilot = new DifferentialPilot(Config.WHEEL_DIAMETER, Config.AXEL_LENGTH, Motor.A, Motor.C);
	public static LightSensor scanZone = new LightSensor(SensorPort.S2, true);
	public static UltrasonicSensor scanDistance = new UltrasonicSensor(SensorPort.S1);
	public static TouchSensor boxTouch = new TouchSensor(SensorPort.S4);
	// 0 = black, 1 = white - Array
	// 0 = Red, 1 = Green, 2 = Yellow - QR Code
	public static int[] FloorColours = new int[2];
	//currentQR stores the current QR on the fork lift, 0=None, 1=Red, 2=Green, 3=Yellow/Blue
	public static int BoxQR = 0;
	public static BTConnection connection = null;
	public static boolean PayloadLoaded = false;
	public static boolean FollowingLine = false;
	public static boolean InPlace = false;
	
	public static void CalibrateLSensor(LightSensor sensor, String area) {
		String[] ColourNames = {"Black", "White"};
		for(int i = 0; i < ColourNames.length; i++) {
			LCD.clear();
			LCD.drawString(area + " Sensor", 0, 0, true);
			LCD.drawString(ColourNames[i], 0, 1);
			int temp_value = 0;
			try {
				Button.ENTER.waitForPressAndRelease();
				for(int j = 0; j<4;j++) {
					temp_value += scanZone.readNormalizedValue();
					Delay.msDelay(500);
				}
				temp_value /= 4;
				if(area.equals("Floor")) { FloorColours[i] = temp_value; }
			} catch(Exception ex) {}
		}
	}
	
	public static void main(String[] args) {
		LCD.drawString("Waiting for BT..", 0, 0);
		Forklift.connection = Bluetooth.waitForConnection(0,  NXTConnection.RAW);
		LCD.clear();
		CalibrateLSensor(scanZone, "Floor");
		
		pilot.setTravelSpeed(Config.TRAVEL_SPEED);
		pilot.setRotateSpeed(Config.ROTATE_SPEED);
	
		Behavior [] behaviours = {
			new Trundle(), 
			new DetectLine(), 
			new Black(), 
			new White(), 
			new DetectBox(), 
			new TurnLeft(), 
			//new DetectFloor(),  
			new DropBox(),
			new LowBattery()
		};
	    Arbitrator arbitrator = new Arbitrator(behaviours);
	    
	    LCD.clear();
	    LCD.drawString("Georgie", 0, 0);
	    LCD.drawString("Version 1.0.3", 0, 1);
	    Button.ENTER.waitForPressAndRelease();
	    
	    arbitrator.start();
	}
	
}



