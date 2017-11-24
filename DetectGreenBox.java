import lejos.robotics.subsumption.Behavior;

public class DetectGreenBox implements Behavior {

	@Override
	public boolean takeControl() {
		return ((Forklift.scanBox.readValue() >= (Forklift.FloorColours[5] - 3) && Forklift.scanBox.readValue() <= (Forklift.FloorColours[5] + 3))) && Forklift.boxTouch.isPressed() ;
	}

	@Override
	public void action() {
		Forklift.GreenBox = true;
}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
