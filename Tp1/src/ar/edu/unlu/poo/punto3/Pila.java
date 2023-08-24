package ar.edu.unlu.poo.punto3;

public class Pila {
    private Nodo tope = null;

    private int longitud = 0;

    public int getLongitud(){
        return longitud;
    }

    public boolean estaVacia(){
        return tope == null;
    }

    public String toString(){
        String acumulador = "";
        int i = 1;
        Nodo nodoAux = tope;
        if(tope == null){
            acumulador = "Pila vacía";
        } else {
            while (nodoAux != null){
                if(i == 1){
                    acumulador += "Nodo " + longitud + " (Tope): " + nodoAux.getDato() + "\n";
                } else {
                    acumulador += "Nodo " + (longitud - i + 1) + ": " + nodoAux.getDato() + "\n";
                }
                i ++;
                nodoAux = nodoAux.getAnterior();
            }
        }
        return acumulador;
    }

    public boolean apilar(Object dato){
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setDato(dato);

        if(!estaVacia()){
            nuevoNodo.setAnterior(tope);
        }
        tope = nuevoNodo;
        longitud++;
        return true;
    }

    public Object desapilar(){
        Object nodoDesapilado;
        if(!estaVacia()){
            nodoDesapilado = tope.getDato();
            if(longitud == 1){
                tope = null;
            } else {
                tope = tope.getAnterior();
            }
            longitud--;
        } else {
            nodoDesapilado = null;
        }
        return nodoDesapilado;
    }

    public Nodo getTope(){
        return tope;
    }
}
