package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	
	private String direzioneBloccata;
	private String oggettoCheSblocca;
	
	private final static String MESSAGGIO_STANZA_BLOCCATA = "La stanza è bloccata";

	public StanzaBloccata(String nome,String direzioneBloccata,String oggettoCheSblocca) {
		super(nome);
		// TODO Auto-generated constructor stub
		direzioneBloccata = this.direzioneBloccata;
		oggettoCheSblocca = this.oggettoCheSblocca;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione.equals(direzioneBloccata) && !super.hasAttrezzo(oggettoCheSblocca)) {
			return this;
		}
		
		return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		if(direzione.equals(direzioneBloccata) && !super.hasAttrezzo(oggettoCheSblocca)) {
			return MESSAGGIO_STANZA_BLOCCATA;
		}
		
		else {
			return super.getDescrizione();
		}
	}

}
