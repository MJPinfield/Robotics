 import lejos.robotics.subsumption.Behavior;

public class TurnLeft implements Behavior {
	public static int ROTATION = 90;
	public static int WALL_DISTANCE = 20;

	@Override
	public boolean takeControl() {
		return (Forklift.scanDistance.getDistance() <= WALL_DISTANCE);
	}

	@Override
	public void action() {
		Forklift.pilot.stop();
		Forklift.pilot.rotate(ROTATION);

	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
