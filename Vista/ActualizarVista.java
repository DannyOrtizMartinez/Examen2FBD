package Vista;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ActualizarVista extends JFrame {

    public ActualizarVista() {

        // Configuración de la ventana principal
        setTitle("Formulario de Actualización de Usuarios");
        setSize(800, 600); // Tamaño ajustado
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar solo esta ventana
        setLocationRelativeTo(null);

        // Cambiar color de fondo
        getContentPane().setBackground(new Color(245, 245, 220)); // Beige claro

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

        // Crear etiquetas y campos de texto
        JLabel labelBuscar = crearEtiqueta("Buscar por ID:");
        JTextField txtBuscar = crearCampoTexto("Ingrese el ID del registro que desea actualizar.");
        JButton btnBuscar = crearBoton("Buscar", "Haga clic para buscar el registro.", "imagenes/lupa.png",
                new Color(100, 149, 237), Color.WHITE); // Azul claro

        // Crear etiquetas y campos para cada columna
        JLabel labelPrimerNombre = crearEtiqueta("Primer Nombre:");
        JTextField txtPrimerNombre = crearCampoTexto("Ingrese el nuevo primer nombre.");

        JLabel labelSegundoNombre = crearEtiqueta("Segundo Nombre:");
        JTextField txtSegundoNombre = crearCampoTexto("Ingrese el nuevo segundo nombre (opcional).");

        JLabel labelPrimerApellido = crearEtiqueta("Primer Apellido:");
        JTextField txtPrimerApellido = crearCampoTexto("Ingrese el nuevo primer apellido.");

        JLabel labelSegundoApellido = crearEtiqueta("Segundo Apellido:");
        JTextField txtSegundoApellido = crearCampoTexto("Ingrese el nuevo segundo apellido (opcional).");

        JLabel labelLogin = crearEtiqueta("Login:");
        JTextField txtLogin = crearCampoTexto("Ingrese el nuevo login de usuario.");

        JLabel labelClave = crearEtiqueta("Clave:");
        JTextField txtClave = crearCampoTexto("Ingrese la nueva clave de usuario.");

        JLabel labelFechaCreacion = crearEtiqueta("Fecha de Creación:");
        JTextField txtFechaCreacion = crearCampoTexto("Ingrese la nueva fecha en formato AAAA-MM-DD.");

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
                        "Datos actualizados:\nPrimer Nombre: %s\nSegundo Nombre: %s\nPrimer Apellido: %s\nSegundo Apellido: %s\nLogin: %s\nClave: %s\nFecha de Creación: %s",
                        txtPrimerNombre.getText(), txtSegundoNombre.getText(), txtPrimerApellido.getText(),
                        txtSegundoApellido.getText(), txtLogin.getText(), txtClave.getText(), txtFechaCreacion.getText());
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

        int fila = 2;
        for (JLabel etiqueta : new JLabel[]{labelPrimerNombre, labelSegundoNombre, labelPrimerApellido, labelSegundoApellido, labelLogin, labelClave, labelFechaCreacion}) {
            gbc.gridx = 0;
            gbc.gridy = fila++;
            panelPrincipal.add(etiqueta, gbc);
        }

        fila = 2;
        for (JTextField campo : new JTextField[]{txtPrimerNombre, txtSegundoNombre, txtPrimerApellido, txtSegundoApellido, txtLogin, txtClave, txtFechaCreacion}) {
            gbc.gridx = 1;
            gbc.gridy = fila++;
            panelPrincipal.add(campo, gbc);
        }

        gbc.gridx = 1;
        gbc.gridy = fila++;
        gbc.anchor = GridBagConstraints.CENTER;
        panelPrincipal.add(btnActualizar, gbc);

        gbc.gridy = fila++;
        panelPrincipal.add(btnRegresar, gbc);

        // Mostrar ventana
        setVisible(true);
    }

    private JLabel crearEtiqueta(String texto) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setForeground(new Color(105, 105, 105)); // Gris oscuro
        etiqueta.setFont(new Font("Arial", Font.BOLD, 14));
        return etiqueta;
    }

    private JTextField crearCampoTexto(String tooltip) {
        JTextField campoTexto = new JTextField(20);
        campoTexto.setToolTipText(tooltip);
        campoTexto.setFont(new Font("Arial", Font.PLAIN, 16));
        campoTexto.setPreferredSize(new Dimension(300, 30));
        return campoTexto;
    }

    private JButton crearBoton(String texto, String tooltip, String rutaIcono, Color colorFondo, Color colorTexto) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial", Font.BOLD, 12));
        boton.setFocusPainted(false);
        boton.setToolTipText(tooltip);
        boton.setBackground(colorFondo);
        boton.setForeground(colorTexto);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setPreferredSize(new Dimension(150, 30));

        if (new File(rutaIcono).exists()) {
            ImageIcon icono = new ImageIcon(rutaIcono);
            boton.setIcon(new ImageIcon(icono.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
            boton.setHorizontalTextPosition(SwingConstants.RIGHT);
        }

        return boton;
    }
}
