package main.java.tests.conjuntistas;

import main.java.conjuntistas.ArbolABB;

public class testArbolBB {
    public static void main(String[] args) {
        ArbolABB prueba = new ArbolABB();
        
        System.out.println("Es vacio?"+ prueba.esVacio());
        System.out.println(prueba.insertar(1));
        System.out.println(prueba.insertar(2));
        System.out.println(prueba.insertar(8));
        System.out.println(prueba.insertar(9));
        System.out.println(prueba.insertar(3));
        System.out.println(prueba.insertar(4));
        System.out.println(prueba.insertar(5));
        System.out.println(prueba.insertar(6));
        System.out.println(prueba.insertar(7));
        System.out.println(prueba.insertar(10));
        System.out.println(prueba.insertar(14));
        //Si un elemento pertenece al arbol
        System.out.println("El elemento 9 pertenece al arbol? " + prueba.pertenece(9));

        
        //Vacio?
        System.out.println("Es vacio?"+ prueba.esVacio());

        //Listar
        System.out.println("Listado del arbol: "+ prueba.listar());

        //Listar rango
        System.out.println("Listado del arbol (rango) :" + prueba.listarRango(3, 8));

        //Minimo Elemento del arbol
        System.out.println("El minimo elemento del arbol es: " + prueba.minimoElem());

        //Maximo Elemento del arbol
        System.out.println("El maximo elemento del arbol es: " + prueba.maximoElem());
    }
}
