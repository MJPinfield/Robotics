import lejos.robotics.subsumption.Behavior;

public class FollowLine implements Behavior {

	@Override
	public boolean takeControl() {
		if(!Forklift.boxTouch.isPressed() && Forklift.scanZone.readValue() <= Forklift.FloorColours.get("Black")) {
			return true;
		} else if(Forklift.FoundLine) {
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public void action() {
		if(Forklift.FoundLine) {
			if(Forklift.scanZone.readValue() <= Forklift.FloorColours.get("Black")) {
				Forklift.pilot.rotate(20, true);
			} else {
				Forklift.pilot.rotate(-20, true);
			}
		}
		
			
	}

	@Override
	public void suppress() {}
}
