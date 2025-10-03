package controladores;

import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;

public class ControladorSesion {
    private final List<Usuario> usuariosRegistrados;
    private Usuario usuarioActual;

    public ControladorSesion() {
        this.usuariosRegistrados = new ArrayList<>();
        usuariosRegistrados.add(new Usuario("Don Donnie","123","ownerrrr"));}

    public void registrarUsuario(String u, String p, String n) {
        if (u==null||u.isBlank()||p==null||p.isBlank()
        ||n==null||n.isBlank()) throw new IllegalArgumentException("Datos requeridos");
        for (Usuario user : usuariosRegistrados) {
            if (user.getUsername().equalsIgnoreCase(u)) {
                throw new IllegalArgumentException("El nombre de usuario ya existe.");
            }
        usuariosRegistrados.add(new Usuario(n,p,u));
    }}

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

    public void cerrarSession(){usuarioActual=null;}
}
