import lejos.robotics.subsumption.Behavior;

public class Trundle implements Behavior {

	@Override
	public boolean takeControl() {
		return (Forklift.scanDistance.getDistance() >= FindingLine.BOX_DISTANCE);
	}

	@Override
	public void action() {
		Forklift.pilot.forward();

	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
