import lejos.robotics.subsumption.Behavior;

public class DetectRedFloor implements Behavior {

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return ((Forklift.scanZone.readValue() >= (Forklift.FloorColours[4] - 3) && Forklift.scanZone.readValue() <= (Forklift.FloorColours[4] + 3))) && Forklift.boxTouch.isPressed() ;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		Forklift.RedFloor = true;

	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
