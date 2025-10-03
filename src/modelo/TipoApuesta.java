package modelo;


public enum TipoApuesta {
    ROJO, NEGRO, PAR, IMPAR;


    public static boolean evaluarResultado(int numero, TipoApuesta tipo) {
        if (numero==0){return false;}
        return switch (tipo) {
            case ROJO -> Ruleta.esRojo(numero);
            case NEGRO -> !Ruleta.esRojo(numero);
            case PAR -> numero % 2 == 0;
            case IMPAR -> numero % 2 != 0;
        };
    }


    }
