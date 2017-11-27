import lejos.robotics.subsumption.Behavior;

public class White implements Behavior {

	@Override
	public boolean takeControl() {
		return (Forklift.scanZone.readValue() >= (Forklift.FloorColours[1] - 10) && Forklift.scanZone.readValue() <= (Forklift.FloorColours[1] + 10) && Forklift.FollowingLine && !Forklift.PayloadLoaded);
	}

	@Override
	public void action() {
		Forklift.pilot.rotate(-3);

	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
