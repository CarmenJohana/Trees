package Clases;

public class RedBlackTree<T> extends BinarySearchTree<T>  {

    public RedBlackTree() {
        super();
    }

    public void leftRotation(Node<RBEntry<T>> x){
        RBEntry<T> y = this.right(x);
        this.insertRight(x, this.left(y));

        if (this.parent(x) == null) {

        }

    }

}