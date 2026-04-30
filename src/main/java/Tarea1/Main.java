package Tarea1;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args){
        Expendedor exp = new Expendedor(1);
        Comprador c;

        Moneda m1 = new Moneda1000();
        c = new Comprador(m1,EnumProducto.COCA, exp);
        System.out.println("Compraste: " + c.queProducto());
        System.out.println("Vuelto recibido: $" + c.cuantoVuelto());

        Moneda m2 = new Moneda1000();
        c = new Comprador(m2,EnumProducto.COCA, exp);
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
