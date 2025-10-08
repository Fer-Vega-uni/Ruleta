package controladores;

import modelo.Resultado;
import modelo.Usuario;


import java.util.ArrayList;
import java.util.List;

public class ControladorResultado {
    private ArrayList<Resultado> historial;
    private final ControladorSesion session;

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
