package it.uniroma3.diadia;

public class IOSimulator implements IO {
	private String[] righeDaLeggere;
	private int indiceRigheDaLeggere;
	private String[] messaggiProdotti;
	private int indiceMessaggiProdotti;
	private int indiceMessaggiMostrati;
	
	 
	
	public  IOSimulator(String [] righeDaLeggere) {
		this.righeDaLeggere=righeDaLeggere;
		this.indiceRigheDaLeggere=0;
		this.messaggiProdotti=new 	String[1000];
		this.indiceMessaggiProdotti=0;

	}
	@Override
	public void mostraMessaggio(String msg) {
		this.messaggiProdotti[this.indiceMessaggiProdotti]=msg;
		this.indiceMessaggiProdotti++;
		
	}

	@Override
	public String leggiRiga() {
		String rigaLetta=this.righeDaLeggere[this.indiceRigheDaLeggere];
		this.indiceRigheDaLeggere++;
		return rigaLetta;
	}
	
	public String  nextMessaggio() {
		String next=this.messaggiProdotti[this.indiceMessaggiMostrati];
		this.indiceMessaggiMostrati++;
		return next;
	}
	
	public boolean hasNextMessaggio() {
		return this.indiceMessaggiMostrati<this.indiceMessaggiProdotti;
	}
	

}
