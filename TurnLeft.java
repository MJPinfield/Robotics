 import lejos.robotics.subsumption.Behavior;

public class TurnLeft implements Behavior {
	

	@Override
	public boolean takeControl() {
		return (Forklift.scanDistance.getDistance() <= Config.WALL_DISTANCE && !Forklift.FollowingLine);
	}

	@Override
	public void action() {
		Forklift.pilot.rotate(-Config.WALL_ROTATE);

	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
