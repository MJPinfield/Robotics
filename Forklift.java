import java.util.HashMap;
import java.util.Map;

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

class Forklift {
	final static float WHEEL_DIAMETER = 56;
	final static float AXEL_LENGTH = 115; //to be confirmed
	
	public static DifferentialPilot pilot = new DifferentialPilot(WHEEL_DIAMETER, AXEL_LENGTH, Motor.A, Motor.C);
	public static LightSensor scanBox = new LightSensor(SensorPort.S3, true);
	public static LightSensor scanZone = new LightSensor(SensorPort.S2, true);
	public static UltrasonicSensor scanDistance = new UltrasonicSensor(SensorPort.S1);
	public static TouchSensor boxTouch = new TouchSensor(SensorPort.S4);
	public static Map<String, Integer> FloorColours = new HashMap<String, Integer>();
	public static Map<String, Integer> BoxColours = new HashMap<String, Integer>();
	public static boolean FoundLine = false;
	

	private static void CalibrateColours(Map<String, Integer> ColourMap, String level, LightSensor sensor) {
		String[] ColourNames = {"Black", "Red", "Green", "Blue"};
		for(String colour: ColourNames) {
			LCD.clear();
			LCD.drawString(level + " Sensor", 0, 0, true);
			LCD.drawString(colour, 0, 1);
			Button.ENTER.waitForPressAndRelease();
			ColourMap.put(colour, sensor.readValue());
		}
	}
	
	public static void main(String[] args) {
		
		CalibrateColours(FloorColours, "Floor", scanZone);
		CalibrateColours(BoxColours, "Box", scanBox);
		
		
	    Behavior b1 = new Trundle();
	    Behavior b2 = new TurnLeft();
	    Behavior b3 = new FollowLine();
	    
	    Behavior [] behaviours = {b1, b2, b3};
	    Arbitrator arbitrator = new Arbitrator(behaviours);
	    arbitrator.start();
	}
}