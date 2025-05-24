package java.lineales.estaticas;

public class Cola {
    private Object[] arreglo;
    private int frente;
    private int fin;
    private static final int TAMANIO = 10;

    public Cola(){
        this.arreglo = new Object[TAMANIO];
        this.frente = 0;
        this.fin = 0;
    }

    public boolean poner(Object unElem){
        boolean exito = false;
        if((this.fin +1) % this.TAMANIO != this.frente){
            this.arreglo[fin] = unElem;
            this.fin = (this.fin + 1) % this.TAMANIO;
            exito = true;
        }
        return exito;
    }

    public boolean sacar(){
        boolean exito = false;
        if(!esVacia()){
            this.arreglo[this.frente] = null;
            this.frente = (this.frente + 1) % this.TAMANIO;
            exito = true;
        }
        return exito;
    }

    public Object obtenerFrente(){
        Object elem = null;
        if(!esVacia()){
            elem = this.arreglo[this.frente];
        }
        return elem;
    }

    public boolean esVacia(){
        return this.fin == this.frente;
    }

    public void vaciar(){
        for(int i = 0; i >= this.arreglo.length -1; i++){
            this.arreglo[i] = null;
        }
        this.fin = 0;
        this.frente = 0;
    }

    public Cola clone(){
        Cola clone = new Cola();
        int frenteaux = this.frente;
        while(frenteaux != this.fin){
            clone.poner(this.arreglo[frenteaux]);
            frenteaux = (frenteaux + 1) % this.TAMANIO;
        }
        return clone;
    }

    public String toString(){
        String salida = "[";
        if(!esVacia()){
            int i = this.frente;
            while(i != this.fin){
                salida = salida + this.arreglo[i];
                if((i +1)% this.TAMANIO != this.fin){
                    salida = salida + ",";
                }
                i = (i + 1)% this.TAMANIO;
            }
            salida = salida + "]";
        }
        return salida;
    }
}

