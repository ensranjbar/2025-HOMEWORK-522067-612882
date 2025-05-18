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

	 private Borsa borsa;
	 private static final String ATTREZZO_DA_POSARE = "attrezzoDaPosare";
	 private ComandoPosa comandoPosa;
	 private Partita partita;
	 private IOConsole io;
	 
	 Attrezzo attrezzoNuovo;
	@BeforeEach
	void setUp() throws Exception {
		
		comandoPosa=new ComandoPosa();
		partita  = new Partita();
		
		borsa=partita.getGiocatore().getBorsa();
		this.io=new IOConsole();
		comandoPosa.setIo(io);
		
		attrezzoNuovo = new Attrezzo(ATTREZZO_DA_POSARE,1);
		borsa.addAttrezzo(attrezzoNuovo);
	}

	@Test
	void testComandoPosaEseguiAttrezzoPresente() {
		comandoPosa.setParametro(ATTREZZO_DA_POSARE);
		comandoPosa.esegui(partita);
	
		assertEquals(attrezzoNuovo, partita.getStanzaCorrente().getAttrezzo(ATTREZZO_DA_POSARE));
		assertFalse(partita.getGiocatore().getBorsa().getMappaAttrezzi().containsKey(ATTREZZO_DA_POSARE));
		
	}
	@Test
	void testComandoPosaEseguiAttrezzoInesistente() {
        String nomeNonPresente = "attrezzoNonPresente";
        this.comandoPosa.setParametro(nomeNonPresente);
		comandoPosa.esegui(partita);
		assertNull(partita.getStanzaCorrente().getAttrezzo(nomeNonPresente));
		assertNull(partita.getStanzaCorrente().getAttrezzo(ATTREZZO_DA_POSARE));
		assertTrue(partita.getGiocatore().getBorsa().getMappaAttrezzi().containsKey(ATTREZZO_DA_POSARE));
	}
	
	//E' stato commentato dopo aver tolto il limite oggetti nella stanza
//	@Test
//	void testComandoPosaEseguiStanzaPiena() {
//		
//		Stanza stanzaCorrente = partita.getStanzaCorrente();
//		
//		for(int i = 0; i < Stanza.NUMERO_MASSIMO_ATTREZZI; i++) {
//			stanzaCorrente.addAttrezzo(new Attrezzo("attrezzo"+i,1));
//		}
//		this.comandoPosa.setParametro(ATTREZZO_DA_POSARE);
//	
//		this.comandoPosa.esegui(partita);
//		assertFalse(stanzaCorrente.hasAttrezzo(ATTREZZO_DA_POSARE),"commento:Borsa piena");
////		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_DA_POSARE));
//
//	}
}
