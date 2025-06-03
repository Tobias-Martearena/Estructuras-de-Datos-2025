package main.java.conjuntistas;

public class NodoABB {
    private Comparable elem;
    private NodoABB izquierdo;
    private NodoABB derecho;

    public NodoABB(Comparable elemento){
        this.elem = elemento;
        this.izquierdo = null;
        this.derecho = null;
    }

    public NodoABB(Comparable elemento, NodoABB hijoIzq, NodoABB hijoDer){
        this.elem = elemento;
        this.izquierdo = hijoIzq;
        this.derecho = hijoDer;
    }
}
