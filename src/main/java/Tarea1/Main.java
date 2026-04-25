package Tarea1;

import java.util.ArrayList;

public class Main {
    public static  void main(String[] args){
        Expendedor exp = new Expendedor(3);
        Comprador c;

        Moneda m1000 = new Moneda1000();
        c = new Comprador(m1000,EnumProducto.COCA, exp);
        System.out.println("Compraste: " + c.queProducto());
        System.out.println("Vuelto recibido: $" + c.cuantoVuelto());
    }
}
