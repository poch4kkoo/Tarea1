package Tarea1;

public class Main {
    public static  void main(String[] args){
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
    }
}
