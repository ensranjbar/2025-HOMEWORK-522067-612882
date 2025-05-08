package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IOSimulatorTest {
	
	private IOSimulator io;
	final static String input = "vai sud\nguarda\nprendi penna\nposa lampada\nfine\n";
    private DiaDia gioco;

	@BeforeEach
	void setUp() throws Exception {
		
		io = new IOSimulator(input);
		gioco = new DiaDia(io);
		
	}

	@Test
	void testPartitaSimulataUltimoOComandoFine() {
		
	}

}
