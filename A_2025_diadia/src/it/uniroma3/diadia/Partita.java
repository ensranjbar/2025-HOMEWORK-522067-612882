package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {


	private boolean finita;
	private Labirinto labirinto;
	private Stanza stanzaCorrente;
	private Giocatore giocatore;
	
	public Partita(){	
		this.labirinto = new Labirinto();
		this.stanzaCorrente = this.labirinto.getStanzaIniziale();
		this.finita = false;
		this.giocatore = new Giocatore();
	}

    
    
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaVincente() {
		return this.labirinto.getStanzaVincente();
	}
	
	public int getCfu() {
		return this.giocatore.getCfu();
	}
	
	public void setCfu(int cfu) {
		this.giocatore.setCfu(cfu);
	}


	@Override
	public String toString() {
		return this.getStanzaCorrente()+"\nCfu: "+this.giocatore.getCfu()+ "\n" +this.giocatore.getBorsa();
	}



	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	public Giocatore getGiocatore() {
		return this.giocatore;
	}

	
		
}
