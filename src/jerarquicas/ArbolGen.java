package jerarquicas;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;

public class ArbolGen {

    private NodoGen raiz;

    public ArbolGen() {
        this.raiz = null;
    }

    public boolean insertar(Object elem, Object elemPadre) {
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoGen(elem);
        } else {
            NodoGen padre = obtenerNodo(this.raiz, elemPadre);
            if (padre != null) {
                NodoGen nuevoNodo = new NodoGen(elem);
                NodoGen hijo = padre.getHijoIzquierdo();
                if (hijo == null) {
                    padre.setHijoIzquierdo(nuevoNodo);
                } else {
                    while (hijo.getHermanoDerecho() != null) {
                        hijo = hijo.getHermanoDerecho();
                    }
                    hijo.setHermanoDerecho(nuevoNodo);
                }
            }
        }
        return exito;
    }

    public NodoGen obtenerNodo(NodoGen nodo, Object elemPadre) {
        NodoGen nodoPadre = null;
        if (nodo != null) {
            if (nodo.getElem() == elemPadre) {
                nodoPadre = nodo;
            } else {
                nodo = nodo.getHijoIzquierdo();
                while (nodo != null && nodoPadre == null) {
                    nodoPadre = obtenerNodo(nodo, elemPadre);
                    nodo = nodo.getHermanoDerecho();
                }
            }
        }
        return nodoPadre;
    }

    public boolean insertarPorPosicion(Object elem, int posicion) {
        boolean exito = false;
        if (posicion > 0) {
            int[] arreglo = new int[1];
            arreglo[0] = 1;
            exito = insertarPorPosicionAux(this.raiz, elem, arreglo, posicion);
        }
        return exito;
    }

    public boolean insertarPorPosicionAux(NodoGen nodo, Object elemento, int[] matriz, int pos) {
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoGen(elemento);
        } else {
            NodoGen padre = obtenerNodoPorPos(this.raiz, pos, matriz);
            if (padre != null) {
                NodoGen nuevoNodo = new NodoGen(elemento);
                NodoGen hijo = padre.getHijoIzquierdo();
                if (hijo == null) {
                    padre.setHijoIzquierdo(nuevoNodo);
                } else {
                    while (hijo.getHermanoDerecho() != null) {
                        hijo = hijo.getHermanoDerecho();
                    }
                    hijo.setHermanoDerecho(nuevoNodo);
                }
            }
        }
        return exito;
    }

    private NodoGen obtenerNodoPorPos(NodoGen nodo, int posicion, int[] arreglo) {
        NodoGen nodoRes = null;
        if (nodo != null) {
            if (arreglo[0] == posicion) {
                nodoRes = nodo;
            } else {
                NodoGen hijo = nodo.getHijoIzquierdo();
                while (hijo != null && nodoRes == null) {
                    arreglo[0] = arreglo[0] + 1;
                    nodoRes = obtenerNodoPorPos(hijo, posicion, arreglo);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
        return nodoRes;
    }

    public boolean pertenece(Object elemento) {
        boolean exito = perteneceAux(this.raiz, elemento);
        return exito;
    }

    private boolean perteneceAux(NodoGen nodo, Object elem) {
        boolean exito = false;
        if (nodo != null) {
            if (nodo.getElem().equals(elem)) {
                exito = true;
            } else {
                NodoGen hijo = nodo.getHijoIzquierdo();

                while (hijo != null && exito == false) {
                    exito = perteneceAux(hijo, elem);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
        return exito;
    }

    public Lista ancestros(Object elemento) {
        Lista lista = new Lista();
        ancestrosAux(this.raiz, elemento, lista);
        return lista;
    }

    private boolean ancestrosAux(NodoGen nodo, Object elem, Lista lis) {
        boolean exito = false;
        if (nodo != null) {
            if (nodo.getElem().equals(elem)) {
                exito = true;
            } else {
                NodoGen hijo = nodo.getHijoIzquierdo();

                while (hijo != null && exito == false) {
                    exito = ancestrosAux(hijo, elem, lis);
                    hijo = hijo.getHermanoDerecho();
                }
                if (exito == true) {
                    lis.insertar(nodo.getElem(), lis.longitud() + 1);
                }
            }
        }
        return exito;
    }

    public boolean esVacio() {
        return (this.raiz == null);
    }

    public int altura() {
        return alturaAux(this.raiz);
    }

    private int alturaAux(NodoGen nodo) {
        int respuesta = -1;
        if (nodo != null) {
            NodoGen hijo = nodo.getHijoIzquierdo();
            while (hijo != null) {
                int alturaHijo = alturaAux(hijo);
                if (alturaHijo > respuesta) {
                    respuesta = alturaHijo;
                }
                hijo = hijo.getHermanoDerecho();
            }
            respuesta++;
        }
        return respuesta;
    }

    public int nivel(Object elemento) {
        return nivelAux(this.raiz, elemento, -1);
    }

    private int nivelAux(NodoGen nodo, Object elem, int alt) {
        int nivel = -1;
        if (nodo != null) {
            if (nodo.getElem().equals(elem)) {
                nivel = alt + 1;
            } else {
                NodoGen hijo = nodo.getHijoIzquierdo();
                while (hijo != null && nivel == -1) {
                    nivel = nivelAux(hijo, elem, alt + 1);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
        return nivel;
    }

    public Object padre(Object elemento) {
        return padreAux(this.raiz, elemento);
    }

    private Object padreAux(NodoGen nodo, Object elem) {
        Object padre = null;
        if (nodo != null) {
            NodoGen hijo = nodo.getHijoIzquierdo();
            if (hijo != null) {
                while (hijo != null && padre == null) {
                    if (hijo.getElem().equals(elem)) {
                        padre = nodo.getElem();
                    }
                    hijo = hijo.getHermanoDerecho();
                }
                if (padre == null) {
                    hijo = nodo.getHijoIzquierdo();
                    while (hijo != null && padre == null) {
                        padre = padreAux(hijo, elem);
                        hijo = hijo.getHermanoDerecho();
                    }
                }
            }
        }
        return padre;
    }

    public Lista listarPreorden(){
        Lista lista = new Lista();
        listarPreordenAux(this.raiz, lista);
        return lista;
    }

    private void listarPreordenAux(NodoGen nodo, Lista lis){
        if(nodo != null){
            lis.insertar(nodo.getElem(), lis.longitud()+1);
            NodoGen hijo = nodo.getHijoIzquierdo();
            while(hijo != null){
                listarPreordenAux(hijo, lis);
                hijo = hijo.getHermanoDerecho();
            }
        }
    }

    public Lista listarPosorden(){
        Lista lista = new Lista();
        listarPosordenAux(this.raiz, lista);
        return lista;
    }

    private void listarPosordenAux(NodoGen nodo, Lista lis){
        if(nodo != null){
            NodoGen hijo = nodo.getHijoIzquierdo();
            while(hijo != null){
                listarPosordenAux(hijo, lis);
                hijo = hijo.getHermanoDerecho();
            }
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
        }
    }

    public Lista listarInorden(){
        Lista lista = new Lista();
        listarInordenAux(this.raiz, lista);
        return lista;
    }

    private void listarInordenAux(NodoGen nodo, Lista lis){
        if(nodo != null){
            NodoGen primerHijo = nodo.getHijoIzquierdo();
            if(primerHijo != null){
                listarInordenAux(primerHijo, lis);
            }
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
            NodoGen hermano;
            if(primerHijo != null){
                hermano = primerHijo.getHermanoDerecho();
            }else{
                hermano = null;
            }
            while(hermano != null){
                listarInordenAux(hermano, lis);
                hermano = hermano.getHermanoDerecho();
            }
        }
    }

    public Lista listarPorNiveles(){
        Lista lista = new Lista();
        Cola cola = new Cola();
        if(this.raiz != null){
            cola.poner(this.raiz);
            while(!cola.esVacia()){
                NodoGen nodo = (NodoGen)cola.obtenerFrente();
                cola.sacar();
                lista.insertar(nodo.getElem(), lista.longitud() + 1);
                NodoGen hijo = nodo.getHijoIzquierdo();
                while(hijo != null){
                    cola.poner(hijo);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
        return lista;
    }

    public ArbolGen clone(){
        ArbolGen clone = new ArbolGen();
        if(!esVacio()){
            clone.raiz = cloneAux(this.raiz);
        }
        return clone;
    }

    private NodoGen cloneAux(NodoGen nodo){
        NodoGen nuevo = null;
        if(nodo != null){
            nuevo = new NodoGen(nodo.getElem());
            nuevo.setHijoIzquierdo(cloneAux(nodo.getHijoIzquierdo()));
            nuevo.setHermanoDerecho(cloneAux(nodo.getHermanoDerecho()));
        }
        return nuevo;
    }

    public void vaciar(){
        this.raiz = null;
    }

    public String toString(){
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoGen nodo){
        String s = "";
        if(nodo != null){
            s += nodo.getElem().toString() + " -> ";
            NodoGen hijo = nodo.getHijoIzquierdo();
            while(hijo != null){
                s += hijo.getElem().toString() + " ";
                hijo = hijo.getHermanoDerecho();
            }
            //comienza recorrido de los hijos de nodo llamado recursivamente
            //para que cada hijo agregue su subcadena a la general
            hijo = nodo.getHijoIzquierdo();
            while(hijo != null){
                s += "\n" + toStringAux(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return s;
    }
}
