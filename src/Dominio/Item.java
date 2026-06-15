package Dominio;

public class Item extends Carta {
	
	private int rareza;
	private int bonificacion;
	public Item(String nombre,String rareza, String bonificacion) {
		super(nombre);
		// TODO Auto-generated constructor stub
		this.bonificacion=Integer.parseInt(bonificacion);
		this.rareza=Integer.parseInt(rareza);
	}
	public int getBonificacion() {
		return bonificacion;
	}
	public void setBonificacion(int bonificacion) {
		this.bonificacion = bonificacion;
	}
	@Override
	public void aceptar(Visitor visitante) {
		// TODO Auto-generated method stub
		visitante.visit(this);;
	}
	
}
