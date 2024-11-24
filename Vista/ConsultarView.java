package Vista;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ConsultarView extends JFrame {

    public ConsultarView() {

        // Configuración de la ventana principal
        setTitle("Formulario de Consulta");
        setSize(800, 600); // Tamaño ajustado
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar solo esta ventana
        setLocationRelativeTo(null);

        // Cambiar color de fondo
        getContentPane().setBackground(new Color(245, 245, 220)); // Color beige claro

        // Configuración del layout principal
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        panelPrincipal.setOpaque(false);
        add(panelPrincipal);

        // Configuración de layout y restricciones
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Crear título estilizado
        JLabel titulo = new JLabel("CONSULTA DE REGISTROS");
        titulo.setFont(new Font("Roboto", Font.BOLD, 28));
        titulo.setForeground(new Color(105, 105, 105)); // Gris oscuro
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.WEST; // Alinear a la izquierda
        panelPrincipal.add(titulo, gbc);

        // Crear etiqueta y campo de texto para buscar
        JLabel labelBuscar = crearEtiqueta("Buscar por ID:");
        JTextField txtBuscar = crearCampoTexto("Ingrese el ID del registro que desea consultar.");

        // Botón de búsqueda
        JButton btnBuscar = crearBoton("Buscar", "Haga clic para buscar el registro.", "imagenes/lupa.png",
                new Color(100, 149, 237), Color.WHITE); // Azul claro

        JTextArea areaResultados = new JTextArea(10, 30);
        areaResultados.setEditable(false);
        areaResultados.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollResultados = new JScrollPane(areaResultados);

        // Acción para el botón "Buscar"
        btnBuscar.addActionListener(e -> {
            String id = txtBuscar.getText();
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un ID para buscar.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                // Lógica para buscar datos
                areaResultados.setText("Resultado de la búsqueda para el ID: " + id + "\n\nSimulación de datos...");
            }
        });

        // Crear botón regresar
        JButton btnRegresar = crearBoton("Regresar", "Regresa al menú principal.", "imagenes/salir.png",
                new Color(255, 69, 0), Color.WHITE); // Naranja

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
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        panelPrincipal.add(scrollResultados, gbc);

        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
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