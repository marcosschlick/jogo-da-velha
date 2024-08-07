package jogo;

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

	public void execute() {

		JFrame tela = new JFrame("Jogo da velha");
		tela.setSize(700, 600);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setDefaultCloseOperation(1);

		JLabel a1 = new JLabel();
		a1.setHorizontalAlignment(JLabel.CENTER);
		a1.setText("Player 1 digite seu username:");
		a1.setFont(new Font("", Font.BOLD, 30));
		a1.setLocation(0, 50);
		a1.setVisible(true);
		a1.setSize(700, 100);
		tela.add(a1);

		JLabel a2 = new JLabel();
		a2.setHorizontalAlignment(JLabel.CENTER);
		a2.setText("Player 2 digite seu username:");
		a2.setFont(new Font("", Font.BOLD, 30));
		a2.setLocation(0, 250);
		a2.setVisible(true);
		a2.setSize(700, 100);
		tela.add(a2);

		JTextField b1 = new JTextField();
		b1.setSize(300, 60);
		b1.setLocation(200, 150);
		tela.add(b1);

		JTextField b2 = new JTextField();
		b2.setSize(300, 60);
		b2.setLocation(200, 350);
		tela.add(b2);

		JButton botao = new JButton();
		botao.setText("Jogar");
		botao.setFont(new Font("", Font.BOLD, 70));
		botao.setSize(250, 100);
		botao.setLocation(225, 430);
		tela.add(botao);
		botao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				user1.setName(b1.getText());
				try {
					user1.checkDatabase();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				user2.setName(b2.getText());
				try {
					user2.checkDatabase();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				MainScreen main = new MainScreen();
				main.execute(user1.getName(), user2.getName());

				tela.dispose();

			}
		});

		tela.setVisible(true);
	}
}