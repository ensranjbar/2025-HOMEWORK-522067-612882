package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	private String nomeAttrezzo;
	private IOConsole io;
	private Attrezzo attrezzo;
	private static final String NOME = "prendi";
	
	public ComandoPrendi(String nomeAttrezzo){
		this.nomeAttrezzo=nomeAttrezzo;
	}
	public ComandoPrendi(){
	
	}
	@Override
	public void esegui(Partita partita) {
		this.attrezzo = null;

		if (partita.getStanzaCorrente().hasAttrezzo(this.attrezzo.getNome())) {
			this.attrezzo = partita.getStanzaCorrente().getAttrezzo(this.attrezzo.getNome());

			partita.getGiocatore().getBorsa().addAttrezzo(this.attrezzo);
			partita.getStanzaCorrente().removeAttrezzo(this.attrezzo);
			io.mostraMessaggio("\n Attrezzo " + this.attrezzo.getNome() + " preso");

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
