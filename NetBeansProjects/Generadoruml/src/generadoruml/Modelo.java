package generadoruml;
import java.util.List;
import java.util.ArrayList;

public class Modelo {
private List<Clase> clases; 
private List<Relacion> relaciones;

public Modelo(){
    this.clases = new ArrayList<>();
    this.relaciones = new ArrayList<>();
    
}
public void crearclase(Clase clase){
    clases.add(clase);
}
public void crearrelacion (Relacion relacion){
  relaciones.add(relacion);
}
    public List<Clase> getClases() {
        return clases;
    }

    public List<Relacion> getRelaciones() {
        return relaciones;
    }
}
