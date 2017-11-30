import lejos.robotics.subsumption.Behavior;

public class Black implements Behavior {

	@Override
	public boolean takeControl() {
		return (Forklift.scanZone.readNormalizedValue() >= (Forklift.FloorColours[0] - 20) && Forklift.scanZone.readNormalizedValue() <= (Forklift.FloorColours[0] + 20) && Forklift.FollowingLine && !Forklift.PayloadLoaded);
	}

	@Override
	public void action() {
		Forklift.pilot.forward();

	}

	@Override
	public void suppress() {

	}

}
