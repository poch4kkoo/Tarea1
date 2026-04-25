package Tarea1;

import java.util.ArrayList;

public class Deposito<T> {
    private ArrayList<T> al;

    public Deposito(){
        al = new ArrayList<T>();
    }

    public void addElemento(T t){
        al.add(t);
    }


    public T getElemento(){
        if (al.size() == 0){
            return null;
        }
        return al.remove(0);
    }
}
