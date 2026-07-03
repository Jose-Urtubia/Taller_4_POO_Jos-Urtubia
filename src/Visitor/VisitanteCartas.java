package Visitor;

import Dominio.Energy;
import Dominio.Item;
import Dominio.Pokemon;
import Dominio.Supporter;

public class VisitanteCartas implements Visitor {
	private int poderCalculado;
	@Override
	public void visit(Pokemon pokemon) {
		// TODO Auto-generated method stub
		if (pokemon.getCantEnergias() > 0) {
			this.poderCalculado = (pokemon.getDaño() / pokemon.getCantEnergias()) * 100;
		} else {
			this.poderCalculado = pokemon.getDaño() * 100; 
		}
	}
	

	@Override
	public void visit(Energy energy) {
		// TODO Auto-generated method stub
		this.poderCalculado = energy.getPoder();
	}

	@Override
	public void visit(Item item) {
		// TODO Auto-generated method stub
		this.poderCalculado = item.getBonificacion() * 20;
	}

	@Override
	public void visit(Supporter supporter) {
		// TODO Auto-generated method stub
		this.poderCalculado = supporter.getEfectosPorTurno() * 50;
	}

	public int getPoderCalculado() {
		return poderCalculado;
	}

}