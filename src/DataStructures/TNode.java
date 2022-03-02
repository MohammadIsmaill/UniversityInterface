package DataStructures;

public class TNode<T> {
	TNode left;
	TNode right;
	
	T data;
	int key;
	
	TNode(T data,int key){
		this.data = data;
		this.key = key;
	}
}
