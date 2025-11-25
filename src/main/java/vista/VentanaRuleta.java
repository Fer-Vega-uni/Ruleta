package vista;

import controladores.ControladorEstadisticas;
import controladores.ControladorRuleta;
import controladores.ControladorSesion;
import modelo.Resultado;
import modelo.Usuario;
import javax.swing.*;
import java.awt.*;

public class VentanaRuleta {
    private final JFrame frame = new JFrame("Ruleta - 🎰Casino black cat🐈‍⬛");
    private final JLabel titulo = new JLabel("Ruleta", SwingConstants.CENTER);
    private final JButton btnVolver = new JButton("Volver");
    private final JButton btnComenzar = new JButton("Jugar");
    private final JLabel lblTipoApuesta = new JLabel("Tipo de apuesta:");
    private final JComboBox<String> cmbTipoApuesta = new JComboBox<String>(new String[]{"ROJO", "NEGRO", "PAR", "IMPAR"});
    private final JLabel lblMontoApuesta = new JLabel("Monto a apostar:");
    private final JTextField txtMontoApuesta = new JTextField();
    private final JLabel lblResultado = new JLabel("¡Haga su apuesta!", SwingConstants.CENTER);
    private final JLabel lblSaldo = new JLabel("Saldo: $0");

    private final ControladorSesion controladorSesion;
    private final ControladorRuleta controladorRuleta;
    private final ControladorEstadisticas controladorEstadisticas;

    public VentanaRuleta(ControladorSesion cs, ControladorRuleta rc, ControladorEstadisticas controladorEstadisticas) {
        this.controladorSesion = cs;
        this.controladorRuleta = rc;
        this.controladorEstadisticas = controladorEstadisticas;
        inicializarVentana();
    }

    // --- Métodos de Configuración ---
    private void inicializarVentana() {
        configurarFrame();
        posicionarComponentes();
        agregarComponentesAlFrame();
        configurarEstilos();
        configurarListeners();
        actualizarSaldoLabel();
    }

    private void configurarFrame() {
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(240, 240, 240));
    }

    private void posicionarComponentes() {
        titulo.setBounds(300, 30, 200, 40);
        lblSaldo.setBounds(550, 40, 200, 30); // Posición para el saldo
        lblTipoApuesta.setBounds(200, 100, 150, 25);
        cmbTipoApuesta.setBounds(350, 100, 200, 30);
        lblMontoApuesta.setBounds(200, 150, 150, 25);
        txtMontoApuesta.setBounds(350, 150, 200, 30);
        btnComenzar.setBounds(300, 220, 200, 40);
        lblResultado.setBounds(200, 280, 400, 40);
        btnVolver.setBounds(325, 350, 150, 40);
    }

    private void agregarComponentesAlFrame() {
        frame.add(titulo);
        frame.add(lblSaldo); // Se añade el label del saldo al frame.
        frame.add(lblTipoApuesta);
        frame.add(cmbTipoApuesta);
        frame.add(lblMontoApuesta);
        frame.add(txtMontoApuesta);
        frame.add(btnComenzar);
        frame.add(lblResultado);
        frame.add(btnVolver);
    }

    private void configurarEstilos() {
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblSaldo.setFont(new Font("Arial", Font.BOLD, 16));
        lblResultado.setFont(new Font("Arial", Font.BOLD, 16));
        btnComenzar.setBackground(new Color(50, 205, 50));
        btnComenzar.setForeground(Color.WHITE);
        btnVolver.setBackground(new Color(220, 20, 60));
        btnVolver.setForeground(Color.WHITE);
    }

    private void configurarListeners() {
        btnComenzar.addActionListener(e -> jugar());
        btnVolver.addActionListener(e -> volverAlMenu());
    }

    private void jugar() {
        Usuario jugador = controladorSesion.getUsuarioActual();
        try {
            int monto = Integer.parseInt(txtMontoApuesta.getText());
            String tipoSeleccionado = (String) cmbTipoApuesta.getSelectedItem();
            Resultado resultado = controladorRuleta.realizarApuesta(monto, tipoSeleccionado);
            lblResultado.setText(resultado.toString());
            actualizarSaldoLabel();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Por favor, ingrese un monto válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalStateException ex){
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Saldo Insuficiente", JOptionPane.WARNING_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Datos Inválidos", JOptionPane.WARNING_MESSAGE);
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error en la Apuesta", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarSaldoLabel() {
        lblSaldo.setText("Saldo: $" + controladorSesion.getUsuarioActual().getSaldo());
    }

    private void volverAlMenu() {
        frame.dispose();
        VentanaMenu menu = new VentanaMenu(controladorSesion, controladorRuleta, controladorEstadisticas);
        menu.mostrarVentana();
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }
}