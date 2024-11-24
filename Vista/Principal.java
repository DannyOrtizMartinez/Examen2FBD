package Vista;

import java.awt.Color;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Principal {

    public static void main(String[] args) {
       
        GUI interfaz = new GUI();
       
        //Configuracion de la ventana principal
        interfaz.setTitle("Menú Principal");
        interfaz.setSize(800, 600);
        interfaz.setBackground(Color.WHITE);
        interfaz.setResizable(false);
        interfaz.setVisible(true);
        interfaz.setLocationRelativeTo(null);
        interfaz.setDefaultCloseOperation(EXIT_ON_CLOSE); 
         
    }
}