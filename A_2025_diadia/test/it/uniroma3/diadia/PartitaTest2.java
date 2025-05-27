package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest2 {
	
	private Partita partita1;
	private Labirinto labirinto1;
	private LabirintoBuilder lb;
	private String stanzaVincente = "sv";
	private String stanzaIniziale = "si";

	@BeforeEach
	void setUp() throws Exception {
		this.partita1 = new Partita();
		this.lb = new LabirintoBuilder();
		this.labirinto1 = lb.addStanzaIniziale("si")
				.addStanzaVincente("sv")
				.getLabirinto();
		
		partita1.setLabirinto(labirinto1);
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
