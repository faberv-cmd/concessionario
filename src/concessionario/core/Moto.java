package concessionario.core;

public class Moto extends Veicolo {
	private Double altezzaSedile;

	public Moto(String targa, String produttore, String modello, String alimentazione, String colore, Double prezzo, Double altezzaSedile) {
		super(targa, produttore, modello, alimentazione, colore, prezzo);
		this.altezzaSedile=altezzaSedile;
		
	}

	public Double getAltezzaSedile() {
		return altezzaSedile;
	}
	
	public void Visualizza() {
		System.out.println("MOTO ");
		super.Visualizza();
		System.out.println("Con un'altezza del sedile pari a " + getAltezzaSedile());
		
	}
	
	public String toString() {
		super.toString();
		return getTarga() + ";" + getProduttore() + ";"
				+ getModello() + ";" + getAlimentazione() + ";" + getColore()
				+ ";" + getPrezzo() + ";" + getAltezzaSedile() + "\n";
	}
}
