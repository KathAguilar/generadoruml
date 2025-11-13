package generadoruml;

public class GeneradorJava {

    // Genera el código de la clase UML
    public String organizarJava(Clase c) {
        String codigo = "public class " + c.getNombre() + " {\n";
        for (Atributo a : c.getAtributos()) {
            codigo += "    " + visibilidad(a.getVisibilidad()) + " " + a.getTipo() + " " + a.getNombre() + ";\n";
        }
        for (Metodo m : c.getMetodos()) {
            codigo += "    " + visibilidad(m.getVisibilidad()) + " " + m.getTipo() + " " + m.getNombre() + "() {\n    }\n";
        }
        codigo += "}\n";
        return codigo;
    }

    // Genera el código de Main.java por separado
    public String generarMain(Clase c) {
    String main = "public class Main {\n"
            + "    public static void main(String[] args) {\n"
            + "        " + c.getNombre() + " obj = new " + c.getNombre() + "();\n"
            + "        System.out.println(\"Clase " + c.getNombre() + " creada correctamente.\");\n"
            + "    }\n"
            + "}\n";
    return main;
}

    private String visibilidad(String visibilidad) {
        visibilidad = visibilidad.toLowerCase();
        if (visibilidad.contains("privado")) return "private";
        if (visibilidad.contains("protegido")) return "protected";
        if (visibilidad.contains("publico")) return "public";
        return "public";
    }
}
