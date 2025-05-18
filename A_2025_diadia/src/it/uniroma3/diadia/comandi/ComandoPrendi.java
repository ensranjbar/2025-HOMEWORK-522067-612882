package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	private IO io;
	private String nomeAttrezzo;
	private static final String NOME = "prendi";
	
	public ComandoPrendi(String nomeAttrezzo){
		this.nomeAttrezzo=nomeAttrezzo;	
		}
	public ComandoPrendi(){
	
	}
	@Override
	public void esegui(Partita partita) {
		
		if(this.nomeAttrezzo==null) {
			io.mostraMessaggio("Specifica l'attrezzo da prendere! \n");
			return;
		}
		
		Attrezzo a = partita.getStanzaCorrente().getAttrezzo(this.nomeAttrezzo);
		
		if (a!=null){
		
			partita.getGiocatore().getBorsa().addAttrezzo(a);
			partita.getStanzaCorrente().removeAttrezzo(a);
			io.mostraMessaggio("\n Attrezzo " + this.nomeAttrezzo + " preso");

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
	public void setIo(IO io) {
		this.io = io;
		
	}
	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

}
