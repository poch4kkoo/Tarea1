package Tarea1;

public class PagoIncorrectoException extends RuntimeException {
    public PagoIncorrectoException(String mensaje) {
        super(mensaje);
    }
}