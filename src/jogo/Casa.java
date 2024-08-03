package jogo;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Casa extends JButton {

	int posicao;
	boolean marcado = false;
	String simbolo = "";

	public Casa(int x, int y) {
		setText(simbolo);
		setFont(new Font("", Font.BOLD, 80));
		setOpaque(true);
		setBackground(Color.GRAY);
		setForeground(Color.WHITE);
		setSize(200, 200);
		setEnabled(true);
		setLocation(x, y);
	}

	public void marcar(String simb) {
		setText(simb);
		this.simbolo = simb;
		this.marcado = true;
		setEnabled(false);
	}

	public boolean estaMarcado() {
		if (this.marcado == true) {
			return true;
		} else {
			return false;
		}
	}

	public int obterPosicao() {
		return this.posicao;
	}

	public String obterSimbolo() {
		return this.simbolo;

	}

}
