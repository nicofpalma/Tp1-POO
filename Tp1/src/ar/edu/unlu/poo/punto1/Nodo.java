package ar.edu.unlu.poo.punto1;

public class Nodo {
    // Dato del nodo
    private Object dato;

    // Siguiente del nodo
    private Nodo siguiente = null;

    public void setDato(Object dato){
        this.dato = dato;
    }

    public Object getDato(){
        return this.dato;
    }

    public void setSiguiente(Nodo siguiente){
        this.siguiente = siguiente;
    }

    public Nodo getSiguiente(){
        return siguiente;
    }

}
