package ar.edu.unlu.poo.punto2;

public class ListaEnlazadaDoble {
    private Nodo cabeza = null;

    private int longitud = 0;

    public int getLongitud(){
        return longitud;
    }

    public boolean agregarAlFinal(Object dato){
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setDato(dato);

        if(estaVacia()){
            cabeza = nuevoNodo;
        } else {
            Nodo nodoAnterior = cabeza;
            while(nodoAnterior.getSiguiente() != null){
                nodoAnterior = nodoAnterior.getSiguiente();
            }
            nodoAnterior.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(nodoAnterior);
        }
        longitud++;
        return true;
    }

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

    public boolean estaVacia(){
        return cabeza == null;
    }

    public boolean eliminarPorPosicion(int posicion){
        boolean exito = false;
        if(posicion > 0 && !estaVacia() && posicion <= longitud){
            Nodo nodoActual = cabeza;
            Nodo nodoAnterior = null;

            if(posicion == 1){
                cabeza = cabeza.getSiguiente();
                if(cabeza != null){
                    cabeza.setAnterior(null);
                }
                exito = true;
                longitud--;
            } else {
                for(int i = 1; i <= posicion; i++){
                    if(i == posicion){
                        if(posicion != longitud){
                            Nodo nodoSiguiente = nodoAnterior.getSiguiente().getSiguiente();
                            nodoAnterior.setSiguiente(nodoSiguiente);
                            nodoSiguiente.setAnterior(nodoAnterior);
                        } else {
                            nodoAnterior.setSiguiente(null);
                        }

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
                            nuevoNodo.setAnterior(nodoAnterior);

                            nuevoNodo.setSiguiente(nodoActual);
                            nodoActual.setAnterior(nuevoNodo);

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
