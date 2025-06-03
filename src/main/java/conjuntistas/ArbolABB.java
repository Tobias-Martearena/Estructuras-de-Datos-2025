package main.java.conjuntistas;

public class ArbolABB {

    private NodoABB raiz;

    public ArbolABB(){
        this.raiz = null;
    }

    public boolean insertar(Comparable elemento){
        boolean exito = true;
        if(this.raiz == null){
            this.raiz = new NodoABB(elemento);
        }else{
            exito = insertarAux(this.raiz, elemento);
        }
        return exito;
    }

    public boolean insertarAux(NodoABB nodo, Comparable elem) {
        boolean exito = true;
        if ((elem.compareTo(nodo.getElem())) == 0) {
            exito = false;
        } else if (elem.compareTo(nodo.getElem()) < 0) {
            if (nodo.getIzquierdo() != null) {
                exito = insertarAux(nodo.getIzquierdo(), elem);
            } else {
                nodo.setIzquierdo(new NodoABB(elem));
            }
        } else {
            if (nodo.getDerecho() != null) {
                exito = insertarAux(nodo.getDerecho(), elem);
            } else {
                nodo.setDerecho(new NodoABB(elem));
            }
        }
        return exito;
    }
}
