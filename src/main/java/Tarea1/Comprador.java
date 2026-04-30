package Tarea1;

public class Comprador {
    private String tipo;
    private int vuelto = 0;

    public Comprador(Moneda m, EnumProducto TipoProducto, Expendedor exp){
        
        Producto p = null;
        try {
            p = exp.comprarProducto(m, TipoProducto);
        } catch (NoHayProductoException e) {
            // Si no hay producto, imprimimos el error
            System.out.println("Error: " + e.getMessage());
            p = null;
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
