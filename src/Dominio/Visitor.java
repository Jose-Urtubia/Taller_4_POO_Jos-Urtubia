package Dominio;

public interface Visitor {
	void visit(Pokemon pokemon);
    void visit(Energy energy);
    void visit(Item item);
    void visit(Supporter supporter);
}
