package jogo;
import java.util.Random;

public class Tempo {

	Random ramdom = new Random();

	int tempo = ramdom.nextInt(2);

	public int obterTempo() {
		return this.tempo;
	}

	public void alterar() {
		if (this.tempo == 1) {

			this.tempo = 0;

		} else if (this.tempo == 0) {

			this.tempo = 1;
		}

	}

}
