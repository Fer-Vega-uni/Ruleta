package modelo;


import java.util.List;

public class Estadisticas {
    private final List<Resultado> historial;
    private final int totalApuestas;

    public Estadisticas(List<Resultado> historial) {
        this.historial= historial;
        this.totalApuestas= historial.size();
    }

    public int getTotalApuestas(){ return  totalApuestas;}

    public int calcularBalanceTotal(){
        int total=0;
        for (Resultado r: historial){total+= r.getGanancia();}
        return total;
    }

    public double calcularPorcentajeAciertos(){
        int aciertos=0;
        if (totalApuestas == 0){return 0.0;}
        for(Resultado r:historial){
            if (r.getGanancia()>0){aciertos++;}
        }
        return (double) aciertos /totalApuestas*100.0;
    }

    public double calcularPorcentajeTipo(String tipo){
        int contador=0;
        if (totalApuestas == 0){return 0.0;}
        for (Resultado r: historial){
            if (r.getTipoApuesta().equals(tipo)){contador++;}
        }
        return (double) contador/totalApuestas *100.0;
    }

    public double calcPorcentajeRojo(){ return calcularPorcentajeTipo("ROJO");}
    public double calcPorcentajeNegro(){return calcularPorcentajeTipo("NEGRO");}
    public double calcPorcentajePar(){return calcularPorcentajeTipo("PAR");}
    public double calcPorcentajeImpar(){return calcularPorcentajeTipo("IMPAR");}
}
