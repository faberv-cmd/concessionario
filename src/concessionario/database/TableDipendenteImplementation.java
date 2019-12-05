package concessionario.database;

import java.util.Collection;
import java.util.Scanner;

import concessionario.core.Dipendente;

public class TableDipendenteImplementation implements TableInterface<Integer, Dipendente> {

	private DriverInterface<Dipendente> driver;
	private Scanner input = new Scanner(System.in);

	public TableDipendenteImplementation(DriverInterface<Dipendente> driver) {
		this.driver = driver;
	}

	@Override
	public Boolean insert(Dipendente v) {
		Collection<Dipendente> dipendenti = driver.read();
		for (Dipendente dipendente : dipendenti) {
			if (dipendente.getCid() == v.getCid()) {
				return false;
			}
		}
		dipendenti.add(v);
		return driver.write(dipendenti);
	}

	@Override
	public Collection<Dipendente> get() {
		return driver.read();
	}

	@Override
	public Dipendente get(Integer k) {
		Collection<Dipendente> dipendenti = driver.read();
		for (Dipendente dipendente : dipendenti) {
			if (dipendente.getCid() == k) {
				return dipendente;
			}
			
		}
		
		return null;
	}

	@Override
	public Dipendente update(Dipendente v) {
		Collection<Dipendente> dipendenti = driver.read();
		//Controlla non venga passato null, a causa del get chiamato nel main
		if(v == null) {
			System.out.println("Codice errato");
			return null;
		}
		//Se il cid è presente fa i vari controlli
		else {
		 //for (Dipendente dipendente : dipendenti) {
			System.out.println(v.getCid() + " " + v.getNome() + " " + v.getCognome()+ ":");
			//if (dipendente.getCid() == v.getCid()) {
				if (v.getAmministratore() == false) {
					
					System.out.println("Vuoi promuovere questo dipendente? (s/n)");
					char scelta = input.next().charAt(0);
					switch (scelta) {
					case 's':
						v.setAmministratore(true);
						driver.write(dipendenti);
						break;
					case 'n':
						System.out.println("addio");
						break;
					default:
						System.out.println("Scelta non valida");
						break;
					}
				
				} else {
					
					System.out.println("E' già amministratore");
				}
				//break;
			} 
	
			
	//	}
		return null;
	//}
	}

	@Override
	// GIUSTA
	public Boolean delete(Integer k) {
		Collection<Dipendente> dipendenti = driver.read(); // leggiamo
		for (Dipendente dip : dipendenti) {
			if (dip.getCid() == k) {
				System.out.println("Dipendente con cid = " + dip.getCid() + " rimosso correttamente");

				dipendenti.remove(dip);
				driver.write(dipendenti); // lo scriviamo su driver

				return true;
			}
		}
		System.out.println("Codice cid non presente");
		return false;
	}

	@Override
	public void setDriver(DriverInterface<Dipendente> d) {
		this.driver = d;

	}

}
