package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	
	private IOConsole io;
	private final static String NOME = "posa";
	private String nomeAttrezzo;
	
	public ComandoPosa(String nomeAttrezzo){
		this.nomeAttrezzo=nomeAttrezzo;
	}
	public ComandoPosa(){
	
	}
	@Override
	public void esegui(Partita partita) {
		Attrezzo a = null;
		if (partita.getGiocatore().getBorsa().hasAttrezzo(this.nomeAttrezzo)) {
			a = partita.getGiocatore().getBorsa().getAttrezzo(this.nomeAttrezzo);
			partita.getStanzaCorrente().addAttrezzo(a);
			partita.getGiocatore().getBorsa().removeAttrezzo(this.nomeAttrezzo);
			io.mostraMessaggio("\n Attrezzo " + this.nomeAttrezzo+ " posata");
		} else {
			io.mostraMessaggio("Attrezzo non esistente!");
		}
		io.mostraMessaggio(partita.toString());

	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;
	}
	@Override
	public String getNome() {
		return NOME;
	}
	@Override
	public void setIo(IOConsole io) {
		this.io = io;
	}
	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

}
