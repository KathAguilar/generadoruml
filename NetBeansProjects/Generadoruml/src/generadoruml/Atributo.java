
package generadoruml;

class Atributo {
private final String nombre; 
private final String tipo; //falta definir los tipos posibles
private final String visibilidad; 
public Atributo(String nombre, String tipo, String visibilidad){
    this.nombre = nombre;
    this.tipo = tipo;
    this.visibilidad = visibilidad;
}
public String getNombre(){
    return nombre;
    }
public String getTipo(){
    return tipo;
    }
public String getVisibilidad(){
    return visibilidad;
}


}