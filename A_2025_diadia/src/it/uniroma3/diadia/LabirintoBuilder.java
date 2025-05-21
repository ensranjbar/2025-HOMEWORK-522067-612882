package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {

	Labirinto labirinto;
	

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
		
		this.labirinto=new Labirinto();
		labirinto.addStanza(biblioteca);
		labirinto.addStanza(atrio);
		labirinto.addStanza(aulaN11);
		labirinto.addStanza(aulaN10);
		labirinto.addStanza(laboratorio);
		
		
		/* collega le stanze */

		labirinto.addAdiacenza(atrio, biblioteca,"nord");
		labirinto.addAdiacenza(atrio, aulaN11,"est");
		labirinto.addAdiacenza(atrio, aulaN10,"sud");
		labirinto.addAdiacenza(atrio, laboratorio,"ovest");
		labirinto.addAdiacenza(aulaN11, laboratorio,"est");
		labirinto.addAdiacenza(aulaN11, atrio,"ovest");
		labirinto.addAdiacenza(aulaN10, atrio,"nord");
		labirinto.addAdiacenza(aulaN10, aulaN11,"est");
		labirinto.addAdiacenza(aulaN10, laboratorio,"ovest");
		labirinto.addAdiacenza(laboratorio, atrio,"est");
		labirinto.addAdiacenza(laboratorio, aulaN11,"ovest");
		labirinto.addAdiacenza(biblioteca, atrio,"sud");
		/* pone gli attrezzi nelle stanze */
		labirinto.aggiungiAttrezzo(lanterna, aulaN10);
		// aulaN10.addAttrezzo(lanterna);
		labirinto.aggiungiAttrezzo(osso, atrio);
		// atrio.addAttrezzo(osso);

		// il gioco comincia nell'atrio
		labirinto.setStanzaIniziale(atrio);
		labirinto.setStanzaVincente(biblioteca); 

	}


	public Labirinto getLabirinto() {
	return this.labirinto;
	}
}
