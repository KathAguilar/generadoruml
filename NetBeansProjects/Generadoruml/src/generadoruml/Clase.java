package generadoruml;
//
import java.util.ArrayList;
import java.util.List;

public class Clase {
    private String nombre;
    private String visibilidad;
    private List<Atributo> atributos;
    private List<Metodo> metodos;

    public Clase(String nombre, String visibilidad) {
        this.nombre = nombre;
        this.visibilidad = visibilidad;
        this.atributos = new ArrayList<>();
        this.metodos = new ArrayList<>();
    }

    public void agregarAtributo(Atributo atributo) {
        atributos.add(atributo);
    }

    public void agregarMetodo(Metodo metodo) {
        metodos.add(metodo);
    }

    public String getNombre() {
        return nombre;
    }

    public String getVisibilidad() {
        return visibilidad;
    }

    public List<Atributo> getAtributos() {
        return atributos;
    }

    public List<Metodo> getMetodos() {
        return metodos;
    }
}
