import lejos.robotics.subsumption.Behavior;

public class FindingLine implements Behavior {
	final static float BOX_DISTANCE = 3; //To be confirmed

	@Override
	public boolean takeControl() {
		return (Forklift.scanDistance.getDistance() <=BOX_DISTANCE && !Forklift.boxTouch.isPressed());
	}

	@Override
	public void action() {
		Forklift.pilot.stop();
		Forklift.pilot.rotate(90);

	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
