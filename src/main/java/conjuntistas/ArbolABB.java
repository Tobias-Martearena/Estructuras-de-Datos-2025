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

    private boolean insertarAux(NodoABB nodo, Comparable elem) {
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

    //Meotod Eliminar a terminar, es muy complicado...
    /* 
    public boolean eliminar(Comparable elemento){
        return eliminarAux(this.raiz, elemento);
    }

    private boolean eliminarAux(NodoABB nodo, Comparable elem){
        boolean exito = true;
        if(nodo.getElem() != null){
            if(elem.compareTo(nodo.getElem()) == 0){

            }
        }
        return exito;
    }
    */

    public boolean pertenece(Comparable elemento){
        return perteneceAux(this.raiz, elemento);
    }

    private boolean perteneceAux(NodoABB nodo, Comparable elem){
        boolean exito = false;
        if(nodo.getElem() != null){
            if(elem.compareTo(nodo.getElem()) == 0){
                exito = true;
            }else{
                if(elem.compareTo(nodo.getElem()) < 0){
                    if(nodo.getIzquierdo() != null){
                        exito = perteneceAux(nodo.getIzquierdo(), elem);
                    }
                }else{
                    if(nodo.getDerecho() != null){
                        exito = perteneceAux(nodo.getDerecho(), elem);
                    }
                }
            }
        }
        return exito;
    }
}
