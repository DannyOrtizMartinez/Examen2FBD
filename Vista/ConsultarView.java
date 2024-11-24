package Vista;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ConsultarView extends JFrame {

    public ConsultarView() {

        // Configuración de la ventana principal
        setTitle("Formulario de Consulta");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Ruta absoluta de la imagen
        String rutaImagen = "imagen/fondo.jpeg";

        // Verificar que la imagen existe
        if (!new File(rutaImagen).exists()) {
            JOptionPane.showMessageDialog(this, "No se encontró la imagen en la ruta especificada:\n" + rutaImagen,
                    "Error de carga", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        FondoPanel panelFondo = new FondoPanel(rutaImagen);
        panelFondo.setLayout(new GridBagLayout()); // Layout para organizar componentes
        add(panelFondo);

        // Configuración de layout y restricciones
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Crear etiqueta y campo de texto para buscar
        JLabel labelBuscar = new JLabel("Buscar por ID:");
        JTextField txtBuscar = new JTextField(15);
        labelBuscar.setToolTipText("Ingrese el ID del registro que desea consultar.");

        // Botón de búsqueda
        JButton btnBuscar = crearBoton("Buscar", "Haga clic para buscar el registro.");
        JTextArea areaResultados = new JTextArea(10, 30);
        areaResultados.setEditable(false);
        areaResultados.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollResultados = new JScrollPane(areaResultados);

        btnBuscar.addActionListener(e -> {
            // Simulación de búsqueda (puedes reemplazar con la lógica real)
            String id = txtBuscar.getText();
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un ID para buscar.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Lógica para buscar datos
            }
        });

        // Posicionar componentes en el panel
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
        panelFondo.add(labelBuscar, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        panelFondo.add(txtBuscar, gbc);

        gbc.gridx = 2; gbc.anchor = GridBagConstraints.CENTER;
        panelFondo.add(btnBuscar, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
        panelFondo.add(scrollResultados, gbc);

        // Mostrar la ventana
        setVisible(true);
    }

    // Método para crear botones estilizados
    private JButton crearBoton(String texto, String tooltip) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.setFocusPainted(false);
        boton.setToolTipText(tooltip);
        boton.setBackground(new Color(70, 130, 180));
        boton.setForeground(Color.WHITE);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return boton;
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
