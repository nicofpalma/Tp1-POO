package ar.edu.unlu.poo.punto4;

public class Nodo {
    private Object dato;
    private Nodo siguiente;

    public void setDato(Object dato){
        this.dato = dato;
    }

    public Object getDato(){
        return dato;
    }

    public void setSiguiente(Nodo siguiente){
        this.siguiente = siguiente;
    }

    public Nodo getSiguiente(){
        return siguiente;
    }
}
