import lejos.robotics.subsumption.Behavior;

public class FindingLine implements Behavior {
	final static float BOX_DISTANCE = 30; //To be confirmed
	final static float TURN = 90;
	final static int ROTATE_SPEED = 360;

	@Override
	public boolean takeControl() {
		return (Forklift.scanDistance.getDistance() <=BOX_DISTANCE && !Forklift.boxTouch.isPressed());
	}

	@Override
	public void action() {
		Forklift.pilot.setRotateSpeed(ROTATE_SPEED);
		Forklift.pilot.stop();
		Forklift.pilot.rotate(TURN);

	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
