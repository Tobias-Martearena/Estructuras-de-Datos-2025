package java.tests.jerarquicas;

import java.jerarquicas.ArbolBinario;
import java.lineales.dinamicas.Lista;

public class arbolTest {

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

        Lista patron = new Lista();

        patron.insertar(1, 1);
        patron.insertar(3, patron.longitud() + 1);
        patron.insertar(4, patron.longitud() + 1);
        patron.insertar(5, patron.longitud() + 1);

        //System.out.println(prueba.verificarPatron(patron));
        Lista hojas = prueba.frontera();

        System.out.println(hojas.toString());

        ArbolBinario clon = prueba.clone();

        Lista preorden = clon.listarPreorden();
        System.out.println(preorden.toString());

        //ArbolBinario clonInv = prueba.cloneInvertido();
        //Lista preordenInv = clonInv.ListarPreorden();
        //System.out.println(preordenInv.toString());
        System.out.println(clon.toString());
        //System.out.println(clonInv.toString());

    }

}
