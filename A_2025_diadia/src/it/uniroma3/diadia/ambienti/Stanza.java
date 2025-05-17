package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo. Una stanza e' un luogo
 * fisico nel gioco. E' collegata ad altre stanze attraverso delle uscite. Ogni
 * uscita e' associata ad una direzione.
 * 
 * @author docente di POO
 * @see Attrezzo
 * @version base
 */

/*
 * DOBBIAMO USARE MAPPE PER ATTREZZI PERCHE' I NOMI DEGLI ATTREZZI DONO UNIVOCI
 * GLOBALMENTE NEL LABIRINTO, NON SOLO NELLA STANZA O NELLA BORSA. VA GESTITO
 * NEL COSTRUTTORE DI LABIRINTO.
 * 
 * 
 * 
 */

public class Stanza {

	static final private int NUMERO_MASSIMO_DIREZIONI = 4;

	private String nome;

	private List<Attrezzo> attrezzi;

	private Map<String, Stanza> stanzeAdiacenti;

	// private List<String> direzioni;

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * 
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;

		// this.direzioni = new ArrayList<>();
		this.stanzeAdiacenti = new HashMap<String, Stanza>();
		this.attrezzi = new ArrayList<>();
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza    stanza adiacente nella direzione indicata dal primo
	 *                  parametro.
	 */
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		
		if(direzione!=null)
		this.stanzeAdiacenti.put(direzione, stanza);
		/*
		 * boolean aggiornato = false;
		 * 
		 * //QUANDO ABBIAMO 2 LISTE PARALLELIZZATE
		 * 
		 * for(int i=0; i<this.direzioni.size(); i++){
		 * 
		 * if (Objects.equals(this.direzioni.get(i), direzione)) {
		 * this.stanzeAdiacenti.set(i, stanza); aggiornato = true; break; } }
		 * 
		 * 
		 * if (!aggiornato && this.stanzeAdiacenti.size() < NUMERO_MASSIMO_DIREZIONI) {
		 * this.direzioni.add(direzione); this.stanzeAdiacenti.add(stanza); }
		 */
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * 
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		return this.stanzeAdiacenti.get(direzione);
		/*
		 * Stanza stanza = null; for (int i = 0; i < this.stanzeAdiacenti.size(); i++)
		 * if (this.direzioni.get(i).equals(direzione)) stanza =
		 * this.stanzeAdiacenti.get(i); return stanza;
		 */
	}

	/**
	 * Restituisce la nome della stanza.
	 * 
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	public int getNumeroAttrezzi() {
		return this.attrezzi.size();
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * 
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * 
	 * @return la collezione di attrezzi nella stanza.
	 */
	public List<Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * 
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {

		return this.attrezzi.add(attrezzo);

	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza, stampadone la
	 * descrizione, le uscite e gli eventuali attrezzi contenuti
	 * 
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		for (String direzione : stanzeAdiacenti.keySet()) {
			if(direzione!=null)
			risultato.append(direzione).append("");
		}
		/*
		 * for (String direzione : this.direzioni) if (direzione != null)
		 * risultato.append(" " + direzione);
		 * 
		 */
		risultato.append("\nAttrezzi nella stanza: ");

		Iterator<Attrezzo> it = this.attrezzi.iterator();

		while (it.hasNext()) {
			Attrezzo attrezzo = it.next();
			risultato.append(attrezzo.toString()).append(" ");
		}

		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * 
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	//abbaimo commentato perchè possiamo utilizzare metodi esistenti nei collezioni
	/*public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato;
		trovato = false;

		Iterator<Attrezzo> it = this.attrezzi.iterator();

		while (it.hasNext()) {
			Attrezzo attrezzo = it.next();
			if (attrezzo.getNome().equals(nomeAttrezzo))
				trovato = true;
		}
		return trovato;
	}*/

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * 
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza. null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;

		Iterator<Attrezzo> it = this.attrezzi.iterator();

		while (it.hasNext()) {

			Attrezzo attrezzo = it.next();
			if (attrezzo.getNome().equals(nomeAttrezzo))
				attrezzoCercato = attrezzo;
		}
		return attrezzoCercato;
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * 
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo wanted) {

		Iterator<Attrezzo> it = this.attrezzi.iterator();

		while (it.hasNext()) {

			Attrezzo attrezzo = it.next();
			if (attrezzo == wanted) {
				 it.remove();
				 return true;
			}

		}
		return false;

	}

	public Set<String> getDirezioni() {
		return this.stanzeAdiacenti.keySet();
	}

}