package Clases;

public class Stack <T>{
    private List<T> data;

    public Stack() {
        data = new List<T>();
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(T e) {
        data.addFirst(e);
    }

    public T pop() {
        return data.removeFirst();
    }

    public T top() {
        if (!isEmpty()) {
            return data.First().getData();
        } else {
            return null;
        }
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
