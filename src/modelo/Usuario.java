package modelo;

public class Usuario {
    private static int contador = 0;
    private int id;
    private String nombre;
    private String password;
    private String user;

    public Usuario(String nombre, String contra, String user){
        this.id=++contador;
        this.nombre=nombre;
        this.password=contra;
        this.user=user;
    }

    public Usuario(){
        this("Invitado", "","Invitado");
    }
    public boolean validarCredenciales(String u, String p) {
        return this.user.equals(u) && this.password.equals(p);
    }
    public String getNombre()   {return nombre;}
    public String getUsername() {return user;}
}
}
