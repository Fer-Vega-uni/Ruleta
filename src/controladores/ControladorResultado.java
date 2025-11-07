package controladores;

import modelo.Resultado;
import modelo.Usuario;


import java.util.List;
import java.util.*;

public class ControladorResultado {
	private java.util.ArrayList<modelo.Resultado> historial;
	private final controladores.ControladorSesion session;

    public ControladorResultado(ControladorSesion session) {
        this.session = session;
    }

    public List<Resultado> obtenerHistorialUsuarioActual() {
        Usuario usuario = session.getUsuarioActual();
        if (usuario != null) {
            return usuario.getHistorial();
        }
        return List.of();
    }
}
