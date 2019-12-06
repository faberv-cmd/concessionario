package concessionario.database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
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
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\PCFIRSTCONSULTING\\Desktop\\concessionario\\concessionario\\src\\concessionario\\database\\Veicoli.txt"));
			
			
			
			Iterator i = v.iterator();
			 Object m;
			
			while(i.hasNext()) {
				m = i.next();
				if(m instanceof Auto) {
				
				writer.write("auto;");
				writer.write(m.toString());
				
				}
				
				if(m instanceof Moto) {
					writer.write("moto;");
					writer.write(m.toString());
				}
				
				
			}
			
			
			writer.close();
		}
		
		catch (IOException e) {
			System.out.println("ERRORE DI I/O");
			System.out.println(e);
			return null;
		}
		return null;
		
	}

	public Collection<Veicolo> read(){
		try {
			BufferedReader reader= new BufferedReader(new FileReader("C:\\Users\\PCFIRSTCONSULTING\\Desktop\\concessionario\\concessionario\\src\\concessionario\\database\\Veicoli.txt"));
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
						System.out.println(values[0]);
						
					}
				}
			}while(next!=null);
			
			
			reader.close();
			
			
			return newDb;
		}
		
		
		catch (IOException e) {
			System.out.println("ERRORE DI I/O");
			System.out.println(e);
			return null;
		}
	}

}
