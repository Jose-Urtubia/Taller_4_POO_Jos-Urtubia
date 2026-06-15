package Dominio;

public abstract class Carta {
	protected String nombre;

	public Carta(String nombre) {
	
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public abstract void aceptar(Visitor v);
	
}
