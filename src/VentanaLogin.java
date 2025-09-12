import javax.swing.*;
import java.util.ArrayList;

public class VentanaLogin {
    public static final ArrayList<Usuario> USUARIOS = new ArrayList<>();

//UI
    private final JFrame frame            = new JFrame("Login - \uD83C\uDFB0Casino black cat\uD83D\uDC08\u200D⬛");
    private final JLabel titulo           = new JLabel("Inicio de sesión");
    private final JLabel lbUsuario        = new JLabel("Ingrese su usuario:");
    private final JTextField txtUsuario   = new JTextField();
    private final JLabel lbClave          = new JLabel("Ingrese su contraseña:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar     = new JButton("Ingresar");
    private JLabel result                 = new JLabel("");
    private final JLabel lbRegister       = new JLabel("¿No tienes cuenta?");
    private final JButton btnRegister     = new JButton("Registrate aquí");
    //armando, se vienen cositas....


    //menti, se alejan cositas
    public VentanaLogin() {
        setFrame();
        setBounds();
        setOnFrame();
        login();
        register();
    }

    private static void run() {
        VentanaLogin ventana = new VentanaLogin();
        ventana.mostrarVentana();
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


    public void mostrarVentana(){
        frame.setVisible(true);
    }

    private void login(){
        btnIngresar.addActionListener(e -> {
            String u = txtUsuario.getText();
            String p = new String(txtClave.getPassword());
            boolean res = Usuario.validarCredenciales(u,p);
            if (res){
                result.setText("Inicio de sesión incorrecto");
            } else {
                result.setText("Inicio de sesión exitoso");
                JOptionPane.showMessageDialog(null, "¡Bienvenid@ " + res + "!");
            }
        });
    }


    private void register(){
        btnRegister.addActionListener(e -> {
            VentanaRegister.main(new String[]{});
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VentanaLogin::run);
    }


}



