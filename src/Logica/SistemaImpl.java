package Logica;

import java.util.ArrayList;
import java.util.List;

import Dominio.*;
public class SistemaImpl implements ISistema {
	private List<Carta> cartas= new ArrayList<Carta>();
	private Visitor visitante = new VisitanteCartas();
	@Override
	public void agregarCarta() {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarCarta() {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarCarta() {
		// TODO Auto-generated method stub

	}

	@Override
	public void ordenarRareza() {
		// TODO Auto-generated method stub

	}

	@Override
	public void ordenarNombre() {
		// TODO Auto-generated method stub

	}

	@Override
	public void ordenarPoder() {
		// TODO Auto-generated method stub

	}

}
