package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

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

public class Stanza implements Comparable<Stanza> {

	static final private int NUMERO_MASSIMO_DIREZIONI = 4;

	private String nome;

	private Map<String, Attrezzo> nome2attrezzo;

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
		this.nome2attrezzo = new HashMap<>();
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza    stanza adiacente nella direzione indicata dal primo
	 *                  parametro.
	 */
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		
		if(direzione!=null && this.stanzeAdiacenti.size()<NUMERO_MASSIMO_DIREZIONI)
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
		return this.nome2attrezzo.size();
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
	public Set<Attrezzo> getAttrezzi() {
		return new TreeSet<Attrezzo>(this.nome2attrezzo.values());
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * 
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {

		if(attrezzo!=null) {
			this.nome2attrezzo.put(attrezzo.getNome(), attrezzo);
			return true;
		}
		
		return false;

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
		risultato.append(this.getDirezioni().toString());
		risultato.append("\nAttrezzi nella stanza: ");
		risultato.append(this.getAttrezzi().toString());
		return risultato.toString();
	}
	
	

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * 
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	//abbaimo commentato perch� possiamo utilizzare metodi esistenti nei collezioni
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.nome2attrezzo.containsKey(nomeAttrezzo);
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * 
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza. null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.nome2attrezzo.get(nomeAttrezzo);
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * 
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo wanted) {
		if(wanted!=null) {
			this.nome2attrezzo.remove(wanted.getNome(), wanted);
		}
		
		return false;

	}

	public Set<String> getDirezioni() {
		return this.stanzeAdiacenti.keySet();
	}

	
	
	
	@Override
	public int hashCode() {
	return this.getNome().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
	Attrezzo that=(Attrezzo)obj;
	return this.getNome().equals(that.getNome());
	}

	public Set<Stanza> getMapStanzeAdiacenti() {
		// TODO Auto-generated method stub
		return new TreeSet<Stanza > (this.stanzeAdiacenti.values());
	}

	@Override
	public int compareTo(Stanza that) {
	
			int cmp=this.getNome().compareTo(that.getNome());

			return cmp;
		
			}





}