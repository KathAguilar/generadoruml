package generadoruml;

public class GeneradorUML {

    public String organizarUML(Modelo modelo) {
        String uml = "@startuml\n";
        
        for (Clase c : modelo.getClases()) {
            uml += "class " + c.getNombre() + " {\n";
            for (Atributo a : c.getAtributos()) {
                uml += " " + simbolo(a.getVisibilidad()) + " " + a.getNombre() + " : " + a.getTipo() + "\n";
            }
            for (Metodo m : c.getMetodos()) {
                uml += " " + simbolo(m.getVisibilidad()) + " " + m.getNombre() + "() : " + m.getTipo() + "\n";
            }
            uml += "}\n";
        }

        for (Relacion r : modelo.getRelaciones()) {
            String flecha = "..>"; 
            
            if (r.getTipo().equalsIgnoreCase("es un")) {
                flecha = "<|--"; 
            } else if (r.getTipo().equalsIgnoreCase("posee")) {
                flecha = "--"; 
            } else if (r.getTipo().equalsIgnoreCase("usa")) {
                flecha = "..>"; 
            }

            uml += r.getOrigen() + " " + flecha + " " + r.getDestino() + " : " + r.getTipo() + "\n";
        }

        uml += "@enduml";
        return uml;
    }

    private String simbolo(String visibilidad) { //traduce visibilidad
        if (visibilidad == null) {
            return "+";
        }
        switch(visibilidad.toLowerCase()) {
            case "privado": case "private":
                return "-";
            case "protegido": case "protected":
                return "#";
            case "publico": case "público": case "public":
                return "+";
        }
    
    }
}