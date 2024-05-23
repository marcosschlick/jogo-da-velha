package jogo;

public class jogador {
	String nome;
	char simb;
	boolean vencedor = false;

	jogador(String nome, char s) {
		this.nome = nome;
		this.simb = s;
	}

	void marcar(char matriz[][], int a, int b) {
		if (matriz[a][b] == '?') {
			matriz[a][b] = jogador.this.simb;
		} else {
			System.out.println("Jogador " + jogador.this.simb + " você perdeu a vez.");
		}
	}
}