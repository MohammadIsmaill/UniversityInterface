package DataStructures;


public class LinkedList<T> {
	LinkedListNode<T> head;
	
	public void insertAtFront(T data){
		LinkedListNode<T> new_node = new LinkedListNode<T>(data);
		if(isEmpty()){
			head = new_node;
			return;
		}
		new_node.next = head;
		head = new_node;
	}
	public void removeStringElement(String data){
		if(isEmpty()) return;
		LinkedListNode temp = head;
		LinkedListNode prev = head;
		
		if(temp.data.equals(data)){
			removeFromFront();

			return;
		}
		while(temp.next != null){
			prev = temp;
			temp = temp.next;
			if(temp.data.equals(data)){
				prev.next = temp.next;
				return;
			}
		}
		//5 7 3 3
	}
	public void removeElement(T data){
		if(isEmpty()) return;
		LinkedListNode temp = head;
		LinkedListNode prev = head;
		
		if(temp.data == data){
			removeFromFront();
			return;
		}
		while(temp.next != null){
			prev = temp;
			temp = temp.next;
			if(temp.data == data){
				prev.next = temp.next;
				return;
			}
		}
		//5 7 3 3
	}
	public void insertAtFront(int key,T data){
		LinkedListNode<T> new_node = new LinkedListNode<T>(key,data);
		if(isEmpty()){
			head = new_node;
			return;
		}
		new_node.next = head;
		head = new_node;
	}
	public void insertAtPosition(int key, T data){
		LinkedListNode<T> new_node = new LinkedListNode<T>(key,data);
		if(isEmpty()){
			head = new_node;
			return;
		}
		LinkedListNode temp = head;
		LinkedListNode prev = head;
		if(prev.key > key){
			insertAtFront(key,data);
			return;
		}
		while(temp.next != null && temp.next.key < key){
//			prev = temp;
//			temp = temp.next;
//			if(temp.key >= new_node.key){
////				prev.next = new_node;
////				new_node.next = temp;
//				return;
//			}
			temp = temp.next;
			// 5(3) -> 3(7) -> 3(8)
			// 7(3)
			
			
		}
		new_node.next = temp.next;
		temp.next = new_node;
		
		//7->3->2->
		//
	}
	public void insertAtBack(T data){
		LinkedListNode<T> new_node = new LinkedListNode<T>(data);
		if(isEmpty()){
			head = new_node;
			return;
		}
		LinkedListNode<T> temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = new_node;
	}
	public void display(){
		LinkedListNode temp = head;
		while(temp != null){
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	public void display2(){
		LinkedListNode temp = head;
		int i = 1;
		while(temp != null){
			System.out.println(i + ". " + temp.data);
			temp = temp.next;
			i++;
		}
	}
	public T removeFromFront(){
		if(isEmpty()) return null;
		T t = head.data;
		head = head.next;
		return t;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public static void main(String[] args){
		LinkedList<Integer> pq = new LinkedList<Integer>();
		
		pq.insertAtPosition(7, 3); //3(7)
		pq.insertAtPosition(7,5);  //5(3)
//		pq.insertAtPosition(3, 8); //8(3)
//		pq.insertAtPosition(8,3);  // 3(8)
//		pq.insertAtPosition(3, 7);// 7(3)
		
//		5->8->7->3->3->
		
		
		pq.display();
//		
//		pq.removeElement(7);
//		pq.display();
		
	}
}
