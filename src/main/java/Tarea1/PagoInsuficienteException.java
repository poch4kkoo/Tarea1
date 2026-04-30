package Tarea1;

public class PagoInsuficienteException extends RuntimeException {
    public PagoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
