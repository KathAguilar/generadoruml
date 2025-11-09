
package generadoruml;

class Atributo {
private final String nombre; 
private final String tipodato; //falta definir los tipos posibles
private final String visibilidad; 
public Atributo(String nombre, String tipodato, String visibilidad){
    this.nombre = nombre;
    this.tipodato = tipodato;
    this.visibilidad = visibilidad;
}
public String getNombre(){
    return nombre;
    }
public String getDato(){
    return tipodato;
    }
public String getVisibilidad(){
    return visibilidad;
}


}