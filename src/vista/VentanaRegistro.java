package vista;

import controladores.ControladorSesion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaRegistro {
    // --- Componentes de la UI ---
    private final JFrame frame = new JFrame("Registro - \uD83C\uDFB0Casino black cat\uD83D\uDC08\u200D⬛");
    private final JLabel titulo = new JLabel("Registro de Usuario");
    private final JLabel lbNombre = new JLabel("Nombre completo:");
    private final JTextField txtNombre = new JTextField();
    private final JLabel lbUsuario = new JLabel("Nombre de usuario:");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lbClave = new JLabel("Contraseña:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnRegister = new JButton("Registrarme");
    private final JButton btnVolver = new JButton("Volver");

    // --- Controlador ---
    private final ControladorSesion controladorSesion;

    // --- Constructor ---
    // ¡ESTA ES LA PARTE CLAVE! Este constructor coincide con la llamada desde VentanaLogin.
    public VentanaRegistro(ControladorSesion cs, JFrame ventanaPadre) {
        this.controladorSesion = cs;
        frame.setLocationRelativeTo(ventanaPadre); // Centra esta ventana sobre la de Login

        inicializarComponentes();
        configurarListeners();
    }

    // --- Métodos de Configuración ---
    private void inicializarComponentes() {
        configurarFrame();
        posicionarComponentes();
        agregarComponentesAlFrame();
    }

    private void configurarFrame() {
        frame.setSize(400, 450);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // DISPOSE_ON_CLOSE para no cerrar toda la app
        frame.setLayout(null);
    }

    private void posicionarComponentes() {
        titulo.setBounds(0, 20, 400, 30);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        lbNombre.setBounds(50, 80, 300, 25);
        txtNombre.setBounds(50, 105, 300, 30);
        lbUsuario.setBounds(50, 155, 300, 25);
        txtUsuario.setBounds(50, 180, 300, 30);
        lbClave.setBounds(50, 235, 300, 25);
        txtClave.setBounds(50, 260, 300, 30);

        btnRegister.setBounds(50, 320, 300, 40);
        btnVolver.setBounds(150, 370, 100, 25);
    }

    private void agregarComponentesAlFrame() {
        frame.add(titulo);
        frame.add(lbNombre);
        frame.add(txtNombre);
        frame.add(lbUsuario);
        frame.add(txtUsuario);
        frame.add(lbClave);
        frame.add(txtClave);
        frame.add(btnRegister);
        frame.add(btnVolver);
    }

    private void configurarListeners() {
        btnRegister.addActionListener(this::intentarRegistro);
        // El botón volver simplemente cierra esta ventana de registro.
        btnVolver.addActionListener(e -> frame.dispose());
    }

    // --- Métodos de Acción ---
    private void intentarRegistro(ActionEvent e) {
        try {
            // Llama al controlador para registrar al usuario
            controladorSesion.registrarUsuario(
                    txtNombre.getText(),
                    new String(txtClave.getPassword()),
                    txtUsuario.getText()
            );
            JOptionPane.showMessageDialog(frame, "¡Usuario registrado con éxito!", "Registro Completo", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose(); // Cierra la ventana de registro si fue exitoso
        } catch (IllegalArgumentException ex) {
            // Si el controlador lanza un error (ej: usuario ya existe), se muestra aquí.
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error de Registro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }
}