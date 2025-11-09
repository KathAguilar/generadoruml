
        package generadoruml;

        class Metodo {
            private final String nombre;
            private final String tipodato;
            private final String visibilidad;

        public Metodo(String nombre, String tipodato, String visibilidad){
            this.nombre = nombre; 
            this.tipodato = tipodato;
            this.visibilidad = visibilidad;
        }
        public String getNombre() {
            return nombre;
        }
        public String getTipoDato() {
            return tipodato;
        }
        public String getVisibilidad(){
            return visibilidad;
        }
        }
