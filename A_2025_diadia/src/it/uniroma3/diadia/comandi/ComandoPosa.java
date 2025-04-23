package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	private String nomeAttrezzo;
	private IOConsole io;
	
	public ComandoPosa(String nomeAttrezzo){
		this.nomeAttrezzo=nomeAttrezzo;
	}
	public ComandoPosa(){
	
	}
	@Override
	public void esegui(Partita partita) {
		Attrezzo a = null;
		if (partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			a = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			partita.getStanzaCorrente().addAttrezzo(a);
			io.mostraMessaggio("\n Attrezzo " + nomeAttrezzo + " posata");
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
