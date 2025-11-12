package generadoruml;

public class Logica {
    private GeneradorUML generadorUML;
    private GeneradorJava generadorJava;

    public Logica() {
        this.generadorUML = new GeneradorUML();
        this.generadorJava = new GeneradorJava();
    }

    public String generarUML(Modelo modelo) {
        return generadorUML.organizarUML(modelo);
    }

    public String generarJava(Clase c) {
        return generadorJava.organizarJava(c);
    }
}

