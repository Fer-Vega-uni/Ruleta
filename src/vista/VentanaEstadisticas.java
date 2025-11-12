package vista;
import controladores.ControladorEstadisticas;
import controladores.ControladorRuleta;
import controladores.ControladorSesion;
import javax.swing.*;
import java.awt.*;

public class VentanaEstadisticas {
    private final JFrame frame = new JFrame("Estadísticas Globales - 🎰Casino black cat🐈‍⬛");
    private final JLabel titulo = new JLabel("Estadísticas Globales", SwingConstants.CENTER);
    private final JButton btnVolver = new JButton("Volver");
    private final JTextArea areaEstadisticas = new JTextArea();
    private final JScrollPane scrollPane = new JScrollPane(areaEstadisticas);

    private final ControladorEstadisticas controladorEstadisticas;
    private final ControladorSesion controladorSesion;
    private final ControladorRuleta controladorRuleta;

    public VentanaEstadisticas(ControladorEstadisticas ce, ControladorSesion cs, ControladorRuleta cr) {
        this.controladorEstadisticas = ce;
        this.controladorSesion = cs;
        this.controladorRuleta = cr;

        inicializarVentana();
        cargarEstadisticas();
    }
    private void inicializarVentana() {
        configurarFrame();
        agregarComponentes();
        configurarListeners();
    }

    private void configurarFrame() {
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));
        frame.setLocationRelativeTo(null);
    }

    private void agregarComponentes() {
        areaEstadisticas.setFont(new Font("Monospaced", Font.PLAIN, 14));
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(titulo, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        JPanel panelInferior = new JPanel();
        panelInferior.add(btnVolver);
        frame.add(panelInferior, BorderLayout.SOUTH);
    }

    private void configurarListeners() {
        btnVolver.addActionListener(e -> {
            frame.dispose();
            VentanaMenu menu = new VentanaMenu(controladorSesion, controladorRuleta, controladorEstadisticas);
            menu.mostrarVentana();
        });
    }

    private void cargarEstadisticas() {
        String datos = controladorEstadisticas.obtenerEstadisticasF();
        areaEstadisticas.setText(datos);
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }

}
