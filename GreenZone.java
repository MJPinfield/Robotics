import lejos.nxt.Motor;
import lejos.robotics.subsumption.Behavior;

public class GreenZone implements Behavior {

	@Override
	public boolean takeControl() {
		return ((Forklift.scanZone.readValue() >= (Forklift.FloorColours[4] - 3) && Forklift.scanZone.readValue() <= (Forklift.FloorColours[4] + 3) && 
				(Forklift.scanBox.readValue() >= (Forklift.BoxColours[4] - 3) && Forklift.scanBox.readValue() <= (Forklift.BoxColours[4] + 3)) && Forklift.PayloadLoaded));
	}

	@Override
	public void action() {
		Forklift.pilot.stop();
		Motor.B.rotate(360);
		Forklift.pilot.travel(-100);
		Forklift.pilot.rotate(-90);
		Forklift.PayloadLoaded = false;

	}

	@Override
	public void suppress() {}

}
