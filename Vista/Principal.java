package Vista;

import java.awt.Color;

public class Principal {

    public static void main(String[] args) {
       
        GUI interfaz = new GUI();
       
        //Configuracion de la ventana principal
        interfaz.setTitle("Menú Principal");
        interfaz.setSize(600, 400);
        interfaz.setBackground(Color.WHITE);
        interfaz.setResizable(false);
        interfaz.setVisible(true);
        interfaz.setLocationRelativeTo(null);
        
    }
    
}