package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;

class FabbricaDiComandiFisarmonicaTest {
 private Comando comandoDaCostruire;
private FabricaDiComandi fc;

	
	@BeforeEach
	void setUp() throws Exception {
	fc=new FabbricaDiComandiFisarmonica ();
	
	}
	@Test
	public void testCostruisciComandoVuoto() {
		comandoDaCostruire=fc.costruisciComando("",new IOConsole());;
		
		assertEquals("non_valido",comandoDaCostruire.getNome());
	}
	@Test
	public void testCostruisciComandoNonValido() {
		comandoDaCostruire=fc.costruisciComando("tttt",new IOConsole());;
		
		assertEquals("non_valido",comandoDaCostruire.getNome());
	}

	@Test
	public void testCostruisciComandoAiuto() {
		comandoDaCostruire=fc.costruisciComando("aiuto",new IOConsole());;
		assertEquals("aiuto",comandoDaCostruire.getNome());
	}
	
	@Test
	public void testCostruisciComandoPosa() {
		comandoDaCostruire=fc.costruisciComando("posa",new IOConsole());;
		assertEquals("posa",comandoDaCostruire.getNome());
		String parametro="osso";
		comandoDaCostruire.setParametro(parametro);
		assertEquals("osso",comandoDaCostruire.getParametro());
		}
	
	
	@Test
	public void testCostruisciComandoPrendi() {
		comandoDaCostruire=fc.costruisciComando("prendi",new IOConsole());;
		assertEquals("prendi",comandoDaCostruire.getNome());
		String parametro="osso";
		comandoDaCostruire.setParametro(parametro);
		assertEquals("osso",comandoDaCostruire.getParametro());
		}
}
