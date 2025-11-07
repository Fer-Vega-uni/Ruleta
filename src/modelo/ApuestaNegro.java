package modelo;

public class ApuestaNegro extends ApuestaBase {

    public ApuestaNegro(int monto){
        super("NEGRO",monto);
    }

    @Override
    public boolean acierto (int numeroGanador, String colorGanador){
        return colorGanador.equals("NEGRO");
    }
}
