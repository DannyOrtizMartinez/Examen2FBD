package Vista;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class EliminarView extends JFrame {

    public EliminarView() {

        // Configuración de la ventana principal
        setTitle("Eliminar Usuario");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Ruta de la imagen de fondo
        String rutaImagen = "imagen/fondo.jpeg";

        // Verificar que la imagen existe
        File archivoImagen = new File(rutaImagen);
        System.out.println("Ruta de la imagen: " + archivoImagen.getAbsolutePath());
        if (!archivoImagen.exists()) {
            JOptionPane.showMessageDialog(this, "No se encontró la imagen en la ruta especificada:\n" + rutaImagen,
                    "Error de carga", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        FondoPanel panelFondo = new FondoPanel(rutaImagen);
        panelFondo.setLayout(new GridBagLayout()); // Usamos GridBagLayout para centrar el contenido
        add(panelFondo);

        // Configuración del layout y restricciones
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Etiqueta y campo de texto para el ID del usuario
        JLabel labelIdUsuario = new JLabel("ID del Usuario:");
        labelIdUsuario.setToolTipText("Ingrese el ID del usuario que desea eliminar.");
        JTextField txtIdUsuario = new JTextField(20);
        txtIdUsuario.setToolTipText("El ID del usuario debe ser numérico.");

        // Botón de eliminar
        JButton btnEliminar = crearBoton("Eliminar", "Haga clic para eliminar el usuario.");
        btnEliminar.addActionListener(e -> {
            String idUsuario = txtIdUsuario.getText().trim();
            if (idUsuario.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese el ID del usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Lógica de eliminación (simulada)
                JOptionPane.showMessageDialog(this, "Usuario con ID " + idUsuario + " eliminado exitosamente.", 
                                              "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Botón para cancelar
        JButton btnCancelar = crearBoton("Cancelar", "Haga clic para cancelar la operación.");
        btnCancelar.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea cancelar?", "Cancelar", 
                                                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                dispose();
            }
        });

        // Posicionar componentes en el panel
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
        panelFondo.add(labelIdUsuario, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        panelFondo.add(txtIdUsuario, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER;
        panelFondo.add(btnEliminar, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER;
        panelFondo.add(btnCancelar, gbc);

        // Mostrar la ventana
        setVisible(true);
    }

    // Método para crear botones estilizados
    private JButton crearBoton(String texto, String tooltip) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.setFocusPainted(false);
        boton.setToolTipText(tooltip);
        boton.setBackground(new Color(220, 53, 69)); // Rojo para resaltar la acción de eliminar
        boton.setForeground(Color.WHITE);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return boton;
    }

    // Clase personalizada para pintar una imagen de fondo
    private static class FondoPanel extends JPanel {
        private final Image imagenFondo;

        public FondoPanel(String rutaImagen) {
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
