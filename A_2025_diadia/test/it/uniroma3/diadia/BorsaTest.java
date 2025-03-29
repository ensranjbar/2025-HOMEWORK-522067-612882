package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BorsaTest {

	private Borsa borsa;
	private Attrezzo attrezzo;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private Attrezzo attrezzo3;
	private Attrezzo attrezzo4;
	private Attrezzo attrezzo5;
	private Attrezzo attrezzo6;
	private Attrezzo attrezzo7;
	private Attrezzo attrezzo8;
	private Attrezzo attrezzo9;
	private Attrezzo attrezzo10;
	
	

	@BeforeEach
	void setUp() throws Exception {
		this.borsa = new Borsa();
		this.attrezzo = new Attrezzo("penna",1);
		this.attrezzo1 = new Attrezzo("pc",1);
		this.attrezzo2 = new Attrezzo("matita",1);
		this.attrezzo3 = new Attrezzo("libro",1);
		this.attrezzo4 = new Attrezzo("cell",1);
		this.attrezzo5 = new Attrezzo("bottiglia",1);
		this.attrezzo6 = new Attrezzo("cuffie",1);
		this.attrezzo7 = new Attrezzo("occhiali",1);
		this.attrezzo8 = new Attrezzo("medicina",1);
		this.attrezzo9 = new Attrezzo("quaderno",1);
		this.attrezzo10 = new Attrezzo("tablet",1);
		
		
	}

	@Test
	void testRemoveAttrezzoConBorsaVuota() {
		assertNull(this.borsa.removeAttrezzo("penna"));
	}
	
	@Test
	void testRemoveAttrezzoConAttrezzoPresente() {
		assertNull(this.borsa.removeAttrezzo("penna"));
		this.borsa.addAttrezzo(attrezzo);
		this.borsa.removeAttrezzo("penna");
		assertFalse(this.borsa.hasAttrezzo("penna"));
	}
	
	@Test
	void testRemoveAttrezzoNonPresente() {
		assertNull(this.borsa.removeAttrezzo("penna"));
		this.borsa.addAttrezzo(attrezzo);
		assertNull(this.borsa.removeAttrezzo("pc"));
	}
	
	//TEST PER ADD ATTREZZO
	
	@Test
	void testAddNessunAttrezzo(){
		assertFalse(this.borsa.hasAttrezzo("penna"));
	}
	
	@Test
	void testAddAttrezzo() {
		assertFalse(this.borsa.hasAttrezzo("penna"));
		this.borsa.addAttrezzo(attrezzo);
		assertTrue(this.borsa.hasAttrezzo("penna"));
	}
	
	@Test
	void AddAttrezzoSopraPesoMax10() {
		this.borsa.addAttrezzo(attrezzo);
		assertTrue(this.borsa.hasAttrezzo("penna"));
		
		this.borsa.addAttrezzo(attrezzo1);
		this.borsa.addAttrezzo(attrezzo2);
		this.borsa.addAttrezzo(attrezzo3);
		this.borsa.addAttrezzo(attrezzo4);
		this.borsa.addAttrezzo(attrezzo5);
		this.borsa.addAttrezzo(attrezzo6);
		this.borsa.addAttrezzo(attrezzo7);
		this.borsa.addAttrezzo(attrezzo8);
		this.borsa.addAttrezzo(attrezzo9);
		this.borsa.addAttrezzo(attrezzo10);
		assertFalse(this.borsa.hasAttrezzo("tablet"));
	}
	
	
	
	@Test
	void AddAttrezzoConBorsaPiena10Attrezzi() {
		this.borsa.addAttrezzo(attrezzo);
		assertTrue(this.borsa.hasAttrezzo("penna"));
		
		this.borsa.addAttrezzo(attrezzo1);
		this.borsa.addAttrezzo(attrezzo2);
		this.borsa.addAttrezzo(attrezzo3);
		this.borsa.addAttrezzo(attrezzo4);
		this.borsa.addAttrezzo(attrezzo5);
		this.borsa.addAttrezzo(attrezzo6);
		this.borsa.addAttrezzo(attrezzo7);
		this.borsa.addAttrezzo(attrezzo8);
		this.borsa.addAttrezzo(attrezzo9);
		this.borsa.addAttrezzo(attrezzo10);
		assertFalse(this.borsa.hasAttrezzo("tablet"));
	}
	
	
	
	
	
	

}
