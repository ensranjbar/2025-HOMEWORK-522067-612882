
//COMMENTO RELEASE 6

package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoFine;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author docente di POO (da un'idea di Michael Kolling and David J. Barnes)
 * 
 * @version base
 */

public class DiaDia {

	public static final String MESSAGGIO_BENVENUTO = ""
			+ "Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n"
			+ "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"
			+ "I locali sono popolati da strani personaggi, " + "alcuni amici, altri... chissa!\n"
			+ "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"
			+ "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n"
			+ "o regalarli se pensi che possano ingraziarti qualcuno.\n\n"
			+ "Per conoscere le istruzioni usa il comando 'aiuto'.";

	//static final private String[] elencoComandi = { "vai", "aiuto", "fine", "posa", "prendi" };

	private Partita partita;
	private IO io;

	public DiaDia(IO io) {
		this.partita = new Partita();
		this.io = io;
	}

	public DiaDia(Labirinto labirinto, IO io) {
		this.partita = new Partita(labirinto);
		this.io=io;
	}
	
	public void gioca() {
		String istruzione;
		// Scanner scannerDiLinee;

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		// scannerDiLinee = new Scanner(io.leggiRiga());
		do
			istruzione = this.io.leggiRiga();

		while (!processaIstruzione(istruzione));
	}

	/**
	 * Processa una istruzione
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false
	 *         altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		/*	Comando comandoDaEseguire = new Comando(istruzione);
	 
			if (comandoDaEseguire.getNome() == null) {
				return false;
			}
	 
			if (comandoDaEseguire.getNome().equals("fine")) {
				this.fine();
				return true;
			} else if (comandoDaEseguire.getNome().equals("vai"))
				this.vai(comandoDaEseguire.getParametro());
			else if (comandoDaEseguire.getNome().equals("aiuto"))
				this.aiuto();
			else if (comandoDaEseguire.getNome().equals("posa"))
				this.posa(comandoDaEseguire.getParametro());
			else if (comandoDaEseguire.getNome().equals("prendi"))
				this.prendi(comandoDaEseguire.getParametro());
			else
				io.mostraMessaggio("Comando sconosciuto");
				*/
			Comando comandoDaEseguire;
			FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
			comandoDaEseguire = factory.costruisciComando(istruzione,io);
			comandoDaEseguire.esegui(this.partita);
			if (this.partita.isFinita()) {
	 
				if (this.partita.vinta()) {
					io.mostraMessaggio("Hai vinto!");
					return true;
				}
				else {
				if(this.partita.getGiocatore().getCfu()==0) {
					io.mostraMessaggio("Hai perso! Hai finito i cfu");
					return true;
				}
				else {
					io.mostraMessaggio(ComandoFine.MESSAGGIO_FINE);
					return true;
				}
				}
			}
			else  return false;
		}

	public static void main(String[] argc) {
		/* N.B. unica istanza di IOConsole
		di cui sia ammessa la creazione */
		IO io = new IOConsole();
		Labirinto labirinto = new LabirintoBuilder()
				.addStanzaIniziale("LabCampusOne")
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("LabCampusOne","Biblioteca","ovest")
				.getLabirinto();
		DiaDia gioco = new DiaDia(labirinto, io);
		gioco.gioca();
		}
//	public static void main(String[] argc) {
//		IOConsole io = new IOConsole();
//		DiaDia gioco = new DiaDia(io);
//		gioco.gioca();
//	}

}