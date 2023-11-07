package Clases;

public class BinaryTree<T> {

	private Node<T> root;
	private int size;
	
	/***
	 *1) ¿Asumimos en el método de remove que el nodo v (a eliminar) está en el árbol?
	 *2) ¿Al agregar una nueva raíz se deberían eliminar los datos antiguos?
	 *3) La profesora usa doble nodo(?) La clase nodo que se hizo es similar en espíritu.
	 *Realmente la única diferencia es que prev es el left y next es el right. Al menos eso
	 *fue lo que inferí que debían ser los prev y next que la profesora ponía en la implementación
	 *de algunos métodos del BinaryTree (en las diapositivas).
	 * Deberíamos hacer las implementaciones con ArrayQueue o con el Queue con lista (este segundo fue el que
	 * puse) 
	 */
	
	public BinaryTree() {
		
		root=null;
		size=0;
		
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size()==0;
	} 
	
	public boolean isRoot(Node<T> v) {
		
		return v.equals(root);
		
	}
	
	public boolean isInternal(Node<T> v){
		return hasLeft(v)|| hasRight(v);
		
	}
	
	public boolean hasLeft(Node<T> v) {
		
		return v.getLeft()!=null;
		
	}
	
	public boolean hasRight(Node<T> v) {
		
		return v.getRight()!=null;
		
	}
	
	public Node<T> root(){
		
		return root;
		
	}
	
	public Node<T> left(Node<T> v){
		
		return v.getLeft();
	}
	
	public Node<T> right(Node<T> v){
		
		return v.getRight();
		
	}
	
	public Node<T> parent(Node<T> v){
		
		if (isRoot(v)){
			return null;
		}
		Queue<Node<T>> Q = new Queue<Node<T>>();
		Q.enqueue(root);
		Node<T> temp = root;
		while(!Q.isEmpty() && !left(Q.first()).equals(v) && !right(Q.first()).equals(v)) {
			
			temp = Q.dequeue();
			if (hasLeft(temp)) {
				Q.enqueue(left(temp));
			}
			if(hasRight(temp)) {
				Q.enqueue(right(temp));
			}
			
		}
		
		return temp;
		
	}
	
	public int depth(Node<T> v) {
		//La profesora usa doble nodo(?)
		if(isRoot(v)){
			return 0;
		}
		return 1+depth(parent(v));
		
		
	}
	
	public int height(Node<T>v) {
		
		if (!isInternal(v)) {
			return 0;
		}
		int h=0;
		int alturaIzquierdo = height(left(v));
		int alturaDerecho = height(right(v));
		
		if(alturaIzquierdo<=alturaDerecho) {
			h= alturaIzquierdo;
		}
		else {
			h=alturaDerecho;
		}
		return h++;
		
	}
	
	public void addRoot(T e) {
		
		//Al agregar una nueva raíz asumimos que al árbol
		//se le eliminan los datos antiguos?
		
		root = new Node<T>(e);
		size=1; 
	}
	
	public void insertLeft(Node<T> v, T e) {
		Node<T> left = new Node<T>(e);
		v.setLeft(left);
		size++;
	}
	
	public void insertRight(Node<T> v, T e) {
		Node<T> right = new Node<T>(e);
		v.setRight(right);
		size++;
	}
	
	public void remove(Node<T> v) {
		
		//Asumimos que v está en el
		//árbol
		Node<T> p = parent(v);
		Node<T> child;
		if(hasLeft(v)||hasRight(v)) {
			if(hasLeft(v)) {
				 child= left(v);
			}
			else {
				child = right(v);
			}
			if (left(p).equals(v)) {
				p.setLeft(child);
			}
			else {
				p.setRight(child);
			}
			v.setLeft(null);
			v.setRight(null);
		}
		else {
			
			if(left(p).equals(v)) {
				p.setLeft(null);
			}
			else {
				p.setRight(null);
			}
			
		}
		size--;
		
		
	}
	
	
	
	
	
}
