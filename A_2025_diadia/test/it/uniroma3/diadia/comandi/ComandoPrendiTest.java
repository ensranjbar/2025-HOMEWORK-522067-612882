package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPrendiTest {

 private Stanza s;
 private Attrezzo a;
 private Attrezzo a2;
 private ComandoPrendi comandoPrendi;
 private ComandoPrendi comandoPrendi2;
 private Partita partita;
 private IOConsole io;
 
	@BeforeEach
	void setUp() throws Exception {
		s=new Stanza("stanza_corrente");
		a=new Attrezzo("attrezzo_1", 5);
		a2=new Attrezzo("attrezzo_2",12);
		s.addAttrezzo(a);
		s.addAttrezzo(a2);
		comandoPrendi=new ComandoPrendi("attrezzo_1");
		comandoPrendi2=new ComandoPrendi("attrezzo_2");
		partita  = new Partita();
		this.io=new IOConsole();
		comandoPrendi.setIo(io);
		comandoPrendi2.setIo(io);
	}

	@Test
	void testComandoPrendiEseguiAttrezzoPresente() {
		partita.setStanzaCorrente(s);
		comandoPrendi.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo_1"));
		
	}
	@Test
	void testComandoPrendiEseguiAttrezzoInesistente() {
	//	partita.setStanzaCorrente(s);
		comandoPrendi.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo_1"));
	}
	
	
	@Test
	void testComandoPrendiEseguiBorsaPiena() {
		partita.setStanzaCorrente(s);
		comandoPrendi.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo_1"));
		comandoPrendi2.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo_2"),"commento:Borsa piena");
	}

}
