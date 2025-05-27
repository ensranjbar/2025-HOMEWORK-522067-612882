package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	private StanzaBloccataProtected sb;
	private Attrezzo attrezzo;
	private StanzaProtected stanzaNord;
	private StanzaProtected stanzaSud;
	@BeforeEach
	void setUp() throws Exception {
		sb=new StanzaBloccataProtected("sb", "nord", "chiave");
		stanzaNord=new StanzaProtected("stanzaNord");
		stanzaSud=new StanzaProtected("stanzaSud");
		
		attrezzo=new Attrezzo("chiave", 1);
		sb.impostaStanzaAdiacente("nord", stanzaNord);
		sb.impostaStanzaAdiacente("sud", stanzaSud);

	}
	@Test
	void testGetStanzaAdiacenteAttrezzoPresente() {
		sb.addAttrezzo(attrezzo);
		assertEquals("stanzaNord", sb.getStanzaAdiacente("nord").getNome());
	}
	@Test
	void testGetStanzaAdiacenteAttrezzoNonPresente() {
		assertEquals("stanzaSud", sb.getStanzaAdiacente("sud").getNome());
		assertEquals("sb", sb.getStanzaAdiacente("nord").getNome());
	}
	
	@Test
	void testgetDescrizioneAttrezzoDisponibile() {
		sb.addAttrezzo(attrezzo);
		assertEquals(sb.toString(),sb.getDescrizione());
	}
	
	@Test
	void testgetDescrizioneAttrezzoNonDisponibile() {
		assertEquals(StanzaBloccata.MESSAGGIO_STANZA_BLOCCATA,sb.getDescrizione());
	}
}
