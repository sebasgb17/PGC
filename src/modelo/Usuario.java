package modelo;

/**
 * Clase que representa a un usuario dentro del sistema PGC.
 * Atiende las estructuras base para REQ-01, REQ-02 y REQ-05.
 */
public class Usuario {
    private String id;
    private String nombre;
    private String correo;
    private String contrasena;
    private Rol rol;

    // Constructor completo
    public Usuario(String id, String nombre, String correo, String contrasena, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    /**
     * Valida si las credenciales ingresadas coinciden con el usuario (REQ-02)
     */
    public boolean autenticar(String correo, String contrasena) {
        if (correo == null || contrasena == null) {
            return false;
        }
        return this.correo.equalsIgnoreCase(correo.trim()) && this.contrasena.equals(contrasena);
    }

    // --- GETTERS Y SETTERS ---

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario {" +
            "ID=" + id +
            ", Nombre=" + nombre +
            ", Correo=" + correo +
            ", Rol=" + rol +
            "}";
    }
}