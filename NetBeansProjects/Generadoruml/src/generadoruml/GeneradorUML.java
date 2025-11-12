package generadoruml;

public class GeneradorUML {

    public String hacerUML(Modelo modelo) {
        String texto = "@startuml\n"; 

        // recorre toooodas las clases
        for (Clase c : modelo.getClases()) {
            texto = texto + "class " + c.getNombre() + " {\n";

         
            for (Atributo a : c.getAtributos()) {
                texto = texto + " " + vis(a.getVisibilidad()) + " " + a.getNombre() + " : " + a.getTipo() + "\n";
            }

            for (Metodo m : c.getMetodos()) {
                texto = texto + " " + vis(m.getVisibilidad()) + " " + m.getNombre() + "() : " + m.getTipo() + "\n";
            }
            texto = texto + "}\n"; 
        }
        for (Relacion r : modelo.getRelaciones()) {
            String f = "..>"; // usa por defecto 
            if (r.getTipo().equalsIgnoreCase("es un")) f = "<|--";
            if (r.getTipo().equalsIgnoreCase("posee")) f = "--";
            if (r.getTipo().equalsIgnoreCase("usa")) f = "..>";

            texto = texto + r.getOrigen() + " " + f + " " + r.getDestino() + " : " + r.getTipo() + "\n";
        }

        texto = texto + "@enduml"; 
        return texto;
    }
    private String vis(String v) {
        if (v == null) return "+";

      switch(v.toLowerCase()) {
            case "privado":
                return "-";
            case "protegido":
                return "#";
            case "publico": 
                return "+";
            default:
                return "+";
    }
    }
}