package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa implements Comando {
	
	private IO io;
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
			Attrezzo a = borsa.getMappaAttrezzi().get(this.nomeAttrezzo);
			
			if(a == null) {
				io.mostraMessaggio("Attrezzo "+this.nomeAttrezzo+" non presente nella borsa");
				return;
			}
			
			boolean posato = partita.getStanzaCorrente().addAttrezzo(a);
			
			if(!posato) {
				io.mostraMessaggio("Non c'è spazio per nuovi attrezzi");
				return;
			}
			
			borsa.getMappaAttrezzi().remove(nomeAttrezzo);
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
	public void setIo(IO io) {
		this.io = io;
	}
	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

}
