package concessionario.database;

import java.util.Collection;

import concessionario.core.Veicolo;

public class TableVeicoloImplementation implements TableInterface<String, Veicolo> {

	private DriverInterface<Veicolo> driver;

	public TableVeicoloImplementation(DriverInterface<Veicolo> driver) {
		this.driver = driver;
	}

	public Boolean insert(Veicolo v) {
		Collection<Veicolo> veicoli = driver.read();
		for (Veicolo veic : veicoli) {
			if (veic.getTarga().equals(v.getTarga())) {
				return false;
			}
		}
		veicoli.add(v);
		return driver.write(veicoli);
	}

	public Collection<Veicolo> get() {
		return driver.read();
	}

	public Veicolo get(String k) {
		Collection<Veicolo> veicoli = driver.read();
		for (Veicolo veic : veicoli) {
			if (veic.getTarga().contentEquals(k)) {
				return veic;
			}
		}
		return null;
	}

	public Veicolo update(Veicolo v) {
		Collection<Veicolo> veicoli = driver.read();

		for (Veicolo veic : veicoli) {
			if (veic.getTarga().equals(v.getTarga())) {
				veic.setPrezzo(v.getPrezzo());
			}
		}
		driver.write(veicoli);

		return null;
	}

	public Boolean delete(String k) {
		Collection<Veicolo> veicoli = driver.read(); // leggiamo
		for (Veicolo veic : veicoli) {
			if (veic.getTarga().equals(k)) {
				System.out.println("Veicolo con targa: " + veic.getTarga() + " rimosso correttamente");

				veicoli.remove(veic);
				driver.write(veicoli); // lo scriviamo su driver

				return true;
			}
		}
		System.out.println("Targa non presente");
		return false;

	}

	public void setDriver(DriverInterface<Veicolo> d) {
		this.driver = d;

	}

}
