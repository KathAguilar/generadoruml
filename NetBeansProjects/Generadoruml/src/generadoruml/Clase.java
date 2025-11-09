package generadoruml;
import java.util.List;
import java.util.ArrayList; 

public class Clase {
private String nombre;
private List<Atributo> atributos; 
private List<Metodo> metodos;
    public Clase(String nombre) {
        this.nombre = nombre;
        this.atributos = new ArrayList<>();
        this.metodos =new ArrayList<>();
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
}
