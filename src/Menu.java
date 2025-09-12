import javax.swing.*;
import java.awt.*;

public class Menu {
    private final JFrame frame            = new JFrame("Inicio - \uD83C\uDFB0Casino black cat\uD83D\uDC08\u200D⬛");
    private final JLabel titulo           = new JLabel("Aquí puedes escoger a qué juego ir");
    private final JButton btnRuleta          = new JButton("Ruleta");
    private final JButton btnTragamonedas    = new JButton("Proximamente");
    private final JButton btnJuego3          = new JButton("Proximamente");
    private final JButton btnJuego4          = new JButton("Proximamente");
    private final JDialog proximamente       = new JDialog();
    private final JLabel lblProximamente     = new JLabel("Juego en construcción");
    private final JButton closeButtonProx = new JButton("Cerrar");

    public Menu(){
        setFrame();
        setbounds();
        addToFrame();
        addListeners();
    }

    public void setFrame() {
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        proximamente.setSize(500, 400);
        proximamente.setLayout(new BorderLayout());
        proximamente.setLocationRelativeTo(frame);
    }

    public void setbounds(){
        titulo.setBounds(400,100, 300, 25);
        btnRuleta.setBounds(300, 300, 150, 30);
        btnTragamonedas.setBounds(500, 300, 150, 30);
        btnJuego3.setBounds(300, 500, 150,30);
        btnJuego4.setBounds(500,500,150,30);
        lblProximamente.setBounds(200,100,200,50);
        closeButtonProx.setBounds(100,100 ,200,20);
    }

    public void addToFrame(){
        frame.add(titulo);
        frame.add(btnRuleta);
        frame.add(btnTragamonedas);
        frame.add(btnJuego3);
        frame.add(btnJuego4);
        proximamente.add(lblProximamente);
        proximamente.add(closeButtonProx);
    }

    public void addListeners(){
        btnRuleta.addActionListener(e -> goRuleta());
        btnTragamonedas.addActionListener(e -> mostrarProximamente());
        btnJuego3.addActionListener(e -> mostrarProximamente());
        btnJuego4.addActionListener(e -> mostrarProximamente());
        closeButtonProx.addActionListener(e -> proximamente.dispose());
    }

    public void mostrarVentana(){
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.mostrarVentana();
    }

    public void goRuleta(){
        Ruleta.main(new String[]{});
    }

    public void mostrarProximamente(){
        proximamente.setVisible(true);
    }
}
