package Tarea1;
import java.util.Scanner;
public class MainInteractivo {
    public static void main(String[] args) {
        //iniciamos el expendedor con 3 unidades de cada producto
        Expendedor exp=new Expendedor(1);
        Scanner sc=new Scanner(System.in);
        System.out.println("=== Bienvenido a la maquina expendedora ===");
        while (true) {
            System.out.println("\n-_-_ Menu de productos _-_-");
            System.out.println("1.CocaCola  ($1000)");
            System.out.println("2.Sprite    ($1000)");
            System.out.println("3.Fanta     ($1000)");
            System.out.println("4.Snickers  ($800)");
            System.out.println("5.Super8    ($500)");
            System.out.println("0.Apagar maquina/Salir");
            System.out.print("Seleccione una opcion: ");
            int seleccion=sc.nextInt();
            if (seleccion ==0) {
                System.out.println("Apagando maquina.");
                break;
            }
            //validacion de la opcion elegida
            EnumProducto tipoProducto =null;
            switch (seleccion) {
                case 1->tipoProducto=EnumProducto.COCA;
                case 2->tipoProducto=EnumProducto.SPRITE;
                case 3->tipoProducto=EnumProducto.FANTA;
                case 4->tipoProducto=EnumProducto.SNICKERS;
                case 5->tipoProducto=EnumProducto.SUPER8;
                default ->{
                    System.out.println("Opcion invalida,intenta de nuevo.");
                    continue; //vuelve al ciclo
                }
            }
            System.out.print("Ingrese el valor de la moneda con la que pagara(100, 500, 1000): ");
            int valorMoneda=sc.nextInt();
            //instanciar la moneda que pida
            Moneda m =null;
            if (valorMoneda==100) {
                m=new Moneda100();
            } else if (valorMoneda==500) {
                m=new Moneda500();
            } else if (valorMoneda ==1000) {
                m=new Moneda1000();
            } else if (valorMoneda!=0) {
                System.out.println("Esta maquina solo acepta monedas de 100, 500 y 1000");
                continue;
            }
            //proceso de compra con manejo de errores
            try {
                System.out.println("\nProcesando compra");
                Comprador comprador=new Comprador(m, tipoProducto, exp);
                //si llegamos aqui, funciono
                System.out.println("Compra exitosa");
                System.out.println("Producto obtenido: "+comprador.queProducto());
                System.out.println("Vuelto recibido: $"+comprador.cuantoVuelto());
            } catch (PagoIncorrectoException e) {
                System.out.println("Error de pago: "+e.getMessage()+" (Moneda no valida)");
            } catch (PagoInsuficienteException e) {
                System.out.println("Error de fondos: "+e.getMessage()+" (Ingrese una moneda de mayor valor)");
            } catch (NoHayProductoException e) {
                System.out.println("Error de stock: "+e.getMessage()+" (Producto agotado o no disponible)");
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
        sc.close(); //cerramos el scaner
    }
}