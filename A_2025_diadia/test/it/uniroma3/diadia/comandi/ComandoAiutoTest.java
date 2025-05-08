package it.uniroma3.diadia.comandi;
 
import static org.junit.jupiter.api.Assertions.*;
 
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
 
import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
 
 
public class ComandoAiutoTest {
 
	@Before
	public void setUp() throws Exception {
	}
 
 
public IOSimulator IOPreparaGioco(String[] righeDaLeggere) {
 
	IOSimulator io= new IOSimulator(righeDaLeggere);
	new DiaDia(io).gioca();	
	return io;
}
	@Test
	public void testPartitaConComandoAiuto() {
		 String[] righeDaLeggere = {"aiuto", "fine"};
		    IOSimulator io = IOPreparaGioco(righeDaLeggere);
 
		    // 1. Messaggio di benvenuto
		    assertTrue(io.hasNextMessaggio());
		    assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
 
		    // 2. Messaggi del comando aiuto (uno per ogni comando supportato)
		    for (String comando : ComandoAiuto.elencoComandi) {
		        assertTrue(io.hasNextMessaggio());
		        assertEquals(comando + " ", io.nextMessaggio());
		    }
 
		    // 3. Messaggio di fine
		    io.nextMessaggio();
		    assertTrue(io.hasNextMessaggio());
		    assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
	}
}
