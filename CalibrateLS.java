
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;

public class CalibrateLS {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LightSensor ls = new LightSensor(SensorPort.S2);
		LCD.clear();
		LCD.drawString("White?", 1, 1);
		int whiteValue = 0;
		try {
			Button.ENTER.waitForPressAndRelease();
			for (int i = 0; i < 4; i++) {
				whiteValue += ls.readValue();
				Delay.msDelay(500);
			}
			whiteValue = whiteValue / 4;
		} catch (Exception ex) {
		}
		LCD.drawString("White value: " + whiteValue, 1, 3);

		Button.ENTER.waitForPressAndRelease();
		LCD.clear();
		LCD.drawString("Black?", 1, 1);
		int blackValue = 0;
		try {
			Button.ENTER.waitForPressAndRelease();
			for (int i = 0; i < 4; i++) {
				blackValue += ls.readValue();
				Delay.msDelay(500);
			}
			blackValue = blackValue / 4;
		} catch (Exception ex) {
		}
		LCD.drawString("Black value: " + blackValue, 1, 3);
		Button.ENTER.waitForPressAndRelease();
		DifferentialPilot pilot = new DifferentialPilot(56, 140, Motor.A, Motor.C);
		pilot.setTravelSpeed(20);
		pilot.setRotateSpeed(20);
		while (true) {
			if (ls.readValue() >= (blackValue - 3) && ls.readValue() <= (blackValue + 3)) {
				pilot.travel(20);
			} else {
				int i = 0;
				while (!(ls.readValue() >= (blackValue - 3) && ls.readValue() <= (blackValue + 3))) {
					pilot.rotate(20);
				}
			}
		}
	}

}