import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.robotics.subsumption.Behavior;

public class DetectBox implements Behavior {

	@Override
	public boolean takeControl() {
		return (Forklift.boxTouch.isPressed() && Forklift.BoxQR == 0);
	}

	@Override
	public void action() {
		Forklift.FollowingLine = false;
		Motor.B.setSpeed(50);
		Motor.B.rotate(-360);
		Forklift.pilot.rotate(-90);
		byte[] buffer = new byte[1];
		if (Forklift.connection != null) {
			if (Forklift.connection.available() > 0) {
				Forklift.connection.read(buffer, 30);
//				String BoxColour = new String(buffer);
				Forklift.BoxQR = buffer[0];
				LCD.drawString("B:"+Forklift.BoxQR, 0, 4);
				
			}
		}
	}

	@Override
	public void suppress() {}
}