package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
	
	public static final String MESSAGGIO_STANZA_BUIA = "Qui c'èc un buio pesto!";
	private String nomeAttrezzo;

	public StanzaBuia(String nome, String nomeAttrezzo) {
		super(nome);
		this.nomeAttrezzo = nomeAttrezzo;
	}
	
	@Override
	public String getDescrizione() {
		if(!super.hasAttrezzo(nomeAttrezzo)) {
			return MESSAGGIO_STANZA_BUIA;
		}
		
		else {
			return super.getDescrizione();
		}
		
	}

}
