import lejos.robotics.subsumption.Behavior;

public class DetectLine implements Behavior {

	@Override
	public boolean takeControl() {
		return (Forklift.scanZone.readNormalizedValue() >= (Forklift.FloorColours[0] - 20) && Forklift.scanZone.readNormalizedValue() <= (Forklift.FloorColours[0] + 20 )) && !Forklift.boxTouch.isPressed();
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
