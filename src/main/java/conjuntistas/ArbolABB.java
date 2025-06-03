package main.java.conjuntistas;

import main.java.lineales.dinamicas.Lista;

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

    public boolean esVacio(){
        return (this.raiz == null);
    }

    public Lista listar(){
        Lista lista = new Lista();
        listarAux(this.raiz, lista);
        return lista;
    }

    private void listarAux(NodoABB nodo, Lista lis){
        if(nodo.getElem() != null){
            listarAux(nodo.getIzquierdo(), lis);
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
            listarAux(nodo.getDerecho(), lis);
        }
    }

    public Lista listarRango(Comparable minimo, Comparable maximo){
        Lista lista = new Lista();
        listarRangoAux(this.raiz, minimo, maximo, lista);
        return lista;
    }

    private void listarRangoAux(NodoABB nodo, Comparable min, Comparable max, Lista lis){
        if(nodo.getElem() != null){
            if(min.compareTo(nodo.getElem()) < 0){
                listarRangoAux(nodo.getIzquierdo(), min, max, lis);
            }
            if(min.compareTo(nodo.getElem()) <= 0 && max.compareTo(nodo.getElem()) >= 0){
                lis.insertar(nodo.getElem(), lis.longitud() + 1);
            }
            if(max.compareTo(nodo.getElem()) > 0){
                listarRangoAux(nodo.getDerecho(), min, max, lis);
            }
        }
    }

    public Comparable minimoElem(){
        return minimoElemAux(this.raiz);
    }

    private Comparable minimoElemAux(NodoABB nodo){
        Comparable retorno = null;
        if(nodo.getElem() != null){
            if(nodo.getIzquierdo() == null){
                retorno = nodo.getElem();
            }else{
                retorno = minimoElemAux(nodo.getIzquierdo());
            }
        }
        return retorno;
    }
}
