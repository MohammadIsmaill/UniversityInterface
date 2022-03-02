package DataStructures;



public class BST<T> {
	TNode root;
	
	
	public void insert(T data,int key){
		root = insertUtil(root,data,key);
	}
	public TNode<T> insertUtil(TNode<T> root,T data,int key){
		if(root == null) {
			root = new TNode<T>(data,key);
			return root;
		}
		if(key < root.key){
			root.left = insertUtil(root.left,data,key);
		}
		else{
			root.right = insertUtil(root.right,data,key);
		}
		return root;
	}
	public TNode search(int key){
		return searchUtil(root,key);
	}
	public T Search(int key){
		return (T) search(key).data;
	}
	public TNode searchUtil(TNode root, int key){
		if(root != null){
			if(root.key == key) return root;
			else if(root.key < key) return searchUtil(root.left,key);
			return searchUtil(root.right,key);
		}
		return null;
	}
	public boolean isFound(int key){
		return search(key) != null;
	}
	public void delete(int key){
		root = deleteRec(root,key);
	}
	public TNode deleteRec(TNode root, int key){
		if(root == null)
			return root;
		
		if(key < root.key)
			root.left = deleteRec(root.left,key);
		else if (key > root.key)
			root.right = deleteRec(root.right,key);
		else{
			if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;
			
			root.key = minValue(root.right);
			root.right = deleteRec(root.right,root.key);
		}
		return root;
	}
	int minValue(TNode root){
		int minv = root.key;
		while(root.left != null){
			minv = root.left.key;
			root = root.left;
		}
		return minv;
	}
}
