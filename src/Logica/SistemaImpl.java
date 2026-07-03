package Logica;

import java.util.ArrayList;
import java.util.List;

import Dominio.*;
import Factory.CartasFactory;
import Visitor.VisitanteCartas;
import Visitor.Visitor;


public class SistemaImpl implements ISistema {
	private List<Carta> cartas= new ArrayList<Carta>();
	private VisitanteCartas visitante = new VisitanteCartas();
	private CartasFactory fabrica = new CartasFactory();
	private static SistemaImpl instance;

	
	private SistemaImpl() {}
	
	public static SistemaImpl getInstance() {
		if(instance == null) {
			instance = new SistemaImpl();
		}
		
		return instance;
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

	@Override
	public void agregarCarta(String linea) {
		// TODO Auto-generated method stub
		Carta nueva = CartasFactory.factoryCartas(linea);
		if (nueva != null) {
			cartas.add(nueva); 
		}
	}
	public List<Carta> getCartas() {
		
	    return this.cartas;
	    
	}
	
}
