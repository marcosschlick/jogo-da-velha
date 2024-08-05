package jogo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaPrincipal {
	Usuario user1 = new Usuario();
	Usuario user2 = new Usuario();
	public static Tempo tempo = new Tempo();

	public void principal(String nome1, String nome2) {
		Casa[] array = new Casa[9];

		user1.definirNome(nome1);
		user2.definirNome(nome2);

		JFrame tela = new JFrame("Jogo da velha");
		tela.setSize(700, 900);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setDefaultCloseOperation(3);

		JLabel legenda = new JLabel();
		legenda.setHorizontalAlignment(JLabel.CENTER);

		if (tempo.obterTempo() == 0) {
			legenda.setText(user1.obterNome() + " é sua vez de jogar");
			user1.definirSimbolo("X");
			user2.definirSimbolo("O");
		} else if (tempo.obterTempo() == 1) {
			legenda.setText(user2.obterNome() + " é sua vez de jogar");
			user1.definirSimbolo("O");
			user2.definirSimbolo("X");
		}

		legenda.setFont(new Font("", Font.BOLD, 30));
		legenda.setLocation(0, 0);
		legenda.setVisible(true);
		legenda.setSize(700, 200);
		tela.add(legenda);

		Casa c1 = new Casa(35, 240);
		c1.setText("1");
		adicionarCasa(c1, 1, tela, array, tempo, legenda, user1, user2);

		Casa c2 = new Casa(240, 240);
		c2.setText("2");
		adicionarCasa(c2, 2, tela, array, tempo, legenda, user1, user2);

		Casa c3 = new Casa(445, 240);
		c3.setText("3");
		adicionarCasa(c3, 3, tela, array, tempo, legenda, user1, user2);

		Casa c4 = new Casa(35, 445);
		c4.setText("4");
		adicionarCasa(c4, 4, tela, array, tempo, legenda, user1, user2);

		Casa c5 = new Casa(240, 445);
		c5.setText("5");
		adicionarCasa(c5, 5, tela, array, tempo, legenda, user1, user2);

		Casa c6 = new Casa(445, 445);
		c6.setText("6");
		adicionarCasa(c6, 6, tela, array, tempo, legenda, user1, user2);

		Casa c7 = new Casa(35, 650);
		c7.setText("7");
		adicionarCasa(c7, 7, tela, array, tempo, legenda, user1, user2);

		Casa c8 = new Casa(240, 650);
		c8.setText("8");
		adicionarCasa(c8, 8, tela, array, tempo, legenda, user1, user2);

		Casa c9 = new Casa(445, 650);
		c9.setText("9");
		adicionarCasa(c9, 9, tela, array, tempo, legenda, user1, user2);

		tela.setVisible(true);

	}

	public static void adicionarCasa(Casa c, int p, JFrame t, Casa[] a, Tempo tempo, JLabel legenda, Usuario user1,
			Usuario user2) {
		Condicoes condicao = new Condicoes();

		c.posicao = p;
		t.add(c);
		c.setVisible(true);
		a[c.posicao - 1] = c;
		c.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (condicao.fim != true) {
					if (tempo.obterTempo() == 0) {
						c.marcar(user1.obterSimbolo());
						legenda.setText(user2.obterNome() + " é sua vez de jogar");
						tempo.alterar();

					} else if (tempo.obterTempo() == 1) {
						c.marcar(user2.obterSimbolo());
						legenda.setText(user1.obterNome() + " é sua vez de jogar");
						tempo.alterar();

					}
				}
				condicao.checar(a);

				if (condicao.fim == true) {
					for (int i = 0; i < 9; i++) {
						a[i].setEnabled(false);

					}

					if (condicao.obterVencedor() == user1.obterSimbolo()) {
						legenda.setText(user1.obterNome() + " você ganhou");
						condicao.pintarVencedora(condicao.linhaVencedora);
						try {
							user1.adicionarVitoria(user1);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					} else if (condicao.obterVencedor() == user2.obterSimbolo()) {
						legenda.setText(user2.obterNome() + " você ganhou");
						condicao.pintarVencedora(condicao.linhaVencedora);
						try {
							user2.adicionarVitoria(user2);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (condicao.obterVencedor() == "") {
						legenda.setText("DEU VELHAAA!!! (nínguem recebe pontos");
						condicao.pintarVelha(a);

					}
				}

			}
		});
	}
}
