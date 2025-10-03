package controladores;
import modelo.Resultado;
import modelo.Ruleta;
import modelo.TipoApuesta;
import modelo.Usuario;

public class ControladorRuleta {
    private final Ruleta modeloRuleta;


    public ControladorRuleta(Ruleta modeloRuleta) {
        this.modeloRuleta = modeloRuleta;
    }

    public Resultado realizarApuesta(int monto, String tipoApuestaStr, Usuario jugador){
        if (monto > jugador.getSaldo()) {
            throw new IllegalStateException("Saldo insuficiente para realizar la apuesta.");
        }
        TipoApuesta tipo = TipoApuesta.valueOf(tipoApuestaStr.toUpperCase());
        Resultado resultado = modeloRuleta.jugarRonda(monto, tipo);
        jugador.actualizarSaldo(resultado.getGanancia());
        return resultado;
    }
}
