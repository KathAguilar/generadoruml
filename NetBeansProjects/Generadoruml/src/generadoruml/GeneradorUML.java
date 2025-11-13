package generadoruml;

public class GeneradorUML {

    public String organizarUML(Modelo modelo) {
        StringBuilder texto = new StringBuilder("@startuml\n");

        for (Clase c : modelo.getClases()) {
            texto.append("class ").append(c.getNombre()).append(" {\n");
            for (Atributo a : c.getAtributos()) {
                texto.append(" ").append(vis(a.getVisibilidad()))
                     .append(" ").append(a.getNombre())
                     .append(" : ").append(a.getTipo()).append("\n");
            }
            for (Metodo m : c.getMetodos()) {
                texto.append(" ").append(vis(m.getVisibilidad()))
                     .append(" ").append(m.getNombre())
                     .append("() : ").append(m.getTipo()).append("\n");
            }
            texto.append("}\n");
        }

        for (Relacion r : modelo.getRelaciones()) {
            String f = "..>";
            if (r.getTipo().equalsIgnoreCase("es un")) f = "<|--";
            if (r.getTipo().equalsIgnoreCase("posee")) f = "--";
            texto.append(r.getOrigen()).append(" ").append(f)
                 .append(" ").append(r.getDestino())
                 .append(" : ").append(r.getTipo()).append("\n");
        }

        texto.append("@enduml");
        return texto.toString();
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

