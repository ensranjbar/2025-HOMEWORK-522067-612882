package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {
	private IO io;
	private static final String NOME = "guarda";
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio(partita.toString() );

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
