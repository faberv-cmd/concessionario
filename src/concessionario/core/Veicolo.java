package concessionario.core;



public  class Veicolo {
	protected String targa, produttore, modello, alimentazione,colore;
	private Double prezzo;
	
	public Veicolo(String targa, String produttore, String modello, String alimentazione, String colore, Double prezzo) {
		this.targa= targa;
		this.produttore=produttore;
		this.modello=modello;
		this.alimentazione=alimentazione;
		this.colore=colore;
		this.prezzo=prezzo;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public String getTarga() {
		return targa;
	}

	public String getProduttore() {
		return produttore;
	}

	public String getModello() {
		return modello;
	}

	public String getAlimentazione() {
		return alimentazione;
	}

	public String getColore() {
		return colore;
	}
	
	public void inserisci(int scelta) {
		System.out.println("Si vuole inserire un'auto o una moto?");
		System.out.println("0)Auto ");
		System.out.println("1)Moto ");
		if(scelta==0) {
			
		}
	}
	public void modifica() {
		
	}
	
	public void Visualizza() {
		System.out.println(this.toString());
	}
	
	/*
	public String toString() {
		return getTarga() + ";" + getProduttore() + ";"
				+ getModello() + ";" + getAlimentazione() + ";" + getColore()
				+ ";" + this.getPrezzo() + "\n";
	}
	*/
	
}