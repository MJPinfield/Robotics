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
	public static boolean NotOnLine = false;
	public static boolean GreenFloor = false;
	public static boolean RedFloor = false;
	public static boolean BlueFloor = false;
	public static boolean GreenBox = false; 
	public static boolean RedBox = false;
	public static boolean BlueBox = false;
	// 1 = black, 2 = white, 3 = blue, 4 = red, 5 = green
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
	
		Behavior b1 = new Trundle();
	    Behavior b2 = new TurnLeft();
	    Behavior b3 = new DetectLine();
	    Behavior b4 = new Black(); 
	    Behavior b5 = new White();
	    Behavior b6 = new DetectBox();
	    //Behavior b7 = new DetectWhite();
	   // Behavior b8 = new DetectGreenBox();
	   // Behavior b9 = new DetectRedBox();
	   // Behavior b10 = new DetectBlueBox();
	   // Behavior b11 = new DetectGreenFloor();
	   // Behavior b12 = new DetectRedFloor();
	    //Behavior b13 = new DetectBlueFloor();
	    
	    Behavior [] behaviours = {b1, b2, b3, b4, b5, b6};
	    Arbitrator arbitrator = new Arbitrator(behaviours);
	    arbitrator.start();
	}
}



