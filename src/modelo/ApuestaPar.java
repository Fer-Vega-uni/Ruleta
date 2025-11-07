package modelo;

public class ApuestaPar extends ApuestaBase {

    public ApuestaPar(int monto){
        super("PAR",monto);
    }

    @Override
    public boolean acierto (int numeroGanador, String colorGanador){
        return numeroGanador != 0 && numeroGanador % 2 == 0;
    }
}
