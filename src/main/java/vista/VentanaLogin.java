package vista;


import controladores.ControladorEstadisticas;
import controladores.ControladorSesion;
import controladores.ControladorRuleta;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class VentanaLogin {

    private final JFrame frame            = new JFrame("Login - 🎰Casino black cat🐈‍⬛");
    private final JLabel titulo           = new JLabel("Inicio de sesión");
    private final JLabel lbUsuario        = new JLabel("Ingrese su usuario:");
    private final JTextField txtUsuario   = new JTextField();
    private final JLabel lbClave          = new JLabel("Ingrese su contraseña:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar     = new JButton("Ingresar");
    private JLabel result                 = new JLabel("");
    private final JLabel lbRegister       = new JLabel("¿No tienes cuenta?");
    private final JButton btnRegister     = new JButton("Registrate aquí");

    private final ControladorSesion controladorSesion;
    private final ControladorRuleta controladorRuleta;
    private final ControladorEstadisticas controladorEstadisticas;
    //armando, se vienen cositas....


    //menti, se alejan cositas
    public VentanaLogin(ControladorSesion cs, ControladorRuleta rc, ControladorEstadisticas ce) {
        this.controladorSesion = cs;
        this.controladorRuleta = rc;
        this.controladorEstadisticas = ce;
        inicializarComponentes();
        configurarListeners();
    }

    private void inicializarComponentes(){
        setFrame();
        setBounds();
        setOnFrame();
        mostrarVentana();
    }

    private void configurarListeners() {
        btnIngresar.addActionListener(this::intentarLogin);
        btnRegister.addActionListener(e -> abrirVentanaRegistro());
    }

    private void intentarLogin(ActionEvent e) {
        String user = txtUsuario.getText();
        String password = new String(txtClave.getPassword());
        boolean loginExitoso = controladorSesion.iniciarSesion(user, password);

        if (loginExitoso) {
            JOptionPane.showMessageDialog(frame, "¡Bienvenido!");
            frame.dispose();
            VentanaMenu menu = new VentanaMenu(controladorSesion, controladorRuleta, controladorEstadisticas);
            menu.mostrarVentana();
        } else {
            JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void abrirVentanaRegistro() {
        VentanaRegistro vr = new VentanaRegistro(controladorSesion, frame); // Le pasamos el controlador
        vr.mostrarVentana();
    }


    public void setFrame() {
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
    }
    public void setBounds() {
        titulo.setBounds(350, 120, 200, 25);
        lbUsuario.setBounds(250, 155, 300, 25);
        txtUsuario.setBounds(250, 190, 300, 25);
        lbClave.setBounds(250, 235, 300, 25);
        txtClave.setBounds(250, 270, 300, 25);
        btnIngresar.setBounds(300, 310, 200, 30);
        result.setBounds(300, 430, 300, 25);
        lbRegister.setBounds(345, 475, 200,25);
        btnRegister.setBounds(300, 500,200,25);
    }
    public void setOnFrame(){
        frame.add(titulo);
        frame.add(lbUsuario);
        frame.add(txtUsuario);
        frame.add(txtClave);
        frame.add(lbClave);
        frame.add(btnIngresar);
        frame.add(result);
        frame.add(lbRegister);
        frame.add(btnRegister);
    }


    public void mostrarVentana(){frame.setVisible(true);}
}



