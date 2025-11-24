package vista;

import controladores.ControladorEstadisticas;
import controladores.ControladorResultado;
import controladores.ControladorRuleta;
import controladores.ControladorSesion;
import modelo.Resultado;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaHistorial {
    private final JFrame frame = new JFrame("Historial - 🎰Casino black cat🐈‍⬛");
    private final JLabel titulo = new JLabel("Historial de Partidas", SwingConstants.CENTER);
    private final JButton btnVolver = new JButton("Volver");

    private final JTextArea areaHistorial = new JTextArea();
    private final JScrollPane scrollPane = new JScrollPane(areaHistorial);

    private final ControladorResultado controladorResultado;
    private final ControladorSesion controladorSesion;
    private final ControladorRuleta controladorRuleta;
    private final ControladorEstadisticas controladorEstadisticas;

    public VentanaHistorial(ControladorResultado cr, ControladorSesion controladorSesion, ControladorRuleta controladorRuleta, ControladorEstadisticas ce) {
        this.controladorResultado = cr;
        this.controladorSesion = controladorSesion;
        this.controladorRuleta = controladorRuleta;
        this.controladorEstadisticas = ce;
        inicializarVentana();
        cargarHistorial();
    }

    private void inicializarVentana() {
        configurarFrame();
        agregarComponentes();
        configurarListeners();
    }

    private void configurarFrame() {
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10)); // 10px de espacio
        frame.setLocationRelativeTo(null);
        areaHistorial.setEditable(false);
        areaHistorial.setFont(new Font("Monospaced", Font.PLAIN, 12));
    }

    private void agregarComponentes() {
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(titulo, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        JPanel panelInferior = new JPanel();
        panelInferior.add(btnVolver);
        frame.add(panelInferior, BorderLayout.SOUTH);
    }

    private void configurarListeners(){
        btnVolver.addActionListener(e -> {
            frame.dispose();
            VentanaMenu menu = new VentanaMenu(controladorSesion, controladorRuleta, controladorEstadisticas);
            menu.mostrarVentana();
        });
    }


    private void cargarHistorial() {
        List<Resultado> historial = controladorResultado.obtenerHistorialUsuarioActual();
        if (historial.isEmpty()) {
            areaHistorial.setText("Aún no se han registrado jugadas.");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%-10s | %-10s | %-10s | %-10s\n", "Número", "Apuesta", "Monto", "Ganancia"));
            sb.append("--------------------------------------------------\n");
            for (Resultado r : historial) {
                sb.append(String.format("%-10d | %-10s | %-10d | %-10d\n",
                        r.getNumeroObtenido(),
                        r.getTipoApuesta(),
                        r.getMontoApostado(),
                        r.getGanancia()));
            }
            areaHistorial.setText(sb.toString());
        }
    }

    public void mostrarVentana() {frame.setVisible(true);}
}

