package DataStructures;

public class Queue<T> extends LinkedList<T>{

	public boolean isEmpty(){
		return super.isEmpty();
	}
	
	public void enqueue(T data){
		insertAtBack(data);
	}
	public T dequeue(){
		return removeFromFront();
	}
	public void removeElement(T data){
		super.removeElement(data);
	}
	public static void main(String[] args){
		Queue<Integer> q = new Queue<Integer>();
		
		q.enqueue(1);
		q.enqueue(4);
		q.enqueue(3);
		q.enqueue(2);
		q.display();
		q.removeElement(2);
		q.display();
	}
	
}
