import lejos.robotics.subsumption.Behavior;

public class FollowLine implements Behavior {

	@Override
	public boolean takeControl() {
		return (!Forklift.boxTouch.isPressed() && Forklift.scanZone.readValue() <= Forklift.FloorColours.get("Black"));
	}

	@Override
	public void action() {
		
		 		
			
	}

	@Override
	public void suppress() {

	}

}
