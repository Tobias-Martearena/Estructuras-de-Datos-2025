package tests.jerarquicas;

import jerarquicas.ArbolGen;

public class testArbolGen {

    public static void main(String[] args) {
        ArbolGen prueba = new ArbolGen();

        System.out.println("Es vacio?"+ prueba.esVacio());
        System.out.println(prueba.insertar(1, null));
        System.out.println(prueba.insertar(2, 1));
        System.out.println(prueba.insertar(8, 1));
        System.out.println(prueba.insertar(9, 1));
        System.out.println(prueba.insertar(3, 2));
        System.out.println(prueba.insertar(4, 2));
        System.out.println(prueba.insertar(5,4));
        System.out.println(prueba.insertar(6,4));
        System.out.println(prueba.insertar(7,4));
        System.out.println(prueba.insertar(10,9));
        System.out.println(prueba.insertar(14,9));
        System.out.println(prueba.insertar(15,9));
        System.out.println(prueba.insertar(11,10));
        System.out.println(prueba.insertar(12,11));
        System.out.println(prueba.insertar(13,11));
        System.out.println(prueba.insertar(16,15));
        System.out.println(prueba.insertar(17,15));

        // Recorridos
        System.out.println("Recorrido Preorden: " + prueba.listarPreorden());
        System.out.println("Recorrido Posorden: " + prueba.listarPosorden());
        System.out.println("Recorrido Inorden: " + prueba.listarInorden());
        System.out.println("Recorrido por Niveles: " + prueba.listarPorNiveles());

        //Si un elemento pertenece al arbol
        System.out.println("El elemento 9 pertenece al arbol? " + prueba.pertenece(9));

        // Ancestros de un nodo
        System.out.println("Ancestros de 12: " + prueba.ancestros(12));
        
        //Vacio?
        System.out.println("Es vacio?"+ prueba.esVacio());

        //Altura del arbol
        System.out.println("Altura del arbolGenerico: "+ prueba.altura());

        //Nivel del arbol
        System.out.println("Nivel del elemento 3:" + prueba.nivel(3));

        //Padre del elemento
        System.out.println("El padre de 6 es: " +prueba.padre(6));

        //Clone
        System.out.println("Generando clon...");
        ArbolGen clone = prueba.clone();
        System.out.println("clon (toString): " + clone.toString());

        //toString
        System.out.println("Arbol original (toString): ");
        System.out.println(prueba.toString());

        //Vaciar
        System.out.println("Arbol vaciandoce... ");
        prueba.vaciar();

        System.out.println("Es vacio?"+ prueba.esVacio());
    }
}
