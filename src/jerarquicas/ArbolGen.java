package jerarquicas;

public class ArbolGen {
    private NodoGen raiz;

    public ArbolGen(){
        this.raiz = null;
    }

    public boolean insertar(Object elem, Object elemPadre){
        boolean exito = true;
        if(this.raiz == null){
            this.raiz = new NodoGen(elem);
        }else{
            NodoGen padre = obtenerNodo(this.raiz, elemPadre);
            if(padre != null){
                NodoGen nuevoNodo = new NodoGen(elem);
                NodoGen hijo = padre.getHijoIzquierdo();
                if(hijo == null){
                    padre.setHijoIzquierdo(nuevoNodo);
                }else{
                    while(hijo.getHermanoDerecho() != null){
                        hijo = hijo.getHermanoDerecho();
                    }
                    hijo.setHermanoDerecho(nuevoNodo);
                }
            }
        }
        return exito;
    }

    public NodoGen obtenerNodo(NodoGen nodo, Object elemPadre){
        NodoGen nodoPadre = null;
        if(nodo != null){
            if(nodo.getElem() == elemPadre){
                nodoPadre = nodo;
            }else{
                nodo = nodo.getHijoIzquierdo();
                while(nodo != null && nodoPadre == null){
                    nodoPadre = obtenerNodo(nodo, elemPadre);
                    nodo = nodo.getHermanoDerecho();
                }
            }
        }
        return nodoPadre;
    }

    public boolean insertarPorPosicion(Object elem, int posicion){
        boolean exito = false;
        if(posicion > 0){
            int[] arreglo = new int[1];
            arreglo[0] = 1;
            exito = insertarPorPosicionAux(this.raiz, elem, arreglo, posicion);
        }
        return exito;
    }

    public boolean insertarPorPosicionAux(NodoGen nodo, Object elemento, int[] matriz, int pos ){
        boolean exito = true;
        if(this.raiz == null){
            this.raiz = new NodoGen(elemento);
        }else{
            NodoGen padre = obtenerNodoPorPos(this.raiz, pos, matriz);
            if(padre != null){
                NodoGen nuevoNodo = new NodoGen(elemento);
                NodoGen hijo = padre.getHijoIzquierdo();
                if(hijo == null){
                    padre.setHijoIzquierdo(nuevoNodo);
                }else{
                    while(hijo.getHermanoDerecho() != null){
                        hijo = hijo.getHermanoDerecho();
                    }
                    hijo.setHermanoDerecho(nuevoNodo);
                }
            }
        }
        return exito;
    }

    private NodoGen obtenerNodoPorPos(NodoGen nodo, int posicion, int[] arreglo){
        NodoGen nodoRes = null;
        if(nodo != null){
            if(arreglo[0] == posicion){
                nodoRes = nodo;
            }else{
                NodoGen hijo = nodo.getHijoIzquierdo();
                while(hijo != null && nodoRes == null){
                    arreglo[0] = arreglo[0] + 1;
                    nodoRes = obtenerNodoPorPos(hijo, posicion, arreglo);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
        return nodoRes;
    }
}
