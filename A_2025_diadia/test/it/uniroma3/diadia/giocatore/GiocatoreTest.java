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
	private Giocatore giocatore;


	@BeforeEach
	void setUp() throws Exception {
		this.partita = new Partita();
        this.giocatore = new Giocatore();
		
	}

	
	
	@Test
	public void testCfuNonFinitiInizioPartita() {
		assertNotEquals(0,this.giocatore.getCfu());
	}
	
	@Test
	public void testCfuIniziali() {
		assertEquals(Giocatore.CFU_INIZIALI,this.giocatore.getCfu());
	}

	
	

}
