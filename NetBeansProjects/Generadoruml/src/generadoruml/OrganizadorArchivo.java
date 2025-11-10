package generadoruml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OrganizadorArchivo {

    // Crea un archivo .txt con el nombre indicado
    public boolean crearArchivo(String nombreArchivo) {
        try {
            File archivo = new File(nombreArchivo + ".txt");
            if (archivo.createNewFile()) {
                return true; // se creó correctamente
            } else {
                return false; // ya existía
            }
        } catch (IOException e) {
            return false;
        }
    }

    // Guarda texto dentro de un archivo (sin interacción directa)
    public boolean guardarArchivo(String rutaArchivo, String contenido) {
        try (FileWriter escritor = new FileWriter(rutaArchivo, true)) { // true = agregar al final
            escritor.write(contenido + System.lineSeparator());
            return true; // se guardó correctamente
        } catch (IOException e) {
            return false; // hubo error al guardar
        }
    }

    // Verifica si un archivo existe en la ruta dada
    public boolean verificarArchivo(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        return archivo.exists();
    }
}
