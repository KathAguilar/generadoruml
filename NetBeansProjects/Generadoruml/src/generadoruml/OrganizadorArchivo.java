package generadoruml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OrganizadorArchivo {

    public boolean guardarArchivo(String rutaArchivo, String contenido) {
        try (FileWriter escritor = new FileWriter(rutaArchivo, false)) { // false = sobrescribir
            escritor.write(contenido);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean verificarArchivo(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        return archivo.exists();
    }
}

