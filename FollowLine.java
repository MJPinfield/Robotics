import lejos.robotics.subsumption.Behavior;

public class FollowLine implements Behavior {

	@Override
	public boolean takeControl() {
		return (Forklift.scanZone.readValue() <= Forklift.FloorColours.get("black") && !Forklift.boxTouch.isPressed());
	}

	@Override
	public void action() {
		while(!Forklift.boxTouch.isPressed())
		{
			if (Forklift.scanZone.readValue() <= Forklift.FloorColours.get("black"))
			{
				Forklift.pilot.rotate(-10);
			}
			else
			{
				Forklift.pilot.rotate(10);
				//Forklift.LineStatus = false;
			}
			
		}
		
			
	}

	@Override
	public void suppress() {}
}
