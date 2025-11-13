
package generadoruml;
import java.util.Scanner;
//
public class ConsolaIO implements InterfaceIO{
    private Scanner scanner = new Scanner(System.in); //declaracioon
    @Override
    public String leer(String mensaje) {
        System.out.println(mensaje);
        return scanner.nextLine();
    }
    @Override
    public void mostrar(String mensaje) {
        System.out.println(mensaje);
    
    }
}

