package java.jerarquicas;
import java.lineales.dinamicas.Cola;
import java.lineales.dinamicas.Lista;
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

    public boolean insertarPorPosicion(Object nuevoElem, int pos, char posHijo){
        boolean exito = true;
        if(this.raiz == null){
            this.raiz = new NodoArbol(nuevoElem);
        }else{
            Lista lista = listarPorNivel();
            if(pos > 0 && pos<=lista.longitud()){
                NodoArbol padre = (NodoArbol)lista.recuperar(pos);
                if(padre.getIzquierdo()==null){
                    padre.setIzquierdo(new NodoArbol(nuevoElem));
                }else{
                    if(padre.getDerecho()==null){
                        padre.setDerecho(new NodoArbol(nuevoElem));
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

    public Lista listarPorNivel(){
        Lista lista = new Lista();
        Cola cola = new Cola();
        if(this.raiz!= null){
            cola.poner(this.raiz);
            while (!cola.esVacia()) {
                NodoArbol nodo =(NodoArbol)cola.obtenerFrente();
                cola.sacar();
                lista.insertar(nodo.getElem(), lista.longitud()+1);
                if(nodo.getIzquierdo()!= null){
                    cola.poner(nodo.getIzquierdo());
                }else{
                    if(nodo.getDerecho()!=null){
                        cola.poner(nodo.getDerecho());
                    }
                }
            }
        }
        return lista;
    }

    public boolean esVacio(){
        boolean exito = true;
        if(this.raiz != null){
            exito = false;
        }
        return exito;
    }

    public int altura(){
        return alturaAux(this.raiz);
    }

    private int alturaAux(NodoArbol nodo){
        int res = 0;
        if(nodo!=null){
            int izq = alturaAux(nodo.getIzquierdo());
            int der = alturaAux(nodo.getDerecho());
            if(izq > der){
                res = izq+1;
            }else{
                res = der+1;
            }
        }
        return res;
    }

}
