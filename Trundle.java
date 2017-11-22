import lejos.robotics.subsumption.Behavior;

public class Trundle implements Behavior {
	public static int TRAVEL_SPEED = 360; //to be confirmed

	@Override
	public boolean takeControl() {
		return true;
	}

	@Override
	public void action() {
		Forklift.pilot.setTravelSpeed(TRAVEL_SPEED);
		Forklift.pilot.forward();
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
