import lejos.robotics.subsumption.Behavior;

public class DetectBlueBox implements Behavior {

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return ((Forklift.scanBox.readValue() >= (Forklift.FloorColours[3] - 3) && Forklift.scanBox.readValue() <= (Forklift.FloorColours[3] + 3))) && Forklift.boxTouch.isPressed() ;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		Forklift.BlueBox = true;

	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
