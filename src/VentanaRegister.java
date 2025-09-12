import javax.swing.*;

public class VentanaRegister {

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

    private static void run() {
        VentanaRegister ventana = new VentanaRegister();
        ventana.mostrarVentana();
    }

    public void mostrarVentana(){
        frame.setVisible(true);
    }

    public VentanaRegister() {
        setFrame();
        setBounds();
        setOnFrame();
        register();
        volver();
    }

    public void register(){
        btnRegister.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            String username = txtUsuario.getText().trim();
            String password = new String(txtClave.getPassword()).trim();
            if(validarCampos(nombre,username,password)&&verificarUnicidad(username)) {
                crearUser(username,password,nombre);
                result.setText("Registro exitoso! Redirigiendo...");
                timerVolver(2000);
            }
        });
    }

    public boolean validarCampos(String n, String u, String c){
        if (n.isEmpty()||u.isEmpty()||c.isEmpty()){
            result.setText("Los campos no pueden estar vacíos");
            return false;
        } else{
            return true;
        }
    }

    public boolean verificarUnicidad(String u){
        for (Usuario usuario : VentanaLogin.USUARIOS) {
            if (usuario.getUsername().equals(u)) {
                result.setText("El usuario ya existe");
                return false;
            }
        }
        return true;
    }

    public void volver(){
        btnVolver.addActionListener(e -> {timerVolver(300);});
    }

    public void timerVolver(int delay){
        Timer timer = new Timer(delay, evt -> {
            frame.dispose();
        });
        timer.setRepeats(false);
        timer.start();
    }

    public void crearUser(String username, String password, String nombre){
        Usuario nuevoUsuario = new Usuario(username, password, nombre);
        VentanaLogin.USUARIOS.add(nuevoUsuario);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VentanaRegister::run);
    }

}