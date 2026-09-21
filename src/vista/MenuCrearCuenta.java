package vista;

import java.util.Scanner;
import modelo.Rol;
import modelo.Usuario;
import servicio.GestorUsuarios;

public class MenuCrearCuenta {

    private GestorUsuarios gestorUsuarios;
    private Scanner scanner;

    // Constructor: conecta la vista con la lógica de negocio (Kevin)
    public MenuCrearCuenta(GestorUsuarios gestorUsuarios) {
        this.gestorUsuarios = gestorUsuarios;
        this.scanner = new Scanner(System.in);
    }

    // Método principal para capturar datos e interactuar con el usuario (REQ-01)
    public void mostrarFormularioRegistro() {
        System.out.println("\n========================================");
        System.out.println("   REGISTRO DE NUEVA CUENTA ");
        System.out.println("========================================");

        System.out.print("Ingrese ID / Documento: ");
        String id = scanner.nextLine().trim();

        System.out.print("Ingrese Nombre Completo: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("Ingrese Correo Electrónico: ");
        String correo = scanner.nextLine().trim();

        System.out.print("Ingrese Contraseña: ");
        String contrasena = scanner.nextLine().trim();

        // Selección de rol mediante submenú interactivo
        Rol rolSeleccionado = seleccionarRol();

        // Crear objeto Usuario con los datos capturados 
        Usuario nuevoUsuario = new Usuario(id, nombre, correo, contrasena, rolSeleccionado);
        
        System.out.println("\nProcesando registro...");
        
        // Enviar a la lógica de negocio para validar y guardar 
        boolean exito = gestorUsuarios.registrarUsuario(nuevoUsuario);

        // Mensaje de respuesta al usuario
        if (exito) {
            System.out.println("----------------------------------------");
            System.out.println(" ¡Cuenta creada exitosamente!");
            System.out.println(" Bienvenido/a, " + nombre + " [" + rolSeleccionado + "]");
            System.out.println("----------------------------------------");
        } else {
            System.out.println("----------------------------------------");
            System.out.println(" No se pudo completar el registro.");
            System.out.println(" Verifique que los datos no estén vacíos o repetidos.");
            System.out.println("----------------------------------------");
        }
    }

    // Submenú para seleccionar Rol de forma segura mediante números
    private Rol seleccionarRol() {
        Rol rolElegido = null;
        boolean seleccionValida = false;

        while (!seleccionValida) {
            System.out.println("\nSeleccione el Rol del usuario:");
            System.out.println("1. Administrador");
            System.out.println("2. Coordinador");
            System.out.println("3. Docente");
            System.out.println("4. Estudiante (Por defecto)");
            System.out.print("Opción (1-4): ");

            String entrada = scanner.nextLine().trim();

            switch (entrada) {
                case "1":
                    rolElegido = Rol.ADMINISTRADOR;
                    seleccionValida = true;
                    break;
                case "2":
                    rolElegido = Rol.COORDINADOR;
                    seleccionValida = true;
                    break;
                case "3":
                    rolElegido = Rol.DOCENTE;
                    seleccionValida = true;
                    break;
                case "4":
                case "": // Si presiona Enter sin escribir nada, asigna Estudiante
                    rolElegido = Rol.ESTUDIANTE;
                    seleccionValida = true;
                    break;
                default:
                    System.out.println(" Opción inválida. Ingrese un número entre 1 y 4.");
            }
        }
        return rolElegido;
    }
}