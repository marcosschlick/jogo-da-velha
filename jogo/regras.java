package jogo;

public class regras {
	char win = '?';

	boolean fileiraA(char matriz[][]) {
		if (matriz[0][0] == matriz[0][1] & matriz[0][0] == matriz[0][2] & matriz[0][0] != '?') {
			win = matriz[0][0];
			return true;
		} else {
			return false;
		}
	}

	boolean fileiraB(char matriz[][]) {
		if (matriz[1][0] == matriz[1][1] & matriz[1][0] == matriz[1][2] & matriz[1][0] != '?') {
			win = matriz[1][0];
			return true;
		} else {
			return false;
		}
	}

	boolean fileiraC(char matriz[][]) {
		if (matriz[2][0] == matriz[2][1] & matriz[2][0] == matriz[2][2] & matriz[2][0] != '?') {
			win = matriz[2][0];
			return true;
		} else {
			return false;
		}
	}

	boolean colunaA(char matriz[][]) {
		if (matriz[0][0] == matriz[1][0] & matriz[0][0] == matriz[2][0] & matriz[0][0] != '?') {
			win = matriz[0][0];
			return true;
		} else {
			return false;
		}
	}

	boolean colunaB(char matriz[][]) {
		if (matriz[0][1] == matriz[1][1] & matriz[0][1] == matriz[2][1] & matriz[0][1] != '?') {
			win = matriz[0][1];
			return true;
		} else {
			return false;
		}
	}

	boolean colunaC(char matriz[][]) {
		if (matriz[0][2] == matriz[1][2] & matriz[0][2] == matriz[2][2] & matriz[0][2] != '?') {
			win = matriz[0][2];
			return true;
		} else {
			return false;
		}
	}

	boolean diagonalA(char matriz[][]) {
		if (matriz[0][0] == matriz[1][1] & matriz[0][0] == matriz[2][2] & matriz[0][0] != '?') {
			win = matriz[0][0];
			return true;
		} else {
			return false;
		}
	}

	boolean diagonalB(char matriz[][]) {
		if (matriz[0][2] == matriz[1][1] & matriz[0][2] == matriz[2][0] & matriz[0][2] != '?') {
			win = matriz[0][0];
			return true;
		} else {
			return false;
		}
	}

	boolean velha(char matriz[][]) {
		if (matriz[0][0] != '?' & matriz[0][1] != '?' & matriz[0][2] != '?' & matriz[1][0] != '?' & matriz[1][1] != '?'
				& matriz[1][2] != '?' & matriz[2][0] != '?' & matriz[2][1] != '?' & matriz[2][2] != '?') {
			return true;
		} else {
			return false;
		}

	}

	boolean fim(char matriz[][]) {
		if (fileiraA(matriz) | fileiraB(matriz) | fileiraC(matriz) | colunaA(matriz) | colunaB(matriz) | colunaC(matriz)
				| diagonalA(matriz) | diagonalB(matriz) | velha(matriz)) {
			return true;
		} else {
			return false;
		}
	}

}
