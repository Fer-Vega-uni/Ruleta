package controladores;

import java.util.ArrayList;
import java.util.List;

import modelo.Resultado;
import modelo.Usuario;

public class ControladorSesion {
    private final List<Usuario> usuariosRegistrados;
    private Usuario usuarioActual;


    public ControladorSesion() {
        this.usuariosRegistrados = new ArrayList<>();
        usuariosRegistrados.add(new Usuario("Don Donnie","123","ownerrrr"));}

    public void registrarUsuario(String nombre, String password, String user) {
        if (nombre == null || nombre.isBlank() || password == null || password.isBlank() || user == null || user.isBlank()) {throw new IllegalArgumentException("Todos los campos son requeridos.");}
        for (Usuario u : usuariosRegistrados) {
            if (u.getUsername().equalsIgnoreCase(user)) {throw new IllegalArgumentException("El nombre de usuario ya existe.");}}
        usuariosRegistrados.add(new Usuario(nombre, password, user));
    }

    public boolean iniciarSesion(String u, String p){
        for (Usuario user : usuariosRegistrados) {
            if (user.validarCredenciales(u, p)) {
                this.usuarioActual = user;
                return true;
            }
        }
        return false;
    }
    public boolean hayUsuario(){return usuarioActual!=null;}

    public String getNombreUsuario(){return hayUsuario()? String.valueOf(usuarioActual) :"";}

    public Usuario getUsuarioActual(){return usuarioActual;}

    public void cerrarSesion(){usuarioActual=null;}
}
