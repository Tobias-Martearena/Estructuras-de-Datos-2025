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
}
