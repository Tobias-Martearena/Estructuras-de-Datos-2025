package java.lineales.estaticas;
public class Pila{
private final int TAMANIO = 10;
private Object[] arreglo;
private int tope;

public Pila(){
    this.arreglo = new Object[TAMANIO];
    this.tope = -1;
}

public boolean apilar(Object tipoElem){
    boolean exito = false;
    if(this.tope < this.arreglo.length){
        this.arreglo[tope] = tipoElem;
        tope++;
        exito = true;
    }
    return exito;
}

public boolean desapilar(){
    boolean exito = false;
    if(!esVacia()){
        this.arreglo[tope] = null;
        this.tope--;
        exito = true;
    }
    return exito;
}

public Object obtenerTope(){
    Object elemTope = null;
    if(!esVacia()){
        elemTope = this.arreglo[tope];
    }
    return elemTope;
}

public boolean esVacia(){
    return this.tope == -1;
}

public void vaciar(){
    for(int i = 0; i <= this.tope; i++){
        this.arreglo[i] = null;
    }
    this.tope = -1;
}

public Pila clone(){
    Pila clonePila = new Pila();
    clonePila.tope = this.tope;
    for(int i = 0; i <= clonePila.tope; i++){
        clonePila.arreglo[i] = this.arreglo[i];
    }
    return clonePila;
}

public String toString(){
    String salida = "";
    for(int i = this.tope; i >= 0; i--){
        salida += this.arreglo[i] + System.lineSeparator();
    }
    return salida;
}
}