package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public interface Comando {
	public void esegui(Partita partita);
	public  void setParametro(String parametro);
	public String getNome();
	public void setIo(IO io);
	public String getParametro();
}
