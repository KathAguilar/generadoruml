package generadoruml;
public class GeneradorJava {
    public String organizarJava(Clase c) {
        String codigo = "public class " + c.getNombre() + " {\n";
        for (Atributo a : c.getAtributos()) {
            codigo += "    " + visibilidad(a.getVisibilidad()) + " " + a.getTipo() + " " + a.getNombre() + ";\n";
        }
        for (Metodo m : c.getMetodos()) {
            codigo += "    " + visibilidad(m.getVisibilidad()) + " " + m.getTipo() + " " + m.getNombre() + "() {\n    }\n";
        }
        codigo += "}";
        return codigo;
    }

    private String visibilidad(String visibilidad) {
        visibilidad = visibilidad.toLowerCase();
        if (visibilidad.contains("privado")) return "private";
        if (visibilidad.contains("protegido")) return "protected";
        if (visibilidad.contains("publico")) return "public";
        return "public";
    }
}

