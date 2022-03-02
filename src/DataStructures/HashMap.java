package DataStructures;


public class HashMap<K,V> {
	private static final int SIZE = 16;
	private Entry<K,V> table[] = new Entry[SIZE];
	
	private int getSupplementalHash(int h)
	{
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}
	
	private int getBucketNumber(int hash)
	{
		return hash & (SIZE - 1); 
	}
	
	public void put(K key, V value)
	{
		int userHash = key.hashCode();
		int hash = getSupplementalHash(userHash);
		
		
		int bucket = getBucketNumber(hash);
		Entry<K,V> existingElement = table[bucket];
		
		while(existingElement != null)
		{
			
			if(existingElement.key.equals(key))
			{
//				System.out.println("Duplicate key value pair, replacing existing key " +
//			     key + ", adding elemenet to the existing bucket");
//				existingElement.value = value;
				return;
			}
			else{
//				System.out.println("Collision detected for key " + key + ", adding element to the existing bucket");
			}
			
			existingElement = existingElement.next;
			
			
		}
//		System.out.println("Put adding key: " + key + ", value: " + value + " to the list");
		
		Entry<K,V> entryInOldBucket = new Entry<K,V>(key, value);
		entryInOldBucket.next = table[bucket];
		table[bucket] = entryInOldBucket;
	}

	public V get(K key){
		int hash = getSupplementalHash(key.hashCode());
		
		int bucket = getBucketNumber(hash);
		
		Entry<K,V> existingElement = table[bucket];
		
		while(existingElement != null){
//			System.out.println("Traversing the list inside the bucket for the key "
//					            + existingElement.getKey());			
			if(existingElement.key.equals(key)){
				return existingElement.getValue();
			}
			existingElement = existingElement.next;
		}
		return null;
	}

}
