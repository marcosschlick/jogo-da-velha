package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainScreen {
	User user1 = new User();
	User user2 = new User();
	public static Times time = new Times();

	public void execute(String nome1, String nome2) {
		Grid[] array = new Grid[9];

		user1.setName(nome1);
		user2.setName(nome2);

		JFrame screen = new JFrame("Jogo da velha");
		screen.setSize(700, 900);
		screen.setLayout(null);
		screen.setLocationRelativeTo(null);
		screen.setDefaultCloseOperation(3);

		JLabel label = new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("", Font.BOLD, 30));
		label.setLocation(0, 0);
		label.setVisible(true);
		label.setSize(700, 200);
		if (time.getTime() == 0) {
			label.setText(user1.getName() + " é sua vez de jogar");
			user1.setSymbol("X");
			user2.setSymbol("O");
		} else if (time.getTime() == 1) {
			label.setText(user2.getName() + " é sua vez de jogar");
			user1.setSymbol("O");
			user2.setSymbol("X");
		}
		screen.add(label);

		Grid c1 = new Grid(35, 240);
		addGrid(c1, 1, screen, array, time, label, user1, user2);

		Grid c2 = new Grid(240, 240);
		addGrid(c2, 2, screen, array, time, label, user1, user2);

		Grid c3 = new Grid(445, 240);
		addGrid(c3, 3, screen, array, time, label, user1, user2);

		Grid c4 = new Grid(35, 445);
		addGrid(c4, 4, screen, array, time, label, user1, user2);

		Grid c5 = new Grid(240, 445);
		addGrid(c5, 5, screen, array, time, label, user1, user2);

		Grid c6 = new Grid(445, 445);
		addGrid(c6, 6, screen, array, time, label, user1, user2);

		Grid c7 = new Grid(35, 650);
		addGrid(c7, 7, screen, array, time, label, user1, user2);

		Grid c8 = new Grid(240, 650);
		addGrid(c8, 8, screen, array, time, label, user1, user2);

		Grid c9 = new Grid(445, 650);
		addGrid(c9, 9, screen, array, time, label, user1, user2);

		screen.setVisible(true);

	}

	public static void addGrid(Grid grid, int pos, JFrame screen, Grid[] array, Times time, JLabel label, User user1, User user2) {
		Rules rules = new Rules();
		grid.setPosition(pos);
		screen.add(grid);
		grid.setVisible(true);
		array[grid.getPosition() - 1] = grid;

		grid.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (rules.isOver() != true) {
					if (time.getTime() == 0) {
						grid.setGrid(user1.getSymbol(), new Color(20, 100, 255));
						label.setText(user2.getName() + " é sua vez de jogar");
						time.toggle();

					} else if (time.getTime() == 1) {
						grid.setGrid(user2.getSymbol(), new Color(255, 10, 10));
						label.setText(user1.getName() + " é sua vez de jogar");
						time.toggle();

					}
				}
				rules.check(array);

				if (rules.isOver() == true) {
					for (int i = 0; i < 9; i++) {
						array[i].setEnabled(false);
					}

					if (rules.getWinner() == user1.getSymbol()) {
						TimerTask task = new TimerTask() {
							@Override
							public void run() {
								if (time.getTime() == 0) {
									rules.paintWin(rules.getWinningLine(), new Color(0, 255, 25));
									time.toggle();

								} else if (time.getTime() == 1) {
									rules.paintWin(rules.getWinningLine(), new Color(100, 255, 100));
									time.toggle();
								}
							}
						};
						time.scheduleAtFixedRate(task, 0, 100);
						label.setText(user1.getName() + " você ganhou");

						try {
							user1.addWin();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					} else if (rules.getWinner() == user2.getSymbol()) {
						TimerTask task = new TimerTask() {
							@Override
							public void run() {
								if (time.getTime() == 0) {
									rules.paintWin(rules.getWinningLine(), new Color(0, 255, 25));
									time.toggle();

								} else if (time.getTime() == 1) {
									rules.paintWin(rules.getWinningLine(), new Color(100, 255, 100));
									time.toggle();
								}
							}
						};
						time.scheduleAtFixedRate(task, 0, 100);
						label.setText(user2.getName() + " você ganhou");

						try {
							user2.addWin();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (rules.getWinner() == "") {
						label.setText("DEU VELHAAA!!! (nínguem recebe pontos)");
						rules.paintDraw(array);

					}
				}

			}
		});
	}
}
