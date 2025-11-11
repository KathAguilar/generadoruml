package generadoruml;
import java.util.List;
import java.util.ArrayList; 

public class Clase {
private String nombre;
private final String visibilidad;
private final List<Atributo> atributos; 
private final List<Metodo> metodos;


    public Clase(String nombre, String visibilidad) {
        this.nombre = nombre;
        this.atributos = new ArrayList<>();
        this.metodos =new ArrayList<>();
        this.visibilidad = visibilidad;
       
    }
    public void agregarAtributo(Atributo atributo){
        atributos.add(atributo);
    }
    public void agregarMetodo(Metodo metodo){
        metodos.add(metodo);
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    } 
    public List<Atributo> getAtributos(){
   return atributos;
    }
     public List<Metodo> getMetodos(){
   return metodos;
     }
    public String getVisibilidad(){
        return visibilidad;
    }   
}
