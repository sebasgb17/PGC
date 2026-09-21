package modelo;

public class Usuario {
    private String id;
    private String nombre;
    private String correo;
    private String contrasena;
    private Rol rol;

    public Usuario(String id, String nombre, String correo, String contrasena, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    // Validar inicio de sesión (REQ-02)
    public boolean autenticar(String correo, String contrasena) {
        return this.correo.equalsIgnoreCase(correo) && this.contrasena.equals(contrasena);
    }

    // Getters y Setters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public Rol getRol() { return rol; }
    public String getContrasena() { return contrasena; }

    @Override
    public String toString() {
        return "Usuario: " + nombre + " | Rol: " + rol + " | Correo: " + correo;
    }
}