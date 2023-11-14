package Clases;

public class RedBlackTree<T> {

    private RBEntry<T> root;
    private int size;

    public RedBlackTree() {
        root = null;
        size = 0;
    }

    public RBEntry<T> find(int k) {
        return searchTree(k, root());
    }
    
    public RBEntry<T> searchTree(int key, RBEntry<T> node) {
        if (node == null) {
            return null; 
        }
    
        if (key == node.getKey()) {
            return node;
        } else if (key < node.getKey()) {
            return searchTree(key, left(node));
        } else {
            return searchTree(key, right(node));
        }
    }
    

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isRoot(RBEntry<T> v) {
        return root.equals(v);
    }

    public boolean isInternal(RBEntry<T> v) {
        return hasLeft(v) || hasRight(v);
    }

    public boolean hasLeft(RBEntry<T> v) {
        return v != null && v.getLeft() != null;
    }

    public boolean hasRight(RBEntry<T> v) {
        return v != null && v.getRight() != null;
    }

    public RBEntry<T> root() {
        return root;
    }

    public RBEntry<T> left(RBEntry<T> v) {
        return v.getLeft();
    }

    public RBEntry<T> right(RBEntry<T> v) {
        return v.getRight();
    }

    public RBEntry<T> parent(RBEntry<T> v) {
        if (v != null) {
            if (isRoot(v)) {
                return null;
            }

            Queue<RBEntry<T>> Q = new Queue<>();
            Q.enqueue(root);
            RBEntry<T> temp = root;

            while (!Q.isEmpty()) {
                temp = Q.dequeue();

                if (hasLeft(temp) && left(temp).equals(v)) {
                    return temp;
                }
                if (hasRight(temp) && right(temp).equals(v)) {
                    return temp;
                }

                if (hasLeft(temp)) {
                    Q.enqueue(left(temp));
                }
                if (hasRight(temp)) {
                    Q.enqueue(right(temp));
                }
            }

            return null;
        }

        return null;
    }

    public int depth(RBEntry<T> v) {
        if (isRoot(v)) {
            return 0;
        }
        return 1 + depth(parent(v));
    }

    public int height(RBEntry<T> v) {
        if (!isInternal(v)) {
            return 0;
        } else {
            int h = 0;
            int alturaIzquierdo = 0;
            int alturaDerecho = 0;

            RBEntry<T> izquierdo = left(v);
            RBEntry<T> derecho = right(v);

            if (izquierdo != null) {
                alturaIzquierdo = height(izquierdo);
            }
            if (derecho != null) {
                alturaDerecho = height(derecho);
            }

            if (alturaIzquierdo >= alturaDerecho) {
                h = alturaIzquierdo + 1;
            } else {
                h = alturaDerecho + 1;
            }
            return h;
        }
    }

    public void addRoot(RBEntry<T> entry) {
        root = entry;
        size = 1;
    }
    

    public void insertLeft(RBEntry<T> v, RBEntry<T> e) {
        v.setLeft(e);
        size++;
    }

    public void insertRight(RBEntry<T> v, RBEntry<T> e) {
        v.setRight(e);
        size++;
    }

    public void remove(RBEntry<T> v) {
        RBEntry<T> p = parent(v);
        RBEntry<T> child;
        if (hasLeft(v) || hasRight(v)) {
            if (hasLeft(v)) {
                child = left(v);
            } else {
                child = right(v);
            }
            if (left(p) != null && left(p).equals(v)) {
                p.setLeft(child);
            } else {
                p.setRight(child);
            }

            v.setLeft(null);
            v.setRight(null);
        } else {

            if (left(p) != null && left(p).equals(v)) {
                p.setLeft(null);
            } else {
                p.setRight(null);
            }

        }
        size--;
    }

    public void imprimirArbol() {
        int height = this.height(root);
    
        int cantidad = (int) (3 * (Math.pow(2, height) - 1) + Math.pow(2, height));
        int valorMalla = cantidad;
    
        Queue<RBEntry<T>> q1 = new Queue<>(); 
        Queue<RBEntry<T>> q2 = new Queue<>(); 
    
        q2.enqueue(root());
    
        for (int i = 1; i <= height + 1; i++) {
            int nodosEnNivel = (int) Math.pow(2, i - 1);
            for (int j = 0; j < nodosEnNivel; j++) {
                RBEntry<T> saca = q2.dequeue(); 
    
                q1.enqueue(saca != null ? saca : null);
    
                if (saca != null) {
                    q2.enqueue(saca.getLeft());
                    q2.enqueue(saca.getRight());
                } else {
                    q2.enqueue(null);
                    q2.enqueue(null);
                }
            }
        }
    
        RBEntry<T> e = null; 
    
        e = q1.dequeue();
    
        cantidad = (int) Math.floor(cantidad / 2);
        for (int j = 1; j <= valorMalla; j++) {
            System.out.print(" ");
            if (j == cantidad) {
                System.out.println(e);
                break;
            }
        }
    
        if (this.size() == 1) {
            System.out.println(root);
        }
    
        int contador;
        int h = 1; 
    
        while (h <= height) {
            contador = cantidad;
            cantidad = (int) Math.floor(cantidad / 2);
    
            int j = 0;
            int i = 0;
            int m = 1;
    
            while (i != Math.pow(2, h) && j != valorMalla) {
                j++;
                if (j == cantidad && i == 0) {
                    e = q1.dequeue();
                    if (e == null) {
                        System.out.print("x");
                    } else {
                        System.out.print(e);
                    }
                    i++;
                } else if (j == contador * m + m + cantidad) {
                    e = q1.dequeue();
                    if (e == null) {
                        System.out.print("x");
                    } else {
                        System.out.print(e);
                    }
                    i++;
                    m++;
                } else {
                    System.out.print(" ");
                }
            }
    
            h++;
            System.out.println();
        }

        
    
    }

    
	public void setSize(int size) {
		this.size = size;
	}
    
public void insert(T e, int k) {
    RBEntry<T> newNode = new RBEntry<>(e, k);
    if (isEmpty()) {
        addRoot(newNode);
    } else {
        addRBEntry((RBEntry<T>) this.root(), newNode);
        this.setSize(this.size() + 1);
    }
}
    
    
    private void addRBEntry(RBEntry<T> v, RBEntry<T> newNode) {
        if (newNode.getKey() < v.getKey()) {
            if (hasLeft(v)) {
                addRBEntry(v.getLeft(), newNode);
            } else {
                v.setLeft(newNode);
            }
        } else {
            if (hasRight(v)) {
                addRBEntry(v.getRight(), newNode);
            } else {
                v.setRight(newNode);
            }
        }
    }
    

    public void leftRotation(RBEntry<T> x) {
        RBEntry<T> y = right(x);  
        insertRight(x, left(y));  
        if (parent(x) == null) {
            addRoot(y);
        } else if (x == left(parent(x))) {
            insertLeft(parent(x), y);
        } else {
            insertRight(parent(x), y);
        }
        insertLeft(y, x);
    }
    
    public void rightRotation(RBEntry<T> y) {
        RBEntry<T> x = left(y);
        insertLeft(y, right(x));
        
        if (parent(y) == null) {
            addRoot(x);
        } else if (y == left(parent(y))) {
            insertLeft(parent(y), x);
        } else {
            insertRight(parent(y), x);
        }
        
        insertRight(x, y);
    }
    
    public void RBInsert(T o, int k) {
        RBEntry<T> e = new RBEntry<>(o, k);
        RBEntry<T> newNode;
    
        if (isEmpty()) {
            addRoot(e);
            newNode = root();
        } else {
            RBEntry<T> temp = root();
            RBEntry<T> parent = null;
    
            while (temp != null) {
                parent = temp;
                if (k <= temp.getKey()) {
                    temp = left(temp);
                } else {
                    temp = right(temp);
                }
            }
    
            if (k <= parent.getKey()) {
                insertLeft(parent, e);
                newNode = left(parent);
            } else {
                insertRight(parent, e);
                newNode = right(parent);
            }
        }
    
        setSize(size() + 1);
        RBEntry<T> rightSentinel = new RBEntry<>(null, -1);
        RBEntry<T> leftSentinel = new RBEntry<>(null, -1);
        rightSentinel.setColor(true);
        leftSentinel.setColor(true);
    
        // Adjusted placement of sentinel nodes
        insertRight(newNode, rightSentinel);
        insertLeft(newNode, leftSentinel);
    
         RBInsertFixup(newNode); 
    }
    
    
    
    private void RBInsertFixup(RBEntry<T> z) {
        while (z != null && !z.getColor()) {
            RBEntry<T> parent = parent(z);
            RBEntry<T> grandparent = parent(parent);
            RBEntry<T> sibling;
    
            if (parent != null && z == left(parent)) {
                sibling = right(grandparent);
    
                if (sibling != null && !sibling.getColor()) {
                    z.setColor(true);
                    sibling.setColor(true);
                    grandparent.setColor(false);
                    z = grandparent;
                } else {
                    if (z == right(parent)) {
                        z = parent;
                        leftRotation(z);
                    }
    
                    parent.setColor(true);
                    grandparent.setColor(false);
                    rightRotation(grandparent);
                }
            } else {
                sibling = left(grandparent);
    
                if (sibling != null && !sibling.getColor()) {
                    z.setColor(true);
                    sibling.setColor(true);
                    grandparent.setColor(false);
                    z = grandparent;
                } else {
                    if (z == left(parent)) {
                        z = parent;
                        rightRotation(z);
                    }
                    parent.setColor(true);
                    grandparent.setColor(false);
                    leftRotation(grandparent);
                }
            }
        }
        if (z != null) {
            z.setColor(true);
        }
    }
    

    public RBEntry<T> minimo() {
        return min(root());
    }
    
    private RBEntry<T> min(RBEntry<T> v) {
        if (hasLeft(v)) {
            return min(left(v));
        } else {
            return v;
        }
    }

    public RBEntry<T> predecessor(RBEntry<T> v) {
        RBEntry<T> temp = left(v);
        return maxNode(temp);
    }
    
    private RBEntry<T> maxNode(RBEntry<T> temp) {
        if (hasRight(temp)) {
            return maxNode(right(temp));
        } else {
            return temp;
        }
    }
    


    
    public static void main(String[] args) {
            RedBlackTree<Integer> tree = new RedBlackTree<>();

            //LeftRotation y RightRotation funcionan bien, solo hay que asegurarse de que no haya nodos nulos.
            // El método problema es RBInsert pero más específicamente el método que llama el cual es RBInsertFixup (No funciona bn!!!!)
            // Los nodos con (-1) son las hojas sentinela, por cada nodo que se agrega con RBInsert se agregan dos nodos sentinela, sin embargo
            // El metódo RBInsertFixup no funciona bien (debería de arreglar el arbol), no se si es por el método RBInsert o por el método RBInsertFixup.

            tree.RBInsert(2, 7);
            tree.RBInsert(3, 5);
            tree.RBInsert(4, 6);


            if (!tree.find(-1).getColor()) {
                System.out.println("Es rojo");
            }
            tree.imprimirArbol();
        
    }

}