package Clases;



public class SistemaMensajeria{
	
	private BinarySearchTree<Usuario> users;
	
	
	public SistemaMensajeria(int capacity){
		
		users = new BinarySearchTree<Usuario>();
		
	}

	/***
	 
	Aquí van los métodos que se encargan de inicializar la lista de usuarios

	***/
	
	
	
	
	public void setUsers(BinarySearchTree<Usuario> users){

		//Creamos los usuarios iniciales, estos son los extraídos del archivo empleados.txt
		
		this.users=users;
		

	}
	public BinarySearchTree<Usuario> getUsers() {
		return this.users;	
	}
	

	/***Demás getters, setters y métodos de búsqueda y eliminación de usuarios
	por aquí. También los de cambio de contraseña y alias de usuario***/

	
	public Node<BSTEntry<Usuario>> busquedaUsuario(int id) {
	   
		return users.find(id);
		
	}
	
	

	public void mostrarUsuarios() {
		users.imprimirArbol();
	}
	

	
	
	public void registrarUsuarios(Usuario usuario, int clave) {
		users.insert(usuario, clave);

	}
	
	
	
	
	
	public BSTEntry<Usuario> eliminarUsuario(int k) {
		
		return users.remove(k);
		
	}
	
	

	public static void main(String[] args) {
		
		
		
		
		BinaryTree<Integer> b= new BinaryTree<Integer>();
		b.addRoot(1);
		
		Node<Integer> n6 = new Node<Integer>(6);
		Node<Integer> n2 = new Node<Integer>(2);
		Node<Integer> n3 = new Node< Integer>(3);
		Node<Integer> n7 = new Node< Integer>(7);
		Node<Integer> n5 = new Node< Integer>(5);
		Node<Integer> n4 = new Node< Integer>(4);
		Node<Integer> n8 = new Node< Integer>(8);
		Node<Integer> n9 = new Node< Integer>(9);
		Node<Integer> n10 = new Node<Integer>(0);
		Node<Integer> n11 = new Node<Integer>(1);
		Node<Integer> n12 = new Node< Integer>(1);
		Node<Integer> n13 = new Node< Integer>(1);
		Node<Integer> n14 = new Node< Integer>(1);
		Node<Integer> n15 = new Node< Integer>(1);
		Node<Integer> n16 = new Node< Integer>(1);
		Node<Integer> n17 = new Node< Integer>(1);
		
		b.insertLeft(b.root(), 2);
		b.insertRight(b.root(), 3);
		b.insertRight(b.root().getLeft(),5 );
		b.insertLeft(b.root().getLeft(), 4 );
		b.insertRight(b.root().getRight(), 7 );
		b.insertLeft(b.root().getRight().getRight(),  9);
		b.insertLeft(b.root().getRight(), 6 );
		b.insertLeft(b.root().getRight().getLeft(), 6 );
		b.insertLeft(b.root().getLeft().getLeft(), 8 );
		b.insertRight(b.root().getLeft().getLeft(), 9 );
		b.insertRight(b.root().getLeft().getRight(), 1 );
		b.insertLeft(b.root().getLeft().getRight(), 3 );
		b.insertLeft(b.root().getLeft().getRight().getLeft(), 1 );
		b.insertRight(b.root().getLeft().getRight().getLeft().getLeft(), 19);
		//b.insertRight(b.root().getLeft().getRight().getLeft().getLeft().getRight(), 0);
		//b.insertLeft(b.root().getLeft().getRight().getLeft().getLeft().getRight(), 5);
		//b.insertLeft(b.root().getLeft().getRight().getLeft().getLeft().getRight().getRight(), 11);
		System.out.println("ESTE ---> "+b.parent(b.root().getLeft().getRight().getLeft().getLeft().getRight().getRight()));
		
		//System.out.println("PADRE DE 9 "+ b.parent(b.root().getRight().getRight().getLeft()));
		/***
		b.root().setLeft(n2);
		b.root().setRight(n3);
		b.root().getLeft().setLeft(n4);
		b.root().getLeft().setRight(n5);
		b.root().getRight().setLeft(n6);
		b.root().getRight().setRight(n7);
		b.root().getLeft().getLeft().setLeft(n8);
		b.root().getLeft().getLeft().setRight(n9);
		
		b.root().getLeft().getRight().setLeft(n10);
		b.root().getLeft().getRight().setRight(n11);
		b.root().getLeft().getRight().getLeft().setLeft(n12);
		//b.root().getLeft().getRight().getLeft().setRight(n12);
		***/
		
		//b.imprimeArbol();
		b.imprimirArbol();
		System.out.println("PARENT 6 "+ b.parent(b.root().getRight()));
		b.remove(b.root().getRight());
		System.out.println("HIJO DERECHO DEL 1 "+ b.root().getRight());
		//b.imprimirArbol();
		
		
		
		BinarySearchTree<Integer> b1= new BinarySearchTree<Integer>();
		
		
		b1.insert(2, 7);
		b1.insert(19, 7);
		b1.insert(19, 7);
		b1.insert(19, 3);
		b1.insert(19, 4);
		b1.insert(19, 8);
		b1.insert(19, 6);
		b1.insert(19, 24);
		
		b1.imprimirArbol();
		System.out.println();
		
		//System.out.println(b.height(b.root()));
	}

}
