package modelo;

public class ApuestaImpar extends ApuestaBase {

    public ApuestaImpar(int monto){
        super("IMPAR",monto);
    }

    @Override
    public boolean acierto (int numeroGanador, String colorGanador){
        return numeroGanador % 2 != 0;
    }
}