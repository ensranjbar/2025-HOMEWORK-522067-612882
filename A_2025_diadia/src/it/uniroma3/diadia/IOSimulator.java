package it.uniroma3.diadia;

import java.util.Scanner;

public class IOSimulator implements IO {
	private String[] righeDaLeggere;
	private int indiceRigheDaLeggere;
	private String[] messaggiProdotti;
	private int indiceMessaggiProdotti;
//	private int indiceMessaggiMostrati;
	
	private Scanner scanner;
	
	public  IOSimulator(String comandiInput) {
		
		this.scanner = new Scanner(comandiInput);
		
		this.righeDaLeggere=comandiInput.split("\n");
		this.indiceRigheDaLeggere=0;
		this.messaggiProdotti=new String[100];
		this.indiceMessaggiProdotti=0;

	}
	@Override
	public void mostraMessaggio(String msg) {
		
		if(indiceMessaggiProdotti < messaggiProdotti.length) {
			messaggiProdotti[indiceMessaggiProdotti++] = msg;
		}
		
		else {
		System.err.println("Array dei messaggi pieno");	
		}
		
		
	}

	@Override
	public String leggiRiga() {
		
		if(scanner.hasNextLine()) {
			return scanner.nextLine();
		}
		
		else {
			return null;
		}
		
		
//		String rigaLetta=this.righeDaLeggere[this.indiceRigheDaLeggere];
//		this.indiceRigheDaLeggere++;
//		return rigaLetta;
	}
	
//	public String  nextMessaggio() {
//		String next=this.messaggiProdotti[this.indiceMessaggiMostrati];
//		this.indiceMessaggiMostrati++;
//		return next;
//	}
//	
//	public boolean hasNextMessaggio() {
//		return this.indiceMessaggiMostrati<this.indiceMessaggiProdotti;
//	}
	

}
