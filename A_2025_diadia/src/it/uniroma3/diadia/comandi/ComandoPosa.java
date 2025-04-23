package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	
	private IOConsole io;
	private final static String NOME = "posa";
	private Attrezzo attrezzo;
	
	public ComandoPosa(String nomeAttrezzo){
		this.attrezzo.setNome(nomeAttrezzo);
	}
	public ComandoPosa(){
	
	}
	@Override
	public void esegui(Partita partita) {
		this.attrezzo = null;
		if (partita.getGiocatore().getBorsa().hasAttrezzo(this.attrezzo.getNome())) {
			this.attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(this.attrezzo.getNome());
			partita.getGiocatore().getBorsa().removeAttrezzo(this.attrezzo.getNome());
			partita.getStanzaCorrente().addAttrezzo(this.attrezzo);
			io.mostraMessaggio("\n Attrezzo " + this.attrezzo.getNome() + " posata");
		} else {
			io.mostraMessaggio("Attrezzo non esistente!");
		}
		io.mostraMessaggio(partita.toString());

	}

	@Override
	public void setParametro(String parametro) {
		this.attrezzo.setNome(parametro);
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
		return this.attrezzo.getNome();
	}

}
