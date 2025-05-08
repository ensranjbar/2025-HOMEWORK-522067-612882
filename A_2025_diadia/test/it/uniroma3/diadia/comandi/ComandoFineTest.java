package it.uniroma3.diadia.comandi;
 
import static org.junit.jupiter.api.Assertions.*;
 
import org.junit.After;
import org.junit.jupiter.api.Test;
 
import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
 
class ComandoFineTest {
 
	
	public IOSimulator IOPreparaGioco(String[] righeDaLeggere) {
 
		IOSimulator io= new IOSimulator(righeDaLeggere);
		new DiaDia(io).gioca();	
		return io;
	}
 
	

 
	
	@Test
	public void testPartitaConComandoFine() {
		 String[] righeDaLeggere = {"fine"};
		    IOSimulator io = IOPreparaGioco(righeDaLeggere);
 
		    // 1. Messaggio di benvenuto
		    assertTrue(io.hasNextMessaggio());
		    assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
	    io.nextMessaggio();
	    assertTrue(io.hasNextMessaggio());
	    assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
 
	}
}
