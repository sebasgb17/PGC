package servicio;

import java.util.ArrayList;
import java.util.List;
import modelo.Rol;
import modelo.Usuario;

public class GestorUsuarios {
    private List<Usuario> listaUsuarios;

    public GestorUsuarios() {
        this.listaUsuarios = new ArrayList<>();
    }

    // REQ-01: Crear Cuenta
    public boolean registrarUsuario(Usuario nuevoUsuario) {

        // Validacion #1 Verificar que ningun campo obligatorio este vacio o nulo.
        if (nuevoUsuario.getNombre() == null || nuevoUsuario.getNombre().trim().isEmpty() ||
            nuevoUsuario.getCorreo() == null || nuevoUsuario.getCorreo().trim().isEmpty() ||
            nuevoUsuario.getContrasena() == null || nuevoUsuario.getContrasena().trim().isEmpty() ||
            nuevoUsuario.getRol() == null) {

                System.out.println("Error: Datos incompletos. No se pudo crear la cuenta.");
                return false;
            }

        // Validacion #2 Recorrer la lista de usuarios para confirmar que el correo no exista previamente.
        for (Usuario u : listaUsuarios) {
            if (u.getCorreo().equalsIgnoreCase(nuevoUsuario.getCorreo())) {
                System.out.println("Error: El correo " + nuevoUsuario.getCorreo() + " ya está registrado en el sistema.");
                return false;
            }
        }
        // Flujo normal: Si pasa las dos validaciones, se agrega el usuario a la lista y se retorna true.
        listaUsuarios.add(nuevoUsuario);
        System.out.println("Cuenta creada exitosamente para: " + nuevoUsuario.getNombre());
        return true;
    }

    // REQ-02: Iniciar Sesión
    public Usuario iniciarSesion(String correo, String contrasena) {
        for (Usuario u : listaUsuarios) {
            if (u.autenticar(correo, contrasena)) {
                return u;
            }
        }
        return null;
    }

    // REQ-05: Eliminar Cuenta
    public boolean eliminarUsuario(String correo) {
        return listaUsuarios.removeIf(u -> u.getCorreo().equalsIgnoreCase(correo));
    }
}