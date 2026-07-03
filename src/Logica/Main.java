package Logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import GUI.PanelPrincipal;

public class Main {
	
	
	private static ISistema sistema = SistemaImpl.getInstance();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		leerArch();
		PanelPrincipal panel = new PanelPrincipal();
		panel.setVisible(true);
	
		

	}
	private static void leerArch() {
		// TODO Auto-generated method stub
		
		File arch = new File("txt/Sobres.txt");
		Scanner s;
		try {
			s = new Scanner(arch);
			while (s.hasNextLine()) {
				
				sistema.agregarCarta(s.nextLine());
				
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}

}
