import lejos.robotics.subsumption.Behavior;

public class DetectBlueFloor implements Behavior {

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return ((Forklift.scanZone.readValue() >= (Forklift.FloorColours[3] - 3) && Forklift.scanZone.readValue() <= (Forklift.FloorColours[3] + 3))) && Forklift.boxTouch.isPressed() ;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		Forklift.BlueFloor = true;

	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
