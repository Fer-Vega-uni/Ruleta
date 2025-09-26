package modelo;

import static modelo.Ruleta.numerosRojos;

public enum TipoApuesta {
    ROJO, NEGRO, PAR, IMPAR;


    public static boolean evaluarResultado(int numero, TipoApuesta tipo) {
        return switch (tipo) {
            case ROJO -> esRojo(numero);
            case NEGRO -> !esRojo(numero);
            case PAR -> numero % 2 == 0;
            case IMPAR -> numero % 2 != 0;
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

    }
