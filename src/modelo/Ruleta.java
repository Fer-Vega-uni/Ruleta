package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ruleta {
    private final Random rng = new Random();
    private final List<Resultado> historialResultados;
    private static final int[] numerosRojos = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};


    public Ruleta() {
        this.historialResultados = new ArrayList<>();
    }

    private int girarRuleta() {
        return rng.nextInt(37); // Números del 0 al 36
    }

    public static boolean esRojo(int n) {
        for (int num : numerosRojos) {
            if (num == n) {
                return true;
            }
        }
        return false;
    }

    public Resultado jugarRonda(int montoApostado, TipoApuesta tipoSeleccionado) {
        if (montoApostado <= 0) {
            throw new IllegalArgumentException("La apuesta debe ser mayor a cero.");
        }

        int numeroGanador = girarRuleta();
        boolean acierto = tipoSeleccionado.evaluarResultado(numeroGanador, tipoSeleccionado);
        int ganancia = acierto ? montoApostado : -montoApostado;

        Resultado resultado = new Resultado(numeroGanador, tipoSeleccionado, montoApostado, ganancia);
        historialResultados.add(resultado);

        return resultado;
    }

    public List<Resultado> getHistorialResultados() {
        return historialResultados;
    }
}