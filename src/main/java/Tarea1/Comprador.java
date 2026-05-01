package Tarea1;

public class Comprador {
    private String tipo;
    private int vuelto = 0;

    public Comprador(Moneda m, EnumProducto TipoProducto, Expendedor exp){
        Producto p = null;
        try {
            p = exp.comprarProducto(m, TipoProducto);

            //Error en caso de acabarse el stock
        } catch (NoHayProductoException e) {
            System.out.println("Error: " + e.getMessage());
            p = null;

            //Error en caso de Pago insuficiente
        } catch (PagoInsuficienteException e){
            System.out.println("Error en el pago: " + e.getMessage());
            p = null;

            //error en caso de moneda nula (pago incorrecto)
        } catch (PagoIncorrectoException e){
            System.out.println("Error de moneda: "+e.getMessage());
            p =null;
        }

        if (p != null) {
            tipo = p.consumir();
        } else {
            tipo = null;
        }

        Moneda aux = exp.getVuelto();

        while (aux != null){
            vuelto += aux.getValor();
            aux = exp.getVuelto();
        }
    }

    public int cuantoVuelto(){
        return vuelto;
    }

    public String queProducto(){
        return tipo;
    }
}