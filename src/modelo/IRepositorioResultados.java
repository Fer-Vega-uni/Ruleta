package modelo;


import java.io.IOException;
import java.util.List;

public interface IRepositorioResultados {

	void guardar(Resultado resultado) throws IOException;

	List<Resultado> obtenerTodos() throws IOException;

}