package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {
	private Borsa vuota;
	private Attrezzo piuma;
	private Attrezzo martello;
	private Borsa piena;
	private Attrezzo martelletto;
	private Attrezzo puma;
	
	@BeforeEach
	void setUp() throws Exception {
		this.vuota=new Borsa();
		this.piuma=new Attrezzo("piuma", 1);
		this.martello=new Attrezzo("martello", 9);
		this.piena=new Borsa();
		this.martelletto=new Attrezzo("martello", 2);
		this.puma=new Attrezzo("puma", 1);

	}
	
	@Test
	void testBorsaVuota() {
		assertEquals(0, vuota.getPeso());
	}
	
	@Test
	void testBorsa2Attrezzi() {
		vuota.addAttrezzo(piuma);
		vuota.addAttrezzo(martello);
		assertEquals(10, vuota.getPeso());
	}
	
	
	
	/*****************************************************************************************************************/
	/*****************************************************************************************************************/
		/**************************************getContenutoOrdinatoNome*****************************************/
	
	@Test
	void testGetContenutoOrdinatoNome_NomiUguali() {
		piena.addAttrezzo(martello);
		//piena.addAttrezzo(martelletto);
		assertEquals(1, piena.getNumeroAttrezzi());
		assertEquals(1, piena.getContenutoOrdinatoNome().size());
		piena.addAttrezzo(martelletto);
		assertEquals(1, piena.getNumeroAttrezzi());
    	assertEquals(1, piena.getContenutoOrdinatoNome().size()); 
		//treeset ha un svantaggio perche in sorted dobbiamo for
		//forzare ordinamento totale allora in comparto in attrezzo
	} 

	@Test
	void testGetContenutoOrdinatoNome_NomiDistinti() {
		piena.addAttrezzo(martello);
		//piena.addAttrezzo(martelletto);
		assertEquals(1, piena.getNumeroAttrezzi());
		assertEquals(1, piena.getContenutoOrdinatoNome().size());
		piena.addAttrezzo(piuma);
		assertEquals(2, piena.getNumeroAttrezzi());
    	assertEquals(2, piena.getContenutoOrdinatoNome().size()); 
		//treeset ha un svantaggio perche in sorted dobbiamo for
		//forzare ordinamento totale allora in comparto in attrezzo
	}
	
	
	
	
	
	//Caso1: mappa pesi distinti nomi distinti
	//Caso2: mappa nomi uguali per pesi distinti
	//!Caso3: mappa pesi uguali per nomi distinti
/*****************************************************************************************************************/
/*****************************************************************************************************************/
	/**************************************getContenutoRagruppatoPerPeso*****************************************/

	@Test
	void testGetContenutoRaggruppatoPerPeso_Mappa_borsa_vuota() {
		Map<Integer,Set<Attrezzo>> mappa=vuota.getContenutoRagruppatoPerPeso();
		assertTrue(mappa.isEmpty());
	}
	
	@Test
	void testGetContenutoRaggruppatoPerPeso_Mappa_PesiDistinti_NomiDistinti() {
		piena.addAttrezzo(martello);
		piena.addAttrezzo(piuma);
		assertEquals(2,piena.getNumeroAttrezzi());
		assertEquals(2,piena.getContenutoRagruppatoPerPeso().size());
	}
	
	
	@Test
	void testGetContenutoRaggruppatoPerPeso_Mappa_Pesiuguali_NomiDistinti() {
		piena.addAttrezzo(puma);
		piena.addAttrezzo(piuma);
		piena.addAttrezzo(martelletto);
		assertEquals(3,piena.getNumeroAttrezzi());
		Map<Integer, Set<Attrezzo>> r=piena.getContenutoRagruppatoPerPeso();
		
		assertEquals(2,r.size());
		assertTrue(r.containsKey(1));
		assertTrue(r.containsKey(2));
		assertTrue(r.get(1).contains(puma));
		assertTrue(r.get(1).contains(piuma));
		assertTrue(r.get(2).contains(martelletto));
		
	}
	
	/*Per come abbiamo gestito gli attrezzi nella borsa per mappa come NomeAttrezzo chiave
	 * e Attrezzo valore, allora aggiungendo due attrezzi con stesso nome è un errore,
	 * perché la chiave è univoca. Ma per noi è importante avere 2 attrezzi con nomi uguali
	 * e pesi diversi?
	 * 
	 * Dobbiamo cambiare attrezzi tramite lista invece che con la mappa?
	 * --->siamo arrivati a questo punto che meglio avere nomi distinti per attrezzi nel labirinto che la borsa
	 * per poter prendere e posare correttamente  allora manteniamo attrezzi con la mappa in Borsa  */
	@Test
	void testGetContenutoRaggruppatoPerPeso_Mappa_PesiDistinti_NomiUguali() {
		piena.addAttrezzo(martello);//9
		piena.addAttrezzo(martelletto);//2
//		assertEquals(1,piena.getNumeroAttrezzi());
		assertEquals(1,piena.getContenutoRagruppatoPerPeso().size());
		
		 assertTrue(piena.getContenutoRagruppatoPerPeso().containsKey(9));
	     assertFalse(piena.getContenutoRagruppatoPerPeso().containsKey(2));
	     assertTrue(piena.getContenutoRagruppatoPerPeso().get(9).contains(martello));
	     assertNull(piena.getContenutoRagruppatoPerPeso().get(2));
	}
	
	/*****************************************************************************************************************/
	/*****************************************************************************************************************/
		/**************************************getSortedSetOrdinatoPerPeso*****************************************/	
	
	@Test
	void testGetContenutoSortedSetOrdinatoPerPeso_BorsaVuota() {
		SortedSet<Attrezzo> s=vuota.getSortedSetOrdinatoPerPeso();
		assertTrue(s.isEmpty());
	}
	@Test
	void testGetContenutoSortedSetOrdinatoPerPeso_stessoPeso_nomiDiversi() {
		piena.addAttrezzo(piuma);
		assertEquals(1, piena.getNumeroAttrezzi());
		piena.addAttrezzo(puma);
		assertEquals(2, piena.getNumeroAttrezzi());
		assertEquals(2, piena.getPeso());
		/* s � uno snapshot statico, non si aggiorna dopo addAttrezzo(puma)
		Serve ricrearlo dopo l�aggiunta.*/
		SortedSet<Attrezzo> s=piena.getSortedSetOrdinatoPerPeso();
		assertTrue(s.contains(puma));
		assertEquals(2, s.size());
	}
	
	@Test
	void testGetContenutoSortedSetOrdinatoPerPeso_ordinamentoCorretto() {
		piena.addAttrezzo(piuma);
		piena.addAttrezzo(martelletto);
		piena.addAttrezzo(puma);
		SortedSet<Attrezzo> s=piena.getSortedSetOrdinatoPerPeso();
		
		Iterator <Attrezzo> it= s.iterator();
		Attrezzo primo=it.next();
		Attrezzo secondo=it.next();
		Attrezzo terzo=it.next();
		assertEquals("piuma",primo.getNome());
		assertEquals("puma",secondo.getNome());
		assertEquals("martello",terzo.getNome());
	}

//
//	private Borsa borsa;
//	private Attrezzo attrezzo;
//	private Attrezzo attrezzo1;
//	private Attrezzo attrezzo2;
//	private Attrezzo attrezzo3;
//	private Attrezzo attrezzo4;
//	private Attrezzo attrezzo5;
//	private Attrezzo attrezzo6;
//	private Attrezzo attrezzo7;
//	private Attrezzo attrezzo8;
//	private Attrezzo attrezzo9;
//	private Attrezzo attrezzo10;
//	
//	
//
//	@BeforeEach
//	void setUp() throws Exception {
//		this.borsa = new Borsa();
//		this.attrezzo = new Attrezzo("penna",1);
//		this.attrezzo1 = new Attrezzo("pc",1);
//		this.attrezzo2 = new Attrezzo("matita",1);
//		this.attrezzo3 = new Attrezzo("libro",1);
//		this.attrezzo4 = new Attrezzo("cell",1);
//		this.attrezzo5 = new Attrezzo("bottiglia",1);
//		this.attrezzo6 = new Attrezzo("cuffie",1);
//		this.attrezzo7 = new Attrezzo("occhiali",1);
//		this.attrezzo8 = new Attrezzo("medicina",1);
//		this.attrezzo9 = new Attrezzo("quaderno",1);
//		this.attrezzo10 = new Attrezzo("tablet",1);
//		
//		
//	}
//
//	@Test
//	void testRemoveAttrezzoConBorsaVuota() {
//		assertNull(this.borsa.removeAttrezzo("penna"));
//	}
//	
//	@Test
//	void testRemoveAttrezzoConAttrezzoPresente() {
//		assertNull(this.borsa.removeAttrezzo("penna"));
//		this.borsa.addAttrezzo(attrezzo);
//		this.borsa.removeAttrezzo("penna");
//		assertFalse(this.borsa.hasAttrezzo("penna"));
//	}
//	
//	@Test
//	void testRemoveAttrezzoNonPresente() {
//		assertNull(this.borsa.removeAttrezzo("penna"));
//		this.borsa.addAttrezzo(attrezzo);
//		assertNull(this.borsa.removeAttrezzo("pc"));
//	}
//	
//	//TEST PER ADD ATTREZZO
//	
//	@Test
//	void testAddNessunAttrezzo(){
//		assertFalse(this.borsa.hasAttrezzo("penna"));
//	}
//	
//	@Test
//	void testAddAttrezzo() {
//		assertFalse(this.borsa.hasAttrezzo("penna"));
//		this.borsa.addAttrezzo(attrezzo);
//		assertTrue(this.borsa.hasAttrezzo("penna"));
//	}
//	
//	@Test
//	void testAddAttrezzoSopraPesoMax10() {
//		this.borsa.addAttrezzo(attrezzo);
//		assertTrue(this.borsa.hasAttrezzo("penna"));
//		
//		this.borsa.addAttrezzo(attrezzo1);
//		this.borsa.addAttrezzo(attrezzo2);
//		this.borsa.addAttrezzo(attrezzo3);
//		this.borsa.addAttrezzo(attrezzo4);
//		this.borsa.addAttrezzo(attrezzo5);
//		this.borsa.addAttrezzo(attrezzo6);
//		this.borsa.addAttrezzo(attrezzo7);
//		this.borsa.addAttrezzo(attrezzo8);
//		this.borsa.addAttrezzo(attrezzo9);
//		this.borsa.addAttrezzo(attrezzo10);
//		assertFalse(this.borsa.hasAttrezzo("tablet"));
//	}
//	
//	@Test
//	void testAddAttrezzoConBorsaPiena10Attrezzi() {
//		this.borsa.addAttrezzo(attrezzo);
//		assertTrue(this.borsa.hasAttrezzo("penna"));
//		
//		this.borsa.addAttrezzo(attrezzo1);
//		this.borsa.addAttrezzo(attrezzo2);
//		this.borsa.addAttrezzo(attrezzo3);
//		this.borsa.addAttrezzo(attrezzo4);
//		this.borsa.addAttrezzo(attrezzo5);
//		this.borsa.addAttrezzo(attrezzo6);
//		this.borsa.addAttrezzo(attrezzo7);
//		this.borsa.addAttrezzo(attrezzo8);
//		this.borsa.addAttrezzo(attrezzo9);
//		this.borsa.addAttrezzo(attrezzo10);
//		assertFalse(this.borsa.hasAttrezzo("tablet"));
//	}
//	
//	//TEST HAS ATTREZZO
//	@Test
//	void testHasNessunAttrezzo() {
//		assertFalse(this.borsa.hasAttrezzo("penna"));
//	}
//	
//	@Test
//	void testHasAttrezzoPresente() {
//		assertFalse(this.borsa.hasAttrezzo("penna"));
//		this.borsa.addAttrezzo(attrezzo);
//		assertTrue(this.borsa.hasAttrezzo("penna"));
//	}
//	
//	
//	
//	
//	
	

}
