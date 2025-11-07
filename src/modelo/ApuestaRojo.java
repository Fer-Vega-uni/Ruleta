package modelo;

public class ApuestaRojo extends ApuestaBase {

    public ApuestaRojo(int monto){
        super("ROJO",monto);
    }

    @Override
    public boolean acierto (int numeroGanador, String colorGanador){
        return colorGanador.equals("ROJO");
    }
}
