import lejos.robotics.subsumption.Behavior;

public class FollowLine implements Behavior {

	@Override
	public boolean takeControl() {
		return (Forklift.scanDropZone.readValue() < Forklift.SCANDROPZONE_WHITE && !Forklift.boxTouch.isPressed());
	}

	@Override
	public void action() {
		while(!Forklift.boxTouch.isPressed())
		{
			Forklift.scanDropZone.setFloodlight(true);
			if (Forklift.scanDropZone.readValue() > Forklift.SCANDROPZONE_WHITE)
			{
				Forklift.pilot.rotate(-Forklift.ROTATE);
			}
			else
			{
				Forklift.pilot.rotate(Forklift.ROTATE);
			}
		}
		Forklift.scanDropZone.setFloodlight(false);
			
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
