package concessionario.core;

public class Auto extends Veicolo {
	
	private Integer numPorte;

	public Auto(String targa, String produttore, String modello, String alimentazione, String colore, Double prezzo, Integer numPorte) {
		super(targa, produttore, modello, alimentazione, colore, prezzo);
		this.numPorte=numPorte;
		
	}

	public Integer getNumPorte() {
		return numPorte;
	}
	
	public void Visualizza() {
		System.out.println("AUTO: ");
		super.Visualizza();
		System.out.println("Con " + getNumPorte() + " porte");
	}
}
