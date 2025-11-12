package generadoruml;

public class Logica {

    private GeneradorUML generadorUML;
    private GeneradorJava generadorJava;

    public Logica() {
        this.generadorUML = new GeneradorUML();
        this.generadorJava = new GeneradorJava();
    }

    // Generar UML a partir del modelo
    public String generarUML(Modelo modelo) {
        if (modelo == null) {
            return "Error: No hay modelo para generar UML.";
        }
        return generadorUML.organizarUML(modelo);
    }

    // Generar código Java a partir del modelo
    public String generarJava(Modelo modelo) {
        if (modelo == null) {
            return "Error: No hay modelo para generar código Java.";
        }
        return generadorJava.organizarJava(modelo);
    }
}
