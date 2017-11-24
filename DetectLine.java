import lejos.robotics.subsumption.Behavior;

public class DetectLine implements Behavior {

	@Override
	public boolean takeControl() {
		return (Forklift.scanZone.readValue() >= (Forklift.FloorColours[0] - 5) && Forklift.scanZone.readValue() <= (Forklift.FloorColours[0] + 5 )) && !Forklift.boxTouch.isPressed();
	}

	@Override
	public void action() {
		Forklift.FollowingLine = true;

	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
