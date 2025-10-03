package modelo;

public class Resultado {
    private final int numeroObtenido;
    private final TipoApuesta tipoApuesta;
    private final int montoApostado;
    private final int ganancia; // Positivo si ganó, negativo si perdió

    public Resultado(int numeroObtenido, TipoApuesta tipoApuesta, int montoApostado, int ganancia) {
        this.numeroObtenido = numeroObtenido;
        this.tipoApuesta = tipoApuesta;
        this.montoApostado = montoApostado;
        this.ganancia = ganancia;
    }

    public int getNumeroObtenido() {
        return numeroObtenido;
    }

    public int getGanancia() {
        return ganancia;
    }

    @Override
    public String toString() {
        String estado = ganancia > 0 ? "Ganó" : "Perdió";
        return String.format("Salió el %d. Apostó a %s. Resultado: %s $%d",
                numeroObtenido, tipoApuesta.name(), estado, Math.abs(ganancia));
    }
}
