/*
 * Nathan Ostrander
 * Fixed-size hash map that associates string keys 
 * with arbitrary data object references
 * 10/30/15
 */
package Map;
public class FSHashMap<V> {

	private int size;
	private float count;
	private Node<V> map[];
	
	public FSHashMap(int size){
		this.size = size;
		map = new Node[size];
		count = 0;
	}
	
	/**
	 * Stores the given key/value pair in the hash map 
	 * @param key
	 * @param value
	 * @return boolean value indicating success / failure of the operation
	 */
	public boolean set(String key, V value)
	{
		int hash = key.hashCode() % size;
		Node temp = map[hash];
		Node curr = temp;
		if(temp != null){
			if(temp.key.equals(key)) {	//If the key already exist the original value is replace with the new value
                temp.value = value;
                return true;
            } else {
                while(curr.next != null) {	//Traverses through the list until the next bucket is null
                    if(curr.key.equals(key)) {
                        curr.value = value;
                    }
    				curr = curr.next;
                }
                //Inserts the new value at the end of the list
                Node valueInOldBucket = new Node(key, value);
                curr.next = valueInOldBucket;
                return true;
            }
		}
		else{	//Inserts a new node containing the key and value into the map according to the hash value
			Node newNode = new Node(key, value);
            map[hash] = newNode;
            count++;
            return true;
		}	
	}
	
	/**
	 * Traverses the list to find the value associated with the given key
	 * @param key
	 * @return the value associated with the given key, or null if no value is set
	 */
	public V get(String key){
		int hash = key.hashCode() % size;
		Node temp = map[hash];
		if(temp != null){	//traverses the list to find the given key
			while(temp != null) {
				if(temp.key.equals(key)) {
					return (V) temp.value;
				}
				temp = temp.next;
			}
		}
		return null;	//return null if key is not found in the list
	}
	
	/**
	 * Deletes the value associated with the given key from the map
	 * @param key
	 * @return the value on success or null if the key has no value
	 */
	public V delete(String key){
		Node prev = null;
		int hash = key.hashCode() % size;
		Node front = map[hash];
		Node curr = front;
		if(front == null){
			return null;
		}else{
			if(front.next == null)
			{	
				count--;
			}
				while(curr != null) {	//traverses the list to find the given key
				if(curr.key.equals(key)) {	//the value is deleted from the list if the key is found
					if (curr == front) {
						front = front.next;
						map[hash] = front;
						
					} else {
						prev.next = curr.next;
					} 
					return (V) curr.value;
				}
				prev = curr;
				curr = curr.next;
			}
		}
		
		return null;
	}
	
	/**
	 * Returns a float value representing the load factor of the data structure
	 * @return (items in hash map)/(size of hash map) 
	 */
	public float load(){
		return count/size;
	}
	
	protected class Node<V>{
		protected String key;
		protected V value;
		protected Node next;
		
		protected Node(String key, V value) {
			this.key = key;
			this.value = value;
			next = null;
		}
	}
}
