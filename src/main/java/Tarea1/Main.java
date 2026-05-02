package Tarea1;

import java.util.ArrayList;

/**
 * Clase que actua como el entorno de prueba.
 * simula la interaccion entre un comprador y una maquina expendora.
 * Ademas, se muestra la habilidad de ordenar las monedas.
 */
public class Main {

    /**
     * Ejecurta una serie de casos de prueba para validar el correcto funcionamineto de las clases y metodos.
     * @param args Argumentos de linea de comandos (no se hace uso de estas).
     */
    public static void main(String[] args){

        Expendedor exp = new Expendedor(1);
        Comprador c;

        //Casos exitosos:
        System.out.println("Prueba 1: Compra dulce Super 8");
        System.out.println();
        Moneda m3 = new Moneda1000();
        c = new Comprador(m3,EnumProducto.SUPER8, exp);
        System.out.println("Compraste: " + c.queProducto());
        System.out.println("Vuelto recibido: $" + c.cuantoVuelto());
        System.out.println();

        System.out.println("Prueba 2: Compra dulce Snickers");
        System.out.println();
        Moneda m6 = new Moneda1000();
        c = new Comprador(m6,EnumProducto.SNICKERS, exp);
        System.out.println("Compraste: " + c.queProducto());
        System.out.println("Vuelto recibido: $" + c.cuantoVuelto());
        System.out.println();

        System.out.println("Prueba 3: Compra Bebida CocaCola");
        System.out.println();
        Moneda m7 = new Moneda1000();
        c = new Comprador(m7,EnumProducto.COCA, exp);
        System.out.println("Compraste: " + c.queProducto());
        System.out.println("Vuelto recibido: $" + c.cuantoVuelto());
        System.out.println();

        System.out.println("Prueba 4: Compra Bebida Sprite");
        System.out.println();
        Moneda m8 = new Moneda1000();
        c = new Comprador(m8,EnumProducto.SPRITE, exp);
        System.out.println("Compraste: " + c.queProducto());
        System.out.println("Vuelto recibido: $" + c.cuantoVuelto());
        System.out.println();

        System.out.println("Prueba 5: Compra Bebida Fanta");
        System.out.println();
        Moneda m9 = new Moneda1000();
        c = new Comprador(m9,EnumProducto.FANTA, exp);
        System.out.println("Compraste: " + c.queProducto());
        System.out.println("Vuelto recibido: $" + c.cuantoVuelto());
        System.out.println();

        //Prueba de excepciones:
        System.out.println("EXCEPCIONES");
        System.out.println("Prueba 6: Se intenta pagar con menos dinero ");
        System.out.println();
        Moneda m1 = new Moneda100();
        c = new Comprador(m1,EnumProducto.COCA, exp);
        System.out.println("Compraste: " + c.queProducto());
        System.out.println("Vuelto recibido: $" + c.cuantoVuelto());
        System.out.println();

        System.out.println("Prueba 7: No se ingresa moneda o Null ");
        System.out.println();
        Moneda m2 = null;
        c = new Comprador(m2,EnumProducto.COCA, exp);
        System.out.println("Compraste: " + c.queProducto());
        System.out.println("Vuelto recibido: $" + c.cuantoVuelto());
        System.out.println();

        System.out.println("Prueba 8: sin stock");
        System.out.println();
        Moneda m4 = new Moneda1000();
        c = new Comprador(m4,EnumProducto.SNICKERS, exp);
        System.out.println("Compraste: " + c.queProducto());
        System.out.println("Vuelto recibido: $" + c.cuantoVuelto());
        System.out.println();



        //Prueba de ordenamiento de monedas.
        ArrayList<Moneda> listaMonedas = new ArrayList<>();
        listaMonedas.add(new Moneda1000());
        listaMonedas.add(new Moneda500());
        listaMonedas.add(new Moneda100());

        System.out.println("Antes del ordenamiento: " + listaMonedas);
        listaMonedas.sort(null);
        System.out.println("Despues del ordenamiento: " + listaMonedas);
    }
}
