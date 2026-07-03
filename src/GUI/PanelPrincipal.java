package GUI;

import javax.swing.*;

import Dominio.Carta;
import Logica.ISistema;
import Logica.SistemaImpl;
import Visitor.VisitanteCartas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PanelPrincipal extends JFrame {
   
	    private ISistema sistema;
	    private JPanel panelAdministracion;
	    private JPanel panelColeccion;
	    private JTextField txtNombreCarta;
	    private JLabel lblImagenCarta;
	    private JTextArea areaTextoResultados;
	    

	    public PanelPrincipal() {
	        setTitle("Colección Pokémon TCG - Sutrostian & POOsandon");
	        setSize(850, 650);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        this.sistema = SistemaImpl.getInstance();
	        
	        setLayout(new BorderLayout());

	        JPanel panelMenu = new JPanel();
	  
	        
	        JButton botoneraAdmin = new JButton("Administración");
	        JButton botoneraColeccion = new JButton("Ver Colección");
	        
	        panelMenu.add(botoneraAdmin);
	        panelMenu.add(botoneraColeccion);
	        add(panelMenu, BorderLayout.NORTH);
	        panelAdministracion = crearPanelAdmin();
	        panelColeccion = crearPanelColeccion();
	        JPanel panelCentro = new JPanel();
	        panelCentro.add(panelAdministracion);
	        panelCentro.add(panelColeccion);
	        panelAdministracion.setVisible(true);
	        panelColeccion.setVisible(false);
	        
	        add(panelCentro, BorderLayout.CENTER);
	        
	        botoneraAdmin.addActionListener(e -> {
	            panelAdministracion.setVisible(true);
	            panelColeccion.setVisible(false);
	            revalidate();
	            repaint(); 
	        });

	        botoneraColeccion.addActionListener(e -> {
	            panelAdministracion.setVisible(false);
	            panelColeccion.setVisible(true);
	            revalidate();
	            repaint();
	        });
	    }

	    private JPanel crearPanelAdmin() {
	        JPanel panel = new JPanel();
	        panel.setPreferredSize(new Dimension(800, 520));
	        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
	        panel.setBackground(new Color(240, 248, 255));

	
	        JLabel lblTitulo = new JLabel("GESTIÓN DE CARTAS");
	        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
	        
	        JLabel lblNombre = new JLabel("Nombre de la Carta:");
	        txtNombreCarta = new JTextField(15);
	        
	        JButton btnAgregar = new JButton("Agregar");
	        JButton btnEliminar = new JButton("Eliminar");
	        JButton btnModificar = new JButton("Modificar");

	   
	        lblImagenCarta = new JLabel("Visualización de Carta", SwingConstants.CENTER);
	        lblImagenCarta.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	        lblImagenCarta.setBackground(Color.WHITE);
	        lblImagenCarta.setOpaque(true);

	        btnAgregar.addActionListener(e -> {
	            String nombre = txtNombreCarta.getText().trim();
	            if (!nombre.isEmpty()) {

	                sistema.agregarCarta("nombre"); 

	                cargarImagen(nombre);
	                JOptionPane.showMessageDialog(this, "Carta '" + nombre + "' agregada con éxito.");
	            } else {
	                JOptionPane.showMessageDialog(this, "¡Error! Debe ingresar un nombre.", "Validación", JOptionPane.ERROR_MESSAGE);
	            }
	        });

	        btnEliminar.addActionListener(e -> {
	            String nombre = txtNombreCarta.getText().trim();
	            if (!nombre.isEmpty()) {
	                sistema.eliminarCarta();
	                lblImagenCarta.setIcon(null);
	                lblImagenCarta.setText("Carta Eliminada");
	                JOptionPane.showMessageDialog(this, "Carta '" + nombre + "' eliminada del sistema.");
	            } else {
	                JOptionPane.showMessageDialog(this, "Ingrese el nombre de la carta a eliminar.");
	            }
	        });

	        btnModificar.addActionListener(e -> {
	            sistema.modificarCarta();
	            JOptionPane.showMessageDialog(this, "Función Modificar ejecutada.");
	        });


	        panel.add(lblTitulo);
	        panel.add(lblNombre);
	        panel.add(txtNombreCarta);
	        panel.add(btnAgregar);
	        panel.add(btnEliminar);
	        panel.add(btnModificar);
	        panel.add(lblImagenCarta); 

	        return panel;
	    }

	    
	    private JPanel crearPanelColeccion() {
	        JPanel panel = new JPanel();
	        panel.setPreferredSize(new Dimension(800, 520));
	        panel.setBackground(new Color(255, 250, 240)); 
	        
	        JLabel lblTitulo = new JLabel("Colección penca");
	        lblTitulo.setFont(new Font("", Font.BOLD, 16));
	        panel.add(lblTitulo);

	        JTextArea areaTextoResultados = new JTextArea(15, 50);
	        JButton btnOrdNombre = new JButton("Ordenar por Nombre");
	        JButton btnOrdRareza = new JButton("Ordenar por Rareza");
	        JButton btnOrdPoder = new JButton("Ordenar por Poder");

	        
	        btnOrdNombre.addActionListener(e -> {
	            sistema.ordenarNombre();
	            actualizarPantalla(panel);
	            JOptionPane.showMessageDialog(this, "Colección ordenada alfabéticamente.");
	            
	        });

	        btnOrdRareza.addActionListener(e -> {
	            sistema.ordenarRareza();
	            actualizarPantalla(panel);
	            JOptionPane.showMessageDialog(this, "Colección ordenada por rareza.");
	        });

	        btnOrdPoder.addActionListener(e -> {
	            sistema.ordenarPoder();
	            actualizarPantalla(panel);
	            JOptionPane.showMessageDialog(this, "Colección ordenada por poder (Visitor).");
	        });

	        panel.add(btnOrdNombre);
	        panel.add(btnOrdRareza);
	        panel.add(btnOrdPoder);

	        return panel;
	    }

	    
	     
	    private void cargarImagen(String nombreCarta) {
	        String rutaImagen = "imagenes/" + nombreCarta + ".png";
	        ImageIcon icono = new ImageIcon(rutaImagen);

	    
	        if (icono.getImageLoadStatus() != MediaTracker.COMPLETE) {
	      
	            rutaImagen = "imagenes/defecto.png"; 
	            icono = new ImageIcon(rutaImagen);
	        }

	        if (icono.getImageLoadStatus() == MediaTracker.COMPLETE) {
	            Image imgEscalada = icono.getImage().getScaledInstance(200, 280, Image.SCALE_SMOOTH);
	            lblImagenCarta.setIcon(new ImageIcon(imgEscalada));
	            lblImagenCarta.setText(""); 
	        } else {
	            lblImagenCarta.setIcon(null);
	            lblImagenCarta.setText("Imagen no encontrada");
	        }
	    }
	    private void actualizarPantalla(JPanel panel) {
	        areaTextoResultados.setText("");
	        
	        VisitanteCartas calculador = new VisitanteCartas();
	        
	        List<Carta> listaCartas = ((SistemaImpl)sistema).getCartas();
	        
	        if (listaCartas.isEmpty()) {
	            areaTextoResultados.setText("La colección está vacía. ¡Carga el archivo o agrega cartas!");
	            return;
	        }
	        
	        for (Carta c : listaCartas) {
	            c.aceptar(calculador);
	            int poder = calculador.getPoderCalculado();
	            
	            areaTextoResultados.append("• Nombre: " + c.getNombre() + " | Poder: " + poder + "\n");
	        }
	        

	        panel.revalidate();
	        panel.repaint();
	    }
	}