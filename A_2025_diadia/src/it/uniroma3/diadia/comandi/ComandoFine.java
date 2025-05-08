package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {
	private IO io;
    private static final String NOME = "fine";
    public static final String MESSAGGIO_FINE="Grazie di aver giocato!";
    
    
	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		io.mostraMessaggio(MESSAGGIO_FINE);
	}


	@Override
	public void setParametro(String parametro) {
		
	}


	@Override
	public String getNome() {
		return NOME;
	}


	@Override
	public void setIo(IO io) {
		this.io = io;
	}


	@Override
	public String getParametro() {
		return null;
	}

}
