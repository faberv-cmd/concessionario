package concessionario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import concessionario.core.Dipendente;
import concessionario.core.Veicolo;
import concessionario.database.DriverDiskVeicolo;
import concessionario.database.DriverInterface;
import concessionario.database.DriverMemoryImplementation;
import concessionario.database.TableDipendenteImplementation;
import concessionario.database.TableInterface;
import concessionario.database.TableVeicoloImplementation;

public class Main {
	
	

	public static void main(String[] args) {
		DriverInterface<Dipendente> driverDip = new DriverMemoryImplementation();
		TableInterface<Integer, Dipendente> tabellaDipendente = new TableDipendenteImplementation(driverDip);
		DriverInterface<Veicolo> driverVeic = new DriverDiskVeicolo();
		
		
		TableInterface<String, Veicolo> tabellaVeicolo= new TableVeicoloImplementation(driverVeic);
		
		tabellaDipendente.insert(new Dipendente(1, "Mario", "Rossi",true));
		tabellaDipendente.insert(new Dipendente(10, "Mario", "Rossi",false));
		
		tabellaDipendente.insert(new Dipendente(2, "Mario", "Rossi",false));
		tabellaDipendente.insert(new Dipendente(43, "Luca", "verdi", true));
		tabellaDipendente.insert(new Dipendente(45, "Luca", "verdi", false));
		
		tabellaDipendente.delete(10);
		tabellaDipendente.update(tabellaDipendente.get(2));
		tabellaDipendente.update(tabellaDipendente.get(45));
		tabellaDipendente.update(tabellaDipendente.get(43));
		tabellaDipendente.update(tabellaDipendente.get(50));
		tabellaDipendente.update(tabellaDipendente.get(10));
		
		//tabellaVeicolo.insert(new )
		
		//System.out.println(driverVeic.read());
		
		//driverVeic.write(driverVeic.read());
		
		//tabellaVeicolo.insert(new Veicolo())
		
		
		Iterator i = driverVeic.read().iterator();
		
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		
		
		driverVeic.write(driverVeic.read());
		
		
		
		//System.out.println(tabellaDipendente.get());
		
		for(Dipendente d : tabellaDipendente.get()) {
			if(d.getAmministratore()==true) {
			System.out.println(d + " :Amministratore");
			}
			else {
				System.out.println(d + " :Dipendente");
			}
		}
		
	}
	

}
