package generadoruml;

import java.util.ArrayList;
import java.util.List;

public class Modelo {
    private List<Clase> clases;
    private List<Relacion> relaciones;

    public Modelo() {
        this.clases = new ArrayList<>();
        this.relaciones = new ArrayList<>();
    }

    public void crearClase(Clase clase) {
        clases.add(clase);
    }

    public void crearRelacion(Relacion relacion) {
        relaciones.add(relacion);
    }

    public List<Clase> getClases() { return clases; }
    public List<Relacion> getRelaciones() { return relaciones; }
}
