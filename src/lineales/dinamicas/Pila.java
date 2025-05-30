package lineales.dinamicas;

public class Pila {
    private Nodo tope;

    public Pila(){
        this.tope = null;
    }

    public boolean apilar(Object nuevoElem){
        Nodo nuevo = new Nodo(nuevoElem, this.tope);
        this.tope = nuevo;
        return true;
    }

    public boolean desapilar(){
        boolean exito = false;
        if(this.tope != null){
            this.tope = this.tope.getEnlace();
            exito = true;
        }
        return exito;
    }

    public Object obtenerTope(){
        Object elem = null;
        if(this.tope != null){
            elem = this.tope.getElemento();
        }
        return elem;
    }

    public boolean esVacia(){
        boolean exito = false;
        if(this.tope == null){
            exito = true;
        }
        return exito;
    }

    public void vaciar(){
        this.tope = null;
    }

    public Pila clone(){
        Pila clone = new Pila();
        Nodo aux = this.tope;
        Pila pilaAux = new Pila();

        while (aux != null){
            pilaAux.apilar(aux.getElemento());
            aux = aux.getEnlace();
        }
        aux = pilaAux.tope;

        while(aux != null){
            clone.apilar(aux.getElemento());
            aux = aux.getEnlace();
        }
        return clone;
    }

    public String toString(){
        String salida = "[";
        Nodo aux = this.tope;

        while (aux != null){
            salida += aux.getElemento();

            if(aux.getEnlace() != null){
                salida += ",";
            }
            aux = aux.getEnlace();
        }
        salida += "]";
        return salida;
    }
}
