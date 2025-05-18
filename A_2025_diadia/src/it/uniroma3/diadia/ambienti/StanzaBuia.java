package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuia extends Stanza {
	
	public static final String MESSAGGIO_STANZA_BUIA = "Qui c'�c un buio pesto!";
	private String nomeAttrezzo;

	public StanzaBuia(String nome, String nomeAttrezzo) {
		super(nome);
		this.nomeAttrezzo = nomeAttrezzo;
	}
	
	@Override
	public String getDescrizione() {
		Attrezzo a = super.getAttrezzo(nomeAttrezzo);
		if(a==null) {
			return MESSAGGIO_STANZA_BUIA;
		}
		
		else {
			return super.getDescrizione();
		}
		
	}

}
