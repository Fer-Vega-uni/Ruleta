package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioEnMemoria implements IRepositorioResultados {

    private List<Resultado> resultados = new ArrayList<>();
    @Override
    public void guardar(Resultado resultado) {
        resultados.add(resultado);
    }

    @Override
    public List<Resultado> obtenerTodos() {
        return Collections.unmodifiableList(resultados);
    }

    //hmmm, creo q tengo problemas con git
}