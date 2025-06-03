package main.java.lineales.dinamicas;
public class Lista {

    private Nodo cabecera;
    private int longitud;

    public Lista() {
        this.cabecera = null;
        this.longitud = 0;
    }

    public boolean insertar(Object elem, int pos) {
        boolean res;
        //Pos tiene que ser mayor que 0 y menor que longitud+1.
        if (pos < 1 || pos > (this.longitud + 1)) {
            res = false;
        } else {
            if (pos == 1) {
                //Inserta en la posicion 1, en caso de haber ya un elem se lo settea como enlace.
                this.cabecera = new Nodo(elem, this.cabecera);
                this.longitud++;
            } else {
                Nodo recorredor = this.cabecera;
                int i = 1;
                //Recorre hasta uno menos a la posicion a insertar.
                while (i < pos - 1) {
                    recorredor = recorredor.getEnlace();
                    i++;
                }

                //Crea un nuevo nodo, en caso de que haya un elemento, se lo settea como enlace.
                recorredor.setEnlace(new Nodo(elem, recorredor.getEnlace()));
                this.longitud++;
            }
            res = true;
        }

        return res;
    }

    public boolean eliminar(int pos) {
        boolean res = false;

        if (pos >= 1 && pos <= this.longitud) {//verifica que la posicion sea valida
            if (pos == 1) {//Pos 1 caso especial. se tiene que settear el enlace del tope.
                this.cabecera = this.cabecera.getEnlace();
                this.longitud--;
                res = true;
            } else {
                int i = 1;
                Nodo recorredor = this.cabecera;
                while (i < pos - 1) {//recorre hasta uno antes de la posicion a eliminar
                    recorredor = recorredor.getEnlace();
                    i++;
                }
                //Se le pone el enlace del elemento a eliminar.
                recorredor.setEnlace(recorredor.getEnlace().getEnlace());
                this.longitud--;
                res = true;
            }
        }
        return res;
    }

    public int longitud() {
        return this.longitud;
    }

    public Object recuperar(int pos) {
        Object elemento = null;

        if (pos >= 1 && pos <= this.longitud) {//Verifica pos valida.
            Nodo recorredor = this.cabecera;
            int i = 1;
            while (i < pos) {//recorre hasta el elemento
                recorredor = recorredor.getEnlace();
                i++;
            }
            elemento = recorredor.getElemento();
        }
        return elemento;
    }

    public int localizar(Object elem) {
        int pos = -1;
        int contador = 0;
        boolean bandera = false;

        if (this.cabecera != null) {//Verifico que no sea vacia
            Nodo recorredor = this.cabecera;
            //Se hace un while mientras estemos dentro de la lista y no se encuentre el elemento.
            while (recorredor != null && !bandera) {
                contador++;
                if (recorredor.getElemento().equals(elem)) {
                    bandera = true;
                    pos = contador;
                }
                recorredor = recorredor.getEnlace();
            }
        }

        return pos;
    }

    public void vaciar() {
        this.cabecera = null;
        this.longitud = 0;
    }

    public boolean esVacia() {
        return this.cabecera == null;
    }

    public Lista clone() {

        Lista copia = new Lista();
        //Verifico que exista una lista
        if (this.cabecera != null) {
            Nodo recorredor, actual;
            //Nodo que va a recorrer la lista original
            recorredor = this.cabecera.getEnlace();
            //Nodo de la lista clon
            actual = new Nodo(this.cabecera.getElemento());
            //La cabecera de la copia es el ultimo nodo creado, de aqui se engancha todo
            copia.cabecera = actual;
            while (recorredor != null) {
                //Voy setteando los enlaces
                actual.setEnlace(new Nodo(recorredor.getElemento()));
                //se mueven en sus listas
                actual = actual.getEnlace();
                recorredor = recorredor.getEnlace();
            }
            copia.longitud=this.longitud;
        }

        return copia;
    }

    public String toString() {
        String cad = "[]";
        if (this.cabecera != null) {
            cad = "[";
            Nodo aux = this.cabecera;
            do {
                cad = cad + aux.getElemento();
                aux = aux.getEnlace();
                if (aux != null) {
                    cad = cad + ",";
                }
            } while (aux != null);

            cad = cad + "]";
        }
        return cad;
    }
    public Lista obtenerMultiplos(int num) {
        Lista nuevaLista = new Lista();
        Nodo recorredor = this.cabecera;
        int pos = 1; // Comienza en la posición 1
    
        while (recorredor != null) {
            if (pos % num == 0) {
                // Si la posición es múltiplo de num, se agrega el elemento a la nueva lista
                nuevaLista.insertar(recorredor.getElemento(), nuevaLista.longitud() + 1);
            }
            recorredor = recorredor.getEnlace(); // Avanza al siguiente nodo
            pos++;
        }
    
        return nuevaLista;
    }
    public void eliminarApariciones(Object x) {
        // Caso especial: eliminar elementos desde la cabecera
        while (this.cabecera != null && this.cabecera.getElemento().equals(x)) {
            this.cabecera = this.cabecera.getEnlace(); 
            this.longitud--; 
        }
        Nodo recorredor = this.cabecera; // Caso general: eliminar elementos en el resto de la lista
        while (recorredor != null && recorredor.getEnlace() != null) {
            if (recorredor.getEnlace().getElemento().equals(x)) {
                recorredor.setEnlace(recorredor.getEnlace().getEnlace());
                this.longitud--; 
            } else {
                recorredor = recorredor.getEnlace(); // Avanza al siguiente nodo
            }
        }
    }
    public Lista invertirVocalesDuplicarSinVocales(Cola q){
        Lista res= new Lista();
        Cola c= q.clone();
        Cola aux=new Cola();
        Pila vocal=new Pila();
        int contador=0;
        while(!c.esVacia()){
            char caracter=(char)c.obtenerFrente();
            while(!c.esVacia()&&esVocal((char)c.obtenerFrente())){
                vocal.apilar(caracter);
                c.sacar();
                contador++;
            }
            while(!c.esVacia()&&!esVocal(caracter)&&caracter!='#'&&contador==0){
                aux.poner((char)c.obtenerFrente());
                res.insertar((char)c.obtenerFrente(),res.longitud()+1);
                c.sacar();
            }
            if(!c.esVacia()&&caracter=='#'){
                while(!vocal.esVacia()){
                    res.insertar(vocal.obtenerTope(),res.longitud()+1);
                    vocal.desapilar();
                }
            }else if(c.esVacia()&&contador==0){
                while(!aux.esVacia()){
                    res.insertar(aux.obtenerFrente(), res.longitud()+1);
                    aux.sacar();
                }
            if(!c.esVacia()){
                c.sacar();
            contador=0;
            }
            
            }
            c.sacar();
        }
        return res;
    }
    private boolean esVocal(char car){
        return (car=='a'|| car=='e'||car=='i'||car=='o'||car=='u');
    }


    public void moverAAnteultima(Lista lista, int pos) {
        if (lista.cabecera != null && pos > 0 && pos <= lista.longitud() && lista.longitud() > 2) {
            Nodo anterior = null;
            Nodo actual = lista.cabecera;
            Nodo previoAnteultimo = null;
            Nodo ultimo = lista.cabecera;
            int contador = 1;
    
            // Recorrer la lista en un solo recorrido
            while (ultimo.getEnlace() != null) {
                // Encontrar el nodo en la posición `pos`
                if (contador < pos) {
                    anterior = actual;
                    actual = actual.getEnlace();
                }
    
                // Mantener referencia al anteúltimo nodo
                if (ultimo.getEnlace().getEnlace() == null) {
                    previoAnteultimo = ultimo;
                }
    
                ultimo = ultimo.getEnlace();
                contador++;
            }
    
            // Mover el nodo a la anteúltima posición
            if (actual != null && actual != previoAnteultimo && actual != ultimo) {
                // Desenlazar el nodo de su posición actual
                if (anterior != null) {
                    anterior.setEnlace(actual.getEnlace());
                } else {
                    lista.cabecera = actual.getEnlace(); // Si es la cabecera
                }
    
                // Insertar el nodo en la anteúltima posición
                actual.setEnlace(previoAnteultimo.getEnlace());
                previoAnteultimo.setEnlace(actual);
            }
        }
    }
}
