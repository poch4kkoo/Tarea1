package Tarea1;

public class NoHayProductoException extends RuntimeException {
    public NoHayProductoException(String mensaje) {

        super(mensaje);
    }
}
