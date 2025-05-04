package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends StanzaProtected {

	private String direzioneBloccata;
	private String oggettoCheSblocca;

	public final static String MESSAGGIO_STANZA_BLOCCATA = "La stanza è bloccata";

	public StanzaBloccata(String nome, String direzioneBloccata, String oggettoCheSblocca) {
		super(nome);
	 this.direzioneBloccata=direzioneBloccata ;
	  this.oggettoCheSblocca=oggettoCheSblocca;
	}

	@Override
	public StanzaProtected getStanzaAdiacente(String direzione) {
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
