package Factory;

import Dominio.Carta;
import Dominio.Energy;
import Dominio.Item;
import Dominio.Pokemon;
import Dominio.Supporter;

public class CartasFactory {
	
	public static Carta factoryCartas(String linea) {
		try {
	        String partes[] = linea.split(";");
	        
	        if (partes[2].equalsIgnoreCase("Pokemon")) {
	            return new Pokemon(partes[0], partes[1], partes[3], partes[4]);
	        } else if(partes[2].equalsIgnoreCase("Item")) {
	            return new Item(partes[0], partes[1], partes[3]);
	        } else if (partes[2].equalsIgnoreCase("Supporter")) {
	            return new Supporter(partes[0], partes[1], partes[3]);
	        } else if (partes[2].equalsIgnoreCase("Energy")) {
	            return new Energy(partes[0], partes[1], partes[3]);
	        }
	    } catch (Exception e) {
	        System.out.println("Error al leer una línea del archivo: " + linea);
	    }
	    return null;
	}
}
