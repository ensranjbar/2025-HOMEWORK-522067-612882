package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.uniroma3.diadia.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	private Set<Attrezzo> attrezziPresenti;
	private List<Stanza> stanzeLabirinto=new ArrayList<Stanza>();
	
	
	public Labirinto() {
		attrezziPresenti = new HashSet<>();

	}

	

	public void setStanzaIniziale(Stanza stanzaIniziale) {
		this.stanzaIniziale = stanzaIniziale;
	}



	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}

public void addAdiacenza(Stanza stanza1,Stanza stanza2,String dir){
stanza1.impostaStanzaAdiacente(dir, stanza2);
}

	// controlla se nome attrezzo esiste in labirinto
	public boolean presenteAttrezzo(Attrezzo attrezzo) {
		for (Attrezzo a : attrezziPresenti) {
			if (a.getNome() == attrezzo.getNome())
				return true;
		}
		return false;

	}

	// aggiunge attrezzo alla stanza tenendo traccia a tutti attrezzi in labirinto
	public void aggiungiAttrezzo(Attrezzo attrezzo, Stanza stanza) {

		if (!presenteAttrezzo(attrezzo)) {
			stanza.addAttrezzo(attrezzo);
			this.attrezziPresenti.add(attrezzo);

		}

	}

	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}
	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
	
	
	/********************************************************///da vedree 
	public void  addStanza(Stanza stanza) {
		this.stanzeLabirinto.add(stanza);
	}

}
