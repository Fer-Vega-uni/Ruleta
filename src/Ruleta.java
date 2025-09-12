import java.awt.*;
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



    public static void iniciarRonda(int apuesta, String tipoSeleccionado) {
        if (apuesta <= 0) return;
        assert tipoSeleccionado != null;
        int numero = girarRuleta();
        boolean acierto = evaluarResultado(numero, tipoSeleccionado);
        registrarResultado(numero, apuesta, acierto);
        historialSize++;

    }


    public static int girarRuleta() {
        return rng.nextInt(36) + 1;
    }



    public static boolean evaluarResultado(int numero, String tipo) {
        boolean validar = esRojo(numero);
        boolean par = numero % 2 == 0;
        return switch (tipo) {
            case "Rojo" -> validar;
            case "Negro" -> !validar;
            case "Impar" -> !par;
            case "Par" -> par;
            default -> false;
        };
    }

    public static boolean esRojo(int n) {
        for (int num : numerosRojos) {
            if (num == n) {
                return true;
            }
        }
        return false;
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