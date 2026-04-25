package Tarea1;

public enum EnumProducto {
    COCA(1000),
    SPRITE(1000),
    FANTA(1000),
    SNICKERS(800),
    SUPER8(500);

    private int precio;

    EnumProducto(int p){
        precio = p;
    }

    public int getPrecio(){
        return precio;
    }

}
