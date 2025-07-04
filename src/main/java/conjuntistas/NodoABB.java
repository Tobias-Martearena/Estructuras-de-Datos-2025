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

    public Comparable getElem(){
        return this.elem;
    }

    public NodoABB getIzquierdo(){
        return this.izquierdo;
    }

    public NodoABB getDerecho(){
        return this.derecho;
    }

    public void setElem(Comparable elemento){
        this.elem = elemento;
    }

    public void setIzquierdo(NodoABB hijoIzq){
        this.izquierdo = hijoIzq;
    }

    public void setDerecho(NodoABB hijoDer){
        this.derecho = hijoDer;
    }
}
