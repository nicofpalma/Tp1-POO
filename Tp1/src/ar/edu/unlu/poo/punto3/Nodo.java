package ar.edu.unlu.poo.punto3;

public class Nodo {
    private Object dato;

    private Nodo anterior = null;

    public void setDato(Object dato){
        this.dato = dato;
    }

    public Object getDato() {return dato;}

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo getAnterior(){
        return anterior;
    }
}
