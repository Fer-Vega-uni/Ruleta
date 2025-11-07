package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ruleta {
    private final Random rng = new Random();
    private final IRepositorioResultados repositorio;
    private static final int[] numerosRojos = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};


    public Ruleta(IRepositorioResultados repositorio) {
        this.repositorio = repositorio;
    }

    private int girarRuleta() {
        return rng.nextInt(37); // Números del 0 al 36
    }

    private String determinarColor(int numero) {
        for (int num : numerosRojos) {
            if (num == numero) {
                return "ROJO";
            }
        }
        return "NEGRO";
    }

    public Resultado jugarRonda(ApuestaBase apuesta) {
        if (apuesta.getMonto() <= 0) {
            throw new IllegalArgumentException("La apuesta debe ser mayor a cero.");
        }

        int numeroGanador = girarRuleta();
        String colorGanador = determinarColor(numeroGanador);
        boolean acierto = apuesta.acierto(numeroGanador,colorGanador);
        int ganancia = acierto ? apuesta.getMonto() : -apuesta.getMonto();

        Resultado resultado = new Resultado(numeroGanador, apuesta.getTipo(), apuesta.getMonto(), ganancia);
        this.repositorio.guardar(resultado);
        return resultado;
    }




}