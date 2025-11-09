
package generadoruml;

public class Relacion {
    private String origen;
    private String destino;
    private String tipo;


public Relacion (String origen, String destino, String tipo){
    this.origen = origen;
    this.destino = destino;
    this.tipo = tipo;
}
 public String gettipo(){
     return tipo;
 }
 public String getorigen(){
     return origen;
 }
 public String gettdestino(){
     return destino;
 }

}