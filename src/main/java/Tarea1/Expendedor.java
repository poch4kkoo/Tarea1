package Tarea1;

public class Expendedor {

    private Deposito<Bebida> coca;
    private Deposito<Bebida> sprite;
    private Deposito<Bebida> fanta;

    private Deposito<Dulce> super8;
    private Deposito<Dulce> snickers;

    private Deposito<Moneda> monVu;
    private int precio;


    public Expendedor(int num) {

        coca = new Deposito<>();
        fanta = new Deposito<>();
        sprite = new Deposito<>();

        super8 = new Deposito<>();
        snickers = new Deposito<>();

        monVu = new Deposito<>();

        for (int i = 0; i < num; i++){
            coca.addElemento(new CocaCola(100 + i));
            sprite.addElemento(new Sprite(200 + i));
            fanta.addElemento(new Fanta(300 + i));

            super8.addElemento(new Super8(400+i));
            snickers.addElemento(new Snickers(500 + i));
        }
    }

    public Producto comprarProducto(Moneda m, EnumProducto TipoProducto)
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {

        if (m == null){
            throw new PagoIncorrectoException("el pago es incorrecto, ingresaste para pagar algo null");
        }

        int precio = TipoProducto.getPrecio();

        if (m.getValor() < precio){
            monVu.addElemento(m);
            throw new PagoInsuficienteException("pago insuficiente, no te alcanza");
        }

        Producto p = null;

        if (TipoProducto == EnumProducto.COCA) p = coca.getElemento();
        else if (TipoProducto == EnumProducto.SPRITE) p = sprite.getElemento();
        else if (TipoProducto == EnumProducto.FANTA) p = fanta.getElemento();
        else if (TipoProducto == EnumProducto.SNICKERS) p = snickers.getElemento();
        else if (TipoProducto == EnumProducto.SUPER8) p = super8.getElemento();


        if (p != null) {
            int vuelto = m.getValor() - precio;
            while (vuelto >= 100) {
                monVu.addElemento(new Moneda100());
                vuelto -= 100;
            }
            return p;
        } else {
            monVu.addElemento(m);

            throw new NoHayProductoException("Agotado");
        }
    }

    public Moneda getVuelto(){
        return monVu.getElemento();
    }
}