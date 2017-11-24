import lejos.robotics.subsumption.Behavior;

public class DetectRedBox implements Behavior {

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return ((Forklift.scanBox.readValue() >= (Forklift.FloorColours[4] - 3) && Forklift.scanBox.readValue() <= (Forklift.FloorColours[4] + 3))) && Forklift.boxTouch.isPressed() ;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		Forklift.RedBox = true;

	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
