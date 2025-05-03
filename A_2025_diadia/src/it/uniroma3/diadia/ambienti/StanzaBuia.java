package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
	
	private static final String MESSAGGIO_STANZA_BUIA = "Qui c'è un buio pesto!";
	private String nomeAttrezzo;

	public StanzaBuia(String nome, String nomeattrezzo) {
		super(nome);
		// TODO Auto-generated constructor stub
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
