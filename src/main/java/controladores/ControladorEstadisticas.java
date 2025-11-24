package controladores;

import modelo.Estadisticas;
import modelo.IRepositorioResultados;
import modelo.Resultado;
import java.util.List;


public class ControladorEstadisticas {

    private final IRepositorioResultados repositorio;


    public ControladorEstadisticas(IRepositorioResultados repositorio){
        this.repositorio=repositorio;
    }

    public String obtenerEstadisticasF(){
        try {
            List<Resultado> historial = repositorio.obtenerTodos();
            if (historial.isEmpty()){ return "Aún no hay datos para mostrar estadísticas";}
            Estadisticas est =new Estadisticas(historial);
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("--- Estadísticas Globales del Casino ---%n%n"));
            sb.append(String.format("Total de Rondas Jugadas: %d%n", est.getTotalApuestas()));
            sb.append(String.format("Balance Total (Ganancias/Pérdidas): $%d%n", est.calcularBalanceTotal()));
            sb.append(String.format("Porcentaje de Aciertos: %.2f%%%n", est.calcularPorcentajeAciertos()));
            sb.append(String.format("%n--- Distribución de Apuestas ---%n"));
            sb.append(String.format("Apuestas a ROJO: %.2f%%%n", est.calcPorcentajeRojo()));
            sb.append(String.format("Apuestas a NEGRO: %.2f%%%n", est.calcPorcentajeNegro()));
            sb.append(String.format("Apuestas a PAR: %.2f%%%n", est.calcPorcentajePar()));
            sb.append(String.format("Apuestas a IMPAR: %.2f%%%n", est.calcPorcentajeImpar()));
            return sb.toString();
        }catch (Exception e){
            System.err.println("Error al leer el repositorio: " + e.getMessage());
            return "Error al cargar las estadísticas desde el repositorio.";
        }
    }






}
