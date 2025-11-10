package generadoruml;


import java.util.Scanner;


public class Control {
  
 private Logica logica;
 private InterfaceIO interfaceIO;
   private OrganizadorArchivo organizador;

    public void iniciar() {

        Scanner sc = new Scanner(System.in);
    System.out.println("Seleccione el tipo de interfaz a utilizar:");
    System.out.println("1. App");
    System.out.println("2. Consola");
    System.out.print("Opción: ");

    int opcion = sc.nextInt();
    sc.nextLine(); // limpiar el buffer

    // Según la opción, se asigna la interfaz
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


private void capturarDatos(){
    
    
}
    
private void generarCodigo(){
    
    
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

    // 🧩 Este método confirma si el archivo se guardó correctamente en disco
    public void confirmarResultado() {
        
        boolean existe = organizador.verificarArchivo(rutaArchivo);

        if (existe) {
            interfaceIO.mostrar("Confirmación: el archivo existe en disco y se guardó correctamente.");
        } else {
            interfaceIO.mostrar("Error: el archivo no se encontró en el sistema.");
        }
    }
}
