package generadoruml;

public class Relacion {
    private String origen;
    private String destino;
    private String tipo;

    public Relacion(String origen, String destino, String tipo) {
        this.origen = origen;
        this.destino = destino;
        this.tipo = tipo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
