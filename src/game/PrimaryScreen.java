package game;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PrimaryScreen {
	User user1 = new User();
	User user2 = new User();
	Times timer = new Times();

	public void execute() {

		JFrame screen = new JFrame("Jogo da velha");
		screen.setSize(700, 600);
		screen.setLayout(null);
		screen.setLocationRelativeTo(null);
		screen.setDefaultCloseOperation(3);

		JLabel label1 = new JLabel();
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setText("Player 1 digite seu username:");
		label1.setFont(new Font("", Font.BOLD, 30));
		label1.setLocation(0, 50);
		label1.setVisible(true);
		label1.setSize(700, 100);
		screen.add(label1);

		JTextField enter1 = new JTextField();
		enter1.setSize(300, 60);
		enter1.setFont(new Font("", Font.BOLD, 20));
		enter1.setLocation(200, 150);
		screen.add(enter1);

		JLabel label2 = new JLabel();
		label2.setHorizontalAlignment(JLabel.CENTER);
		label2.setText("Player 2 digite seu username:");
		label2.setFont(new Font("", Font.BOLD, 30));
		label2.setLocation(0, 250);
		label2.setVisible(true);
		label2.setSize(700, 100);
		screen.add(label2);

		JTextField enter2 = new JTextField();
		enter2.setSize(300, 60);
		enter2.setFont(new Font("", Font.BOLD, 20));
		enter2.setLocation(200, 350);
		screen.add(enter2);

		JButton buttonPlay = new JButton();
		buttonPlay.setText("Jogar");
		buttonPlay.setFont(new Font("", Font.BOLD, 70));
		buttonPlay.setSize(250, 100);
		buttonPlay.setLocation(225, 430);
		screen.add(buttonPlay);
		buttonPlay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (timer.getTime() == 0) {
					user2.setName(enter2.getText());
					try {
						user2.checkDatabase();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					user1.setName(enter1.getText());
					try {
						user1.checkDatabase();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}

				if (timer.getTime() == 1) {
					user1.setName(enter1.getText());
					try {
						user1.checkDatabase();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					user2.setName(enter2.getText());
					try {
						user2.checkDatabase();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}

				MainScreen main = new MainScreen();
				main.execute(user1.getName(), user2.getName());

				screen.dispose();

			}
		});

		screen.setVisible(true);
	}
}