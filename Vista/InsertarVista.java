package Vista;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class InsertarVista extends JFrame {

    public InsertarVista() {

        // Configuración de la ventana principal
        setTitle("Formulario de Registro de Nombres");
        setSize(800, 600); // Tamaño ajustado
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar solo esta ventana
        setLocationRelativeTo(null);

        // Cambiar color de fondo
        getContentPane().setBackground(new Color(245, 245, 220)); // Color beige claro

        // Configuración de layout principal
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        panelPrincipal.setOpaque(false);
        add(panelPrincipal);

        // Configuración de layout y restricciones
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Crear título estilizado
        JLabel titulo = new JLabel("REGISTRO DE USUARIOS");
        titulo.setFont(new Font("Roboto", Font.BOLD, 28));
        titulo.setForeground(new Color(105, 105, 105)); // Gris oscuro
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST; // Alinear a la izquierda
        panelPrincipal.add(titulo, gbc);

        // Crear etiquetas y campos de texto
        JLabel labelID = crearEtiqueta("ID de Usuario:");
        JTextField txtID = crearCampoTexto("Ingrese el ID del usuario.");

        JLabel labelPrimerNombre = crearEtiqueta("Primer Nombre:");
        JTextField txtPrimerNombre = crearCampoTexto("Ingrese su primer nombre.");

        JLabel labelSegundoNombre = crearEtiqueta("Segundo Nombre:");
        JTextField txtSegundoNombre = crearCampoTexto("Ingrese su segundo nombre (opcional).");

        JLabel labelPrimerApellido = crearEtiqueta("Primer Apellido:");
        JTextField txtPrimerApellido = crearCampoTexto("Ingrese su primer apellido.");

        JLabel labelSegundoApellido = crearEtiqueta("Segundo Apellido:");
        JTextField txtSegundoApellido = crearCampoTexto("Ingrese su segundo apellido (opcional).");

        // Posicionar etiquetas y campos de texto a la izquierda
        gbc.gridwidth = 1; // Restablecer gridwidth para otros componentes
        gbc.weightx = 1.0;

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(labelID, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelPrincipal.add(txtID, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panelPrincipal.add(labelPrimerNombre, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panelPrincipal.add(txtPrimerNombre, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panelPrincipal.add(labelSegundoNombre, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        panelPrincipal.add(txtSegundoNombre, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panelPrincipal.add(labelPrimerApellido, gbc);
        gbc.gridx = 0;
        gbc.gridy = 8;
        panelPrincipal.add(txtPrimerApellido, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        panelPrincipal.add(labelSegundoApellido, gbc);
        gbc.gridx = 0;
        gbc.gridy = 10;
        panelPrincipal.add(txtSegundoApellido, gbc);

        // Crear botones estilizados
        JButton btnInsertar = crearBoton("Insertar", "Haga clic para insertar los datos.", "imagen/insertar2.png",
                new Color(60, 179, 113), Color.WHITE); // Verde con texto blanco
        btnInsertar.addActionListener(e -> {
            // Acción para insertar los datos
            String mensaje = String.format(
                    "Datos ingresados:\nID: %s\nPrimer Nombre: %s\nSegundo Nombre: %s\nPrimer Apellido: %s\nSegundo Apellido: %s",
                    txtID.getText(),
                    txtPrimerNombre.getText(),
                    txtSegundoNombre.getText(),
                    txtPrimerApellido.getText(),
                    txtSegundoApellido.getText());
            JOptionPane.showMessageDialog(this, mensaje, "Datos Insertados", JOptionPane.INFORMATION_MESSAGE);
        });

        JButton btnRegresar = crearBoton("Regresar", "Regresa al menú principal.", "imagen/salir.png",
                new Color(30, 144, 255), Color.WHITE); // Azul con texto blanco
        btnRegresar.addActionListener(e -> {
            // Acción para regresar a la ventana principal
            this.dispose(); // Cierra esta ventana
            new GUI(); // Abre la ventana principal
        });

        // Posicionar botones a la derecha
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER; // Centrar en la columna derecha
        panelPrincipal.add(btnInsertar, gbc);

        gbc.gridy = 7;
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
