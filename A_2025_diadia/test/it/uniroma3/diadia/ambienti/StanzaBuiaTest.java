package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	
	private StanzaBuia sb;
	private Attrezzo attrezzo;
	
	@BeforeEach
	void setUp() throws Exception {
		sb=new StanzaBuia("sb", "penna");
		attrezzo=new Attrezzo("penna", 1);
	}
	@Test
	void testgetDescrizioneAttrezzoDisponibile() {
		sb.addAttrezzo(attrezzo);
		assertEquals(sb.toString(),sb.getDescrizione());
	}
	
	@Test
	void testgetDescrizioneAttrezzoNonDisponibile() {
		assertEquals(StanzaBuia.MESSAGGIO_STANZA_BUIA,sb.getDescrizione());

	}

}
