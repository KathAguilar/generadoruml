package generadoruml;
import javax.swing.JOptionPane;

public class PopUpIO implements InterfaceIO {
    @Override
    public String leer(String mensaje) {
        return JOptionPane.showInputDialog(mensaje);
    }
    
    @Override
    public void mostrar(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}


