package controladores;

import modelo.Usuario;

public class ControladorSesion {
    private Usuario usuarioActual;

    public void registrarUsuario(String u, String p, String n) {
        if (u==null||u.isBlank()||p==null||p.isBlank()
        ||n==null||n.isBlank()) throw new IllegalArgumentException("Datos requeridos");
        this.usuarioActual = new Usuario(n,p,u);
    }

    public boolean iniciarSesion(String u, String p){
        if (usuarioActual==null) return false;
        return usuarioActual.validarCredenciales(u,p);
    }
    public boolean hayUsuario(){return usuarioActual!=null;}

    public String getNombreUsuario(){return hayUsuario()? String.valueOf(usuarioActual) :"";}

    public Usuario getUsuarioActual(){return usuarioActual;}

    public void cerrarSession(){usuarioActual=null;}
}
