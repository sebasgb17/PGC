package servicio;

import java.util.ArrayList;
import java.util.List;
import modelo.Rol;
import modelo.Usuario;

public class GestorUsuarios {
    private List<Usuario> listaUsuarios; // Ole, existe una forma de informacion con un excel local con Apache POI
    //lo que pille es que apache era como mas complicado de usar mk
    //Pues lo que andaba viendo es que se crea una hoja de calculo en excel, y dentro del codigo de manera local se le da la instruccion de crear el usuario con nombre y rol

    //pues ahi si no se mk, siempre esta complicadita esta vuelta
    //Pues el codigo que genera es algo como esto:

// Guardar
XSSFWorkbook libro = new XSSFWorkbook();
XSSFSheet hoja = libro.createSheet("Usuarios");
XSSFRow fila = hoja.createRow(0);
fila.createCell(0).setCellValue("nombre");
fila.createCell(1).setCellValue("rol");

XSSFRow nueva = hoja.createRow(1);
nueva.createCell(0).setCellValue("Carlos");
nueva.createCell(1).setCellValue("Administrador");

try (FileOutputStream out = new FileOutputStream("datos.xlsx")) {
    libro.write(out);
}
libro.close();   


















// pues si estoy viendo que esto no se esta guardando 
// Pues toca darle ctrl + s xd
//ya le di y no sale
// creo que si toca como con comandos o alguna mrd asi voy a pillar 

// pues si, igual ahi esta la idea 
    public GestorUsuarios() {
        this.listaUsuarios = new ArrayList<>();
    }

    // REQ-01: Crear Cuenta
    public boolean registrarUsuario(Usuario nuevoUsuario) {
        for (Usuario u : listaUsuarios) {
            if (u.getCorreo().equalsIgnoreCase(nuevoUsuario.getCorreo())) {
                System.out.println("Error: El correo ya se encuentra registrado.");
                return false;
            }
        }
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