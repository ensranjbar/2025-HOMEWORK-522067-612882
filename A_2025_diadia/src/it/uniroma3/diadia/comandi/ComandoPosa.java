package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

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
		    Borsa borsa = partita.getGiocatore().getBorsa();
			Attrezzo a = borsa.getAttrezzo(this.nomeAttrezzo);
			
			if(a == null) {
				io.mostraMessaggio("Attrezzo "+a+" non presente nella borsa");
				return;
			}
			
			boolean posato = partita.getStanzaCorrente().addAttrezzo(a);
			
			if(!posato) {
				io.mostraMessaggio("Non c'è spazio per nuovi attrezzi");
				return;
			}
			
			borsa.removeAttrezzo(nomeAttrezzo);
			io.mostraMessaggio("\n Attrezzo " + this.nomeAttrezzo+ " posata");
			
		
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
