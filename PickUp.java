import lejos.nxt.Motor;
import lejos.robotics.subsumption.Behavior;

public class PickUp implements Behavior {
	final static float PICKUP_SPEED = 50;
	final static int PICKUP_ROTATE = -360;

	@Override
	public boolean takeControl() {
		return (Forklift.scanDistance.getDistance() <= 10 && !Forklift.boxTouch.isPressed());
	}

	@Override
	public void action() {
		Forklift.pilot.stop();
		Motor.B.setSpeed(PICKUP_SPEED);
		Motor.B.backward();
	}

	@Override
	public void suppress() {

	}

}
