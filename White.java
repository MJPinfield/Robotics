import lejos.robotics.subsumption.Behavior;

public class White implements Behavior {

	@Override
	public boolean takeControl() {
		return (Forklift.scanZone.readValue() >= (Forklift.FloorColours[1] - 5) && Forklift.scanZone.readValue() <= (Forklift.FloorColours[1] + 5)) && Forklift.FollowingLine;
	}

	@Override
	public void action() {
		Forklift.pilot.rotate(-10);

	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
