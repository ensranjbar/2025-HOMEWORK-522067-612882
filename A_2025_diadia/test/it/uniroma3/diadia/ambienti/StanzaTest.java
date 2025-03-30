package it.uniroma3.diadia.ambienti;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
private Stanza s1;
private Stanza s2;
private Stanza s3;
private Stanza s4;
private Stanza s5;
private Attrezzo a1;


	@BeforeEach
	void setUp() throws Exception {
		this.s1=new Stanza("s1");
		this.s2=new Stanza("s2");
		this.s3=new Stanza("s3");
		this.s2=new Stanza("s4");
		this.s3=new Stanza("s5");
		this.a1=new Attrezzo("Penna", 1);
	}
//testImpostaStanzaAdiacente
	@Test
	void testImpostaAdiacenteDirezioneTrue() {
	this.s1.impostaStanzaAdiacente("nord", s2);
	assertEquals(s2, this.s1.getStanzaAdiacente("nord"));
	}
	
	@Test
	void testImpostaAdiacenteDirezioneFalse() {
	this.s1.impostaStanzaAdiacente("nord", s2);
	this.s1.impostaStanzaAdiacente("sud", s3);
	assertNotEquals(s2, this.s1.getStanzaAdiacente("sud"));
	}
	
	@Test 
	void testDirezioneNull() {
		this.s1.impostaStanzaAdiacente(null, s2);
		assertNull( this.s1.getStanzaAdiacente(null));

	}

	@Test
	void testSostituzioneStanzaAdiacente() {
		this.s1.impostaStanzaAdiacente("nord", s2);
		this.s1.impostaStanzaAdiacente("nord", s3);
		assertEquals(s3, this.s1.getStanzaAdiacente("nord"));

	}
	

//test Metodo AddAttrezzo
	
	@Test
	void testAddAttrezzo() {
		assertFalse(this.s1.hasAttrezzo("Penna"));
		this.s1.addAttrezzo(a1);
		assertTrue(this.s1.hasAttrezzo("Penna"));
	}
	
	@Test
	void testHasAttrezzo() {
		this.s1.addAttrezzo(a1);
		assertTrue(this.s1.hasAttrezzo("Penna"));
	}
	
	@Test
	void testRemoveAttrezzo() {
		assertFalse(this.s1.removeAttrezzo(a1));
		this.s1.addAttrezzo(a1);
		assertTrue(this.s1.removeAttrezzo(a1));
	}
	
	
	
	
	
	
	
	
}

    
