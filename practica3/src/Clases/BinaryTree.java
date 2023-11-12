package Clases;



public class BinaryTree<T> {
	
	
	/***
	 *1) ¿Asumimos en el método de remove que el nodo v está en el árbol?
	 *2) ¿Al agregar una nueva raíz se deberían eliminar los datos antiguos?
	 *3) La profesora usa doble nodo(?) La clase nodo que se hizo es similar en espíritu.
	 *Realmente la única diferencia es que prev es el left y next es el right. Al menos eso
	 *fue lo que inferí que debían ser los prev y next que la profesora ponía en la implementación
	 *de algunos métodos del BinaryTree (en la diapositivas).
	 */

	private Node<T> root;
	private int size;
	
	public BinaryTree() {
		
		root=null;
		size=0;
		
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size()==0;
	} 
	
	public boolean isRoot(Node<T> v) {
		
		return root.equals(v);
		
	}
	
	public boolean isInternal(Node<T> v){
		
		return hasLeft(v)|| hasRight(v);
		
	}
	
	public boolean hasLeft(Node<T> v) {
		
		if(v!=null) {
		return v.getLeft()!=null;
		}
		return false;
	}
	
	public boolean hasRight(Node<T> v) {
		
		if(v!=null) {
			return v.getRight()!=null;
			}
			return false;
		
	}
	
	public Node<T> root(){
		
		return root;
		
	}
	
	public Node<T> left(Node<T> v){
		
		return v.getLeft();
		
	}
	
	public Node<T> right(Node<T> v){
		
		
			return v.getRight();
	
		
	}
	/***
	public Node<T> parent(Node<T> v){
		if(v!=null) {
		if (isRoot(v)){
			return null;
		}
		Queue<Node<T>> Q = new Queue<Node<T>>();
		Q.enqueue(root);
		Node<T> temp = root;
		while(!Q.isEmpty() && !left(Q.first()).equals(v) && !right(Q.first()).equals(v)) {
			
			temp = Q.dequeue();
			if (hasLeft(temp)) {
				Q.enqueue(left(temp));
			}
			if(hasRight(temp)) {
				Q.enqueue(right(temp));
			}
			
		}
		
		return temp;
		}
		return null;
		
	}
	***/
	
	
	
	public Node<T> parent(Node<T> v) {
	    if (v != null) {
	        if (isRoot(v)) {
	            return null;
	        }

	        Queue<Node<T>> Q = new Queue<>();
	        Q.enqueue(root);
	        Node<T> temp = root;

	        while (!Q.isEmpty()) {
	            temp = Q.dequeue();

	            // Verificar si left(temp) y right(temp) son null antes de comparar con v
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

	        // Si no se encuentra el padre, puedes devolver null o lanzar una excepción según tu lógica.
	        return null;
	    }

	    return null;
	}

	
	public int depth(Node<T> v) {
		
		if(isRoot(v)){
			return 0;
		}
		return 1+depth(parent(v));
		
		
	}
	public int height(Node<T> v) {
	    //System.out.println("Comentario de depuración" + v);

	    if (!isInternal(v)) {
	        return 0;
	    } else {
	        int h = 0;
	        int alturaIzquierdo = 0;
	        int alturaDerecho = 0;

	        Node<T> izquierdo = left(v);
	        Node<T> derecho = right(v);

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
	        //System.out.println("Valor de h " + h);
	        return h;
	    }
	}

	
	public void addRoot(T e) {
		
		root = new Node<T>(e);
		size=1; 
	}
	
	public void insertLeft(Node<T> v, T e) {
		Node<T> left = new Node<T>(e);
		v.setLeft(left);
		size++;
	}
	
	public void insertRight(Node<T> v, T e) {
		Node<T> right = new Node<T>(e);
		v.setRight(right);
		size++;
	}
	
	public void remove(Node<T> v) {
		Node<T> p = parent(v);
		Node<T> child;
		if(hasLeft(v)||hasRight(v)) {
			if(hasLeft(v)) {
				 child = left(v);
			}
			else {
				child = right(v);
			}
			if (left(p).equals(v)) {
				p.setLeft(child);
			}
			else {
				p.setRight(child);
			}
			v.setLeft(null);
			v.setRight(null);
		}
		else {
			
			if(left(p).equals(v)) {
				p.setLeft(null);
			}
			else {
				p.setRight(null);
			}
			
		}
		size--;
		
		
	}
	
	public void imprimirArbol() {

		int height=this.height(root);
		
		int cantidad =(int) (3*(Math.pow(2, height)-1)+Math.pow(2, height));
		int valorMalla =cantidad;
		
		/***Queue<Node<T>> q1 = new Queue<Node<T>>();
		Queue<Node<T>> q2 = new Queue<Node<T>>();
		q1.enqueue(root());
		q2.enqueue(root());

		while (!q2.isEmpty()) {
		    Node<T> saca = q2.dequeue();

		    if (saca != null) {
		        if (saca.getLeft() != null) {
		            q2.enqueue(saca.getLeft());
		        } else {
		            q2.enqueue(null);
		        }

		        if (saca.getRight() != null) {
		            q2.enqueue(saca.getRight());
		        } else {
		            q2.enqueue(null);
		        }

		        q1.enqueue(saca.getLeft());
		        q1.enqueue(saca.getRight());
		    } else {
		        // Si el nodo actual es nulo, encolamos dos nodos nulos correspondientes a los hijos inexistentes
		        q1.enqueue(null);
		        q1.enqueue(null);
		    }
		}***/
		Queue<Node<T>> q1 = new Queue<Node<T>>();
	    Queue<Node<T>> q2 = new Queue<Node<T>>();
	    
	    q2.enqueue(root());

	    for (int i = 1; i <= height+1; i++) {
	        int nodosEnNivel = (int) Math.pow(2, i - 1);
	        for (int j = 0; j < nodosEnNivel; j++) {
	            Node<T> saca = q2.dequeue();
	            
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
		//q1 tiene todos los nodos del árbol mas los hijos nulos de los últimos
		/***
		//VERIFICACIÓN AQUI
		while(!q1.isEmpty()) {
			
			System.out.println(q1.dequeue());
			
			
		}***/
		
		
		Node<T> e=null;
		
		
			e=q1.dequeue();
			
				cantidad = (int) Math.floor(cantidad/2);
				for (int j= 1; j<=valorMalla; j++) {
					System.out.print(" ");
					if(j==cantidad) {
						System.out.println(e);
						break;
					}
				}
				
			
			
			
		int contador;
		int h=1;//Controla la cantidad de veces que se hace desqueue
			
		while(h<=height) {
			contador= cantidad;
			cantidad = (int) Math.floor(cantidad/2);
			
			
			
			int j=0;
			int i = 0;
			int m=1;
			
			
			//IMPRIME UN RENGLÓN
			while(i!=Math.pow(2, h) && j!=valorMalla ) {
				j++;
				if(j==cantidad && i==0) {
					e=q1.dequeue();
					if(e==null) {
						System.out.print("x");
					}
					else {
					System.out.print(e);
					}
					i++;
				}
				else if(j==contador*m+m+cantidad) {
					e= q1.dequeue();
					if(e==null) {
						System.out.print("x");
					}
					else {
					System.out.print(e);
					}
					i++;
					m++;
				}
				else {
					System.out.print(" ");
				}
				
				
				
			}
			
			h++;	
			System.out.println();
		}
	}
	
	

}
