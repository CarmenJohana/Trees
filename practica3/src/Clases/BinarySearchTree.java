package Clases;

public class BinarySearchTree <T> extends BinaryTree<T>{

	BinarySearchTree(){
		super();
	}
	
	public Node<BSTEntry<T>> find(int k) {
		
		return searchTree(k, this.root());
		
	}
	
	public Node<BSTEntry<T>> searchTree(int key, Node<T> node){
		BSTEntry<T> u = (BSTEntry<T>) node.getData();
		if (key==u.getKey()) {
			return (Node<BSTEntry<T>>) node;
		}
		else if(key<u.getKey()) {
			return searchTree(key, node.getLeft());
		}
		else {
			return searchTree(key, node.getRight());
		}
		
	}
	
	public void insert(T e, int k) {
		BSTEntry<T> O = new BSTEntry<T>(e,k);
		if (isEmpty()) {
			super.addRoot((T) O);
		}
		else {
			addEntry((Node<BSTEntry<T>>) this.root(), O);
			this.setSize(this.size()+1);
		}
	}
	
	public void addEntry(Node<BSTEntry<T>> v, BSTEntry<T> o ) {
		
		BSTEntry<T> temp = v.getData();
		Node<BSTEntry<T>> nD = new Node<BSTEntry<T>>(o);
		if (o.getKey()<temp.getKey()) {
			if (hasLeft((Node<T>) v)) {
				
				addEntry((Node<BSTEntry<T>>) left((Node<T>) v), o);
			}
			else {
				v.setLeft(nD);
			}
		}
		else {
			if(hasRight((Node<T>) v)) {
				addEntry((Node<BSTEntry<T>>) right((Node<T>) v), o);
			}
			else {
				v.setRight(nD);
			}
		}
		
	}
	
	public BSTEntry<T> maximo(){
		return max((Node<BSTEntry<T>>) this.root());
	}
	
	public BSTEntry<T> max(Node<BSTEntry<T>> v){
		if (hasRight((Node<T>) v)) {
			return max((Node<BSTEntry<T>>) right( (Node<T>) v));
		}
		else {
			return v.getData();
		}
	}
	
	public BSTEntry<T> minimo(){
		return min((Node<BSTEntry<T>>) this.root());
	}
	
	public BSTEntry<T> min(Node<BSTEntry<T>> v){
		if (hasLeft((Node<T>) v)) {
			return min((Node<BSTEntry<T>>) left( (Node<T>) v));
		}
		else {
			return v.getData();
		}
	}
	
	
	
	
	public Node<BSTEntry<T>> predecesor(Node<BSTEntry<T>> v){
		Node<BSTEntry<T>> temp = v.getLeft();
		return maxNode(temp);
	}
	
	public Node<BSTEntry<T>> maxNode(Node<BSTEntry<T>> temp){
		if (hasRight((Node<T>) temp)) {
			return maxNode((Node<BSTEntry<T>>) right((Node<T>) temp));
		}
		else {
			return temp;
		}
	}
	
	public BSTEntry<T> remove(int k) {
		
		Node<BSTEntry<T>> v = find(k);
		BSTEntry<T> temp = v.getData();
		if ( hasLeft((Node<T>) v) && hasRight((Node<T>) v) ) {
			Node<BSTEntry<T>> w = predecesor(v);
			v.setData(w.getData());
			super.remove((Node<T>) w);
		}
		else {
			super.remove((Node<T>) v);
		}
		return temp;	
		
	}
	
}