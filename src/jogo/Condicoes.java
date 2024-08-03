package jogo;
import java.awt.Color;

public class Condicoes {
	boolean fim = false;
	String vencedor = "";
	Casa[] linhaVencedora = new Casa[3];

	public void pintarVencedora(Casa[] linhaVencedora) {
		linhaVencedora[0].setBackground(Color.green);
		linhaVencedora[1].setBackground(Color.green);
		linhaVencedora[2].setBackground(Color.green);

	}

	public String obterVencedor() {
		return this.vencedor;
	}

	public void checar(Casa[] a) {
		condicao1(a);
		condicao2(a);
		condicao3(a);
		condicao4(a);
		condicao5(a);
		condicao6(a);
		condicao7(a);
		condicao8(a);
		condicao9(a);

	}

	public void condicao1(Casa[] a) {
		if (a[0].estaMarcado() & a[0].obterSimbolo() == a[1].obterSimbolo()
				& a[0].obterSimbolo() == a[2].obterSimbolo()) {
			this.fim = true;
			this.vencedor = a[0].obterSimbolo();
			this.linhaVencedora[0] = a[0];
			this.linhaVencedora[1] = a[1];
			this.linhaVencedora[2] = a[2];
		}

	}

	public void condicao2(Casa[] a) {
		if (a[3].estaMarcado() & a[3].obterSimbolo() == a[4].obterSimbolo()
				& a[3].obterSimbolo() == a[5].obterSimbolo()) {
			this.fim = true;
			this.vencedor = a[3].obterSimbolo();
			this.linhaVencedora[0] = a[3];
			this.linhaVencedora[1] = a[4];
			this.linhaVencedora[2] = a[5];
		}

	}

	public void condicao3(Casa[] a) {
		if (a[6].estaMarcado() & a[6].obterSimbolo() == a[7].obterSimbolo()
				& a[6].obterSimbolo() == a[8].obterSimbolo()) {
			this.fim = true;
			this.vencedor = a[6].obterSimbolo();
			this.linhaVencedora[0] = a[6];
			this.linhaVencedora[1] = a[7];
			this.linhaVencedora[2] = a[8];
		}

	}

	public void condicao4(Casa[] a) {
		if (a[0].estaMarcado() & a[0].obterSimbolo() == a[3].obterSimbolo()
				& a[0].obterSimbolo() == a[6].obterSimbolo()) {
			this.fim = true;
			this.vencedor = a[0].obterSimbolo();
			this.linhaVencedora[0] = a[0];
			this.linhaVencedora[1] = a[3];
			this.linhaVencedora[2] = a[6];
		}

	}

	public void condicao5(Casa[] a) {
		if (a[1].estaMarcado() & a[1].obterSimbolo() == a[4].obterSimbolo()
				& a[1].obterSimbolo() == a[7].obterSimbolo()) {
			this.fim = true;
			this.vencedor = a[1].obterSimbolo();
			this.linhaVencedora[0] = a[1];
			this.linhaVencedora[1] = a[4];
			this.linhaVencedora[2] = a[7];
		}

	}

	public void condicao6(Casa[] a) {
		if (a[2].estaMarcado() & a[2].obterSimbolo() == a[5].obterSimbolo()
				& a[2].obterSimbolo() == a[8].obterSimbolo()) {
			this.fim = true;
			this.vencedor = a[2].obterSimbolo();
			this.linhaVencedora[0] = a[2];
			this.linhaVencedora[1] = a[5];
			this.linhaVencedora[2] = a[8];
		}

	}

	public void condicao7(Casa[] a) {
		if (a[0].estaMarcado() & a[0].obterSimbolo() == a[4].obterSimbolo()
				& a[0].obterSimbolo() == a[8].obterSimbolo()) {
			this.fim = true;
			this.vencedor = a[0].obterSimbolo();
			this.linhaVencedora[0] = a[0];
			this.linhaVencedora[1] = a[4];
			this.linhaVencedora[2] = a[8];
		}

	}

	public void condicao8(Casa[] a) {
		if (a[2].estaMarcado() & a[2].obterSimbolo() == a[4].obterSimbolo() & a[2].simbolo == a[6].obterSimbolo()) {
			this.fim = true;
			this.vencedor = a[2].obterSimbolo();
			this.linhaVencedora[0] = a[2];
			this.linhaVencedora[1] = a[4];
			this.linhaVencedora[2] = a[6];
		}

	}

	public void condicao9(Casa[] a) {
		if (a[0].estaMarcado() & a[1].estaMarcado() & a[2].estaMarcado() & a[3].estaMarcado() & a[4].estaMarcado()
				& a[5].estaMarcado() & a[6].estaMarcado() & a[7].estaMarcado() & a[8].estaMarcado()) {
			this.fim = true;
		}
	}

}
