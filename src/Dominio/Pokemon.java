package Dominio;

public class Pokemon extends Carta {
	
	private int daño;
	private int CantEnergias;
	private int rareza;
	public Pokemon(String nombre,String rareza, String daño, String CantEnergias) {
		super(nombre);
		// TODO Auto-generated constructor stub
		this.rareza=Integer.parseInt(rareza);
		this.daño= Integer.parseInt(daño);
		this.CantEnergias= Integer.parseInt(CantEnergias);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDaño() {
		return daño;
	}
	public void setDaño(int daño) {
		this.daño = daño;
	}
	public int getCantEnergias() {
		return CantEnergias;
	}
	public void setCantEnergias(int cantEnergias) {
		CantEnergias = cantEnergias;
	}
	@Override
	public void aceptar(Visitor visitante) {
		// TODO Auto-generated method stub
		visitante.visit(this);
	}
	
}
