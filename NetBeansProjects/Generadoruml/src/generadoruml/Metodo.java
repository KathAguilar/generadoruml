package generadoruml;

public class Metodo {
    private String nombre;
    private String tipo;
    private String visibilidad;

    public Metodo(String nombre, String tipo, String visibilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.visibilidad = visibilidad;
    }

    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public String getVisibilidad() { return visibilidad; }
}
