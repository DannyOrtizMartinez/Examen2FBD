package Vista;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class EliminarVista extends JFrame {

    public EliminarVista() {

        // Configuración de la ventana principal
        setTitle("Eliminar Usuario");
        setSize(800, 600); // Tamaño ajustado
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar solo esta ventana
        setLocationRelativeTo(null);

        // Cambiar color de fondo
        getContentPane().setBackground(new Color(245, 245, 220)); // Color beige claro

        // Configuración del layout principal
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        panelPrincipal.setOpaque(false);
        add(panelPrincipal);

        // Configuración del layout y restricciones
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Crear título estilizado
        JLabel titulo = new JLabel("ELIMINACIÓN DE USUARIO");
        titulo.setFont(new Font("Roboto", Font.BOLD, 28));
        titulo.setForeground(new Color(105, 105, 105)); // Gris oscuro
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST; // Alinear a la izquierda
        panelPrincipal.add(titulo, gbc);

        // Etiqueta y campo de texto para el ID del usuario
        JLabel labelIdUsuario = crearEtiqueta("ID del Usuario:");
        JTextField txtIdUsuario = crearCampoTexto("Ingrese el ID del usuario que desea eliminar.");

        // Botón de eliminar
        JButton btnEliminar = crearBoton("Eliminar", "Haga clic para eliminar el usuario.", "imagenes/eliminarIcon.png",
                new Color(220, 53, 69), Color.WHITE); // Rojo para resaltar la acción

        // Acción para el botón "Eliminar"
        btnEliminar.addActionListener(e -> {
            String idUsuario = txtIdUsuario.getText().trim();
            if (idUsuario.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese el ID del usuario.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                // Lógica de eliminación (simulada)
                JOptionPane.showMessageDialog(this, "Usuario con ID " + idUsuario + " eliminado exitosamente.",
                        "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Botón regresar
        JButton btnRegresar = crearBoton("Regresar", "Regresa al menú principal.", "imagenes/salir.png",
                new Color(255, 165, 0), Color.WHITE); // Naranja

        // Acción para el botón "Regresar"
        btnRegresar.addActionListener(e -> {
            this.dispose(); // Cierra esta ventana
            new CrudGUI(); // Abre la ventana principal
        });

        // Posicionar componentes
        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;
        panelPrincipal.add(labelIdUsuario, gbc);
        gbc.gridx = 1;
        panelPrincipal.add(txtIdUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelPrincipal.add(btnEliminar, gbc);

        gbc.gridy = 3;
        panelPrincipal.add(btnRegresar, gbc);

        // Mostrar la ventana
        setVisible(true);
    }

    // Método para crear etiquetas estilizadas
    private JLabel crearEtiqueta(String texto) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setForeground(new Color(105, 105, 105)); // Gris oscuro
        etiqueta.setFont(new Font("Arial", Font.BOLD, 14));
        return etiqueta;
    }

    // Método para crear campos de texto estilizados
    private JTextField crearCampoTexto(String tooltip) {
        JTextField campoTexto = new JTextField(20);
        campoTexto.setToolTipText(tooltip);
        campoTexto.setFont(new Font("Arial", Font.PLAIN, 16));
        campoTexto.setPreferredSize(new Dimension(300, 30));
        return campoTexto;
    }

    // Método para crear botones estilizados con colores personalizados e íconos
    private JButton crearBoton(String texto, String tooltip, String rutaIcono, Color colorFondo, Color colorTexto) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial", Font.BOLD, 12));
        boton.setFocusPainted(false);
        boton.setToolTipText(tooltip);
        boton.setBackground(colorFondo);
        boton.setForeground(colorTexto);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setPreferredSize(new Dimension(150, 30));

        // Asignar ícono al botón si existe
        if (new File(rutaIcono).exists()) {
            ImageIcon icono = new ImageIcon(rutaIcono);
            boton.setIcon(new ImageIcon(icono.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
            boton.setHorizontalTextPosition(SwingConstants.RIGHT); // Texto a la derecha del ícono
        }

        return boton;
    }
}
