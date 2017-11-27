import lejos.robotics.subsumption.Behavior;

public class Black implements Behavior {

	@Override
	public boolean takeControl() {
		return (Forklift.scanZone.readValue() >= (Forklift.FloorColours[0] - 10) && Forklift.scanZone.readValue() <= (Forklift.FloorColours[0] + 10) && Forklift.FollowingLine && !Forklift.PayloadLoaded);
	}

	@Override
	public void action() {
		Forklift.pilot.travel(10);

	}

	@Override
	public void suppress() {

	}

}
