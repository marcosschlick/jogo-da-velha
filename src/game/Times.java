package game;

import java.util.Random;
import java.util.Timer;

public class Times extends Timer {

	private Random ramdom = new Random();
	private int time = ramdom.nextInt(2);

	public int getTime() {
		return this.time;
	}

	public void toggle() {
		if (this.time == 1) {
			this.time = 0;
		} else if (this.time == 0) {
			this.time = 1;
		}
	}

}