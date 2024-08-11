package game;

import java.awt.Color;

public class Condicoes {
	private boolean over = false;
	private String vencedor = "";
	private Grid[] linhaVencedora = new Grid[3];

	public boolean isOver() {
		return this.over;
	}

	public String getVencedor() {
		return this.vencedor;
	}

	public Grid[] getLinhaVencedora() {
		return this.linhaVencedora;
	}

	public void paintWin(Grid[] linhaVencedora, Color color) {
		linhaVencedora[0].setBackground(color);
		linhaVencedora[1].setBackground(color);
		linhaVencedora[2].setBackground(color);
	}

	public void pintarVelha(Grid[] posicoes) {
		for (int i = 0; i < 9; i++) {
			posicoes[i].setBackground(Color.red);
		}
	}

	public void check(Grid[] array) {
		conditionDraw(array);
		conditionWin(array, 0, 1, 2);
		conditionWin(array, 3, 4, 5);
		conditionWin(array, 6, 7, 8);
		conditionWin(array, 0, 3, 6);
		conditionWin(array, 1, 4, 7);
		conditionWin(array, 2, 5, 8);
		conditionWin(array, 0, 4, 8);
		conditionWin(array, 2, 4, 6);

	}

	public void conditionWin(Grid[] array, int a, int b, int c) {
		if (array[a].isMarked() & array[a].getSymbol() == array[b].getSymbol()
				& array[b].getSymbol() == array[c].getSymbol()) {
			this.over = true;
			this.vencedor = array[a].getSymbol();
			this.linhaVencedora[0] = array[a];
			this.linhaVencedora[1] = array[b];
			this.linhaVencedora[2] = array[c];
		}

	}

	public void conditionDraw(Grid[] a) {
		if (a[0].isMarked() & a[1].isMarked() & a[2].isMarked() & a[3].isMarked() & a[4].isMarked() & a[5].isMarked()
				& a[6].isMarked() & a[7].isMarked() & a[8].isMarked()) {
			this.over = true;
			this.vencedor = "";
		}
	}

}
