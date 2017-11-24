import lejos.nxt.Motor;
import lejos.robotics.subsumption.Behavior;

public class PickUp implements Behavior {

	@Override
	public boolean takeControl() {
		return (Forklift.boxTouch.isPressed());
	}

	@Override
	public void action() {
		Motor.C.setSpeed(50);
		Motor.C.rotate(360);
	}

	@Override
	public void suppress() {

	}

}
