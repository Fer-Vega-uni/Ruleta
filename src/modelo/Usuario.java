package modelo;

public class Usuario {
    private static int contador = 0;
    private int id;
    private String nombre;
    private String password;
    private String user;
    private int saldo=5000;



    public Usuario(String nombre, String password, String user) {
        this.id = ++contador;
        this.setNombre(nombre);
        this.password = password;
        this.user = user;
        this.saldo = 5000;
    }

    public Usuario(){
        this("Invitado", "","Invitado");
    }
    public boolean validarCredenciales(String u, String p) {
        return this.user.equals(u) && this.password.equals(p);
    }

    public void depositar(int monto) {
        if (monto > 0) {this.saldo += monto;} else
        {throw new IllegalArgumentException("El monto a depositar debe ser positivo.");}
    }

    public void actualizarSaldo(int montoGanadoOPerdido) {this.saldo += montoGanadoOPerdido;}

    //getters y setters
    public String getNombre()   {return nombre;}
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;}

    public String getUsername() {return user;}
    public void setUser(String user) {this.user = user;}

    public int getSaldo() {return saldo;}
    public void setSaldo(int saldo) {this.saldo = saldo;}
}

