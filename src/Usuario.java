public class Usuario {
    private String nombre;
    private String username;
    private String password;

    public Usuario(String username,String password, String nombre) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
    }

    public boolean validarCredenciales(String u, String p) {
        return this.username.equals(u) && this.password.equals(p);
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsername() {
        return username;
    }
}
