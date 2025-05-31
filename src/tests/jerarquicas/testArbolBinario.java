package tests.jerarquicas;

import jerarquicas.ArbolBinario;
import lineales.dinamicas.Lista;

public class testArbolBinario {
    public static void main(String[] args) {
        ArbolBinario prueba = new ArbolBinario();

        System.out.println(prueba.esVacio());
        prueba.insertar(1, null, 'I');
        System.out.println(prueba.insertar(2, 1, 'I'));
        System.out.println(prueba.insertar(3, 1, 'D'));
        System.out.println(prueba.insertar(4, 3, 'D'));
        System.out.println(prueba.insertar(5, 4, 'I'));
        System.out.println(prueba.insertar(6, 2, 'I'));
        System.out.println(prueba.insertar(7, 6, 'D'));
        System.out.println(prueba.insertar(8, 7, 'I'));
        System.out.println(prueba.insertar(9, 8, 'D'));

        // Recorridos
        System.out.println("Recorrido Preorden: " + prueba.listarPreorden());
        System.out.println("Recorrido Inorden: " + prueba.listarInorden());
        System.out.println("Recorrido Posorden: " + prueba.listarPosorden());
        System.out.println("Recorrido por Niveles: " + prueba.listarPorNiveles());

        // Frontera (hojas)
        System.out.println("Frontera (hojas): " + prueba.frontera());

        // Ancestros de un nodo
        System.out.println("Ancestros de 9: " + prueba.obtenerAncestro(9));

        // Descendientes de un nodo
        System.out.println("Descendientes de 2: " + prueba.obtenerDecendientes(2));

        // Altura y nivel
        System.out.println("Altura del árbol: " + prueba.altura());
        System.out.println("Nivel de 9: " + prueba.nivel(9));

         // Clonado
        ArbolBinario clon = prueba.clone();
        System.out.println("Clon (toString): " + clon.toString());
        Lista patron = new Lista();

        patron.insertar(1, 1);
        patron.insertar(3, patron.longitud() + 1);
        patron.insertar(4, patron.longitud() + 1);
        patron.insertar(5, patron.longitud() + 1);
    }
}
