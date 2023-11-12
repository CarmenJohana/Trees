package Clases;

public class BSTEntry<T>{

	protected T data;
	protected int k;
	
	BSTEntry(T data, int k){
		this.data = data;
		this.k=k;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public int getKey() {
		return k;
	}
	
	public void setKey(int k) {
		this.k = k;
	}
	
}
