package launcher;
import controladores.ControladorSesion;
import controladores.ControladorRuleta;
import modelo.Ruleta;
import vista.VentanaLogin;

public class Launcher {
    public static void main(String[] args) {
        ControladorSesion controladorSesion = new ControladorSesion();
        RuletaController ruletaController = new RuletaController(modeloRuleta);

        VentanaLogin ventanaLogin = new VentanaLogin(controladorSesion, ruletaController);
        ventanaLogin.mostrarVentana();
    }
}
