package ar.edu.unlu.poo.punto4;

public class Cola {
    private Nodo primero = null;
    private Nodo ultimo = null;

    private int longitud;

    public int getLongitud(){
        return longitud;
    }

    public boolean estaVacia(){
        return primero == null && ultimo == null;
    }

    public String toString(){
        String elementos = "";
        if(estaVacia()){
            elementos = "Cola vacía";
        } else {
            int i = 1;
            Nodo nodoAux = primero;
            while (nodoAux != null){
                elementos += "Nodo " + i + ": " + nodoAux.getDato() + "\n";
                i ++;
                nodoAux = nodoAux.getSiguiente();
            }
        }
        return elementos;
    }

    public boolean encolar(Object dato){
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setDato(dato);
        if(estaVacia()){
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
        }
        longitud++;
        return true;
    }

    public Object desencolar(){
        Object nodoDesencolado;
        if(!estaVacia()){
            nodoDesencolado = primero.getDato();
            primero = primero.getSiguiente();
            longitud--;
        } else {
            nodoDesencolado = null;
        }
        return nodoDesencolado;
    }

    public Nodo getPrimero(){return primero;}

    public Nodo getUltimo(){return ultimo;}
}
