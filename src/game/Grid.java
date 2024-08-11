package game;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Grid extends JButton {

	private int position;
	private boolean marked = false;
	private String symbol = "";

	public Grid(int x, int y) {
		setText(symbol);
		setFont(new Font("", Font.BOLD, 80));
		setOpaque(true);
		setBackground(Color.DARK_GRAY);
		setForeground(Color.WHITE);
		setSize(200, 200);
		setEnabled(true);
		setLocation(x, y);
	}

	public void setGrid(String s, Color color) {
		setText(s);
		this.symbol = s;
		this.marked = true;
		setEnabled(false);
		setBackground(color);
	}

	public void setPosition(int p) {
		this.position = p;
	}

	public int getPosition() {
		return this.position;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public boolean isMarked() {
		return this.marked;
	}

}
