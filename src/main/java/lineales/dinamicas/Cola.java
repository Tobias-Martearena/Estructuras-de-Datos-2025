package main.java.lineales.dinamicas;

public class Cola {
    private Nodo frente;
    private Nodo fin;

    public Cola(){
        this.frente = null;
        this.fin = null;
    }

    public boolean poner(Object unElem){
        Nodo nuevo = new Nodo(unElem, null);
        if(this.frente == null && this.fin == null){
            this.frente = nuevo;
            this.fin = nuevo;
        }else{
            this.fin.setEnlace(nuevo);
            this.fin = this.fin.getEnlace();
        }
        return true;
    }

    public boolean sacar(){
        boolean exito = false;
        if(this.frente != null){
            this.frente = this.frente.getEnlace();
            if(this.frente == null){
                this.fin = null;
            }
            exito = true;
        }
        return exito;
    }

    public Object obtenerFrente(){
        Object elem = null;
        if(this.frente != null){
            elem = this.frente.getElemento();
        }
        return elem;
    }

    public boolean esVacia(){
        boolean exito = false;
        if(this.frente == null && this.fin == null){
            exito = true;
        }
        return exito;
    }

    public void vaciar(){
        this.frente = null;
        this.fin = null;
    }

    public Cola clone(){
        Cola clone = new Cola();
        if(!esVacia()){
            Nodo actual = this.frente.getEnlace();
            Nodo aux = new Nodo(this.frente.getElemento(), null);
            clone.frente = aux;

            while (actual != null) {

                aux.setEnlace(new Nodo(actual.getElemento(), null));
                aux = aux.getEnlace();
                actual = actual.getEnlace();
            }

            clone.fin = aux;
        }
        return clone;
    }

    public String toString() {

        String cadena = "[]";

        if (this.frente != null) {

            cadena = "[";
            Nodo aux = this.frente;

            while (aux != null) {

                cadena = cadena + aux.getElemento();
                aux = aux.getEnlace();

                if (aux != null) {

                    cadena = cadena + ",";
                }
            }

            cadena = cadena + "]";
        }

        return cadena;
    }

    public boolean verificarCola(int t, Cola c){
        boolean exito = true;
        int i =0;
        Pila auxPila = new Pila();
        if(c.verificarLongitud(c, t)){
            while(!c.esVacia() && exito){
                i = 0;
                while(i < t && !c.esVacia()){
                    Object elem = c.obtenerFrente();
                    auxPila.apilar(elem);
                    c.sacar();
                    i++;
                }
                i = 0;
                while( i < t && !c.esVacia() && exito){
                    Object elem = c.obtenerFrente();
                    Object tope = auxPila.obtenerTope();
                    if(tope == null || !tope.equals(elem)){
                        exito = false;
                    }
                    auxPila.desapilar();
                    c.sacar();
                    i++;
                }
            }  
        }else{
            exito = false;
        }
        return exito;
    }

    private boolean verificarLongitud(Cola c, int t){
        int longitud = 0;
        Cola auxCola = new Cola();

        while(!c.esVacia()){
            auxCola.poner(c.obtenerFrente());
            c.sacar();
            longitud++;
        }

        while(!auxCola.esVacia()){
            c.poner(auxCola.obtenerFrente());
            auxCola.sacar();
        }
        return longitud % (2*t) == 0;
    }
}
