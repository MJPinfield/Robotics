import lejos.nxt.Motor;
import lejos.robotics.subsumption.Behavior;

public class DetectBox implements Behavior {

	@Override
	public boolean takeControl() {
		return (Forklift.boxTouch.isPressed() && !Forklift.PayloadLoaded);
	}

	@Override
	public void action() {
		Forklift.FollowingLine = false;
		Forklift.PayloadLoaded = true;
		Motor.B.setSpeed(50);
		Motor.B.rotate(-360);
		Forklift.pilot.rotate(-90);
	}

	@Override
	public void suppress() {}
}
