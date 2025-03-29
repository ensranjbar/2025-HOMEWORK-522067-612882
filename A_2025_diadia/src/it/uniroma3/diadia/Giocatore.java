package it.uniroma3.diadia;

public class Giocatore {

private Borsa borsa;
private Partita partita;
private int cfu;
static final private int CFU_INIZIALI = 20;

public Giocatore() {
	this.cfu = CFU_INIZIALI;
	this.borsa = new Borsa();
	this.partita = new Partita();
}

public int getCfu() {
	return this.cfu;
}

public void setCfu(int cfu) {
	this.cfu = cfu;		
}

//public void posa(String nomeAttrezzo) {
//	//DA IMPLEMENTARE
//	Attrezzo a = null;
//	if(this.borsa.hasAttrezzo(nomeAttrezzo)) {
//		a = this.borsa.removeAttrezzo(nomeAttrezzo);
//		this.partita.getStanzaCorrente().addAttrezzo(a);
//	}
//	
//}
//
//public void prendi(String nomeAttrezzo) {
//	Attrezzo a = null;
//	if(this.partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
//		a = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
//		this.partita.getStanzaCorrente().removeAttrezzo(a);
//		this.borsa.addAttrezzo(a);
//	}
//}
}
