import lejos.robotics.subsumption.Behavior;

public class White implements Behavior {

	@Override
	public boolean takeControl() {
		return (Forklift.scanZone.readNormalizedValue() >= (Forklift.FloorColours[1] - 20) && Forklift.scanZone.readNormalizedValue() <= (Forklift.FloorColours[1] + 20) && Forklift.FollowingLine && !Forklift.PayloadLoaded);
	}

	@Override
	public void action() {
		Forklift.pilot.stop();
		Forklift.pilot.rotate(-5);

	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
