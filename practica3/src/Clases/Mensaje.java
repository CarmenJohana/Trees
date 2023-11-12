package Clases;
import java.util.Date;


public class Mensaje {
	
	
	private String remitente;
	private long cedulaDestinatario;
	private String titulo;
	private String mensaje;
	private Date dateHour; //Con hacer Date date=new Date() automaticamente tendremos un String con la fecha y hora actuales
	
	public Mensaje(String remitente,long cedulaDestinatario, String titulo, String mensaje) {
		
		this.remitente=remitente;
		this.cedulaDestinatario=cedulaDestinatario;
		this.titulo=titulo;
		this.mensaje=mensaje;
		this.dateHour=new Date();
		
		
	}
	
	
	

	public String getRemitente() {
		return remitente;
	}




	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}




	public long getCedulaDestinatario() {
		return cedulaDestinatario;
	}

	public void setCedulaDestinatario(long cedulaDestinatario) {
		this.cedulaDestinatario = cedulaDestinatario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Date getDateHour() {
		return dateHour;
	}
	
	
	
	@Override
	public String toString() {
		
		return dateHour+"\n"+titulo+"\n"+remitente;
		
	}
	
	
}
