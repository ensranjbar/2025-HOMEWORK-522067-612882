package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class LabirintoTest {

	
	private Labirinto labirinto;
	private Attrezzo martello;
	private Attrezzo penna;
	private Stanza stanza;
	private Attrezzo lanterna;

	@BeforeEach
	void setUp() throws Exception {
		
		this.penna = new Attrezzo("penna", 1);
		this.stanza = new Stanza("corrente");
		this.labirinto = new LabirintoBuilder()
				.addStanza("corrente")
				.aggiungiAttrezzo("penna", 1)
				.getLabirinto();
		this.martello = new Attrezzo("martello", 1);
		
		// this.lanterna=new Attrezzo("lanterna", 1);
		
	}

	@Test
	void testStanzaInizialeNotNull() {
		assertNotNull(this.labirinto.getStanzaIniziale());
	}

	@Test
	void testStanzaVincenteNotNull() {
		assertNotNull(this.labirinto.getStanzaVincente());
	}

//	@Test
//	void testAggiungiAttrezzoEsistente() {
//		stanza.addAttrezzo(lanterna);
//		assertTrue(labirinto.getListaStanze(lanterna));
//
//	}

	@Test
	void testAggiungiAttrezzoNonEsistente() {
		assertFalse(labirinto.presenteAttrezzo(martello));
		labirinto.aggiungiAttrezzo(martello, stanza);
		assertTrue(labirinto.presenteAttrezzo(martello));
	}

	
	
	

}
