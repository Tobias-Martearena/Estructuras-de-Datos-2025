package java.jerarquicas;

public class ArbolBinario {
   private NodoArbol raiz;

   public ArbolBinario(){
    this.raiz = null;
   }

    public boolean insertar(Object nuevoElem, Object elemPadre, char posHijo){
        boolean exito = true;
        if(this.raiz == null){
            this.raiz = new NodoArbol(nuevoElem);
        }else{
            NodoArbol nPadre = obtenerNodo(this.raiz, elemPadre);
            //si padre existe y lugar no esta ocupado lo pone, sino da error
            if(nPadre != null){
                if(posHijo == 'I' && nPadre.getIzquierdo() == null){
                    nPadre.setIzquierdo(new NodoArbol(nuevoElem));
                }else{
                    if(posHijo == 'D' && nPadre.getDerecho() == null){
                        nPadre.setDerecho(new NodoArbol(nuevoElem));
                    }else{
                        exito = false;
                    }
                }

            }else{
                exito = false;
            }
        }
        return exito;
    }

    public boolean insertarPorPosicion(Object nuevoElem, Object elemPadre, char posHijo){
        boolean exito = true;

        return exito;
    }
    
    private NodoArbol obtenerNodo(NodoArbol n, Object buscado){
        //metodo PRIVADO que busca un elemento y devuelve el nodo
        // que lo contiene. Si no se encuentra buscado devuelve null
        NodoArbol resultado = null;
        if(n != null){
            if(n.getElem().equals(buscado)){
                //si el buscado es n, lo devuelve
                resultado = n;
            }else{
                //no es el buscado: busca primero en el HI
                resultado = obtenerNodo(n.getIzquierdo(), buscado);
                //si no lo encontro en el HI, busca en HD
                if(resultado == null){
                    resultado = obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }
        return resultado;
    }
}
