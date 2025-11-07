package modelo;

public abstract class ApuestaBase {
    protected int monto;
    protected String tipo;

    public ApuestaBase(String tipo, int monto){
        this.tipo=tipo;
        this.monto=monto;
    }
    public abstract boolean acierto(int numeroGanador, String colorGanador);

    public int getMonto() {return monto;}
    public String getTipo() {return tipo;}
}
