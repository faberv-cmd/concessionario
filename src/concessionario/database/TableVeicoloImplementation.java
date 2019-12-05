package concessionario.database;

import java.util.Collection;


import concessionario.core.Veicolo;

public class TableVeicoloImplementation implements TableInterface<String, Veicolo> {
	
	
	private DriverInterface<Veicolo> driver;
	
	public TableVeicoloImplementation (DriverInterface<Veicolo> driver) {
		this.driver=driver;
	}
	public Boolean insert(Veicolo v) {
		Collection<Veicolo> veicoli = driver.read();
		for(Veicolo veic:veicoli) {
			if(veic.getTarga().equals(v.getTarga())) {
				return false;
			}
		}
		veicoli.add(v);
		return driver.write(veicoli);
	}
	
public Collection<Veicolo> get(){
	return driver.read();
}
	
	public Veicolo get(String k) {
		return null;
	}
	
	public Veicolo update(Veicolo v) {
		return null;
	}
	
	public Boolean delete(String k) {
		return null;
	}
	
	public void setDriver(DriverInterface<Veicolo> d) {
		
	}
	
	
	

}
