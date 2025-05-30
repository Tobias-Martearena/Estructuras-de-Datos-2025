package jerarquicas;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;

public class ArbolBinario {

    private NodoArbol raiz;

    public ArbolBinario() {
        this.raiz = null;
    }
//-----------------------------------------------------------------------------------------//
//Posible arreglo...

    public boolean insertar(Object nuevoElem, Object elemPadre, char posHijo) {
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoArbol(nuevoElem);
        } else {
            NodoArbol nPadre = obtenerNodo(this.raiz, elemPadre);
            //si padre existe y lugar no esta ocupado lo pone, sino da error
            if (nPadre != null) {
                if (posHijo == 'I' && nPadre.getIzquierdo() == null) {
                    nPadre.setIzquierdo(new NodoArbol(nuevoElem));
                } else {
                    if (posHijo == 'D' && nPadre.getDerecho() == null) {
                        nPadre.setDerecho(new NodoArbol(nuevoElem));
                    } else {
                        exito = false;
                    }
                }

            } else {
                exito = false;
            }
        }
        return exito;
    }

    public boolean insertarPorPosicion(Object nuevoElem, int pos, char posHijo) {
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoArbol(nuevoElem);
        } else {
            Lista lista = listarPorNivel();
            if (pos > 0 && pos <= lista.longitud()) {
                NodoArbol padre = (NodoArbol) lista.recuperar(pos);
                if (padre.getIzquierdo() == null) {
                    padre.setIzquierdo(new NodoArbol(nuevoElem));
                } else {
                    if (padre.getDerecho() == null) {
                        padre.setDerecho(new NodoArbol(nuevoElem));
                    } else {
                        exito = false;
                    }
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }

    private NodoArbol obtenerNodo(NodoArbol n, Object buscado) {
        //metodo PRIVADO que busca un elemento y devuelve el nodo
        // que lo contiene. Si no se encuentra buscado devuelve null
        NodoArbol resultado = null;
        if (n != null) {
            if (n.getElem().equals(buscado)) {
                //si el buscado es n, lo devuelve
                resultado = n;
            } else {
                //no es el buscado: busca primero en el HI
                resultado = obtenerNodo(n.getIzquierdo(), buscado);
                //si no lo encontro en el HI, busca en HD
                if (resultado == null) {
                    resultado = obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }
        return resultado;
    }

    public Lista listarPorNivel() {
        Lista lista = new Lista();
        Cola cola = new Cola();
        if (this.raiz != null) {
            cola.poner(this.raiz);
            while (!cola.esVacia()) {
                NodoArbol nodo = (NodoArbol) cola.obtenerFrente();
                cola.sacar();
                lista.insertar(nodo.getElem(), lista.longitud() + 1);
                if (nodo.getIzquierdo() != null) {
                    cola.poner(nodo.getIzquierdo());
                } else {
                    if (nodo.getDerecho() != null) {
                        cola.poner(nodo.getDerecho());
                    }
                }
            }
        }
        return lista;
    }
//-----------------------------------------------------------------------------------------//

    public boolean esVacio() {
        boolean exito = true;
        if (this.raiz != null) {
            exito = false;
        }
        return exito;
    }

    public int altura() {
        return alturaAux(this.raiz);
    }

    private int alturaAux(NodoArbol nodo) {
        int res = 0;
        if (nodo != null) {
            int izq = alturaAux(nodo.getIzquierdo());
            int der = alturaAux(nodo.getDerecho());
            if (izq > der) {
                res = izq + 1;
            } else {
                res = der + 1;
            }
        } else {
            res = -1;
        }
        return res;
    }

    public int nivel(Object elemento) {
        return nivelAux(this.raiz, elemento, -1);
    }

    private int nivelAux(NodoArbol nodo, Object elem, int altura) {
        int alturaAux = -1;
        altura++;
        if (nodo != null) {
            if (nodo.getElem().equals(elem)) {
                alturaAux = altura;
            } else {
                if (nodo.getIzquierdo() != null) {
                    alturaAux = nivelAux(nodo.getIzquierdo(), elem, altura);
                } else {
                    if (alturaAux == -1) {
                        if (nodo.getDerecho() != null) {
                            alturaAux = nivelAux(nodo.getDerecho(), elem, altura);
                        }
                    }
                }
            }
        }
        return alturaAux;
    }

    public Object padre(Object elemento) {
        return padreRec(this.raiz, elemento);
    }

    private Object padreRec(NodoArbol nodo, Object elem) {
        Object res = null;
        if (nodo != null) {
            if (nodo.getIzquierdo() != null && nodo.getIzquierdo().getElem().equals(elem)) {
                res = nodo.getElem();
            } else {
                if (nodo.getDerecho() != null && nodo.getDerecho().getElem().equals(elem)) {
                    res = nodo.getElem();
                } else {
                    res = padreRec(nodo.getIzquierdo(), elem);

                    if (res == null) {
                        res = padreRec(nodo.getDerecho(), elem);
                    }
                }
            }
        }
        return res;
    }

    public Lista listarPreorden() {
        Lista lista = new Lista();
        listarPreordenAux(this.raiz, lista);
        return lista;
    }

    private void listarPreordenAux(NodoArbol nodo, Lista lis) {
        if (nodo != null) {
            //Inserta en la lista el elemento
            lis.insertar(nodo.getElem(), lis.longitud() + 1);

            //Recorre sus hijos en preOrden
            listarPreordenAux(nodo.getIzquierdo(), lis);
            listarPreordenAux(nodo.getDerecho(), lis);
        }
    }

    public Lista listarInorden() {
        Lista lista = new Lista();
        listarInordenAux(this.raiz, lista);
        return lista;
    }

    private void listarInordenAux(NodoArbol nodo, Lista lis) {
        if (nodo != null) {
            listarInordenAux(nodo.getIzquierdo(), lis);
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
            listarInordenAux(nodo.getDerecho(), lis);
        }
    }

    public Lista listarPosorden() {
        Lista lista = new Lista();
        listarPosordenAux(this.raiz, lista);
        return lista;
    }

    private void listarPosordenAux(NodoArbol nodo, Lista lis) {
        if (nodo != null) {
            listarPosordenAux(nodo.getIzquierdo(), lis);
            listarPosordenAux(nodo.getDerecho(), lis);
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
        }
    }

    public Lista listarPorNiveles() {
        Lista lista = new Lista();
        int altura = altura();
        for (int i = 0; i <= altura; i++) {
            listarPorNivelesAux(this.raiz, lista, 0);
        }
        return lista;
    }

    private void listarPorNivelesAux(NodoArbol nodo, Lista lis, int nivel) {
        if (nodo != null) {
            if (nivel == 0) {
                lis.insertar(nodo.getElem(), lis.longitud() + 1);
            } else {
                listarPorNivelesAux(nodo.getIzquierdo(), lis, nivel - 1);
                listarPorNivelesAux(nodo.getDerecho(), lis, nivel - 1);
            }
        }
    }

    public ArbolBinario clone() {
        ArbolBinario clone = new ArbolBinario();
        if (!esVacio()) {
            clone.raiz = cloneAux(this.raiz);
        }
        return clone;
    }

    private NodoArbol cloneAux(NodoArbol nodo) {
        NodoArbol nuevo = new NodoArbol(nodo.getElem());
        if (nodo.getIzquierdo() != null) {
            nuevo.setIzquierdo(cloneAux(nodo.getIzquierdo()));
        } else {
            if (nodo.getDerecho() != null) {
                nuevo.setDerecho(cloneAux(nodo.getDerecho()));
            }
        }
        return nuevo;
    }

    public void vaciar() {
        this.raiz = null;
    }

    public String toString() {
        String cad = "";
        if (this.raiz != null) {
            cad = cad + "raiz" + this.raiz.getElem() + "\n";
            cad = toStringAux(this.raiz, cad);
        }
        return cad;
    }

    private String toStringAux(NodoArbol nodo, String cadena) {
        if (nodo != null) {

            if (nodo.getIzquierdo() != null) {
                cadena = cadena + nodo.getIzquierdo().getElem() + "Hi - Padre: " + nodo.getElem() + "\n";
                cadena = toStringAux(nodo.getIzquierdo(), cadena);
            }
            if (nodo.getDerecho() != null) {
                cadena = cadena + nodo.getDerecho().getElem() + "Hd - Padre:" + nodo.getElem() + "\n";
                cadena = toStringAux(nodo.getDerecho(), cadena);
            }

        }
        return cadena;
    }

    public Lista frontera() {
        Lista lista = new Lista();
        fronteraAux(this.raiz, lista);
        return lista;
    }

    private void fronteraAux(NodoArbol nodo, Lista lis) {
        if (nodo != null) {
            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                lis.insertar(nodo.getElem(), lis.longitud() + 1);
            } else {
                fronteraAux(nodo.getIzquierdo(), lis);
                fronteraAux(nodo.getDerecho(), lis);
            }
        }
    }

    public Lista obtenerAncestro(Object elem) {
        Lista lista = new Lista();
        obtenerAncestroAux(this.raiz, elem, lista);
        return lista;
    }

    private boolean obtenerAncestroAux(NodoArbol nodo, Object elemento, Lista lis) {
        boolean exito = false;
        if (nodo != null) {
            if (nodo.getElem().equals(elemento)) {
                exito = true;
            } else {
                if (obtenerAncestroAux(nodo.getIzquierdo(), elemento, lis) || obtenerAncestroAux(nodo.getDerecho(), elemento, lis)) {
                    lis.insertar(nodo.getElem(), lis.longitud() + 1);
                    exito = true;
                }
            }
        }
        return exito;
    }

    public Lista obtenerDecendientes(Object elem) {
        Lista lista = new Lista();
        NodoArbol nodoElem = obtenerNodo(this.raiz, elem);
        if(nodoElem != null){obtenerDecendientesAux(nodoElem, lista);
        }
        return lista;
    }

    private void obtenerDecendientesAux(NodoArbol nodo, Lista lis) {
        if (nodo != null) {
            if(nodo.getIzquierdo() != null){
                lis.insertar(nodo.getIzquierdo().getElem(), lis.longitud()+1);
                obtenerDecendientesAux(nodo.getIzquierdo(), lis);
            }else{
                if(nodo.getDerecho() != null){
                    lis.insertar(nodo.getDerecho().getElem(), lis.longitud()+1);
                    obtenerDecendientesAux(nodo.getDerecho(), lis);
                }
            }
        }
    }
}
