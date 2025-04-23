package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LabirintoTest {

	
	private Labirinto labirinto;

	@BeforeEach
	void setUp() throws Exception {
		this.labirinto = new Labirinto();
	}

	@Test
	void testStanzaInizialeNotNull() {
		assertNotNull(this.labirinto.getStanzaIniziale());
	}
	
	@Test
	void testStanzaVincenteNotNull() {
		assertNotNull(this.labirinto.getStanzaVincente());
	}

}
