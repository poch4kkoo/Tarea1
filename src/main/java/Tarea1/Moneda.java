package Tarea1;

public abstract class Moneda implements Comparable<Moneda> {
    public Moneda(){}

    public abstract int getValor();

    @Override
    public String toString() {
        return "valor: " + getValor() + ", serie: " + this.hashCode();
    }

    @Override
    public int compareTo(Moneda m) {
        return Integer.compare(this.getValor(), m.getValor());
    }
}
