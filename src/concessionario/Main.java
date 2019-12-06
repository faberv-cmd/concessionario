package concessionario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import concessionario.core.Auto;
import concessionario.core.Dipendente;
import concessionario.core.Moto;
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
		
		
	    driverVeic.read();
		
		tabellaVeicolo.insert(new Auto("uuu","mercedes","classe a","benzina","blu",34000.0,3));
		tabellaVeicolo.insert(new Moto("VIVA","mercedes","classe a","benzina","blu",34000.0,33.3));
		
		tabellaVeicolo.delete("uuu");
		
		// Per poter applizare l'update
		tabellaVeicolo.get("FAFA");
		Veicolo temp = null;
		temp = tabellaVeicolo.get("FAFA");
		temp.setPrezzo(300.0);
		tabellaVeicolo.update(temp); //FUNZIONAAAAAA
		
		System.out.println(temp.toString());
	
		
		/*
		Iterator i = driverVeic.read().iterator();
		
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		*/
		
		driverVeic.write(driverVeic.read());
		
		
		
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