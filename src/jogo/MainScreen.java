package jogo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainScreen {
	User user1 = new User();
	User user2 = new User();
	public static Timer time = new Timer();

	public void execute(String nome1, String nome2) {
		Grid[] array = new Grid[9];

		user1.setName(nome1);
		user2.setName(nome2);

		JFrame tela = new JFrame("Jogo da velha");
		tela.setSize(700, 900);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setDefaultCloseOperation(3);

		JLabel legenda = new JLabel();
		legenda.setHorizontalAlignment(JLabel.CENTER);

		if (time.getTime() == 0) {
			legenda.setText(user1.getName() + " é sua vez de jogar");
			user1.setSymbol("X");
			user2.setSymbol("O");
		} else if (time.getTime() == 1) {
			legenda.setText(user2.getName() + " é sua vez de jogar");
			user1.setSymbol("O");
			user2.setSymbol("X");
		}

		legenda.setFont(new Font("", Font.BOLD, 30));
		legenda.setLocation(0, 0);
		legenda.setVisible(true);
		legenda.setSize(700, 200);
		tela.add(legenda);

		Grid c1 = new Grid(35, 240);
		c1.setText("1");
		addGrid(c1, 1, tela, array, time, legenda, user1, user2);

		Grid c2 = new Grid(240, 240);
		c2.setText("2");
		addGrid(c2, 2, tela, array, time, legenda, user1, user2);

		Grid c3 = new Grid(445, 240);
		c3.setText("3");
		addGrid(c3, 3, tela, array, time, legenda, user1, user2);

		Grid c4 = new Grid(35, 445);
		c4.setText("4");
		addGrid(c4, 4, tela, array, time, legenda, user1, user2);

		Grid c5 = new Grid(240, 445);
		c5.setText("5");
		addGrid(c5, 5, tela, array, time, legenda, user1, user2);

		Grid c6 = new Grid(445, 445);
		c6.setText("6");
		addGrid(c6, 6, tela, array, time, legenda, user1, user2);

		Grid c7 = new Grid(35, 650);
		c7.setText("7");
		addGrid(c7, 7, tela, array, time, legenda, user1, user2);

		Grid c8 = new Grid(240, 650);
		c8.setText("8");
		addGrid(c8, 8, tela, array, time, legenda, user1, user2);

		Grid c9 = new Grid(445, 650);
		c9.setText("9");
		addGrid(c9, 9, tela, array, time, legenda, user1, user2);

		tela.setVisible(true);

	}

	public static void addGrid(Grid c, int p, JFrame t, Grid[] a, Timer time, JLabel legenda, User user1,
			User user2) {
		Condicoes condicao = new Condicoes();

		c.setPosition(p);
		t.add(c);
		c.setVisible(true);
		a[c.getPosition() - 1] = c;
		c.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (condicao.fim != true) {
					if (time.getTime() == 0) {
						c.setGrid(user1.getSymbol());
						legenda.setText(user2.getName() + " é sua vez de jogar");
						time.toggle();

					} else if (time.getTime() == 1) {
						c.setGrid(user2.getSymbol());
						legenda.setText(user1.getName() + " é sua vez de jogar");
						time.toggle();

					}
				}
				condicao.checar(a);

				if (condicao.fim == true) {
					for (int i = 0; i < 9; i++) {
						a[i].setEnabled(false);

					}

					if (condicao.obterVencedor() == user1.getSymbol()) {
						legenda.setText(user1.getName() + " você ganhou");
						condicao.pintarVencedora(condicao.linhaVencedora);
						try {
							user1.addWin();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					} else if (condicao.obterVencedor() == user2.getSymbol()) {
						legenda.setText(user2.getName() + " você ganhou");
						condicao.pintarVencedora(condicao.linhaVencedora);
						try {
							user2.addWin();
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
