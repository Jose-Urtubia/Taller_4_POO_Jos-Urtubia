package Dominio;

public interface Visitor {
	void visitarPokemon(Pokemon pokemon);
    void visitarEnergy(Energy energy);
    void visitarItem(Item item);
    void visitarSupporte(Supporter supporter);
}
