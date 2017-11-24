import lejos.robotics.subsumption.Behavior;

public class DetectWhite implements Behavior {

	@Override
	public boolean takeControl() {
		return (!((Forklift.scanBox.readValue() >= (Forklift.FloorColours[0] - 3)) && Forklift.scanBox.readValue() <= (Forklift.FloorColours[0] + 3)));
	}

	@Override
	public void action() {
		Forklift.NotOnLine = true;

	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
