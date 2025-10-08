package vista;

import controladores.ControladorResultado;
import controladores.ControladorRuleta;
import controladores.ControladorSesion;
import modelo.Usuario;
import javax.swing.*;
import java.awt.*;

public class VentanaMenu {

    private final ControladorSesion controladorSesion;
    private final ControladorRuleta controladorRuleta;


    private final JFrame frame            = new JFrame("Inicio - \uD83C\uDFB0Casino black cat\uD83D\uDC08\u200D⬛");
    private final JLabel titulo           = new JLabel("Aquí puedes escoger a qué juego ir");
    private final JLabel lblBienvenida    = new JLabel();
    private final JLabel lblSaldo         = new JLabel();
    private final JButton btnRuleta          = new JButton("Ruleta");
    private final JButton btnTragamonedas    = new JButton("Próximamente");
    private final JButton btnJuego3          = new JButton("Próximamente");
    private final JButton btnJuego4          = new JButton("Próximamente");
    private final JButton btnLogout          = new JButton("Cerrar sesión");
    private final JButton btnHistorial       = new JButton("Historial");

    private final JDialog proximamente       = new JDialog(frame, "Aviso", true); // Es mejor hacerlo modal
    private final JLabel lblProximamente     = new JLabel("Juego en construcción", SwingConstants.CENTER);
    private final JButton closeButtonProx = new JButton("Cerrar");

    public VentanaMenu(ControladorSesion cs, ControladorRuleta rc) {
        this.controladorSesion = cs;
        this.controladorRuleta = rc;
        inicializarVentana();
    }

    private void inicializarVentana() {
        configurarFrame();
        posicionarComponentes();
        agregarComponentesAlFrame();
        configurarListeners();
        actualizarInfoUsuario();
    }

    private void configurarFrame() {
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        // Configuración del diálogo
        proximamente.setSize(300, 150);
        proximamente.setLayout(new BorderLayout());
        proximamente.setLocationRelativeTo(frame);
    }

    private void posicionarComponentes(){
        lblBienvenida.setBounds(50, 20, 300, 25);
        lblSaldo.setBounds(50, 50, 300, 25);
        lblBienvenida.setFont(new Font("Arial", Font.BOLD, 16));
        lblSaldo.setFont(new Font("Arial", Font.PLAIN, 14));

        titulo.setBounds(275, 100, 300, 25);
        btnRuleta.setBounds(150, 200, 200, 50);
        btnTragamonedas.setBounds(450, 200, 200, 50);
        btnJuego3.setBounds(150, 300, 200, 50);
        btnJuego4.setBounds(450, 300, 200, 50);
        btnHistorial.setBounds(150, 450, 200, 40);
        btnLogout.setBounds(450, 450, 200, 40);
    }

    private void agregarComponentesAlFrame(){
        frame.add(lblBienvenida);
        frame.add(lblSaldo);
        frame.add(titulo);
        frame.add(btnRuleta);
        frame.add(btnTragamonedas);
        frame.add(btnJuego3);
        frame.add(btnJuego4);
        frame.add(btnHistorial);
        frame.add(btnLogout);

        proximamente.add(lblProximamente, BorderLayout.CENTER);
        proximamente.add(closeButtonProx, BorderLayout.SOUTH);
    }

    private void configurarListeners(){
        btnRuleta.addActionListener(e -> abrirRuleta());
        btnTragamonedas.addActionListener(e -> mostrarProximamente());
        btnJuego3.addActionListener(e -> mostrarProximamente());
        btnJuego4.addActionListener(e -> mostrarProximamente());
        btnHistorial.addActionListener(e-> abrirHistorial());
        btnLogout.addActionListener(e -> cerrarSesion());
        closeButtonProx.addActionListener(e -> proximamente.dispose());
    }

    private void actualizarInfoUsuario() {
        Usuario usuario = controladorSesion.getUsuarioActual();
        if (usuario != null) {
            lblBienvenida.setText("Bienvenido, " + usuario.getNombre());
            lblSaldo.setText("Saldo actual: $" + usuario.getSaldo());
        }
    }

    private void abrirRuleta() {
        frame.dispose();
        VentanaRuleta vr = new VentanaRuleta(controladorSesion, controladorRuleta);
        vr.mostrarVentana();
    }

    private void cerrarSesion() {
        controladorSesion.cerrarSesion();
        frame.dispose();
        VentanaLogin login = new VentanaLogin(controladorSesion, controladorRuleta);
        login.mostrarVentana();
    }

    private void abrirHistorial(){
        ControladorResultado cr = new ControladorResultado(controladorSesion);
        VentanaHistorial vh = new VentanaHistorial(cr, controladorSesion, controladorRuleta);
        vh.mostrarVentana();
        frame.dispose();
    }

    private void mostrarProximamente(){
        proximamente.setVisible(true);
    }

    public void mostrarVentana() {frame.setVisible(true);}

}