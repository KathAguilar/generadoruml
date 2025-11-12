package generadoruml;
public class Relacion {

    private final String origen;
    private final String destino;
    private final String tipo;

    public Relacion(String origen, String destino, String tipo) {
        this.origen = origen;
        this.destino = destino;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }
}
