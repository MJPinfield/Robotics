import lejos.nxt.LCD;
import lejos.robotics.subsumption.Behavior;

public class DetectFloor implements Behavior {

	@Override
	public boolean takeControl() {
		byte[] buffer = new byte[1];
		if(Forklift.BoxQR > 0 && Forklift.connection != null && Forklift.connection.available() > 0) {
			Forklift.connection.read(buffer, 1);
			LCD.drawString(("F:"+buffer[0]), 0, 5);
			
			return (buffer[0] > 0 && buffer[0] == Forklift.BoxQR);
		} 
		return false;
	}

	@Override
	public void action() { Forklift.InPlace = true; }

	@Override
	public void suppress() {}

}
