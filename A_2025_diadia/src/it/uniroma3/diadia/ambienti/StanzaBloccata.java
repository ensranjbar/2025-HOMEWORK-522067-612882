package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

	private String direzioneBloccata;
	private String oggettoCheSblocca;

	public final static String MESSAGGIO_STANZA_BLOCCATA = "La stanza � bloccata";

	public StanzaBloccata(String nome, String direzioneBloccata, String oggettoCheSblocca) {
		super(nome);
	 this.direzioneBloccata=direzioneBloccata ;
	  this.oggettoCheSblocca=oggettoCheSblocca;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if (direzione.equals(direzioneBloccata) && !(super.hasAttrezzo(oggettoCheSblocca))) {
			return this;
		}
		return super.getStanzaAdiacente(direzione);
	}


	@Override
	public String getDescrizione() {
	if (!super.hasAttrezzo(oggettoCheSblocca))
					return MESSAGGIO_STANZA_BLOCCATA;
		return super.getDescrizione();

	}
	
	
}
