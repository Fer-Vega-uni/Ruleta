import javax.swing.*;
import java.awt.event.*;
public class VentanaSaludo {
    public static void main(String[] args) {
        JFrame ventana = new JFrame ( "App de Saludo - ICC490" );
        ventana.setSize (400 , 400);
        ventana.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        ventana.setLayout ( null );
        JLabel titulo = new JLabel("Escribe tu nombre para recibir un saludo");
        titulo.setBounds(75, 20,300,25);
        JTextField campoTexto = new JTextField ();
        campoTexto.setBounds (50 , 50 , 200 , 25);
        JButton botonSaludar = new JButton ( " Saludar " );
        botonSaludar.setBounds (270 , 50 , 100 , 25);
        JLabel etiquetaSaludo = new JLabel ( " " );
        etiquetaSaludo.setBounds (50 , 80 , 300 , 25);
        botonSaludar.addActionListener ( e -> {
            String nombre = campoTexto.getText();
            etiquetaSaludo.setText ("Hola " + nombre + "! ! !") ;
        }) ;
        ventana . add ( titulo );
        ventana . add ( campoTexto ) ;
        ventana . add ( botonSaludar ) ;
        ventana . add ( etiquetaSaludo ) ;
        ventana . setLocationRelativeTo ( null ) ;
        ventana . setVisible ( true ) ;
    }
}
