package it.uniroma3.diadia.giocatore;

public class Giocatore {

	private Borsa borsa;
	private int cfu;
	static final public int CFU_INIZIALI = 20;

	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}

	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	public Borsa getBorsa() {
		return this.borsa;
	}

}
