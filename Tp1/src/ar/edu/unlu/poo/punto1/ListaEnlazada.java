package ar.edu.unlu.poo.punto1;

public class ListaEnlazada {
    private Nodo cabeza = null;

    // Método para agregar un nodo a la lista
    public boolean agregarAlFinal(Object dato){
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setDato(dato);
        if(cabeza == null){
            cabeza = nuevoNodo;
        } else {
            Nodo nodoAux = cabeza;
            while(nodoAux.getSiguiente() != null){
                nodoAux = nodoAux.getSiguiente();
            }
            nodoAux.setSiguiente(nuevoNodo);
        }
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
    public int longitud(){
        Nodo nodoAux = cabeza;
        int i = 0;
        while (nodoAux != null){
            i ++;
            nodoAux = nodoAux.getSiguiente();
        }

        return i;
    }

    // Elimina un elemento ubicado en cierta posición pasada por parámetro
    public boolean eliminarPorPosicion(int posicion){
        boolean exito = false;
        if(posicion > 0){
            Nodo nodoActual = cabeza;
            Nodo nodoAnterior = null;
            if(!estaVacia()){
                if(posicion == 1){
                    cabeza = cabeza.getSiguiente();
                    exito = true;
                } else {
                    int i = 1;
                    while(nodoActual != null){
                        if(i == posicion){
                            nodoAnterior.setSiguiente(nodoAnterior.getSiguiente().getSiguiente());
                            nodoActual = null;
                            exito = true;
                        } else {
                            nodoAnterior = nodoActual;
                            nodoActual = nodoActual.getSiguiente();
                        }
                    }
                }
            }
        }
        return exito;
    }

    public Nodo recuperarPorPosicion(int posicion){
        Nodo nodoBuscado = cabeza;
        if(posicion > 0){
            if(!estaVacia()){
                for(int i = 1; i < posicion; i++){
                    if(nodoBuscado.getSiguiente() != null) {
                        nodoBuscado = nodoBuscado.getSiguiente();
                    } else {
                        nodoBuscado = null;
                        break;
                    }
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
            } else {
                int i = 1;
                while(nodoActual != null){
                    // Encontré la posición exacta
                    if(i == posicion){
                        // Cuando el proximo nodo de la posición en donde se quiere insertar el elemento es diferente de nulo
                        // Es decir, cuando se quiere insertar en un lugar intermedio de la lista
                        nodoAnterior.setSiguiente(nuevoNodo);
                        if(nodoActual.getSiguiente() != null) {
                            nuevoNodo.setSiguiente(nodoActual);
                        } else {
                            // Cuando se quiere insertar al final
                            nuevoNodo.setSiguiente(nodoActual);
                        }
                        exito = true;
                    } else {
                        // Seguir iterando en caso de no encontrarlo todavía
                        nodoAnterior = nodoActual;
                        nodoActual = nodoActual.getSiguiente();
                    }
                    i++;
                }
            }
        }
        return exito;
    }
}
