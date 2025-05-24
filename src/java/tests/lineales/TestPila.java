package java.tests.lineales;

import java.lineales.estaticas.Pila;
public class TestPila {
    public static void main(String[] args) {
        Pila pila = new Pila();

        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3);
        pila.apilar(4);
        pila.apilar(5);
        pila.apilar(6);
        pila.apilar(7);
        pila.apilar(8);
        pila.apilar(9);
        pila.apilar(10);
        pila.apilar(11); // Intento de apilar un elemento adicional (debería fallar)
        System.out.println("Estado de la pila después de apilar: " + pila.toString());

        System.out.println("Desapilando un elemento...");
        pila.desapilar();
        System.out.println("Estado de la pila después de desapilar: " + pila.toString());

        // Prueba de obtener el tope
        System.out.println("Elemento en el tope: " + pila.obtenerTope());

        // Prueba de si la pila está vacía
        System.out.println("¿La pila está vacía? " + pila.esVacia());

        // Prueba de vaciar la pila
        System.out.println("Vaciando la pila...");
        pila.vaciar();
        System.out.println("Estado de la pila después de vaciar: " + pila.toString());

        // Prueba de si la pila está vacía después de vaciar
        System.out.println("¿La pila está vacía? " + pila.esVacia());
    }
}
