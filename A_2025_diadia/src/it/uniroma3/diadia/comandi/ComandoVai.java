package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	private String direzione;
	private IOConsole io;

	public ComandoVai(String direzione) {
		this.direzione = direzione;
		
	}
	public ComandoVai() {
	}

	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente=partita.getStanzaCorrente();
		Stanza prossimaStanza=null;
		if(this.direzione==null) {
			io.mostraMessaggio("Dove Vuoi andare? \n devi specificare una direzione\n");
			return ;
		}
		
		prossimaStanza=stanzaCorrente.getStanzaAdiacente(this.direzione);
		if(prossimaStanza==null) {
			io.mostraMessaggio("Direzione inesistente\n");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		io.mostraMessaggio(partita.getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		
	}
	
	@Override
	public  void setParametro(String parametro) {
		this.direzione=parametro;
	}
	
}