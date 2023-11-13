package Clases;

public class RBEntry<T> extends BSTEntry<T> {
    
    private boolean color;
    
    public RBEntry(T e, int k) {
        super(e, k);
        this.color = true;
    }
    
    public boolean getColor() {
        return this.color;
    }
    
    public void setColor(boolean c) {
        this.color = c;
    }


}