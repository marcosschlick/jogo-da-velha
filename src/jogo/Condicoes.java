package jogo;

import java.awt.Color;

public class Condicoes {
	boolean fim = false;
	String vencedor = "";
	Grid[] linhaVencedora = new Grid[3];

	public void pintarVencedora(Grid[] linhaVencedora) {
		linhaVencedora[0].setBackground(Color.green);
		linhaVencedora[1].setBackground(Color.green);
		linhaVencedora[2].setBackground(Color.green);
	}

	public void pintarVelha(Grid[] posicoes) {
		for (int i = 0; i < 9; i++) {
			posicoes[i].setBackground(Color.red);
		}
	}

	public String obterVencedor() {
		return this.vencedor;
	}

	public void checar(Grid[] a) {
		condicao9(a);
		condicao1(a);
		condicao2(a);
		condicao3(a);
		condicao4(a);
		condicao5(a);
		condicao6(a);
		condicao7(a);
		condicao8(a);

	}

	public void condicao1(Grid[] a) {
		if (a[0].isMarked() & a[0].getSymbol() == a[1].getSymbol()
				& a[0].getSymbol() == a[2].getSymbol()) {
			this.fim = true;
			this.vencedor = a[0].getSymbol();
			this.linhaVencedora[0] = a[0];
			this.linhaVencedora[1] = a[1];
			this.linhaVencedora[2] = a[2];
		}

	}

	public void condicao2(Grid[] a) {
		if (a[3].isMarked() & a[3].getSymbol() == a[4].getSymbol()
				& a[3].getSymbol() == a[5].getSymbol()) {
			this.fim = true;
			this.vencedor = a[3].getSymbol();
			this.linhaVencedora[0] = a[3];
			this.linhaVencedora[1] = a[4];
			this.linhaVencedora[2] = a[5];
		}

	}

	public void condicao3(Grid[] a) {
		if (a[6].isMarked() & a[6].getSymbol() == a[7].getSymbol()
				& a[6].getSymbol() == a[8].getSymbol()) {
			this.fim = true;
			this.vencedor = a[6].getSymbol();
			this.linhaVencedora[0] = a[6];
			this.linhaVencedora[1] = a[7];
			this.linhaVencedora[2] = a[8];
		}

	}

	public void condicao4(Grid[] a) {
		if (a[0].isMarked() & a[0].getSymbol() == a[3].getSymbol()
				& a[0].getSymbol() == a[6].getSymbol()) {
			this.fim = true;
			this.vencedor = a[0].getSymbol();
			this.linhaVencedora[0] = a[0];
			this.linhaVencedora[1] = a[3];
			this.linhaVencedora[2] = a[6];
		}

	}

	public void condicao5(Grid[] a) {
		if (a[1].isMarked() & a[1].getSymbol() == a[4].getSymbol()
				& a[1].getSymbol() == a[7].getSymbol()) {
			this.fim = true;
			this.vencedor = a[1].getSymbol();
			this.linhaVencedora[0] = a[1];
			this.linhaVencedora[1] = a[4];
			this.linhaVencedora[2] = a[7];
		}

	}

	public void condicao6(Grid[] a) {
		if (a[2].isMarked() & a[2].getSymbol() == a[5].getSymbol()
				& a[2].getSymbol() == a[8].getSymbol()) {
			this.fim = true;
			this.vencedor = a[2].getSymbol();
			this.linhaVencedora[0] = a[2];
			this.linhaVencedora[1] = a[5];
			this.linhaVencedora[2] = a[8];
		}

	}

	public void condicao7(Grid[] a) {
		if (a[0].isMarked() & a[0].getSymbol() == a[4].getSymbol()
				& a[0].getSymbol() == a[8].getSymbol()) {
			this.fim = true;
			this.vencedor = a[0].getSymbol();
			this.linhaVencedora[0] = a[0];
			this.linhaVencedora[1] = a[4];
			this.linhaVencedora[2] = a[8];
		}

	}

	public void condicao8(Grid[] a) {
		if (a[2].isMarked() & a[2].getSymbol() == a[4].getSymbol() & a[2].getSymbol() == a[6].getSymbol()) {
			this.fim = true;
			this.vencedor = a[2].getSymbol();
			this.linhaVencedora[0] = a[2];
			this.linhaVencedora[1] = a[4];
			this.linhaVencedora[2] = a[6];
		}

	}

	public void condicao9(Grid[] a) {
		if (a[0].isMarked() & a[1].isMarked() & a[2].isMarked() & a[3].isMarked() & a[4].isMarked()
				& a[5].isMarked() & a[6].isMarked() & a[7].isMarked() & a[8].isMarked()) {
			this.fim = true;
			this.vencedor = "";
		}
	}

}
