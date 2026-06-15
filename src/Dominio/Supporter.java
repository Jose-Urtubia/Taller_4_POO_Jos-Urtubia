package Dominio;

public class Supporter extends Carta {
	private int rareza;
	private int efectosPorTurno;
	public Supporter(String nombre,String rareza, String efectosPorTurno) {
		super(nombre);
		// TODO Auto-generated constructor stub
		this.rareza= Integer.parseInt(rareza);
		this.efectosPorTurno= Integer.parseInt(efectosPorTurno);
	}
	public int getEfectosPorTurno() {
		return efectosPorTurno;
	}
	public void setEfectosPorTurno(int efectosPorTurno) {
		this.efectosPorTurno = efectosPorTurno;
	}
	@Override
	public void aceptar(Visitor visitante) {
		// TODO Auto-generated method stub
		visitante.visitarSupporte(this);
	}
	
}
