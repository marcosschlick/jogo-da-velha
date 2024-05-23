package jogo;

public class tabuleiro {
	char matriz[][] = new char[3][3];

	public void toString(char matriz[][]) {
		int i;
		int j;
		for (i = 0; i < matriz.length; i++) {
			for (j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void fill(char matriz[][]) {
		int i;
		int j;
		for (j = 0; j < 3; j++) {
			for (i = 0; i < 3; i++) {
				matriz[i][j] = '?';
			}
			i = 0;
		}
	}
}
