package generadoruml;

public class GeneradorJava {

    public String organizarJava(Clase c) {
        StringBuilder codigo = new StringBuilder();
        codigo.append("public class ").append(c.getNombre()).append(" {\n");

        for (Atributo a : c.getAtributos()) {
            codigo.append("    ")
                  .append(visibilidad(a.getVisibilidad())).append(" ")
                  .append(a.getTipo()).append(" ")
                  .append(a.getNombre()).append(";\n");
        }

        for (Metodo m : c.getMetodos()) {
            codigo.append("    ")
                  .append(visibilidad(m.getVisibilidad())).append(" ")
                  .append(m.getTipo()).append(" ")
                  .append(m.getNombre()).append("() {}\n");
        }

        codigo.append("}\n");
        return codigo.toString();
    }

    public String generarMain(Clase c) {
        return "public class Main {\n"
             + "    public static void main(String[] args) {\n"
             + "        " + c.getNombre() + " obj = new " + c.getNombre() + "();\n"
             + "        System.out.println(\"Clase " + c.getNombre() + " creada correctamente.\");\n"
             + "    }\n"
             + "}";
    }

    private String visibilidad(String vis) {
        if (vis == null) return "public";
        switch (vis.toLowerCase()) {
            case "privado": return "private";
            case "protegido": return "protected";
            case "publico": return "public";
            default: return "public";
        }
    }
}
