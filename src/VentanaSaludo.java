import javax.swing.*;
import java.awt.event.*;
public class VentanaSaludo {
    public static JFrame ventana = new JFrame ( "App de Saludo - ICC490" );
    public static JLabel titulo = new JLabel("Escribe tu nombre para recibir un saludo");
    public static JTextField campoTexto = new JTextField ();
    public static JButton botonSaludar = new JButton ( " Saludar " );
    public static JLabel etiquetaSaludo = new JLabel ( " " );
    public static JButton botonBorrar = new JButton("Borrar");

    public VentanaSaludo(){
        configVentana();
        configComponentes();
        addComponentes();
        saludar();
        borrar();
        show();
    }

    public static void main(String[] args) {
        new VentanaSaludo();
    }

    public void configVentana(){
        ventana.setSize (400 , 400);
        ventana.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        ventana.setLocationRelativeTo ( null ) ;
        ventana.setLayout ( null );
    }

    public void configComponentes(){
        titulo.setBounds(75, 20,300,25);
        campoTexto.setBounds (50 , 50 , 200 , 25);
        botonSaludar.setBounds (270 , 50 , 100 , 25);
        etiquetaSaludo.setBounds (50 , 80 , 300 , 25);
        botonBorrar.setBounds (50, 120,200,25);
    }

    public void addComponentes() {
        ventana . add ( titulo );
        ventana . add ( campoTexto ) ;
        ventana . add ( botonSaludar ) ;
        ventana . add ( etiquetaSaludo ) ;
        ventana . add ( botonBorrar ) ;
    }

    public void saludar(){
        botonSaludar.addActionListener ( e -> {
            String nombre = campoTexto.getText();
            if (validar(nombre)){
                etiquetaSaludo.setText ("Hola " + nombre + "! ! !") ;
            } else {
                etiquetaSaludo.setText ("No es posible saludar sin un nombre :(") ;
            }
        });
    }

    public void borrar(){
        botonBorrar.addActionListener(e -> {
            etiquetaSaludo.setText(" ");
            campoTexto.setText("");
        });
    }

    public void show(){
        ventana . setVisible ( true ) ;
    }

    public boolean validar(String s){
        return !s.isEmpty();
    }
}
