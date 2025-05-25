package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;

	public void setStanzaIniziale(Stanza stanzaIniziale) {
		this.stanzaIniziale = stanzaIniziale;
	}

	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}

	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}
	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}


}
