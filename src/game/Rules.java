package game;

import java.awt.Color;

public class Rules {
	private boolean over = false;
	private String winner = "";
	private Grid[] winningLine = new Grid[3];

	public boolean isOver() {
		return this.over;
	}

	public String getWinner() {
		return this.winner;
	}

	public Grid[] getWinningLine() {
		return this.winningLine;
	}

	public void paintWin(Grid[] winningLine, Color color) {
		winningLine[0].setBackground(color);
		winningLine[1].setBackground(color);
		winningLine[2].setBackground(color);
	}

	public void paintDraw(Grid[] array) {
		for (int i = 0; i < 9; i++) {
			array[i].setBackground(Color.red);
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
			this.winner = array[a].getSymbol();
			this.winningLine[0] = array[a];
			this.winningLine[1] = array[b];
			this.winningLine[2] = array[c];
		}

	}

	public void conditionDraw(Grid[] a) {
		if (a[0].isMarked() & a[1].isMarked() & a[2].isMarked() & a[3].isMarked() & a[4].isMarked() & a[5].isMarked()
				& a[6].isMarked() & a[7].isMarked() & a[8].isMarked()) {
			this.over = true;
			this.winner = "";
		}
	}

}
