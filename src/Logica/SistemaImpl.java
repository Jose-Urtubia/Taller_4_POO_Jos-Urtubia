package Logica;

import java.util.ArrayList;
import java.util.List;

import Dominio.*;


public class SistemaImpl implements ISistema {
	private List<Carta> cartas= new ArrayList<Carta>();
	private Visitor visitante = new VisitanteCartas();
	private static SistemaImpl instance;

	
	private SistemaImpl() {}
	
	public static SistemaImpl getInstance() {
		if(instance == null) {
			instance = new SistemaImpl();
		}
		
		return instance;
	}
	
	public void agregarCarta() {
		// TODO Auto-generated method stub

	}
	
	
	
	public void eliminarCarta() {
		// TODO Auto-generated method stub

	}

	
	public void modificarCarta() {
		// TODO Auto-generated method stub

	}

	
	public void ordenarRareza() {
		// TODO Auto-generated method stub

	}

	
	public void ordenarNombre() {
		// TODO Auto-generated method stub

	}

	
	public void ordenarPoder() {
		// TODO Auto-generated method stub

	}
}
