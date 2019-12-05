package concessionario.database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import concessionario.core.Auto;
import concessionario.core.Moto;
import concessionario.core.Veicolo;

public class DriverDiskVeicolo<V> implements DriverInterface {
	
	private List<Veicolo> db;
	static Integer numPorte;
	static Double prezzo;
	static Double altezzaSedile;
	
	public DriverDiskVeicolo() {
		this.db = new ArrayList<>();
	}

	public Boolean write(Collection v) {
		return null;
		
	}

	public Collection<Veicolo> read(){
		try {
			BufferedReader reader= new BufferedReader(new FileReader("C:\\Users\\First\\git\\concessionario\\src\\concessionario\\database\\Veicoli.txt"));
			String next;
			List<Veicolo> newDb = new ArrayList<>();
			do {
				next= reader.readLine();
				if(next!=null) {
					String lineTrimmered=next.trim();
					String[] values=lineTrimmered.split(";");
					if(values[0].equals("auto")) {
						prezzo=Double.parseDouble(values[6]);
						numPorte=Integer.parseInt(values[7]);
						newDb.add(new Auto(values[1], values[2], values[3], values[4], values[5],prezzo,numPorte));
						
						
					}
					else if(values[0].equals("moto")) {
						prezzo=Double.parseDouble(values[6]);
						altezzaSedile= Double.parseDouble(values[7]);
						newDb.add(new Moto(values[1], values[2], values[3], values[4], values[5],prezzo,altezzaSedile));
						
					}
				}
			}while(next!=null);
			
			
			reader.close();
			System.out.println(newDb);
			return newDb;
		}
		
		
		catch (IOException e) {
			System.out.println("ERRORE DI I/O");
			System.out.println(e);
			return null;
		}
	}

}
