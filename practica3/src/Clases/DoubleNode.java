package Clases;

public class DoubleNode<T> {
	
	private T data;
	private DoubleNode<T> next;
	private DoubleNode<T> prev;
	
	public DoubleNode() {
		data=null;
		prev=null;
		next=null;
	}

	public DoubleNode(T d) {
		this();
		data=d;
		
	}
	public void setData(T d) {
		data=d;
	}
	public void setNext(DoubleNode<T> n){
		next=n;
	}
	public void setPrev(DoubleNode<T> p) {
		prev=p;
	}
	public T getData() {
		return data;
	}
	public DoubleNode<T> getNext() {
		return next;
	}
	public DoubleNode<T> getPrev() {
		return prev;
	}
}