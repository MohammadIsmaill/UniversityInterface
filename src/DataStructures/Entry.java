package DataStructures;

public class Entry<K,V> {
//	Course key;
	K key;
	V value;
	
	Entry<K,V> next;
	
	public Entry(K key, V value)
	{
		this.key = key;
		this.value = value;
	}
	
	public V getValue(){
		return value;
	}
	
	public void setValue(V value)
	{
		this.value = value;
	}
	public K getKey()
	{
		return key;
	}
}
