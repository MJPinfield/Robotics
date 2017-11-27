import lejos.robotics.subsumption.Behavior;

public class Trundle implements Behavior {
	 //to be confirmed

	@Override
	public boolean takeControl() { return (!Forklift.FollowingLine); }

	@Override
	public void action() { Forklift.pilot.forward(); }

	@Override
	public void suppress() {}
}
