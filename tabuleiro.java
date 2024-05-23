import java.util.Scanner;

public class tabuleiro {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);
		char t[][] = new char[3][3];
		int i = 0;
		int j = 0;
		int vez = 0;
		System.out.print("Primeiramente jogador X digite o seu nome: ");
		String nomeX = enter.nextLine();
		System.out.print("Agora jogador O digite o seu nome: ");
		String nomeO = enter.nextLine();

		jogador jX = new jogador(nomeX, 'X');
		jogador jO = new jogador(nomeO, 'O');

		for (j = 0; j < 3; j++) {
			for (i = 0; i < 3; i++) {
				t[i][j] = '?';
			}
			i = 0;
		}

		while (!condicao1(t, jX, jO) & !condicao2(t, jX, jO) & !condicao3(t, jX, jO) & !condicao4(t, jX, jO)
				& !condicao5(t, jX, jO) & !condicao6(t, jX, jO) & !condicao7(t, jX, jO) & !condicao8(t, jX, jO)
				& !velha(t)) {

			if (vez == 0) {
				toString(t);

				System.out.println(nomeX + " é sua vez, digite as cordenadas: ");
				System.out.print("Vertical: ");
				int xX = enter.nextInt();
				System.out.print("Horizontal: ");
				int yX = enter.nextInt();
				jX.marcar(t, xX, yX);

				System.out.println();
				vez++;
			} else if (vez == 1) {

				toString(t);

				System.out.println(nomeO + " é sua vez, digite as cordenadas: ");
				System.out.print("Vertical: ");
				int xO = enter.nextInt();
				System.out.print("Horizontal: ");
				int yO = enter.nextInt();
				jO.marcar(t, xO, yO);

				System.out.println();
				vez = 0;
			}
		}
		if (jX.vencedor == true) {
			System.out.println("Parabéns " + nomeX + " você venceu!");
		} else if (jO.vencedor == true) {
			System.out.println("Parabéns " + nomeO + " você venceu!");
		}
		if (velha(t)) {
			System.out.println("DEU VELHA!!!!!");
		}

	}

	static void toString(char matriz[][]) {

		for (int l = 0; l < matriz.length; l++) {

			for (int c = 0; c < matriz[0].length; c++) {
				System.out.print(matriz[l][c] + " ");
			}
			System.out.println();
		}
	}

	static boolean condicao1(char matriz[][], jogador jX, jogador jO) {
		if (matriz[0][0] == 'O' & matriz[0][1] == 'O' & matriz[0][2] == 'O') {
			jO.vencedor = true;
			return true;
		} else if (matriz[0][0] == 'X' & matriz[0][1] == 'X' & matriz[0][2] == 'X') {
			jX.vencedor = true;
			return true;
		} else {
			return false;
		}

	}

	static boolean condicao2(char matriz[][], jogador jX, jogador jO) {
		if (matriz[1][0] == 'O' & matriz[1][1] == 'O' & matriz[1][2] == 'O') {
			jO.vencedor = true;
			return true;
		} else if (matriz[1][0] == 'X' & matriz[1][1] == 'X' & matriz[1][2] == 'X') {
			jX.vencedor = true;
			return true;
		} else {
			return false;
		}

	}

	static boolean condicao3(char matriz[][], jogador jX, jogador jO) {
		if (matriz[2][0] == 'O' & matriz[2][1] == 'O' & matriz[2][2] == 'O') {
			jO.vencedor = true;
			return true;
		} else if (matriz[2][0] == 'X' & matriz[2][1] == 'X' & matriz[2][2] == 'X') {
			return true;
		} else {
			return false;
		}

	}

	static boolean condicao4(char matriz[][], jogador jX, jogador jO) {
		if (matriz[0][0] == 'O' & matriz[1][0] == 'O' & matriz[2][0] == 'O') {
			jO.vencedor = true;
			return true;
		} else if (matriz[0][0] == 'X' & matriz[1][0] == 'X' & matriz[2][0] == 'X') {
			jX.vencedor = true;
			return true;
		} else {
			return false;
		}

	}

	static boolean condicao5(char matriz[][], jogador jX, jogador jO) {
		if (matriz[0][1] == 'O' & matriz[1][1] == 'O' & matriz[2][1] == 'O') {
			jO.vencedor = true;
			return true;
		} else if (matriz[0][1] == 'X' & matriz[1][1] == 'X' & matriz[2][1] == 'X') {
			jX.vencedor = true;
			return true;
		} else {
			return false;
		}

	}

	static boolean condicao6(char matriz[][], jogador jX, jogador jO) {
		if (matriz[0][2] == 'O' & matriz[1][2] == 'O' & matriz[2][2] == 'O') {
			jO.vencedor = true;
			return true;
		} else if (matriz[0][2] == 'X' & matriz[1][2] == 'X' & matriz[2][2] == 'X') {
			jX.vencedor = true;
			return true;
		} else {
			return false;
		}

	}

	static boolean condicao7(char matriz[][], jogador jX, jogador jO) {
		if (matriz[0][0] == 'O' & matriz[1][1] == 'O' & matriz[2][2] == 'O') {
			jO.vencedor = true;
			return true;
		} else if (matriz[0][0] == 'X' & matriz[1][1] == 'X' & matriz[2][2] == 'X') {
			jX.vencedor = true;
			return true;
		} else {
			return false;
		}

	}

	static boolean condicao8(char matriz[][], jogador jX, jogador jO) {
		if (matriz[0][2] == 'O' & matriz[1][1] == 'O' & matriz[2][0] == 'O') {
			jO.vencedor = true;
			return true;
		} else if (matriz[0][2] == 'X' & matriz[1][1] == 'X' & matriz[2][0] == 'X') {
			jX.vencedor = true;
			return true;
		} else {
			return false;
		}

	}

	static boolean velha(char matriz[][]) {
		if ((matriz[0][0] == 'O' | matriz[0][0] == 'X') & (matriz[0][1] == 'O' | matriz[0][1] == 'X')
				& (matriz[0][2] == 'O' | matriz[0][2] == 'X') & (matriz[1][0] == 'O' | matriz[1][0] == 'X')
				& (matriz[1][1] == 'O' | matriz[1][1] == 'X') & (matriz[1][2] == 'O' | matriz[1][2] == 'X')
				& (matriz[2][0] == 'O' | matriz[2][0] == 'X') & (matriz[2][1] == 'O' | matriz[2][1] == 'X')
				& (matriz[2][2] == 'O' | matriz[2][2] == 'X')) {
			return true;
		} else {
			return false;
		}

	}

}

/*
 * imprimir tabuleiro
 * 
 * for (int l = 0; l < t.length; l++) { for (int c = 0; c < t[0].length; c++) {
 * System.out.print(t[l][c] + " "); } System.out.println(); }
 * 
 * 
 * 
 * [1][0] [2][1] [2][2]
 * 
 * [0][2] [1][1] [2][0]
 * 
 * 
 * 
 */