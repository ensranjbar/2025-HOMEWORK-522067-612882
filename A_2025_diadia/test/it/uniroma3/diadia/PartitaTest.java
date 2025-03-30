package it.uniroma3.diadia;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	private Partita partita;
	Stanza stanzaVincente;
	Stanza stanzaNonVincente;
	
	@Before 
	public void setUp() {
		this.partita=new Partita();
		stanzaVincente=this.partita.getStanzaVincente();
		stanzaNonVincente=new Stanza("Qualsiasi");
		
	}
	
	//i test per metodo vinta
	@Test
	public void testStanzaCorrenteNonVincente() {
		this.partita.setStanzaCorrente(stanzaNonVincente);
	assertFalse(this.partita.vinta());
	}
	@Test
	public void testStanzaCorrenteVincente() {
		this.partita.setStanzaCorrente(stanzaVincente);
	assertTrue(this.partita.vinta());
	}

	@Test
	public void testStanzaCorrentenNull() {
		stanzaVincente=null;
		this.partita.setStanzaCorrente(null);
	assertFalse(this.partita.vinta());
	}

	
	//i test per il metodo isFinita
	
	@Test
	public void testFinitaTrue() {
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}
	@Test
	public void testVintaTrue() {
		this.partita.setStanzaCorrente(stanzaVincente);
		assertTrue(this.partita.isFinita());
	}
	
	
	
	@Test
	public void testIsfinitaFalse() {
		this.partita.setStanzaCorrente(stanzaNonVincente);
		assertFalse(this.partita.isFinita());
	}

	@Test
	public void testIsfinita() {
		assertFalse(this.partita.isFinita());
	}
	
	

	
	
}
