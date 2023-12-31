package ar.edu.unlu.poo.punto1;

public class ListaEnlazada {
    private Nodo cabeza = null;

    private int longitud = 0;

    // Método para agregar un nodo a la lista
    public boolean agregarAlFinal(Object dato){
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setDato(dato);
        if(estaVacia()){
            cabeza = nuevoNodo;
        } else {
            Nodo nodoAux = cabeza;
            while(nodoAux.getSiguiente() != null){
                nodoAux = nodoAux.getSiguiente();
            }
            nodoAux.setSiguiente(nuevoNodo);
        }
        longitud++;
        return true;
    }

    // Método para mostrar los nodos de la lista y sus datos
    public String toString(){
        String acumulador = "";
        int i = 1;
        Nodo nodoAux = cabeza;
        if(cabeza == null){
            acumulador = "Lista vacía";
        } else {
            while (nodoAux != null){
                acumulador += "Nodo " + i + ": " + nodoAux.getDato() + "\n";
                i ++;
                nodoAux = nodoAux.getSiguiente();
            }
        }

        return acumulador;
    }

    // Verifica si la lista está vacía
    public boolean estaVacia(){
        return cabeza == null;
    }

    // Devuelve la longitud de la lista
    public int getLongitud(){
        return longitud;
    }

    // Elimina un elemento ubicado en cierta posición pasada por parámetro
    public boolean eliminarPorPosicion(int posicion){
        boolean exito = false;
        if(posicion > 0 && !estaVacia() && posicion <= longitud){
            Nodo nodoActual = cabeza;
            Nodo nodoAnterior = null;
            if(posicion == 1){
                cabeza = cabeza.getSiguiente();
                exito = true;
                longitud--;
            } else {
                for(int i = 1; i <= posicion; i++){
                    if(i == posicion){
                        nodoAnterior.setSiguiente(nodoAnterior.getSiguiente().getSiguiente());
                        nodoActual = null;
                        exito = true;
                        longitud--;
                    } else {
                        nodoAnterior = nodoActual;
                        nodoActual = nodoActual.getSiguiente();
                    }
                }
            }
        }
        return exito;
    }

    public Nodo recuperarPorPosicion(int posicion){
        Nodo nodoBuscado = cabeza;
        if(posicion > 0 && !estaVacia() && posicion <= longitud){
            for(int i = 1; i < posicion; i++){
                if(nodoBuscado.getSiguiente() != null) {
                    nodoBuscado = nodoBuscado.getSiguiente();
                } else {
                    nodoBuscado = null;
                    break;
                }
            }
        } else {
            nodoBuscado = null;
        }

        return nodoBuscado;
    }

    public boolean agregarPorPosicion(Object dato, int posicion){
        boolean exito = false;
        if(posicion > 0){
            Nodo nuevoNodo = new Nodo();
            nuevoNodo.setDato(dato);
            Nodo nodoActual = cabeza;
            Nodo nodoAnterior = null;
            // Insertar en la primera posicion
            if(posicion == 1){
                nuevoNodo.setSiguiente(nodoActual);
                cabeza = nuevoNodo;
                exito = true;
                longitud++;
            } else {
                if(!estaVacia() && posicion <= longitud){
                    int i = 1;
                    while(nodoActual != null){
                        // Encontré la posición exacta
                        if(i == posicion){
                            // Cuando el proximo nodo de la posición en donde se quiere insertar el elemento es diferente de nulo
                            // Es decir, cuando se quiere insertar en un lugar intermedio de la lista
                            nodoAnterior.setSiguiente(nuevoNodo);
                            nuevoNodo.setSiguiente(nodoActual);

                            exito = true;
                            longitud++;
                        } else {
                            // Seguir iterando en caso de no encontrarlo todavía
                            nodoAnterior = nodoActual;
                            nodoActual = nodoActual.getSiguiente();
                        }
                        i++;
                    }
                }
            }
        }
        return exito;
    }
}
