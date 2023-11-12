package Clases;

public class Direccion {
	
	private String calle;
	private String nomenclatura;
	private String barrio;
	private String ciudad;
	private String urbanizacion;
	private int apto;
	
	public Direccion(String calle, String nomenclatura, String barrio, String ciudad, String urbanizacion, int apto) {
		
		this.calle=calle;
		this.nomenclatura=nomenclatura;
		this.barrio=barrio;
		this.ciudad=ciudad;
		this.urbanizacion=urbanizacion;
		this.apto=apto;
		
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	public String getUrbanizacion() {
		return urbanizacion;
	}

	public void setUrbanizaciones(String urbanizacion) {
		this.urbanizacion = urbanizacion;
	}
	
	public int getApto() {
		return apto;
	}

	public void setApto(int apto) {
		this.apto = apto;
	}

	

	public String getNomenclatura() {
		return nomenclatura;
	}

	public void setNomenclatura(String nomenclatura) {
		this.nomenclatura = nomenclatura;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return calle + " " + nomenclatura + " "+ barrio + " " + ciudad+ " "+urbanizacion +" "+apto;
	}
		
}