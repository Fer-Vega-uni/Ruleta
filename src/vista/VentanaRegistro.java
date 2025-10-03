package vista;


import controladores.ControladorSesion;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class VentanaRegistro {

    private final JFrame frame            = new JFrame("Register - \uD83C\uDFB0Casino black cat\uD83D\uDC08\u200D⬛");
    private final JLabel titulo           = new JLabel("Registro");
    private final JLabel lbNombre         = new JLabel("Ingrese su nombre");
    private final JTextField  txtNombre   = new JTextField();
    private final JLabel lbUsuario        = new JLabel("Cree su usuario:");
    private final JTextField txtUsuario   = new JTextField();
    private final JLabel lbClave          = new JLabel("Cree su contraseña:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnRegister     = new JButton("Registro");
    private final JButton btnVolver       = new JButton("VOLVER");
    private final JLabel result                 = new JLabel("");

    private final ControladorSesion controladorSesion;

    public void setFrame() {
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
    }

    public void setBounds() {
        btnVolver.setBounds(0,0,100,30);
        titulo.setBounds(275, 50, 300,25);
        lbNombre.setBounds(240, 85, 300, 25);
        txtNombre.setBounds(150, 110,300,25);
        lbUsuario.setBounds(250, 145,300,25);
        txtUsuario.setBounds(150,170,300,25);
        lbClave.setBounds(240, 205,300,25);
        txtClave.setBounds(150, 230,300,25);
        btnRegister.setBounds(200, 255, 200,30);
        result.setBounds(200, 300,300,25);
    }

    public void setOnFrame(){
        frame.add(btnVolver);
        frame.add(titulo);
        frame.add(lbNombre);
        frame.add(txtNombre);
        frame.add(lbUsuario);
        frame.add(txtUsuario);
        frame.add(lbClave);
        frame.add(txtClave);
        frame.add(btnRegister);
        frame.add(result);
    }


    private void mostrarVentana(){
        frame.setVisible(true);
    }

    public VentanaRegistro(ControladorSesion cs, JFrame ventanaPadre) {
        this.controladorSesion = cs;
        inicializarComponentes();
        agregarListeners();
    }

    private void inicializarComponentes(){
        setFrame();
        setBounds();
        setOnFrame();
        mostrarVentana();
    }

    private void agregarListeners(){
        btnRegister.addActionListener(this::intentarRegistro);
        btnVolver.addActionListener(e -> frame.dispose());
    }

    private void intentarRegistro(ActionEvent e) {
        try {
            controladorSesion.registrarUsuario(
                    txtNombre.getText(),
                    new String(txtClave.getPassword()),
                    txtUsuario.getText()
            );
            JOptionPane.showMessageDialog(frame, "Usuario registrado con éxito.", "Registro Completo", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error de Registro", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void volver(){
        btnVolver.addActionListener(e -> {timerVolver();});
    }

    private void timerVolver(){
        Timer timer = new Timer(300, evt -> {
            frame.dispose();
        });
        timer.setRepeats(false);
        timer.start();
    }

}