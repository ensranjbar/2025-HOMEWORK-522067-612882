package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {
    
	
	private Partita partita;
	private Borsa borsa;
	private Attrezzo attrezzo;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private Giocatore giocatore;

	@BeforeEach
	void setUp() throws Exception {
		this.partita = new Partita();
		this.giocatore = new Giocatore();
		this.borsa = new Borsa();
		this.attrezzo = new Attrezzo("penna",1);
		this.attrezzo1 = new Attrezzo("pc",1);
		this.attrezzo2 = new Attrezzo("matita",1);
		
	}

	@Test
	public void testPartitaFinitaAZeroCfu() {
		this.partita.setCfu(0);
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testPartitaNonFinitaAZeroCfu() {
		this.partita.setCfu(3);
		assertFalse(this.partita.isFinita());
	}
	
	//TEST POSA
//	@Test
//	public void testPosaAttrezzoNonEsistente() {
//		assertFalse(this.borsa.hasAttrezzo("bottiglia"));
//		this.giocatore.posa("bottiglia");
//		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("bottiglia"));
//	}
//	
//	@Test
//	public void testPosaAttrezzoEsistente() {
//		assertFalse(this.borsa.hasAttrezzo("matita"));
//		this.borsa.addAttrezzo(attrezzo2);
//		this.giocatore.posa("matita");
//		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("matita"));
//	}
	
//	//TEST PRENDI
//	@Test
//	public void testPrendiAttrezzoEsistente() {}
//	
//	@Test
//	public void testPrendiAttrezzoNonEsistente() {}
	
	

}
