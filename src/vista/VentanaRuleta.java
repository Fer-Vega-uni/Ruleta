package vista;

import controladores.ControladorSesion;
import controladores.ControladorRuleta;
import modelo.Resultado;
import modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class VentanaRuleta {
    private static final JFrame frame = new JFrame("Ruleta - \uD83C\uDFB0Casino black cat\uD83D\uDC08\u200D⬛");
    private final JLabel titulo = new JLabel("Ruleta", SwingConstants.CENTER);
    private final JButton btnVolver = new JButton("Volver");
    private final JButton btnComenzar = new JButton("Comenzar Juego");
    private final JLabel lblTipoApuesta = new JLabel("Tipo de apuesta:");
    private final JComboBox<String> cmbTipoApuesta = new JComboBox<>(new String[]{"Rojo", "Negro", "Par", "Impar"});
    private final JLabel lblMontoApuesta = new JLabel("Monto a apostar:");
    private static final JTextField txtMontoApuesta = new JTextField();
    private final JLabel lblResultado = new JLabel("", SwingConstants.CENTER);


    private final Color colorRojo = new Color(220, 20, 60);
    private final Color colorNegro = new Color(0, 0, 0);
    private final Color colorVerde = new Color(50, 205, 50);
    private final Color colorFondo = new Color(240, 240, 240);

    private final ControladorSesion controladorSesion;
    private final ControladorRuleta controladorRuleta;

    public VentanaRuleta(ControladorSesion cs, ControladorRuleta rc){
        this.controladorSesion = cs;
        this.controladorRuleta = rc;
        inicializarVentana();
        actualizarSaldoLabel();
        btnComenzar.addActionListener(e -> jugar());
        btnVolver.addActionListener(e -> volverAlMenu());
    }
    private void inicializarVentana(){
        setFrame();
        setBounds();
        setOnFrame();
        setStyles();
        addListeners();
        mostrarVentana();
    }

    private void jugar() {
        Usuario jugador = controladorSesion.getUsuarioActual();
        try {
            int monto = Integer.parseInt(txtMontoApuesta.getText());
            String tipoApuesta = cmbTipoApuesta.getSelectedItem().toString();
            Resultado resultado = controladorRuleta.realizarApuesta(monto, tipoApuesta, jugador);
            lblResultado.setText(resultado.toString());
            actualizarSaldoLabel();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Por favor, ingrese un monto válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error en la Apuesta", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarSaldoLabel() {
        lblSaldo.setText("Saldo: $" + controladorSesion.getUsuarioActual().getSaldo());
    }

    private void setFrame() {
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(colorFondo);
    }

    public void setBounds() {
        titulo.setBounds(300, 30, 200, 40);
        lblTipoApuesta.setBounds(200, 100, 150, 25);
        cmbTipoApuesta.setBounds(350, 100, 200, 30);
        lblMontoApuesta.setBounds(200, 150, 150, 25);
        txtMontoApuesta.setBounds(350, 150, 200, 30);
        btnComenzar.setBounds(300, 200, 200, 40);
        lblResultado.setBounds(200, 260, 400, 40);
        btnVolver.setBounds(420, 320, 150, 40);
    }

    public void setOnFrame(){
        frame.add(titulo);
        frame.add(lblTipoApuesta);
        frame.add(cmbTipoApuesta);
        frame.add(lblMontoApuesta);
        frame.add(txtMontoApuesta);
        frame.add(btnComenzar);
        frame.add(lblResultado);
        frame.add(btnVolver);
    }

    public void setStyles() {
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblResultado.setFont(new Font("Arial", Font.BOLD, 16));
        btnComenzar.setBackground(colorVerde);
        btnComenzar.setForeground(Color.WHITE);
        btnVolver.setBackground(new Color(220, 20, 60));
        btnVolver.setForeground(Color.WHITE);
        btnComenzar.setFont(new Font("Arial", Font.BOLD, 14));
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 12));
    }

    public void addListeners() {
        btnComenzar.addActionListener(e -> {
            Ruleta.iniciarRonda(leerMontoApuesta(), getTipoApuesta());});
        btnVolver.addActionListener(e -> volverAlMenu());
    }

    public String getTipoApuesta(){
        return Objects.requireNonNull(cmbTipoApuesta.getSelectedItem()).toString().toUpperCase();
    }

    public static int leerMontoApuesta() {
        try {
            int valor = Integer.parseInt(txtMontoApuesta.getText().trim());
            if (valor <= 0) {
                JOptionPane.showMessageDialog(frame, "El monto debe ser mayor a 0", "Error", JOptionPane.ERROR_MESSAGE);
                return 0;
            } else {
                return valor;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "El monto debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }


    private void volverAlMenu() {
        frame.dispose();
        JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
    }

    public void mostrarVentana(){
        frame.setVisible(true);
    }

}
