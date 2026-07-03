package GUI;

import javax.swing.*;

import Logica.ISistema;
import Logica.SistemaImpl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPrincipal extends JFrame {
   
	    private ISistema sistema;
	    private JPanel panelAdministracion;
	    private JPanel panelColeccion;
	    private JTextField txtNombreCarta;
	    private JLabel lblImagenCarta;

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

	        // ACCIONES DE LOS BOTONES CON LAMBDAS (FLECHITAS)
	        
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

	        // Agregar los componentes en orden al panel
	        panel.add(lblTitulo);
	        panel.add(lblNombre);
	        panel.add(txtNombreCarta);
	        panel.add(btnAgregar);
	        panel.add(btnEliminar);
	        panel.add(btnModificar);
	        panel.add(lblImagenCarta); // Se agrega abajo el recuadro de la foto

	        return panel;
	    }

	    /**
	     * Construye y retorna el panel correspondiente a la Pestaña 2: Ver Colección.
	     * * @return El JPanel configurado con los botones de ordenamiento y visualización.
	     */
	    private JPanel crearPanelColeccion() {
	        JPanel panel = new JPanel();
	        panel.setPreferredSize(new Dimension(800, 520));
	        panel.setBackground(new Color(255, 250, 240)); // Color crema
	        
	        JLabel lblTitulo = new JLabel("=== MI COLECCIÓN ===");
	        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
	        panel.add(lblTitulo);

	        // Botones de ordenamiento requeridos
	        JButton btnOrdNombre = new JButton("Ordenar por Nombre");
	        JButton btnOrdRareza = new JButton("Ordenar por Rareza");
	        JButton btnOrdPoder = new JButton("Ordenar por Poder");

	        // ACCIONES DE ORDENAMIENTO CON LAMBDAS
	        btnOrdNombre.addActionListener(e -> {
	            sistema.ordenarNombre();
	            JOptionPane.showMessageDialog(this, "Colección ordenada alfabéticamente.");
	        });

	        btnOrdRareza.addActionListener(e -> {
	            sistema.ordenarRareza();
	            JOptionPane.showMessageDialog(this, "Colección ordenada por rareza.");
	        });

	        btnOrdPoder.addActionListener(e -> {
	            sistema.ordenarPoder();
	            JOptionPane.showMessageDialog(this, "Colección ordenada por poder (Visitor).");
	        });

	        panel.add(btnOrdNombre);
	        panel.add(btnOrdRareza);
	        panel.add(btnOrdPoder);

	        return panel;
	    }

	    /**
	     * Método auxiliar para cargar una imagen escalada en el visor.
	     * Si no encuentra el archivo especificado, carga automáticamente una imagen por defecto.
	     * * @param nombreCarta El nombre del archivo de imagen a buscar (sin extensión).
	     */
	    private void cargarImagen(String nombreCarta) {
	        String rutaImagen = "imagenes/" + nombreCarta + ".png";
	        ImageIcon icono = new ImageIcon(rutaImagen);

	        // Control de errores / Validación: Si la imagen no existe en la ruta
	        if (icono.getImageLoadStatus() != MediaTracker.COMPLETE) {
	            // Carga la imagen por defecto como exige el taller
	            rutaImagen = "imagenes/defecto.png"; 
	            icono = new ImageIcon(rutaImagen);
	        }

	        if (icono.getImageLoadStatus() == MediaTracker.COMPLETE) {
	            // Escalamos la imagen para que se adapte perfectamente al tamaño de 200x280
	            Image imgEscalada = icono.getImage().getScaledInstance(200, 280, Image.SCALE_SMOOTH);
	            lblImagenCarta.setIcon(new ImageIcon(imgEscalada));
	            lblImagenCarta.setText(""); // Borramos el texto descriptivo
	        } else {
	            lblImagenCarta.setIcon(null);
	            lblImagenCarta.setText("Imagen no encontrada");
	        }
	    }
	}