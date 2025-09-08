import javax.swing.*;
import java.awt.event.*;
public class VentanaSaludo {
    //creamos los componentes
    public static JFrame ventana = new JFrame ( "App de Saludo - ICC490" );
    public static JLabel titulo = new JLabel("Escribe tu nombre para recibir un saludo");
    public static JTextField campoTexto = new JTextField ();
    public static JButton botonSaludar = new JButton ( " Saludar " );
    public static JLabel etiquetaSaludo = new JLabel ( " " );
    public static JButton botonBorrar = new JButton("Borrar");

    public VentanaSaludo(){
        //iniciamos los metodos
        configVentana();
        configComponentes();
        addComponentes();
        saludar();
        borrar();
        show();
        eventoEnter();
    }

    public static void main(String[] args) {
        //creamos la ventana y la llamamos para que se inicialize
        new VentanaSaludo();
    }

    public void configVentana(){
        //autoexplicativo, el nombre lo dice, aquí configuramos la ventana
        ventana.setSize (400 , 400);
        ventana.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        ventana.setLocationRelativeTo ( null ) ;
        ventana.setLayout ( null );
    }

    public void configComponentes(){
        //lo mismo que arriba, solo que acá ponemos las ubicaciones y tamaños de los componentes
        titulo.setBounds(75, 20,300,25);
        campoTexto.setBounds (50 , 50 , 200 , 25);
        botonSaludar.setBounds (270 , 50 , 100 , 25);
        etiquetaSaludo.setBounds (50 , 80 , 300 , 25);
        botonBorrar.setBounds (50, 120,200,25);
    }

    public void addComponentes() {
        //añadimos los componentes a la pantalla en sus posiciones antes definidas
        ventana . add ( titulo );
        ventana . add ( campoTexto ) ;
        ventana . add ( botonSaludar ) ;
        ventana . add ( etiquetaSaludo ) ;
        ventana . add ( botonBorrar ) ;
    }

    public void saludar(){
        /*tomamos el valor del campo de texto al presionar el botón, en base a eso si la validación devuelve verdadero,
         saludamos cambiando el texto de la etiqueta que iniciamos vacía, si no enviamos un mensaje mediante la misma etiqueta */
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
        //esta función borra el contenido del campo de texto y vuelve a poner la etiqueta vacía para que no quede en pantalla el resultado
        botonBorrar.addActionListener(e -> {
            etiquetaSaludo.setText(" ");
            campoTexto.setText("");
        });
    }

    public void show(){
        //muestra la ventana
        ventana . setVisible ( true ) ;
    }

    public boolean validar(String s){
        //evalúa si el String dado está vacio o no
        return !s.trim().isEmpty();
    }
    public void eventoEnter(){
        //nos permite 'hacer click' en el botón saludar al presionar enter
    campoTexto . addKeyListener ( new KeyAdapter () {
        public void keyPressed ( KeyEvent e ) {
            if ( e . getKeyCode () == KeyEvent . VK_ENTER ) {
                botonSaludar . doClick () ;
            }
        }
    });}
}
