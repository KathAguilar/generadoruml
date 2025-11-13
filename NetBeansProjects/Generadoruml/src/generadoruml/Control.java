package generadoruml;

import java.util.Scanner;

public class Control {
    private InterfaceIO interfaceIO;
    private OrganizadorArchivo organizador;
    private Modelo modelo;
    private String rutaArchivo;

    public void iniciar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione el tipo de interfaz a utilizar:");
        System.out.println("1. App");
        System.out.println("2. Consola");
        System.out.println("escoger: ");

        int opcion = sc.nextInt();
        sc.nextLine();

        if (opcion == 1) {
            interfaceIO = new PopUpIO();
            interfaceIO.mostrar("Usted ha seleccionado App");
        } else {
            interfaceIO = new ConsolaIO();
            interfaceIO.mostrar("Usted ha seleccionado Consola");
        }

        organizador = new OrganizadorArchivo();
        modelo = new Modelo();

        interfaceIO.mostrar("Bienvenido al generador de archivos UML / Código Java");
        menuPrincipal();
    }

    private void menuPrincipal() {
        boolean continuar = true;

        while (continuar) {
            String opcion = interfaceIO.leer("=== Opciones ===" +
                                "\n1. escribir clases" +
                                "\n2. escribir relaciones" +
                                "\n3. generar UML" +
                                "\n4. generar Java" +
                                "\n5. Salir" +
                                "\n\nEscribe el número de opción:");

            if (opcion.equals("1")) {
                capturarClases();
            } else if (opcion.equals("2")) {
                capturarRelaciones();
            } else if (opcion.equals("3")) {
                generarUML();
            } else if (opcion.equals("4")) {
                generarJava();
            } else if (opcion.equals("5")) {
                continuar = false;
            } else {
                interfaceIO.mostrar("Opción no válida");
            }
        }
    }

    private void capturarClases() {
        boolean seguir = true;

        while (seguir) {
            String nombre = interfaceIO.leer("Ingrese el nombre de la clase:");
            Clase c = new Clase(nombre, "publico");

            boolean atributosListos = false;
            while (!atributosListos) {
                String nombreA = interfaceIO.leer("Nombre del atributo (o vacio para terminar):");
                if (nombreA.isEmpty()) {
                    atributosListos = true;
                } else {
                    String tipoA = seleccionarTipo();
                    String visA = seleccionarVisibilidad();
                    c.agregarAtributo(new Atributo(nombreA, tipoA, visA));
                }
            }

            boolean metodosListos = false;
            while (!metodosListos) {
                String nombreM = interfaceIO.leer("Nombre del método (o vacio para terminar):");
                if (nombreM.isEmpty()) {
                    metodosListos = true;
                } else {
                    String tipoM = seleccionarTipo();
                    String visM = seleccionarVisibilidad();
                    c.agregarMetodo(new Metodo(nombreM, tipoM, visM));
                }
            }

            modelo.crearClase(c);

            String otra = interfaceIO.leer("¿Desea capturar otra clase? (s/n):");
            if (!otra.equalsIgnoreCase("s")) {
                seguir = false;
            }
        }
    }

    private void capturarRelaciones() {
        if (modelo.getClases().size() < 2) {
            interfaceIO.mostrar("Necesitas al menos dos clases para crear una relación.");
            return;
        }

        boolean seguir = true;
        while (seguir) {
            String lista = "";
            int i = 1;
            for (Clase c : modelo.getClases()) {
                lista += "\n" + i + ". " + c.getNombre();
                i++;
            }
            String opOrigen = interfaceIO.leer("Seleccione la clase ORIGEN:" + lista);
            String opDestino = interfaceIO.leer("Seleccione la clase DESTINO:" + lista);

            if ((opOrigen.equals("1") || opOrigen.equals("2") || opOrigen.equals("3")) &&
                (opDestino.equals("1") || opDestino.equals("2") || opDestino.equals("3")) &&
                !opDestino.equals(opOrigen)) {
                String tipo = "";
                while (true) {
                    tipo = interfaceIO.leer("Seleccione tipo de relación:" +
                                            "\n1. es un" +
                                            "\n2. posee" +
                                            "\n3. usa" +
                                            "\n\nEscribe el número de opción:");
                    if (tipo.equals("1") || tipo.equals("2") || tipo.equals("3")) {
                        break;
                    } else {
                        interfaceIO.mostrar("Opción inválida. Intente de nuevo.");
                    }
                }

                String nombreOrigen = modelo.getClases().get(Integer.parseInt(opOrigen) - 1).getNombre();
                String nombreDestino = modelo.getClases().get(Integer.parseInt(opDestino) - 1).getNombre();
                modelo.crearRelacion(new Relacion(nombreOrigen, nombreDestino, tipo));

                String otra = interfaceIO.leer("¿Desea capturar otra relación? (s/n):");
                if (!otra.equalsIgnoreCase("s")) seguir = false;
            } else {
                interfaceIO.mostrar("Opción inválida (No puede ser igual al origen). Intente de nuevo.");
            }
        }
    }

    private void generarUML() {
        if (modelo.getClases().isEmpty()) {
            interfaceIO.mostrar("No hay clases capturadas");
            return;
        }
        GeneradorUML generadorUML = new GeneradorUML();
        String contenido = generadorUML.organizarUML(modelo);
        interfaceIO.mostrar("Contenido UML generado:\n" + contenido);
        String nombreArchivo = interfaceIO.leer("Nombre del archivo UML (sin extensión):");
        rutaArchivo = nombreArchivo + ".puml";
        boolean exito = organizador.guardarArchivo(rutaArchivo, contenido);
        if (exito) {
            interfaceIO.mostrar("Archivo UML guardado en " + rutaArchivo);
        } else {
            interfaceIO.mostrar("Error al guardar UML");
        }
    }

    private void generarJava() {
    if (modelo.getClases().isEmpty()) {
        interfaceIO.mostrar("No hay clases capturadas");
        return;
    }

    GeneradorJava generadorJava = new GeneradorJava();

    for (Clase c : modelo.getClases()) {
        String contenido = generadorJava.organizarJava(c);
        interfaceIO.mostrar("Contenido Java generado para " + c.getNombre() + ":\n" + contenido);
        String nombreArchivo = c.getNombre() + ".java";
        boolean exito = organizador.guardarArchivo(nombreArchivo, contenido);
        if (exito) {
            interfaceIO.mostrar("Archivo Java guardado en " + nombreArchivo);
        } else {
            interfaceIO.mostrar("Error al guardar Java");
        }
    }

    if (!modelo.getClases().isEmpty()) {
        Clase primeraClase = modelo.getClases().get(0);
        String contenidoMain = generadorJava.generarMain(primeraClase);
        String nombreArchivoMain = "Main.java";
        boolean exitoMain = organizador.guardarArchivo(nombreArchivoMain, contenidoMain);
        if (exitoMain) {
            interfaceIO.mostrar("Archivo Main.java guardado correctamente");
        } else {
            interfaceIO.mostrar("Error al guardar Main.java");
        }
    }
}

    private String seleccionarTipo() {
        String tipo = "";
        while (true) {
            String opcion = interfaceIO.leer("Seleccione tipo:" +
                                "\n1. String" +
                                "\n2. boolean" +
                                "\n3. void" +
                                "\n4. int" +
                                "\n5. double" +
                                "\n\nEscribe el número de opción:");
            if (opcion.equals("1")) {
                tipo = "String";
                break;
            } else if (opcion.equals("2")) {
                tipo = "boolean";
                break;
            } else if (opcion.equals("3")) {
                tipo = "void";
                break;
            } else if (opcion.equals("4")) {
                tipo = "int";
                break;
            } else if (opcion.equals("5")) {
                tipo = "double";
                break;
            } else {
                interfaceIO.mostrar("Opción inválida. Intente de nuevo.");
            }
        }
        return tipo;
    }

    private String seleccionarVisibilidad() {
        String vis = "";
        while (true) {
            String opcion = interfaceIO.leer("Seleccione visibilidad:" +
                                "\n1. publico" +
                                "\n2. privado" +
                                "\n3. protegido" +
                                "\n\nEscribe el número de opción:");
            if (opcion.equals("1")) {
                vis = "publico";
                break;
            } else if (opcion.equals("2")) {
                vis = "privado";
                break;
            } else if (opcion.equals("3")) {
                vis = "protegido";
                break;
            } else {
                interfaceIO.mostrar("Opción inválida. Intente de nuevo.");
            }
        }
        return vis;
    }
}
