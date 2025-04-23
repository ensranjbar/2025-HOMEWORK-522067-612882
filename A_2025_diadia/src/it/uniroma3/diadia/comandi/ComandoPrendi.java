package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	private String nomeAttrezzo;
	private IOConsole io;
	
	public ComandoPrendi(String nomeAttrezzo){
		this.nomeAttrezzo=nomeAttrezzo;
	}
	public ComandoPrendi(){
	
	}
	@Override
	public void esegui(Partita partita) {
		Attrezzo a = null;

		if (partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			a = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);

			partita.getGiocatore().getBorsa().addAttrezzo(a);
			partita.getStanzaCorrente().removeAttrezzo(a);
			io.mostraMessaggio("\n Attrezzo " + nomeAttrezzo + " preso");

		} else {
			io.mostraMessaggio("Attrezzo non esistente!");
		}
		io.mostraMessaggio(partita.toString());

	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

}
