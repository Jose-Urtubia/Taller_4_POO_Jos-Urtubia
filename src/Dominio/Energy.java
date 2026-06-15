package Dominio;

public class Energy extends Carta {
	private int poder;
	private int rareza;
	private String elemento;
	public Energy(String nombre, String rareza, String elemento) {
		super(nombre);
		// TODO Auto-generated constructor stub
		this.poder=1;
		this.rareza=Integer.parseInt(rareza);
		this.elemento=elemento;
	}

	@Override
	public void aceptar(Visitor visitante) {
		// TODO Auto-generated method stub
		visitante.visitarEnergy(this);
	}
	public int getPoder() {
		return poder;
	}
}
