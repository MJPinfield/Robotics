import lejos.robotics.subsumption.Behavior;

public class DetectGreenFloor implements Behavior {

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return ((Forklift.scanZone.readValue() >= (Forklift.FloorColours[5] - 3) && Forklift.scanZone.readValue() <= (Forklift.FloorColours[5] + 3))) && Forklift.boxTouch.isPressed() ;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		Forklift.GreenFloor = true;

	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
