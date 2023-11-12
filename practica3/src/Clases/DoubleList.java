package Clases;

public class DoubleList<T>{

	
	private DoubleNode<T> head;
	private DoubleNode <T>tail;
	private int size;
	public DoubleList() {
		size=0;
		head=null;
		tail=null;
	}
	
	
	public int size() {
		return size;
	}
	public void setSize(int s){
		size=s;
	}
	
	public Boolean isEmpty(){
		return size==0;
	}
	
	public DoubleNode<T> first(){
		return head;
	}
	public DoubleNode<T> last() {
		return tail;
	}
	
	public void addFirst(T e) {
		DoubleNode<T> n = new DoubleNode<T>(e);
		if (isEmpty()) {
			head = n;
			tail = n;
		}
		else{
			
			n.setNext(head);
			head.setPrev(n);
			head = n;
			
			
		}
		size++;
	}
	public void addLast(T e) {
		DoubleNode<T> n = new DoubleNode<T>(e);
		if (isEmpty()) {
			head = n;
			tail = n;
		}
		else {
			tail.setNext(n);
			n.setPrev(tail);
			tail=n;
			
		}
		size++;
	}
	
	public T removeFirst() {
		if (isEmpty()) {
			return null;
		}
		DoubleNode<T> temp = head;
		head = temp.getNext();
		temp.setNext(null);
		if(head!=null) {
			head.setPrev(null);
		}
		size--;
		return temp.getData();
	}
	
	public T removeLast() {
		if (isEmpty()) {
			return null;
		}
		DoubleNode<T> temp = tail;
		tail = temp.getPrev();
		if(tail!=null) {
			tail.setNext(null);
		}
		temp.setPrev(null);
		size--;
		return temp.getData();
	}
	
	public T remove(DoubleNode<T> n) {
		
		if(n.equals(head)) {
		return removeFirst();
		}
		else if(n.equals(tail)){
			
			return removeLast();
		}
		else {
			
			T e = n.getData();
			DoubleNode<T> temp_prev = n.getPrev();
			DoubleNode<T> temp_next = n.getNext();
			temp_prev.setNext(temp_next);
			temp_next.setPrev(temp_prev);
			n.setNext(null);
			n.setPrev(null);
			size--;
			return e;
		}
		
	}
	public void addBefore(DoubleNode<T> n, T e) {
		if(n.equals(head)) {
			addFirst(e);
		}
		else {
			DoubleNode<T> m = new DoubleNode<T>(e);
			DoubleNode<T> temp_prev = n.getPrev();
			temp_prev.setNext(m);
			m.setPrev(temp_prev);
			m.setNext(n);
			n.setPrev(m);	
			size++;
		}
		
		
	}
	public void addAfter(DoubleNode<T> n, T e) {
		if (n.equals(tail)) {
			addLast(e);
		}
		else {
			DoubleNode<T> m = new DoubleNode<T>(e);
			DoubleNode<T> temp_next = n.getNext();
			n.setNext(m);
			m.setPrev(n);
			m.setNext(temp_next);
			temp_next.setPrev(m);
			size++;
		}
		
	}
	
	

	public DoubleNode<T> Middle(DoubleNode<T> start, DoubleNode<T> end) {
	    if (start == null || end == null) {
	        return null;
	    }

	    DoubleNode<T> slow = start;
	    DoubleNode<T> fast = start;

	    while (fast != null && fast != end && fast.getNext() != end) {
	        slow = slow.getNext();
	        fast = fast.getNext().getNext();
	    }

	    return slow;
	}



	
	
	public void swapNodes(DoubleNode<T> node1, DoubleNode<T> node2) {
        T temp = node1.getData();
        node1.setData(node2.getData());
        node2.setData(temp);
    }
	
	public void quicksort(DoubleNode<T> low, DoubleNode<T> high) {
        if (low != null && high != null && !low.equals(high) && low != high.getNext()) {
            DoubleNode<T> pi = partition(low, high);
            quicksort(low, pi.getPrev());
            quicksort(pi.getNext(), high);
        }
    }

    private DoubleNode<T> partition(DoubleNode<T> low, DoubleNode<T> high) {
        Long pivot = ((Usuario) high.getData()).getId();
        DoubleNode<T> i = low.getPrev();

        for (DoubleNode<T> j = low; !j.equals(high); j = j.getNext()) {
            if (((Usuario) j.getData()).getId()<pivot) {
                i = (i == null) ? low : i.getNext();
                swapNodes(i, j);
            }
        }

        i = (i == null) ? low : i.getNext();
        swapNodes(i, high);
        return i;
    }

    public void sort() {
        quicksort(head, tail);
    }
}
