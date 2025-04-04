package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

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

	static final private String MESSAGGIO_BENVENUTO = ""
			+ "Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n"
			+ "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"
			+ "I locali sono popolati da strani personaggi, " + "alcuni amici, altri... chissa!\n"
			+ "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"
			+ "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n"
			+ "o regalarli se pensi che possano ingraziarti qualcuno.\n\n"
			+ "Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = { "vai", "aiuto", "fine", "posa", "prendi" };

	private Partita partita;
	private Labirinto labirinto;
	private IOConsole io;

	public DiaDia(IOConsole io) {
		this.partita = new Partita();
		this.io=io;
	}

	public void gioca() {
		String istruzione;
		//Scanner scannerDiLinee;

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		//scannerDiLinee = new Scanner(io.leggiRiga());
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
		Comando comandoDaEseguire = new Comando(istruzione);

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
		if (this.partita.isFinita()) {

			if (this.partita.vinta()) {
				io.mostraMessaggio("Hai vinto!");
				return true;
			}
			io.mostraMessaggio("Hai perso! Hai finito i cfu");

			return true;
		}
		return false;
	}

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for (int i = 0; i < elencoComandi.length; i++)
			System.out.print(elencoComandi[i] + " ");
		System.out.println();
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra e ne stampa il
	 * nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if (direzione == null)
			io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;

		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getCfu();
			this.partita.setCfu(cfu - 1);
		}
		io.mostraMessaggio(this.partita.toString());

	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!"); // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole io =new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}

	public void posa(String nomeAttrezzo) {
		Attrezzo a = null;
		if (this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			a = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
			this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			this.partita.getStanzaCorrente().addAttrezzo(a);
			io.mostraMessaggio("\n Attrezzo "+  nomeAttrezzo + " posata");
		}
		 else {
			 io.mostraMessaggio("Attrezzo non esistente!");
		 }
		io.mostraMessaggio(this.partita.toString());
	}

	
	public void prendi(String nomeAttrezzo) {
		Attrezzo a = null;

		if (this.partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			a= this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
						
			this.partita.getGiocatore().getBorsa().addAttrezzo(a);
			this.partita.getStanzaCorrente().removeAttrezzo(a);
			io.mostraMessaggio("\n Attrezzo "+  nomeAttrezzo + " preso");

		} else {
			io.mostraMessaggio("Attrezzo non esistente!");
		}
		io.mostraMessaggio(this.partita.toString());
	}

}