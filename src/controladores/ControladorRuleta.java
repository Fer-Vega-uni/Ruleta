package controladores;
import modelo.Resultado;
import modelo.Ruleta;
import modelo.TipoApuesta;
import modelo.Usuario;

public class ControladorRuleta {
    private final Ruleta modeloRuleta;
    private final ControladorSesion controladorSesion;


    public ControladorRuleta(Ruleta modeloRuleta, ControladorSesion cs) {
        this.modeloRuleta = modeloRuleta;
        this.controladorSesion = cs;
    }

    public Resultado realizarApuesta(int monto, TipoApuesta tipo) {
        Usuario jugador = controladorSesion.getUsuarioActual();
        if (monto > jugador.getSaldo()) {
            throw new IllegalStateException("Saldo insuficiente para realizar la apuesta.");
        }
        Resultado resultado = modeloRuleta.jugarRonda(monto, tipo);
        jugador.actualizarSaldo(resultado.getGanancia());
        jugador.agregarResultado(resultado);
        return resultado;
    }
}
