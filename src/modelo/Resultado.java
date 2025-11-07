package modelo;

public class Resultado {
    private final int numeroObtenido;
    private final String tipoApuesta;
    private final int montoApostado;
    private final int ganancia;

    public Resultado(int numeroObtenido, String tipoApuesta, int montoApostado, int ganancia) {
        this.numeroObtenido = numeroObtenido;
        this.tipoApuesta = tipoApuesta;
        this.montoApostado = montoApostado;
        this.ganancia = ganancia;
    }

    public int getGanancia() {
        return ganancia;
    }

    @Override
    public String toString() {
        String estado = ganancia > 0 ? "Ganó" : "Perdió";
        return String.format("Salió el %d. Apostó a %s. Resultado: %s $%d",
                numeroObtenido, tipoApuesta, estado, Math.abs(ganancia));
    }

    public int getMontoApostado() {return montoApostado;}
    public int getNumeroObtenido() {return numeroObtenido;}

    public String getTipoApuesta() {return tipoApuesta;}
}
