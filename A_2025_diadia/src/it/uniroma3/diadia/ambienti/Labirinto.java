package it.uniroma3.diadia.ambienti;

import java.util.HashSet;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	private Set<Attrezzo> attrezziPresenti;

	public Labirinto() {

		attrezziPresenti = new HashSet<>();
		this.creaStanze();

	}

	/**
	 * Crea tutte le stanze e le porte di collegamento
	 */
	public void creaStanze() {

		/* crea gli attrezzi */
		Attrezzo lanterna = new Attrezzo("lanterna", 3);
		Attrezzo osso = new Attrezzo("osso", 1);

		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");

		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

		/* pone gli attrezzi nelle stanze */
		this.aggiungiAttrezzo(lanterna, aulaN10);
		// aulaN10.addAttrezzo(lanterna);
		this.aggiungiAttrezzo(osso, atrio);
		// atrio.addAttrezzo(osso);

		// il gioco comincia nell'atrio
		this.stanzaIniziale = atrio;
		this.stanzaVincente = biblioteca;

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

}
