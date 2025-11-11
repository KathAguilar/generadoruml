
package generadoruml;
import java.io.FileWriter;
import java.io.IOException;

public class GeneradorUML {
 public void organizarUML(Modelo modelo){
    String uml = "@startuml\n"; // salto entre comillas para cadena
  for (Clase nombreclases  : modelo.getClases()) {
            String simbolo = obtenerSimbolo(nombreclases.getVisibilidad());
            uml += simbolo + " class " + nombreclases.getNombre() + " {\n"; // llave abierta para datos de cada clase
        
        
    

}
 
 }   
}
