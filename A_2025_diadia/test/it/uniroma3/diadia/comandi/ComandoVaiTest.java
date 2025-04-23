package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

class ComandoVaiTest {
	
	private Stanza s1;
	private Stanza s2;
	private Stanza s;
	
	IOConsole io;
	
	private ComandoVai comandoVaiNull;
	private ComandoVai comandoVaiSud;
	private ComandoVai comandoVaiNord;
	private ComandoVai comandoVaiEst;
	
	private Partita partita;
	
	@BeforeEach
	void setUp() throws Exception {
		s1 = new Stanza("StanzaNord");
		s2 = new Stanza("StanzaSud");
		s = new Stanza("StanzaCorrente");
		
		io = new IOConsole();
		
		comandoVaiNull = new ComandoVai();
		comandoVaiNord = new ComandoVai("nord");
		comandoVaiSud = new ComandoVai("sud");
		comandoVaiEst = new ComandoVai("est");
		
		partita  = new Partita();
		
		s.impostaStanzaAdiacente("nord", s1);
		s.impostaStanzaAdiacente("sud", s2);
		
		partita.setStanzaCorrente(s);
		
		comandoVaiNull.setIo(io);
		comandoVaiNord.setIo(io);
		comandoVaiEst.setIo(io);
	}

	@Test
	void testEseguiDirezioneNull() {
		comandoVaiNull.esegui(partita);
		assertEquals(s,partita.getStanzaCorrente());
	}
	
	@Test
	void testEseguiDirezioneNord() {
		comandoVaiNord.esegui(partita);
		assertEquals(s1,partita.getStanzaCorrente());
	}
	
	@Test
	void testEseguiDirezioneInesistente() {
		comandoVaiEst.esegui(partita);
		assertNull(partita.getStanzaCorrente().getStanzaAdiacente("est"));
	}

}
