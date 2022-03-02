package DataStructures;


public class Stack<T> extends LinkedList<T>{
	String name;
	public boolean isEmpty(){
		return super.isEmpty();
	}
	public Stack(String name){
		this.name = name;
	}
	public Stack(){}
	public void push(T data){
		insertAtFront(data);
	}
	public T pop(){
		return removeFromFront();
	}
}
