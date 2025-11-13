package generadoruml;

public class Atributo {
    private String nombre;
    private String tipo;
    private String visibilidad;

    public Atributo(String nombre, String tipo, String visibilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.visibilidad = visibilidad;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getVisibilidad() { return visibilidad; }
    public void setVisibilidad(String visibilidad) { this.visibilidad = visibilidad; }
}
