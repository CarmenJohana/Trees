package Clases;

public class RBEntry<T> extends BSTEntry<T> {
    
    private boolean color;
    private RBEntry<T> right;
    private RBEntry<T> left; 
    
    public RBEntry(T e, int k) {
        super(e, k);
        this.color = true;
    }
    

    public RBEntry<T> getLeft() {
        return left;
    }

    public void setLeft(RBEntry<T> left) {
        this.left = left;
    }

    public RBEntry<T> getRight() {
        return right;
    }

    public void setRight(RBEntry<T> right) {
        this.right = right;
    }

    public boolean getColor() {
        return this.color;
    }

    public void setColor(boolean c) {
        this.color = c;
    }

    @Override
    public String toString() {
        return "(" + getKey() + ")";
    }
}
