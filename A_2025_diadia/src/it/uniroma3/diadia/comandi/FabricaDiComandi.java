package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

public interface FabricaDiComandi {	
	public Comando costruisciComando(String istruzione,IO io) ;

}
