package jerarquicas;

public class NodoGen {
    private Object tipoElmento;
    private NodoGen hijoIzquierdo;
    private NodoGen hermanoDerecho;

    public NodoGen(Object tElem){
        this.tipoElmento = tElem;
        this.hijoIzquierdo = null;
        this.hermanoDerecho = null;
    }

    public NodoGen(Object tElem, NodoGen hIzquierdo, NodoGen hDerecho){
        this.tipoElmento = tElem;
        this.hijoIzquierdo = hIzquierdo;
        this.hermanoDerecho = hDerecho;
    }

    public Object getElem(){
        return this.tipoElmento;
    }

    public NodoGen getHijoIzquierdo(){
        return this.hijoIzquierdo;
    }

    public NodoGen getHermanoDerecho(){
        return this.hermanoDerecho;
    }

    public void setElem(Object tElem){
        this.tipoElmento = tElem;
    }

    public void setHijoIzquierdo(NodoGen hIzquierdo){
        this.hijoIzquierdo = hIzquierdo;
    }

    public void setHermanoDerecho(NodoGen hDerecho){
        this.hermanoDerecho = hDerecho;
    }
}
