package Clases;

public class List<T> {
	
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	public List() {
		head=null;
		tail=null;
		size=0;
	}
	
	public int size() {
		 return size;
	}
	
	public Boolean isEmpty() {
		if (size==0){
			return true;
		}
		return false;
	}
	public void setSize(int s){
		size=s;
	}
	public Node<T> First() {
		return head;
	}
	public Node<T> Last() {
		return tail;
	}
	public void addFirst(T e) {
		
		Node<T> n = new Node<T>(e);
		if (isEmpty()) {
			head = n;
			tail = n;
		}
		else {
			
			n.setNext(head);
			head = n;
			
		}
		size++;
		
	}
	public void addLast(T e) {
		
		Node<T> n = new Node<T>(e);
		if(isEmpty()) {
			head = n;
			tail = n;
		}
		else {
			tail.setNext(n);
			tail = n;
		}
		size++;	
	}
	public T removeFirst() {
		if (!(isEmpty())) {
			
			
			Node<T> temp = head;
			head = temp.getNext();
			temp.setNext(null);
			size--;
			return temp.getData();
			
		}
		return null;
	}
	
	public T removeLast() {
		if (size==1) {
			return removeFirst();
		}
		else {
			Node<T> temp = tail;
			Node<T> anterior =head;
			if(anterior!=null) {
				while(anterior.getNext()!=tail) {
					
					anterior = anterior.getNext();
					
				}
				anterior.setNext(null);
			}
			tail = anterior;
			size--;
			return temp.getData();
			
		}
	}
	
	

	public Node<T> Middle(Node<T> start, Node<T> end) {
		
		
		if (start.equals(null)|| end.equals(null)) {
			return null;
		}
		else if (start.equals(end)) {
			
			return start;
			
		}
		else {
			
			Node<T> temp1=First();
			Node<T> temp2=First();
			while(temp2!=end) {
				temp2=temp2.getNext();
				if(temp2!=end) {
					temp2=temp2.getNext();
					temp1=temp1.getNext();
					
				}
			}
			return temp1;
			
		}
		
	}
	
	
	
}