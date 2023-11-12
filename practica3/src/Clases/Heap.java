package Clases;

public class Heap<T>{

	private T[] nodos;
	private int size;
	
	public T[] getNodos() {
		return nodos;
	}

	public void setNodos(T[] nodos) {
		this.nodos = nodos;
	}

	public Heap(int capacity) {
		
		nodos = (T[]) new Object[capacity];
		setSize(0);
	}
	
	public int parent(int i){
		
		return (int) (Math.ceil(i/2)-1);
		
	}

	public int left(int i) {
		return (int) (2*i + 1);
	}
	
	public int right(int i) {
		return 2*i+2;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
