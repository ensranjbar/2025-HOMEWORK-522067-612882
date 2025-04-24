package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class ComandoPosaTest {
	 private Stanza s;
	 private Borsa borsa;
	 private Attrezzo a;
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
	 private ComandoPosa comandoPosa;
	 private Partita partita;
	 private IOConsole io;
	@BeforeEach
	void setUp() throws Exception {
		s=new Stanza("stanza_corrente");
		
		a=new Attrezzo("attrezzo_1", 1);
		a2=new Attrezzo("attrezzo_2",1);
		a3=new Attrezzo("attrezzo_3",1);
		a4=new Attrezzo("attrezzo_4",1);
		a5=new Attrezzo("attrezzo_5", 1);
		a6=new Attrezzo("attrezzo_6",1);
		a7=new Attrezzo("attrezzo_7",1);
		a8=new Attrezzo("attrezzo_8",1);
		a9=new Attrezzo("attrezzo_9",1);
		a10=new Attrezzo("attrezzo_10",1);
		a11=new Attrezzo("attrezzo_11",1);

		
		borsa=new Borsa();
		s.addAttrezzo(a);
		s.addAttrezzo(a2);
		s.addAttrezzo(a3);
		s.addAttrezzo(a4);
		s.addAttrezzo(a5);
		s.addAttrezzo(a6);
		s.addAttrezzo(a7);
		s.addAttrezzo(a8);
		s.addAttrezzo(a9);
		borsa.addAttrezzo(a11);
		
		comandoPosa=new ComandoPosa();
		
		
		partita  = new Partita();
		this.io=new IOConsole();
		comandoPosa.setIo(io);
	}

	@Test
	void testComandoPosaEseguiAttrezzoPresente() {
		partita.setStanzaCorrente(s);
		comandoPosa.setParametro("attrezzo_11");
		comandoPosa.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("attrezzo_11"));
		
	}
	@Test
	void testComandoPosaEseguiAttrezzoInesistente() {
	//	partita.setStanzaCorrente(s);
		comandoPosa.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("attrezzo_11"));
	}
	
	
	@Test
	void testComandoPosaEseguiStanzaPiena() {
		s.addAttrezzo(a10);
		partita.setStanzaCorrente(s);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("attrezzo_10"));
		comandoPosa.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("attrezzo_11"),"commento:Borsa piena");
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo_11"));

	}
}
