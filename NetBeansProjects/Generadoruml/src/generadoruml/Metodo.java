
        package generadoruml;

        class Metodo {
            private final String nombre;
            private final String tipo;
            private final String visibilidad;

        public Metodo(String nombre, String tipo, String visibilidad){
            this.nombre = nombre; 
            this.tipo = tipo;
            this.visibilidad = visibilidad;
        }
        public String getNombre() {
            return nombre;
        }
        public String getTipo() {
            return tipo;
        }
        public String getVisibilidad(){
            return visibilidad;
        }
        }
