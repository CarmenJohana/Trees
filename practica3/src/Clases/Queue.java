package Clases;

public class Queue<T> {
    private List<T> data;

    public Queue() {
        data = new List<T>();
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return size()==0;
    }

    public void enqueue(T e) {
        data.addLast(e);
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            return data.removeFirst();
        }
    }

    public T first() {
        if (isEmpty()) {
            return null;
        } else {
            return data.First().getData();
        }
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
