package main.java.tests.lineales;
import main.java.lineales.dinamicas.Cola;
public class testCola {
    public static void main(String[] args) {
        Cola c = new Cola();
        // Ejemplo: para t = 3, la cola debe ser 1,2,3,3,2,1
        c.poner(1);
        c.poner(2);
        c.poner(3);
        c.poner(3);
        c.poner(2);
        c.poner(1);

        System.out.println("Cola: " + c);
        System.out.println("¿Verifica para t=3?: " + c.verificarCola(3, c)); // Debe dar true

        Cola c2 = new Cola();
        c2.poner(1);
        c2.poner(2);
        c2.poner(3);
        c2.poner(2);
        c2.poner(1);

        System.out.println("Cola: " + c2);
        System.out.println("¿Verifica para t=3?: " + c2.verificarCola(3, c2)); // Debe dar false
    }
}
