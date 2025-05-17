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
private Attrezzo a2;
private Attrezzo a3;
private Attrezzo a4;
private Attrezzo a5;
private Attrezzo a6;
private Attrezzo a7;
private Attrezzo a8;
private Attrezzo a9;
private Attrezzo a10;
private Attrezzo a11;



	@BeforeEach
	void setUp() throws Exception {
		this.s1=new Stanza("s1");
		this.s2=new Stanza("s2");
		this.s3=new Stanza("s3");
		this.s2=new Stanza("s4");
		this.s3=new Stanza("s5");
		
		this.a1=new Attrezzo("Penna", 1);
		this.a2 = new Attrezzo("pc",1);
		this.a3 = new Attrezzo("matita",1);
		this.a4 = new Attrezzo("libro",1);
		this.a5 = new Attrezzo("cell",1);
		this.a6 = new Attrezzo("bottiglia",1);
		this.a7 = new Attrezzo("cuffie",1);
		this.a8 = new Attrezzo("occhiali",1);
		this.a9 = new Attrezzo("medicina",1);
		this.a10 = new Attrezzo("quaderno",1);
		this.a11 = new Attrezzo("tablet",1);
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
	void testImpostaAdidacenteDirezioneNull() {
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
		assertFalse(this.s1.getAttrezzi().contains(a1));
		this.s1.addAttrezzo(a1);
		assertTrue(this.s1.getAttrezzi().contains(a1));
	}
	/*
	@Test
	void testAddAttrezzoSopraLimiteAttrezzi(){
		this.s1.addAttrezzo(a1);
		this.s1.addAttrezzo(a2);
		this.s1.addAttrezzo(a3);
		this.s1.addAttrezzo(a4);
		this.s1.addAttrezzo(a5);
		this.s1.addAttrezzo(a6);
		this.s1.addAttrezzo(a7);
		this.s1.addAttrezzo(a8);
		this.s1.addAttrezzo(a9);
		this.s1.addAttrezzo(a10);
		this.s1.addAttrezzo(a11);
		assertFalse(this.s1.hasAttrezzo("tablet"));
		assertTrue(this.s1.hasAttrezzo("quaderno"));
	}*/
	
	@Test
	void testHasAttrezzoEsistente() {
		this.s1.addAttrezzo(a1);
		assertTrue(this.s1.getAttrezzi().contains(a1));
	}
	
	@Test
	void testHasAttrezzoInesistente() {
		assertFalse(this.s1.getAttrezzi().contains(a1));
	}
	
	@Test
	void testRemoveAttrezzoEsistente() {
		assertFalse(this.s1.getAttrezzi().contains(a1));
		this.s1.addAttrezzo(a1);
		assertTrue(this.s1.getAttrezzi().contains(a1));
		this.s1.removeAttrezzo(a1);
		assertFalse(this.s1.getAttrezzi().contains(a1));
	}
	
	@Test
	void testRemoveAttrezzoInesistente() {
		assertFalse(this.s1.getAttrezzi().contains(a1));
	}
	
	

	
}

    
