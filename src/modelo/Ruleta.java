package modelo;


import java.util.Random;
import javax.swing.*;

public class Ruleta {
    public static final int MAX_HISTORIAL = 100;
    public static final int[] historialNumeros = new int[MAX_HISTORIAL];
    public static int[] historialApuestas = new int[MAX_HISTORIAL];
    public static boolean[] historialAciertos = new boolean[MAX_HISTORIAL];
    public static int historialSize = 0;
    public static Random rng = new Random();
    public static int[] numerosRojos = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};



    public void iniciarRonda(int apuesta, TipoApuesta tipoSeleccionado) {
        if (apuesta <= 0) return;
        assert tipoSeleccionado != null;
        int numero = girarRuleta();
        boolean acierto = TipoApuesta.evaluarResultado(numero, tipoSeleccionado);
        registrarResultado(numero, apuesta, acierto);
        historialSize++;

    }


    public static int girarRuleta() {
        return rng.nextInt(36) + 1;
    }




    public static void registrarResultado(int numero, int apuesta, boolean acierto) {
        if (historialSize < MAX_HISTORIAL) {
            historialNumeros[historialSize] = numero;
            historialAciertos[historialSize] = acierto;
            if (acierto) {
                historialApuestas[historialSize] = apuesta * 2;
            } else {
                historialApuestas[historialSize] = -apuesta;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Historial máximo alcanzado");
        }
    }






}
