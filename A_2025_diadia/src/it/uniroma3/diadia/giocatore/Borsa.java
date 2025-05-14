package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<>();// speriamo bastino...

	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		return this.attrezzi.add(attrezzo);
	}

	public int getPesoMax() {
		return pesoMax;
	}
//	public Attrezzo getAttrezzo(String nomeAttrezzo) {
//		Attrezzo a = null;
//		for (int i= 0; i<this.numeroAttrezzi; i++) {
//			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
//				a = attrezzi[i];
//		}
//		return a;
//	}

	public int getPeso() {
		int pesoTotale = 0;
		for (Attrezzo attrezzo : attrezzi) {
			pesoTotale += attrezzo.getPeso();
		}
		return pesoTotale;
	}

//	
//	public boolean isEmpty() {
//		return this.numeroAttrezzi == 0;
//	}
//	public boolean hasAttrezzo(String nomeAttrezzo) {
//		return this.getAttrezzo(nomeAttrezzo)!=null;
//	}
//	
//	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
//		Attrezzo a = null;
//		for(int i=0;i<this.numeroAttrezzi;i++) {
//			if(this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
//			a = this.attrezzi[i];
//			this.attrezzi[i] = this.attrezzi[this.numeroAttrezzi-1];
//			this.attrezzi[this.numeroAttrezzi-1] = null;
//			this.numeroAttrezzi--;
//			}
//		}
//		return a;
//	}

//	public String toString() {
//		StringBuilder s = new StringBuilder();
//
//		if (!this.isEmpty()) {
//			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
//			for (Attrezzo attrezzo:attrezzi)
//				s.append(attrezzi.toString()+" ");
//		}
//		else
//			s.append("Borsa vuota");
//		return s.toString();
//	}
//

	// esterno
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		final List<Attrezzo> listaOrdinata = new ArrayList<>(this.getAttrezzi());
		Collections.sort(listaOrdinata, new ComparatorePerPeso());
		// ensi: listaOrdinata.sort(new ComparatorePerPeso());
		return listaOrdinata;
	}

	private List<Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	//Interno
		public  List<Attrezzo> getContenutoOrdinatoPerNome(){
			final List<Attrezzo> listaOrdinata=new ArrayList<>(this.getAttrezzi());
			Collections.sort(listaOrdinata);
			return listaOrdinata;
		}
		
	//interno
	public SortedSet<Attrezzo> getContenutoOrdinatoNome(){
		return new TreeSet<>(this.getAttrezzi()) ;
	}

	public Integer getNumeroAttrezzi() {
	return this.attrezzi.size();
	}
	
	public Map<Integer, Set<Attrezzo>> getContenutoRagruppatoPerPeso(){
		
		final Map<Integer, Set<Attrezzo>> peso2Attrezzi=new HashMap<>();
		for(Attrezzo attrezzo :attrezzi) {
			int peso = attrezzo.getPeso();//refacotor su peso-->local variable
			Set<Attrezzo> attrezziStessoPeso=peso2Attrezzi.get(peso);
			if(attrezziStessoPeso!=null)
				attrezziStessoPeso.add(attrezzo);
			else {
				attrezziStessoPeso=new HashSet<>();
				attrezziStessoPeso.add(attrezzo);
				peso2Attrezzi.put(peso, attrezziStessoPeso);
			}
				
		}
		return peso2Attrezzi;
	}

}
