package ar.edu.unlu.poo.punto2;

public class Nodo {
    private Object dato;

    private Nodo siguiente = null;
    private Nodo anterior = null;

    public void setDato(Object dato){
        this.dato = dato;
    }

    public Object getDato(){
        return dato;
    }

    public void setAnterior(Nodo anterior){
        this.anterior = anterior;
    }

    public void setSiguiente(Nodo siguiente){
        this.siguiente = siguiente;
    }

    public Nodo getAnterior(){
        return anterior;
    }

    public Nodo getSiguiente(){
        return siguiente;
    }

}
