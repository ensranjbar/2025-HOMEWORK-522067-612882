package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaTest {
	
	private StanzaMagica sm;
	private StanzaMagica sm2;
	
	private Attrezzo a;
	

	@BeforeEach
	void setUp() throws Exception {
		sm = new StanzaMagica("s1");
		sm2 = new StanzaMagica("s2",5);
		a = new Attrezzo("att",1);
	}

	@Test
	void testAddAttrezzoMagico() {
		for(int i = 0; i < StanzaMagica.SOGLIA_MAGICA_DEFAULT; i++) {
			sm.addAttrezzo(new Attrezzo("attrezzo"+i,1));
		}
		
		sm.addAttrezzo(a);
//		assertTrue(sm.getAttrezzi.contains(a));
		assertEquals("tta",sm.getAttrezzo("tta").getNome());
		assertEquals(2,sm.getAttrezzo("tta").getPeso());
	}
	
	@Test
	void testAddAttrezzoNonMagico() {
		for(int i = 0; i < sm2.getSogliaMagica() - 1; i++) {
			sm2.addAttrezzo(new Attrezzo("attrezzo"+i,1));
		}
		
		sm2.addAttrezzo(a);
		assertEquals("att",sm2.getAttrezzo("att").getNome());
		assertEquals(1,sm2.getAttrezzo("att").getPeso());
	}

}
