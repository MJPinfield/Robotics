import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

class Forklift {
	 //to be confirmed
	
	public static DifferentialPilot pilot = new DifferentialPilot(Config.WHEEL_DIAMETER, Config.AXEL_LENGTH, Motor.A, Motor.C);
	public static LightSensor scanBox = new LightSensor(SensorPort.S3, true);
	public static LightSensor scanZone = new LightSensor(SensorPort.S2, true);
	public static UltrasonicSensor scanDistance = new UltrasonicSensor(SensorPort.S1);
	public static TouchSensor boxTouch = new TouchSensor(SensorPort.S4);
	public static boolean FollowingLine = false;
	public static boolean PayloadLoaded = false;
	// 0 = black, 1 = white, 2 = blue, 3 = red, 4 = green
	public static int[] FloorColours = new int[5];
	public static int[] BoxColours = new int[5];

	public static void CalibrateSensor(LightSensor sensor, String area) {
		String[] ColourNames = {"Black", "White", "Red", "Green", "Blue"};
		for(int i = 0; i < ColourNames.length; i++) {
			LCD.clear();
			LCD.drawString(area + " Sensor", 0, 0, true);
			LCD.drawString(ColourNames[i], 0, 1);
			Button.ENTER.waitForPressAndRelease();
			if(area.equals("Floor")) { FloorColours[i] = scanZone.getLightValue(); } 
			else { BoxColours[i] = scanBox.getLightValue(); }
		}
		
	}
	
	public static void BetterCalibration(LightSensor sensor, String area) {
		String[] ColourNames = {"Black", "White", "Red", "Green", "Blue"};
		for(int i = 0; i < ColourNames.length; i++) {
			LCD.clear();
			LCD.drawString(area + " Sensor", 0, 0, true);
			LCD.drawString(ColourNames[i], 0, 1);
			int temp_value = 0;
			try {
				Button.ENTER.waitForPressAndRelease();
				for(int j = 0; j<4;j++) {
					temp_value += scanZone.readValue();
					Delay.msDelay(500);
				}
				temp_value /= 4;
				if(area.equals("Floor")) { FloorColours[i] = temp_value; }
				else { BoxColours[i] = temp_value; }
			} catch(Exception ex) {}
		}
	}
	
	public static void main(String[] args) {
		BetterCalibration(scanZone, "Floor");
		BetterCalibration(scanBox, "Box");
		
		pilot.setTravelSpeed(Config.TRAVEL_SPEED);
		pilot.setRotateSpeed(Config.ROTATE_SPEED);
		scanZone.setFloodlight(true);
		scanBox.setFloodlight(true);
	
		Behavior [] behaviours = {new Trundle(), new DetectLine(), new Black(), new White(), new DetectBox(), new TurnLeft(), new RedZone(), new GreenZone(), new BlueZone(), new LowBattery()};
	    Arbitrator arbitrator = new Arbitrator(behaviours);
	    
	    LCD.clear();
	    LCD.drawString("Georgie", 0, 0);
	    LCD.drawString("Version 1.0.2", 0, 1);
	    Button.ENTER.waitForPressAndRelease();
	    
	    arbitrator.start();
	}
}



