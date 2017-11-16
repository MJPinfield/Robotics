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
	final static float MOTOR_SPEED = 360; //to be confirmed
	final static float SCANDROPZONE_WHITE = 50;
	final static float ROTATE = 10;
	public static DifferentialPilot pilot = new DifferentialPilot(WHEEL_DIAMETER, AXEL_LENGTH, Motor.A, Motor.C);
	public static LightSensor scanBox = new LightSensor(SensorPort.S3, true);
	public static LightSensor scanDropZone = new LightSensor(SensorPort.S4, true);
	public static UltrasonicSensor scanDistance = new UltrasonicSensor(SensorPort.S1);
	public static TouchSensor boxTouch = new TouchSensor(SensorPort.S2);

	
	public static void main(String[] args) {
		
		
		Behavior b1 = new FindingLine();
	    Behavior b2 = new FollowLine();
	    Behavior b3 = new PickUp();
	    Behavior b4 = new FindZone();
	    Behavior b5 = new DropZone();
	    Behavior b6 = new LowBattery();
	    Behavior b7 = new CarStall();
	    Behavior b8 = new Trundle();
	    Behavior [] behaviours = {b1, b2, b3, b4, b5, b6, b7, b8};
	    Arbitrator arbitrator = new Arbitrator(behaviours);
	    arbitrator.start();
		
		
		
		
	}
}