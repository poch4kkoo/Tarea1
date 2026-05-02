package Tarea1;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args){
        Expendedor exp = new Expendedor(1);
        Comprador c;

        System.out.println("Primera compra: Se intenta pagar con menos dinero ");
        System.out.println();
        Moneda m1 = new Moneda100();
        c = new Comprador(m1,EnumProducto.COCA, exp);
        System.out.println("Compraste: " + c.queProducto());
        System.out.println("Vuelto recibido: $" + c.cuantoVuelto());


        System.out.println("Segundo intento: No se ingresa moneda o Null ");
        System.out.println();
        Moneda m2 = null;
        c = new Comprador(m2,EnumProducto.COCA, exp);
        System.out.println("Compraste: " + c.queProducto());
        System.out.println("Vuelto recibido: $" + c.cuantoVuelto());

        System.out.println("Tercer intento: Compra exitosa");
        System.out.println();
        Moneda m3 = new Moneda1000();
        c = new Comprador(m3,EnumProducto.SUPER8, exp);
        System.out.println("Compraste: " + c.queProducto());
        System.out.println("Vuelto recibido: $" + c.cuantoVuelto());

        System.out.println("Cuarto intento: sin stock");
        System.out.println();
        Moneda m4 = new Moneda1000();
        c = new Comprador(m4,EnumProducto.SNICKERS, exp);
        System.out.println("Compraste: " + c.queProducto());
        System.out.println("Vuelto recibido: $" + c.cuantoVuelto());

        ArrayList<Moneda> listaMonedas = new ArrayList<>();
        listaMonedas.add(new Moneda1000());
        listaMonedas.add(new Moneda500());
        listaMonedas.add(new Moneda100());

        System.out.println("Antes: " + listaMonedas);
        listaMonedas.sort(null);
        System.out.println("Despues: : " + listaMonedas);
    }
}
