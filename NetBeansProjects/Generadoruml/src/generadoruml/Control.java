package generadoruml;
import java.util.Scanner;

public class Control {
  
    private Logica logica;
    private InterfaceIO interfaceIO;
    private OrganizadorArchivo organizador;
    private GeneradorJava java;
    private GeneradorUML uml;
    private Modelo modelo;
    private String rutaArchivo;

    public void iniciar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione el tipo de interfaz a utilizar:");
        System.out.println("1. App");
        System.out.println("2. Consola");
        System.out.print("Opción: ");

        int opcion = sc.nextInt();
        sc.nextLine(); // limpiar el buffer

        if (opcion == 1) {
            interfaceIO = new PopUpIO();
            interfaceIO.mostrar("Usted ha seleccionado App");
        } else {
            interfaceIO = new ConsolaIO();
            interfaceIO.mostrar("Usted ha seleccionado Consola");
        }
        
        organizador = new OrganizadorArchivo();
        java = new GeneradorJava();
        uml = new GeneradorUML();
        modelo = new Modelo(); // inicializa modeloooo
        logica = new Logica(); // y logicaaa

        interfaceIO.mostrar("Bienvenido al generador de archivos UML / Código Java");
        elegirOpcion();
    }

    private void elegirOpcion() {
        boolean continuar = true;

        while (continuar) {
            interfaceIO.mostrar("=== MENÚ PRINCIPAL ===\n" +
                               "1. Generar archivo UML\n" +
                               "2. Generar código fuente Java\n" +
                               "3. Salir");

            String opcion = interfaceIO.leer("Seleccione una opción (1-3):");

            switch (opcion) {
                case "1" -> {
                    interfaceIO.mostrar("Ha seleccionado la opción: Generar archivo UML");
                    generarUML();
                    confirmarResultado();
                }
                case "2" -> {
                    interfaceIO.mostrar("Ha seleccionado la opción: Generar código fuente Java");
                    generarJava();
                    confirmarResultado();
                }
                case "3" -> {
                    interfaceIO.mostrar("Saliendo del programa...");
                    continuar = false;
                }
                default -> interfaceIO.mostrar("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void generarUML() {
        if (modelo.getClases().isEmpty()) {
            interfaceIO.mostrar("No hay clases en el modelo. Capture los datos primero.");
            return;
        }
        String contenido = logica.generarUML(modelo);
        String nombreArchivo = interfaceIO.leer("Ingrese el nombre del archivo UML (sin extensión):");
        rutaArchivo = nombreArchivo + ".txt";
        boolean exito = organizador.guardarArchivo(rutaArchivo, contenido);
        if (exito) {
            interfaceIO.mostrar("Archivo UML generado y guardado correctamente en: " + rutaArchivo);
        } else {
            interfaceIO.mostrar("Error al guardar el archivo UML.");
        }
    }

    private void generarJava() {
        if (modelo.getClases().isEmpty()) {
            interfaceIO.mostrar("No hay clases en el modelo. Capture los datos primero.");
            return;
        }
        String contenido = logica.generarJava(modelo);
        String nombreArchivo = interfaceIO.leer("Ingrese el nombre del archivo Java (sin extensión):");
        rutaArchivo = nombreArchivo + ".txt";
        boolean exito = organizador.guardarArchivo(rutaArchivo, contenido);
        if (exito) {
            interfaceIO.mostrar("Código Java generado y guardado correctamente en: " + rutaArchivo);
        } else {
            interfaceIO.mostrar("Error al guardar el archivo Java.");
        }
    }

    // Este método confirma si el archivo se guardó correctamente en disco
    public void confirmarResultado() {
        boolean existe = organizador.verificarArchivo(rutaArchivo);
        if (existe) {
            interfaceIO.mostrar("el archivo existe en disco y se guardó correctamente.");
        } else {
            interfaceIO.mostrar("Error: el archivo no se encontró en el sistema.");
        }
    }
}
