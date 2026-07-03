package Visitor;

import Dominio.Energy;
import Dominio.Item;
import Dominio.Pokemon;
import Dominio.Supporter;

public interface Visitor {
	void visit(Pokemon pokemon);
    void visit(Energy energy);
    void visit(Item item);
    void visit(Supporter supporter);
}
