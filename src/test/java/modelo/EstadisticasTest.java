package modelo;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class EstadisticasTest {

    @Test
    void testCalculosCorrectos() {
        List<Resultado> historial = new ArrayList<>();
        historial.add(new Resultado(1, "ROJO", 100, 100));
        historial.add(new Resultado(1, "NEGRO", 100, -100));

        Estadisticas stats = new Estadisticas(historial);

        assertEquals(2, stats.getTotalApuestas(), "Total de apuestas debe ser 2");
        assertEquals(0, stats.calcularBalanceTotal(), "Balance debe ser 0 (Ganó 100, Perdió 100)");
        assertEquals(50.0, stats.calcularPorcentajeAciertos(), "Aciertos debe ser 50%");
        assertEquals(50.0, stats.calcPorcentajeRojo(), "Rojos debe ser 50%");
    }
}