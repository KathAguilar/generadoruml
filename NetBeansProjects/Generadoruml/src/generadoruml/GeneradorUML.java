package generadoruml;
//
public class GeneradorUML {
    public String organizarUML(Modelo modelo) {
        String texto = "@startuml\n";

        for (Clase c : modelo.getClases()) {
            texto += "class " + c.getNombre() + " {\n";
            for (Atributo a : c.getAtributos()) {
                texto += " " + vis(a.getVisibilidad()) + " " + a.getNombre() + " : " + a.getTipo() + "\n";
            }
            for (Metodo m : c.getMetodos()) {
                texto += " " + vis(m.getVisibilidad()) + " " + m.getNombre() + "() : " + m.getTipo() + "\n";
            }
            texto += "}\n";
        }
        for (Relacion r : modelo.getRelaciones()) {
            String f = "..>";
            if (r.getTipo().equalsIgnoreCase("es un")) f = "<|--";
            if (r.getTipo().equalsIgnoreCase("posee")) f = "--";
            if (r.getTipo().equalsIgnoreCase("usa")) f = "..>";
            texto += r.getOrigen() + " " + f + " " + r.getDestino() + " : " + r.getTipo() + "\n";
        }
        texto += "@enduml";
        return texto;
    }

    private String vis(String v) {
        if (v == null) return "+";
        switch (v.toLowerCase()) {
            case "privado": return "-";
            case "protegido": return "#";
            case "publico": return "+";
            default: return "+";
        }
    }
}
