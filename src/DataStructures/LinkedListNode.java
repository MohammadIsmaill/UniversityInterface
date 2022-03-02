package DataStructures;

public class LinkedListNode<T> {
	T data;
	int key;
	LinkedListNode next;
	
	public LinkedListNode(T data){
		this.data = data;
		next = null; 
	}
	
	public LinkedListNode(int key,T data){
		this.data = data;
		this.key = key;
		next = null;
	}
	
}
