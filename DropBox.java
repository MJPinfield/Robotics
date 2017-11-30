import lejos.nxt.Motor;
import lejos.robotics.subsumption.Behavior;

public class DropBox implements Behavior {

	@Override
	public boolean takeControl() {
		return Forklift.InPlace;
	}

	@Override
	public void action() {
		Forklift.pilot.stop();
		Motor.B.rotate(360);
		Forklift.pilot.travel(-100);
		Forklift.pilot.rotate(-90); 
		
		Forklift.PayloadLoaded = false;
		Forklift.BoxQR = 0;
		Forklift.FollowingLine = false;
		Forklift.InPlace = false;
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
