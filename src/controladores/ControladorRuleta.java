package controladores;
import modelo.*;

public class ControladorRuleta {
    private final Ruleta modeloRuleta;
    private final ControladorSesion controladorSesion;


    public ControladorRuleta(Ruleta modeloRuleta, ControladorSesion cs) {
        this.modeloRuleta = modeloRuleta;
        this.controladorSesion = cs;
    }

    public Resultado realizarApuesta(int monto, String tipo) {
        Usuario jugador = controladorSesion.getUsuarioActual();
        if (monto > jugador.getSaldo()) {
            throw new IllegalStateException("Saldo insuficiente para realizar la apuesta.");
        }
        ApuestaBase apuesta;
        switch (tipo) {
            case "ROJO":
                apuesta = new ApuestaRojo(monto);
                break;
            case "NEGRO":
                apuesta = new ApuestaNegro(monto);
                break;
            case "PAR":
                apuesta = new ApuestaPar(monto);
                break;
            case "IMPAR":
                apuesta = new ApuestaImpar(monto);
                break;
            default:
                throw new IllegalStateException("Valor inesperado: " + tipo);
        }

        Resultado resultado = modeloRuleta.jugarRonda(apuesta);
        jugador.actualizarSaldo(resultado.getGanancia());
        jugador.agregarResultado(resultado);
        return resultado;
    }

}
