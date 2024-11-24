package Vista;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ActualizarView extends JFrame {

    public ActualizarView() {

        // Configuración de la ventana principal
        setTitle("Formulario de Actualización de Nombres");
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

        // Crear etiquetas y campos de texto
        JLabel labelBuscar = new JLabel("Buscar por ID:");
        JTextField txtBuscar = new JTextField(15);
        labelBuscar.setToolTipText("Ingrese el ID del registro que desea actualizar.");

        JButton btnBuscar = crearBoton("Buscar", "Haga clic para buscar el registro.");
        btnBuscar.addActionListener(e -> {

            // Simulación de búsqueda (puedes reemplazar con la lógica real)
            String id = txtBuscar.getText();
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un ID para buscar.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Lógica para buscar datos
                JOptionPane.showMessageDialog(this, "Datos encontrados para ID: " + id, "Búsqueda exitosa", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JLabel labelPrimerNombre = new JLabel("Primer Nombre:");
        JTextField txtPrimerNombre = new JTextField(20);
        labelPrimerNombre.setToolTipText("Ingrese el nuevo primer nombre.");

        JLabel labelSegundoNombre = new JLabel("Segundo Nombre:");
        JTextField txtSegundoNombre = new JTextField(20);
        labelSegundoNombre.setToolTipText("Ingrese el nuevo segundo nombre (opcional).");

        JLabel labelPrimerApellido = new JLabel("Primer Apellido:");
        JTextField txtPrimerApellido = new JTextField(20);
        labelPrimerApellido.setToolTipText("Ingrese el nuevo primer apellido.");

        JLabel labelSegundoApellido = new JLabel("Segundo Apellido:");
        JTextField txtSegundoApellido = new JTextField(20);
        labelSegundoApellido.setToolTipText("Ingrese el nuevo segundo apellido (opcional).");

        // Botón de actualización
        JButton btnActualizar = crearBoton("Actualizar", "Haga clic para actualizar los datos.");
        btnActualizar.addActionListener(e -> {
            if (txtPrimerNombre.getText().isEmpty() || txtPrimerApellido.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Los campos de primer nombre y primer apellido son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Lógica de actualización, conectar con la BD
                String mensaje = String.format(
                        "Datos actualizados:\nPrimer Nombre: %s\nSegundo Nombre: %s\nPrimer Apellido: %s\nSegundo Apellido: %s",
                        txtPrimerNombre.getText(),
                        txtSegundoNombre.getText(),
                        txtPrimerApellido.getText(),
                        txtSegundoApellido.getText()
                );
                JOptionPane.showMessageDialog(this, mensaje, "Actualización Exitosa", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Posicionar componentes en el panel
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
        panelFondo.add(labelBuscar, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        panelFondo.add(txtBuscar, gbc);

        gbc.gridx = 2; gbc.anchor = GridBagConstraints.CENTER;
        panelFondo.add(btnBuscar, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.anchor = GridBagConstraints.EAST;
        panelFondo.add(labelPrimerNombre, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        panelFondo.add(txtPrimerNombre, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.anchor = GridBagConstraints.EAST;
        panelFondo.add(labelSegundoNombre, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        panelFondo.add(txtSegundoNombre, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.anchor = GridBagConstraints.EAST;
        panelFondo.add(labelPrimerApellido, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        panelFondo.add(txtPrimerApellido, gbc);

        gbc.gridx = 0; gbc.gridy = 4; gbc.anchor = GridBagConstraints.EAST;
        panelFondo.add(labelSegundoApellido, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        panelFondo.add(txtSegundoApellido, gbc);

        gbc.gridx = 1; gbc.gridy = 5; gbc.anchor = GridBagConstraints.CENTER;
        panelFondo.add(btnActualizar, gbc);

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

    // Clase para pintar una imagen de fondo
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
