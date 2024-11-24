package Vista;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GUI extends JFrame {

    public GUI() {

        // Ruta de la imagen de fondo
        String rutaImagen = "imagen/fondo2.jpg";

        // Verifica que la imagen existe
        if (!new File(rutaImagen).exists()) {
            JOptionPane.showMessageDialog(this, "No se encontró la imagen en la ruta especificada:\n" + rutaImagen,
                    "Error de carga", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        // Creamos el panel de fondo
        FondoPanel panelFondo = new FondoPanel(rutaImagen);
        panelFondo.setLayout(new BorderLayout());
        add(panelFondo);

        // Panel superior con el título
        JPanel panelTitulo = new JPanel();
        panelTitulo.setOpaque(false);
        panelTitulo.setBorder(BorderFactory.createEmptyBorder(30, 0, 10, 0));
        JLabel etiquetaTitulo = new JLabel("MENÚ PRINCIPAL");
        etiquetaTitulo.setForeground(Color.GRAY);
        etiquetaTitulo.setFont(new Font("Roboto", Font.BOLD, 36));
        panelTitulo.add(etiquetaTitulo);
        panelFondo.add(panelTitulo, BorderLayout.NORTH);

        // Panel central con los botones
        JPanel panelBotones = new JPanel(new GridLayout(5, 1, 10, 10));
        panelBotones.setOpaque(false);
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 250, 50, 250));

        // Creación botones con íconos
        JButton btnIngresar = crearBoton("INSERTAR", "Registra nuevos datos en el sistema.", new Color(153, 102, 255),
                "imagen/insertar2.png");
        JButton btnConsultar = crearBoton("CONSULTAR", "Consulta los datos existentes.", new Color(255, 153, 102),
                "imagen/lupa.png");
        JButton btnActualizar = crearBoton("ACTUALIZAR", "Actualiza los datos en el sistema.", new Color(255, 204, 102),
                "imagen/lapiz2.png");
        JButton btnEliminar = crearBoton("ELIMINAR", "Elimina datos del sistema.", new Color(255, 102, 102),
                "imagen/eliminarIcon.png");
        JButton btnSalir = crearBoton("SALIR", "Cierra la aplicación.", new Color(102, 178, 255), "imagen/salir.png");

        // Agrega acciones a los botones
        btnIngresar.addActionListener(e -> abrirVista(new InsertarVista()));
        btnConsultar.addActionListener(e -> abrirVista(new ConsultarView()));
        btnActualizar.addActionListener(e -> abrirVista(new ActualizarVista()));
        btnEliminar.addActionListener(e -> abrirVista(new EliminarVista()));

        btnSalir.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea salir?", "Salir",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        // Agrega los botones al panel
        panelBotones.add(btnIngresar);
        panelBotones.add(btnConsultar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnSalir);

        panelFondo.add(panelBotones, BorderLayout.CENTER);

        // Mostrar la ventana
        setVisible(true);
    }

    // Crea botones con diferentes estilos
    private JButton crearBoton(String texto, String tooltip, Color color, String rutaIcono) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        boton.setFocusPainted(false);
        boton.setToolTipText(tooltip);
        boton.setBackground(color);
        boton.setForeground(Color.WHITE);
        boton.setPreferredSize(new Dimension(200, 30));
        boton.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 1, true));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Asignar ícono al botón
        if (rutaIcono != null) {
            ImageIcon icono = new ImageIcon(rutaIcono);
            boton.setIcon(new ImageIcon(icono.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH)));
            boton.setHorizontalTextPosition(SwingConstants.RIGHT);
        }

        // Agregar efecto de hover
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton.setBackground(color.darker());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton.setBackground(color);
            }
        });

        return boton;
    }

    // Método para abrir una nueva vista
    private void abrirVista(JFrame vista) {
        vista.setVisible(true);
    }

    // Clase personalizada para pintar una imagen de fondo
    private static class FondoPanel extends JPanel {
        private final Image imagenFondo;

        public FondoPanel(String rutaImagen) {
            // Cargar la imagen desde la ruta especificada
            this.imagenFondo = new ImageIcon(rutaImagen).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (imagenFondo != null) {
                g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
