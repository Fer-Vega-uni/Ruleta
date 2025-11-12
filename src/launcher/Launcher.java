package launcher;

import controladores.ControladorEstadisticas;
import controladores.ControladorSesion;
import controladores.ControladorRuleta;
import modelo.IRepositorioResultados;
import modelo.RepositorioArchivo;
import modelo.Ruleta;
import vista.VentanaLogin;

public class Launcher {
    public static void main(String[] args) {
        IRepositorioResultados repoGlobal = new RepositorioArchivo();
        ControladorSesion controladorSesion = new ControladorSesion();
        Ruleta modeloRuleta = new Ruleta(repoGlobal);
        ControladorEstadisticas controladorEstadisticas = new ControladorEstadisticas(repoGlobal);
        ControladorRuleta controladorRuleta = new ControladorRuleta(modeloRuleta, controladorSesion);
        VentanaLogin ventanaLogin = new VentanaLogin(controladorSesion, controladorRuleta, controladorEstadisticas);
        ventanaLogin.mostrarVentana();
    }
}
