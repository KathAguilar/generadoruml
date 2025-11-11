
package generadoruml;

public class GeneradorUML {

    public void organizarUML(Modelo modelo) {
        OrganizadorArchivo archivo = new OrganizadorArchivo();
        archivo.crearArchivo("uml");
        String uml = "@startuml\n";
        

        for (Clase c : modelo.getClases()) {
            uml += "class " + c.getNombre() + " {\n";
            for (Atributo a : c.getAtributos()) {
                uml += " " + a.getVisibilidad() + " " + a.getNombre() + " : " + a.getTipo() + "\n";
            }
            for (Metodo m : c.getMetodos()) {
                uml += " " + m.getVisibilidad() + " " + m.getNombre() + "() : " + m.getTipo() + "\n";
            }
            uml += "}\n\n";
        }

        for (Relacion r : modelo.getRelaciones()) {
            String flecha = "-->";
            if (r.getTipo().equalsIgnoreCase("herencia")) {
                flecha = "<|--";
            } else if (r.getTipo().equalsIgnoreCase("asociacion")) {
                flecha = "--";
            } else if (r.getTipo().equalsIgnoreCase("dependencia")) {
                flecha = "..>";
            } else if (r.getTipo().equalsIgnoreCase("implementacion")) {
                flecha = "<|..";
            }
            uml += r.getOrigen() + " " + flecha + " " + r.getDestino() + " : " + r.getTipo() + "\n";
        }

        uml += "@enduml";
        archivo.guardarArchivo("uml.txt", uml);
        System.out.println("UML.txt generado correctamente.");
    }
}
