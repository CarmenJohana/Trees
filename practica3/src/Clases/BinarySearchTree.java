package Clases;

public class BinarySearchTree <T> extends BinaryTree<BSTEntry<T>>{

	BinarySearchTree(){
		super();
	}
	
	public Node<BSTEntry<T>> find(int k) {
		
		return searchTree(k, this.root());
		
	}
	
	public Node<BSTEntry<T>> searchTree(int key, Node<BSTEntry<T>> v){
		BSTEntry<T> u = v.getData();
		if (key==u.getKey()) {
			return v;
		}
		else if(key<u.getKey()) {
			return searchTree(key, v.getLeft());
		}
		else {
			return searchTree(key, v.getRight());
		}
		
	}
	
	public void insert(T e, int k) {
		BSTEntry<T> O = new BSTEntry<T>(e,k);
		if (isEmpty()) {
			super.addRoot(O);
		}
		addEntry(this.root(), O);
	
	}
	
	public void addEntry(Node<BSTEntry<T>> v, BSTEntry<T> o ) {
		
		BSTEntry<T> temp = v.getData();
		Node<BSTEntry<T>> nD = new Node<BSTEntry<T>>(o);
		if (o.getKey()<temp.getKey()) {
			if (hasLeft(v)) {
				
				addEntry(left(v), o);
			}
			else {
				v.setLeft(nD);
			}
		}
		else {
			if(hasRight(v)) {
				addEntry(right(v), o);
			}
			else {
				v.setRight(nD);
			}
		}
		
	}
	
	public Node<BSTEntry<T>> predecesor(Node<BSTEntry<T>> v){
		Node<BSTEntry<T>> temp = v.getLeft();
		return maxNode(temp);
	}
	
	public Node<BSTEntry<T>> maxNode(Node<BSTEntry<T>> temp){
		if (hasRight(temp)) {
			return maxNode(right(temp));
		}
		else {
			return temp;
		}
	}
	
	public BSTEntry<T> remove(int k) {
		
		Node<BSTEntry<T>> v = find(k);
		BSTEntry<T> temp = v.getData();
		if ( hasLeft(v) && hasRight(v) ) {
			Node<BSTEntry<T>> w = predecesor(v);
			v.setData(w.getData());
			super.remove(w);
		}
		else {
			super.remove(v);
		}
		return temp;	
		
	}
	
}
