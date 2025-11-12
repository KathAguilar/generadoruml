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
    interfaceIO.mostrar("Bienvenido al generador de archivos UML / Código Java");
    }
    private void elegirOpcion(){
    
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
                generarArchivos();  // llama a tu método de creación
                confirmarResultado(); // verifica si el archivo se generó correctamente
            }

            case "2" -> {
                interfaceIO.mostrar("Ha seleccionado la opción: Generar código fuente Java");
                generarArchivos();
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

private String capturarDatos(){
    
    interfaceIO.mostrar("=== Captura de datos UML ===");
    interfaceIO.mostrar("Ingrese la información de las clases, sus atributos, métodos y relaciones.");

    String datos = "";
    boolean continuar = true;

    while (continuar) {
        // Nombre de la clase
        String nombreClase = interfaceIO.leer("Ingrese el nombre de la clase:");
        datos += "Clase: " + nombreClase + "\n";

        // Captura de atributos
        String agregarAtributos = interfaceIO.leer("¿Desea agregar atributos a " + nombreClase + "? (s/n):");
        while (agregarAtributos.equalsIgnoreCase("s")) {
            String atributo = interfaceIO.leer("Ingrese atributo (formato: tipo nombre):");
            datos += "  + Atributo: " + atributo + "\n";
            agregarAtributos = interfaceIO.leer("¿Desea agregar otro atributo? (s/n):");
        }

        // Captura de métodos
        String agregarMetodos = interfaceIO.leer("¿Desea agregar métodos a " + nombreClase + "? (s/n):");
        while (agregarMetodos.equalsIgnoreCase("s")) {
            String metodo = interfaceIO.leer("Ingrese método (formato: tipo nombre(params)): ");
            datos += "  + Método: " + metodo + "\n";
            agregarMetodos = interfaceIO.leer("¿Desea agregar otro método? (s/n):");
        }

        // Captura de relaciones
        String agregarRelaciones = interfaceIO.leer("¿Desea agregar relaciones desde " + nombreClase + "? (s/n):");
        while (agregarRelaciones.equalsIgnoreCase("s")) {
            String relacion = interfaceIO.leer("Ingrese relación (formato: tipo nombreClaseRelacionada, ej: hereda Persona): ");
            datos += "  + Relación: " + relacion + "\n";
            agregarRelaciones = interfaceIO.leer("¿Desea agregar otra relación? (s/n):");
        }

        // Preguntar si desea agregar otra clase
        String otraClase = interfaceIO.leer("¿Desea agregar otra clase? (s/n):");
        if (!otraClase.equalsIgnoreCase("s")) {
            continuar = false;
        }

        datos += "\n";

        }
        interfaceIO.mostrar("Captura de datos completada.");
        if (datos != null) {
        return datos;
        } else {
        return rutaArchivo;
}
}
    
private void generarCodigo() {
    
    interfaceIO.mostrar("=== Generación de código fuente en Java ===");

    if (modelo == null || modelo.getClases().isEmpty()) {
        interfaceIO.mostrar("No hay clases en el modelo. Capture los datos primero.");
        return;
    }

    // Genera el código usando la lógica
    String codigo = java.organizarJava(modelo);

    // Define la ruta donde guardar
    String rutaArchivo = "src/Generado.java";

    // Guarda el archivo usando el organizador
    boolean exito = organizador.guardarArchivo(rutaArchivo, codigo);

    // Muestra resultado
    if (exito) {
        interfaceIO.mostrar("Código Java generado y guardado correctamente en: " + rutaArchivo);
    } else {
        interfaceIO.mostrar("Error al guardar el archivo de código Java.");
    }
}



private void generarArchivos() {
    
        String nombreArchivo = interfaceIO.leer("Ingrese el nombre del archivo (sin extensión)");
        String rutaArchivo = nombreArchivo + ".txt";
        String contenido = interfaceIO.leer("Ingrese el contenido del archivo");

        boolean creado = organizador.crearArchivo(nombreArchivo);
        boolean guardado = organizador.guardarArchivo(rutaArchivo, contenido);

        if (creado && guardado) {
            interfaceIO.mostrar("Archivo creado y guardado correctamente.");
        } else if (!creado) {
            interfaceIO.mostrar("El archivo ya existía, se añadió contenido.");
        } else {
            interfaceIO.mostrar("Ocurrió un error al guardar el archivo.");
        }
    }

    // Este método confirma si el archivo se guardó correctamente en disco
    public void confirmarResultado() {
        
        boolean existe = organizador.verificarArchivo(rutaArchivo);

        if (existe) {
            interfaceIO.mostrar("Confirmación: el archivo existe en disco y se guardó correctamente.");
        } else {
            interfaceIO.mostrar("Error: el archivo no se encontró en el sistema.");
        }
    }
}
