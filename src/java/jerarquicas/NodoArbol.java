package java.jerarquicas;

public class NodoArbol {
    Object elemento;
    NodoArbol izquierdo;
    NodoArbol derecho;

    public NodoArbol(Object unElemento){
        this.elemento = unElemento;
        this.izquierdo = null;
        this.derecho = null;
    }

    public NodoArbol(Object unElemento, NodoArbol unIzquierdo, NodoArbol unDerecho){
        this.elemento = unElemento;
        this.izquierdo = unIzquierdo;
        this.derecho = unDerecho;
    }

    public Object getElem(){
        return elemento;
    }

    public NodoArbol getIzquierdo() {
        return izquierdo;
    }

    public NodoArbol getDerecho(){
        return derecho;
    }

    public void setElem(Object unElemento){
        elemento = unElemento;
    }

    public void setIzquierdo(NodoArbol unIzquierdo){
        izquierdo = unIzquierdo;
    }

    public void setDerecho(NodoArbol unDerecho){
        derecho = unDerecho;
    }
}
