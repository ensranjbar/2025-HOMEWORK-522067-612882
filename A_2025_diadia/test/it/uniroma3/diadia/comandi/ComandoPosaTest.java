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
	@BeforeEach
	void setUp() throws Exception {
		
		comandoPosa=new ComandoPosa();
		partita  = new Partita();
		
		borsa=partita.getGiocatore().getBorsa();
		this.io=new IOConsole();
		comandoPosa.setIo(io);
		
		Attrezzo attrezzoNuovo = new Attrezzo(ATTREZZO_DA_POSARE,1);
		borsa.addAttrezzo(attrezzoNuovo);
	}

	@Test
	void testComandoPosaEseguiAttrezzoPresente() {
		comandoPosa.setParametro(ATTREZZO_DA_POSARE);
		comandoPosa.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo(ATTREZZO_DA_POSARE));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_DA_POSARE));
		
	}
	@Test
	void testComandoPosaEseguiAttrezzoInesistente() {
        String nomeNonPresente = "attrezzoNonPresente";
        this.comandoPosa.setParametro(nomeNonPresente);
		comandoPosa.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo(nomeNonPresente));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo(ATTREZZO_DA_POSARE));
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_DA_POSARE));
	}
	
	
	@Test
	void testComandoPosaEseguiStanzaPiena() {
		
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		
		for(int i = 0; i < Stanza.NUMERO_MASSIMO_ATTREZZI; i++) {
			stanzaCorrente.addAttrezzo(new Attrezzo("attrezzo"+i,1));
		}
		this.comandoPosa.setParametro(ATTREZZO_DA_POSARE);
	
		this.comandoPosa.esegui(partita);
		assertFalse(stanzaCorrente.hasAttrezzo(ATTREZZO_DA_POSARE),"commento:Borsa piena");
//		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_DA_POSARE));

	}
}
