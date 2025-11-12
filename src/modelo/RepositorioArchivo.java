package modelo;
import java.io.Console;
import java.io.File;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


public class RepositorioArchivo implements IRepositorioResultados {

	private String NOMBRE_ARCHIVO = "historial_resultados.csv";

    public void VerificarArchivo(){
        try{
            File archivo = new File(NOMBRE_ARCHIVO);
            if (!archivo.exists()){
                archivo.createNewFile();
            }
        } catch (Exception e){
            System.err.println("Error al crear el archivo de repositorio: " + e.getMessage());
        }
    }

    @Override
    public void guardar(Resultado resultado) throws IOException {

        String linea = String.format("%d,%s,%d,%d",
                resultado.getNumeroObtenido(),
                resultado.getTipoApuesta(),
                resultado.getMontoApostado(),
                resultado.getGanancia()
        );

            Files.writeString(Path.of(NOMBRE_ARCHIVO), linea + "\n", StandardOpenOption.APPEND, StandardOpenOption.CREATE);

    }

    @Override
    public List<Resultado> obtenerTodos() throws IOException {
        List<Resultado> resultados = new ArrayList<>();
        if (!Files.exists(Path.of(NOMBRE_ARCHIVO))) {
            return resultados;
        }
        List<String> lineas = Files.readAllLines(Path.of(NOMBRE_ARCHIVO));

        for (String linea : lineas) {
            String[] valores = linea.split(",");
            if (valores.length == 4) {
                try {
                    int numero = Integer.parseInt(valores[0]);
                    String tipo = valores[1];
                    int monto = Integer.parseInt(valores[2]);
                    int ganancia = Integer.parseInt(valores[3]);

                    resultados.add(new Resultado(numero, tipo, monto, ganancia));
                } catch (NumberFormatException e) {
                    System.err.println("Error al parsear línea: " + linea);
                }
            }
        }
        return resultados;

    }
}