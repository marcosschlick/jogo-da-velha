package jogo;

import java.util.Scanner;

public class jogo {

	public static void main(String[] args) {
		int vez = 0;
		Scanner enter = new Scanner(System.in);
		regras regras = new regras();
		tabuleiro tabuleiro = new tabuleiro();
		tabuleiro.fill(tabuleiro.matriz);
		System.out.print("Jogador X digite o seu nome: ");
		String nomex = enter.nextLine();
		jogador jx = new jogador(nomex, 'X');
		System.out.print("Jogador O digite o seu nome: ");
		String nomeo = enter.nextLine();
		jogador jo = new jogador(nomeo, 'O');
		while (regras.fim(tabuleiro.matriz) == false) {
			if (vez == 0) {
				System.out.println();
				tabuleiro.toString(tabuleiro.matriz);
				System.out.println(jx.nome + " é sua vez, digite as cordenadas: ");
				System.out.print("Fileira: ");
				int xX = enter.nextInt();
				System.out.print("Coluna: ");
				int yX = enter.nextInt();
				jx.marcar(tabuleiro.matriz, (xX - 1), (yX - 1));
				System.out.println();
				vez++;
			} else if (vez == 1) {
				tabuleiro.toString(tabuleiro.matriz);
				System.out.println(jo.nome + " é sua vez, digite as cordenadas: ");
				System.out.print("Fileira: ");
				int xO = enter.nextInt();
				System.out.print("Coluna: ");
				int yO = enter.nextInt();
				jo.marcar(tabuleiro.matriz, (xO - 1), (yO - 1));
				vez = 0;
			}
		}
		switch (regras.win) {
		case 'X':
			System.out.println("Parabéns " + jx.nome + ", você ganhou!");
			break;
		case 'O':
			System.out.println("Parabéns " + jo.nome + ", você ganhou!");
			break;
		default:
			System.out.println("DEU VELHA MUAHAHAHAHAH");
		}
		enter.close();
	}
}