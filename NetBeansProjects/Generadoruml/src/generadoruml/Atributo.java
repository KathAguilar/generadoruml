
package generadoruml;

class Atributo {
private final String nombre; 
private final String tipodato; //falta definir los tipos posibles
private String visibilidad; 
public Atributo(String nombre, String tipodato, String visibilidad){
    this.nombre = nombre;
    this.tipodato = tipodato;
    this.visibilidad = visibilidad;
}
public String getnombre(){
    return nombre;
    }
public String getdato(){
    return tipodato;
    }
public String getvisibilidad(){
    return visibilidad;
}


}