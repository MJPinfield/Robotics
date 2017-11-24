import lejos.nxt.Motor;
import lejos.robotics.subsumption.Behavior;

public class DetectBox implements Behavior {

	@Override
	public boolean takeControl() {
		return (Forklift.boxTouch.isPressed());
	}

	@Override
	public void action() {
		Forklift.FollowingLine = false;
		Motor.B.setSpeed(50);
		Motor.B.rotate(-360);

	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
