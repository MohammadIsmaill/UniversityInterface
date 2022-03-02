package DataStructures;

public class PQ<T> extends LinkedList<T>{
	public void enqueue(int key,T data){
		insertAtPosition(key,data);
	}
	public void enqueue(T data){
		insertAtBack(data);
	}
	public T dequeue(){
		return removeFromFront();
	}
	public void removeElement(String data){
		removeStringElement(data);
	}
	public static void main(String[] args){
		PQ<String> pq = new PQ<String>();
		pq.enqueue(1,"hi");
		pq.enqueue(3,"hello world");
		pq.enqueue(2,"hello everyone");
		pq.removeElement("hello everyone");
		
		pq.display2();
	}
}
