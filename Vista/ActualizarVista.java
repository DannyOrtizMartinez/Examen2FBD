package Vista;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ActualizarVista extends JFrame {

    public ActualizarVista() {

        // Configuración de la ventana principal
        setTitle("Formulario de Actualización de Nombres");
        setSize(800, 600); // Tamaño ajustado
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar solo esta ventana
        setLocationRelativeTo(null);

        // Cambiar color de fondo
        getContentPane().setBackground(new Color(245, 245, 220)); // beige claro

        // Configuración del layout principal
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        panelPrincipal.setOpaque(false);
        add(panelPrincipal);

        // Configuración de layout y restricciones
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Crear título estilizado
        JLabel titulo = new JLabel("ACTUALIZACIÓN DE USUARIOS");
        titulo.setFont(new Font("Roboto", Font.BOLD, 28));
        titulo.setForeground(new Color(105, 105, 105)); // Gris oscuro
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.WEST; // Alinear a la izquierda
        panelPrincipal.add(titulo, gbc);

        // Crea etiquetas y campos de texto
        JLabel labelBuscar = crearEtiqueta("Buscar por ID:");
        JTextField txtBuscar = crearCampoTexto("Ingrese el ID del registro que desea actualizar.");
        JButton btnBuscar = crearBoton("Buscar", "Haga clic para buscar el registro.", "imagenes/lupa.png",
                new Color(100, 149, 237), Color.WHITE); // Azul claro

        JLabel labelPrimerNombre = crearEtiqueta("Primer Nombre:");
        JTextField txtPrimerNombre = crearCampoTexto("Ingrese el nuevo primer nombre.");

        JLabel labelSegundoNombre = crearEtiqueta("Segundo Nombre:");
        JTextField txtSegundoNombre = crearCampoTexto("Ingrese el nuevo segundo nombre (opcional).");

        JLabel labelPrimerApellido = crearEtiqueta("Primer Apellido:");
        JTextField txtPrimerApellido = crearCampoTexto("Ingrese el nuevo primer apellido.");

        JLabel labelSegundoApellido = crearEtiqueta("Segundo Apellido:");
        JTextField txtSegundoApellido = crearCampoTexto("Ingrese el nuevo segundo apellido (opcional).");

        // Crear botón de actualización
        JButton btnActualizar = crearBoton("Actualizar", "Haga clic para actualizar los datos.", "imagenes/lapiz2.png",
                new Color(60, 179, 113), Color.WHITE); // Verde

        // Crear botón regresar
        JButton btnRegresar = crearBoton("Regresar", "Regresa al menú principal.", "imagenes/salir.png",
                new Color(255, 69, 0), Color.WHITE); // Naranja

        // Acción para el botón "Buscar"
        btnBuscar.addActionListener(e -> {
            String id = txtBuscar.getText();
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un ID para buscar.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                // Lógica para buscar datos
                JOptionPane.showMessageDialog(this, "Datos encontrados para ID: " + id, "Búsqueda exitosa",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Acción para el botón "Actualizar"
        btnActualizar.addActionListener(e -> {
            if (txtPrimerNombre.getText().isEmpty() || txtPrimerApellido.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Los campos de primer nombre y primer apellido son obligatorios.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Lógica de actualización
                String mensaje = String.format(
                        "Datos actualizados:\nPrimer Nombre: %s\nSegundo Nombre: %s\nPrimer Apellido: %s\nSegundo Apellido: %s",
                        txtPrimerNombre.getText(),
                        txtSegundoNombre.getText(),
                        txtPrimerApellido.getText(),
                        txtSegundoApellido.getText());
                JOptionPane.showMessageDialog(this, mensaje, "Actualización Exitosa", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Acción para el botón "Regresar"
        btnRegresar.addActionListener(e -> {
            this.dispose(); // Cierra esta ventana
            new CrudGUI(); // Abre la ventana principal
        });

        // Posicionar componentes
        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;
        panelPrincipal.add(labelBuscar, gbc);
        gbc.gridx = 1;
        panelPrincipal.add(txtBuscar, gbc);
        gbc.gridx = 2;
        panelPrincipal.add(btnBuscar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panelPrincipal.add(labelPrimerNombre, gbc);
        gbc.gridx = 1;
        panelPrincipal.add(txtPrimerNombre, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panelPrincipal.add(labelSegundoNombre, gbc);
        gbc.gridx = 1;
        panelPrincipal.add(txtSegundoNombre, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panelPrincipal.add(labelPrimerApellido, gbc);
        gbc.gridx = 1;
        panelPrincipal.add(txtPrimerApellido, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panelPrincipal.add(labelSegundoApellido, gbc);
        gbc.gridx = 1;
        panelPrincipal.add(txtSegundoApellido, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.CENTER;
        panelPrincipal.add(btnActualizar, gbc);

        gbc.gridy = 7;
        panelPrincipal.add(btnRegresar, gbc);

        // Mostrar ventana
        setVisible(true);
    }

    // Método para crear etiquetas
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