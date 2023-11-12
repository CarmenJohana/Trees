package Clases;

import java.util.Date;


public class Usuario {
    private long cedula;
    private String nombre;
    private Fecha fecha_nac;
    private String cargo; // administrador o empleado...Se asigna al leer el txt de passwords 
    private String clave;
    private String ciudad_nac;
    private Direccion dir;
    private long tel;
    private String email;
    private DoubleList<Mensaje> bandejaDeEntrada= new DoubleList<Mensaje>();;
    private Queue<Mensaje> mensajesLeidos= new Queue<Mensaje>();   //Los mensajes leídos estarán en una cola
    private Stack<Mensaje> borradores= new Stack<Mensaje>();  //Los borradores estarán en una pila
    
    public Usuario(String nombre,long cedula,Fecha fecha_nac,String ciudad_nac,long tel,String email,Direccion dir) {
        
        this.cedula=cedula;
        this.nombre=nombre;
        this.fecha_nac=fecha_nac;
        this.ciudad_nac= ciudad_nac;
        this.dir=dir;
        this.tel=tel;
        this.email=email;
        
    }
    
    public Usuario(String n, long cedula) {
        
        this.cedula=cedula;
        this.nombre=n;
        
    }
    
    
//  public String consultarMensajesLeidos() {
//      
//      String texto ="";
////        System.out.println( ((Mensaje)mensajesLeidos.first()).getCedulaDestinatario()+" aqui");
//      Mensaje m = (Mensaje)this.mensajesLeidos.first();
//      int nMensaje = 0;
//      
//      for(int i = 0;i < mensajesLeidos.size();i++) {
//      
//          Date fechaMensaje = m.getDateHour();
//          String titulo = m.getTitulo();
//          String remitente = m.getRemitente();
//      
//          nMensaje++;
//          texto += nMensaje + "# " + fechaMensaje.toLocaleString() + " " + titulo + " " + remitente+"\n";
//          
//          
//              
//      }
//      
//      return texto;
//  }
    
    public String consultarMensajeLeidos() {
        String texto = "";
        Queue<Mensaje> mensajesLeidoscopia= new Queue<Mensaje>();  
        Queue<Mensaje> mensaje = this.mensajesLeidos;
        int nMensaje = 0;
        int c = mensajesLeidos.size();
        
        for(int i = 0;i < c;i++) {
        
            Date fechaMensaje = mensaje.first().getDateHour();
            String titulo = mensaje.first().getTitulo();
            String remitente =mensaje.first().getRemitente();
        
            nMensaje++;
            texto += nMensaje + "# " + fechaMensaje.toLocaleString() + " " + titulo + " " + remitente+"\n";
            
            mensajesLeidoscopia.enqueue(mensaje.first());
            
            mensaje.dequeue();
            
        }
        this.mensajesLeidos = mensajesLeidoscopia;
        return texto;
    }



    public String getCargo() {
        
        return cargo;
        
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public String getClave() {
        return this.clave;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public long getId() {
        return cedula;
    }

    public void setId(long cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Fecha getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Fecha fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getCiudad_nac() {
        return ciudad_nac;
    }

    public void setCiudad_nac(String ciudad_nac) {
        this.ciudad_nac = ciudad_nac;
    }

    public Direccion getDir() {
        return dir;
    }

    public void setDir(Direccion dir) {
        this.dir = dir;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBandejaDeEntrada(DoubleList<Mensaje> bandeja) {
        this.bandejaDeEntrada = bandeja;
    }
    
    public DoubleList<Mensaje> getBandejaDeEntrada() {
        return this.bandejaDeEntrada;
    }
    
    public Queue getMensajeLeidos() {
        return this.mensajesLeidos;
    }
    
    public void setMensajeaLeidos(Queue<Mensaje> cola) {
        this.mensajesLeidos = cola;
    }
    
    @Override
    public String toString() {
        return nombre + "\n " + cedula;
    }
    

    
    public void descartar(Mensaje m) {
        
        //Eliminar mensaje (destroy)
        this.borradores.pop();
        
    }
    
    public void guardarBorrador(Mensaje m) {
        
        //Ingresar en Borradores del remitente
        //Actulizar el txt conectado con el borrador del remitente
        this.borradores.push(m);
    }
    
    public void almacenarInformacionUsuario() {
        
        //Crear tres txt cuyos nombres sean el número de cédula del empleado seguido de 
        //BA para bandeja de entrada
        //Ml para mensajes leidos
        //B para borradores
    }

    public Stack<Mensaje> getBorradores() {
        return borradores;
    }

    public void setBorradores(Stack<Mensaje> borradores) {
        this.borradores = borradores;
    }

    public String mostrarMensajeBorrador(){
        StringBuilder borrador = new StringBuilder();
        Mensaje m = this.getBorradores().top();
        borrador.append("Fecha: " + m.getDateHour() + " Título: " + m.getTitulo() + " Remitente: " + m.getRemitente() + "\n");
        borrador.append("Mensaje:");
        borrador.append("\n").append(m.getMensaje()).append("\n");
        return borrador.toString();
    }

    public String escribirBandejaDeEntrada() {
    StringBuilder texto = new StringBuilder();
    DoubleNode<Mensaje> dNodo = this.bandejaDeEntrada.first();
    int nMensaje = 0;
    
    for (int i = 0; i < bandejaDeEntrada.size(); i++) {
        Mensaje m = dNodo.getData();
    
        nMensaje++;
        texto.append( "\n"+ "Fecha: " + m.getDateHour() + " Titulo: " + m.getTitulo() + " Remitente: " + m.getRemitente() + "\n");
        texto.append("Mensaje:");
        texto.append("\n").append(m.getMensaje()).append("\n");
    
        dNodo = dNodo.getNext();
    }
    
    return texto.toString();
    }

    public String escribirMensajesLeidos() {
        StringBuilder texto = new StringBuilder();
        Queue<Mensaje> mensajesLeidoscopia= new Queue<Mensaje>();  
        Queue<Mensaje> mensaje = this.mensajesLeidos;
        int nMensaje = 0;
        int c = mensajesLeidos.size();
        
        for(int i = 0;i < c;i++) {
        
            Date fechaMensaje = mensaje.first().getDateHour();
            String titulo = mensaje.first().getTitulo();
            String remitente =mensaje.first().getRemitente();
        
            nMensaje++;
            texto.append( "\n"+ "Fecha: " + fechaMensaje.toLocaleString() + " Titulo: " + titulo + " Remitente: " + remitente + "\n");
            texto.append("Mensaje:");
            texto.append("\n").append(mensaje.first().getMensaje()).append("\n");
            
            mensajesLeidoscopia.enqueue(mensaje.first());
            
            mensaje.dequeue();
            
        }
        this.mensajesLeidos = mensajesLeidoscopia;
        return texto.toString();
    }

    public Queue<Mensaje> getMensajesLeidos() {
        return mensajesLeidos;
    }

    public String escribirMensajesBorradores(){
        StringBuilder texto = new StringBuilder();
        Stack<Mensaje> borradores = this.getBorradores();
        int nMensaje = 0;
        int c = borradores.size();
        
        for(int i = 0;i < c;i++) {
        
            Date fechaMensaje = borradores.top().getDateHour();
            String titulo = borradores.top().getTitulo();
            String remitente =borradores.top().getRemitente();
        
            nMensaje++;
            texto.append( "\n"+ "Fecha: " + fechaMensaje.toLocaleString() + " Titulo: " + titulo + " Remitente: " + remitente + "\n");
            texto.append("Mensaje:");
            texto.append("\n").append(borradores.top().getMensaje()).append("\n");
            
            borradores.pop();
            
        }
        return texto.toString();
    }


}