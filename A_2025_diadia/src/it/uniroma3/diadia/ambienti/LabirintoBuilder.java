package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {

	Labirinto labirinto;
	private Map<String,Stanza> nome2stanza;
	private Stanza ultimaAggiunta;

	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.nome2stanza = new HashMap<String, Stanza>();
	}

	public LabirintoBuilder addStanzaIniziale(String nomeStanzaIniziale) {
		Stanza iniziale = new Stanza(nomeStanzaIniziale);
		this.labirinto.setStanzaIniziale(iniziale);
		this.aggiungiAMappaEAggiornaUltima(iniziale);
		return this;
	}
	
	
	
	public LabirintoBuilder addStanzaVincente(String nomeStanzaVincente) {
		Stanza vincente = new Stanza(nomeStanzaVincente);
		this.labirinto.setStanzaVincente(vincente);
		this.aggiungiAMappaEAggiornaUltima(vincente);
		return this;
	}
	
	public LabirintoBuilder addAdiacenza(String partenza,String adiacente,String direzione) {
		Stanza stanzaPartenza = this.nome2stanza.get(partenza);
		Stanza stanzaAdiacente = this.nome2stanza.get(adiacente);
		
		stanzaPartenza.impostaStanzaAdiacente(direzione, stanzaAdiacente);
		return this;
	}
	
	public LabirintoBuilder aggiungiAttrezzo(String nomeAttrezzo, int peso) {
		Attrezzo a = new Attrezzo(nomeAttrezzo, peso);
		this.ultimaAggiunta.addAttrezzo(a);
		return this;
	}
	
	public LabirintoBuilder addStanza(String nomeStanza) {
		Stanza stanza = new Stanza(nomeStanza);
		this.aggiungiAMappaEAggiornaUltima(stanza);
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String nomeStanza) {
		Stanza stanza = new StanzaMagica(nomeStanza);
		this.aggiungiAMappaEAggiornaUltima(stanza);
		return this;
	}
	
	public LabirintoBuilder addStanzaBuia(String nomeStanza,String nomeAttrezzoPerVedere) {
		Stanza stanza = new StanzaBuia(nomeStanza,nomeAttrezzoPerVedere);
		this.aggiungiAMappaEAggiornaUltima(stanza);
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata(String nomeStanza, String direzioneBloccata, String oggettoCheSblocca) {
		Stanza stanza = new StanzaBloccata(nomeStanza,direzioneBloccata,oggettoCheSblocca);
		this.aggiungiAMappaEAggiornaUltima(stanza);
		return this;
	}
	
	
	

	/**
	 * Crea tutte le stanze e le porte di collegamento
	 */



	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	private void aggiungiAMappaEAggiornaUltima(Stanza stanza) {
		this.ultimaAggiunta = stanza;
		this.nome2stanza.put(stanza.getNome(), stanza);
	}

//	public Set<Attrezzo> getListaStanze() {
//		List <Stanza> stanze=new ArrayList<Stanza>(this.nome2stanza.values());
//		Set<Attrezzo> attrezzi=new TreeSet<Attrezzo>();
//	for(Stanza s:stanze) {
//		attrezzi.addAll(s.getAttrezzi());
//
//	}
//		
//		return attrezzi;
//	}

	public Set<Stanza > getListaStanze() {
		return new TreeSet<Stanza>(this.nome2stanza.values());
	}
}


