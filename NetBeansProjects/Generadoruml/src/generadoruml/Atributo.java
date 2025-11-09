
package generadoruml;

class Atributo {
private final String nombre; 
private final String tipodato; //falta definir los tipos posibles

public Atributo(String nombre, String tipodato){
    this.nombre = nombre;
    this.tipodato = tipodato;
}
public String getnombre(){
    return nombre;
    }
public String getdato(){
    return tipodato;
    }


}