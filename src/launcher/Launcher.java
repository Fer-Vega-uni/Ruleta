package launcher;

import controladores.ControladorSesion;
import controladores.ControladorRuleta;
import modelo.Ruleta;
import vista.VentanaLogin;

public class Launcher {
    public static void main(String[] args) {
        ControladorSesion controladorSesion = new ControladorSesion();
        Ruleta modeloRuleta = new Ruleta();
        ControladorRuleta controladorRuleta = new ControladorRuleta(modeloRuleta);
        VentanaLogin ventanaLogin = new VentanaLogin(controladorSesion, controladorRuleta);
        ventanaLogin.mostrarVentana();
    }
}
