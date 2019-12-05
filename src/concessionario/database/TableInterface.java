package concessionario.database;

import java.util.Collection;

import concessionario.core.Dipendente;

public interface TableInterface<K, V> {
	
	public Boolean insert(V v);
	
	public Collection<V> get();
	
	public V get(K k);
	
	public V update(V v);
	
	public Boolean delete(K k);
	
	public void setDriver(DriverInterface<V> d);

}
