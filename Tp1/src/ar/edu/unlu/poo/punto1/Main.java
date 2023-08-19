package ar.edu.unlu.poo.punto1;

public class Main {
    public static void main(String[] args) {
        ListaEnlazada listaEnlazada = new ListaEnlazada();

        // Agrego nuevos nodos
        listaEnlazada.agregarAlFinal("Nodo1");
        listaEnlazada.agregarAlFinal("Nodo2");
        listaEnlazada.agregarAlFinal("Nodo3");
        listaEnlazada.agregarAlFinal("Nodo4");
        System.out.println("Longitud: " + listaEnlazada.longitud());

        // Muestro la lista
        System.out.println("Lista: \n" + listaEnlazada);

        // Controlo si la lista está vacía
        System.out.println(listaEnlazada.estaVacia());

        // Intento eliminar una posición que no existe
        listaEnlazada.eliminarPorPosicion(7);

        // Elimino una posición que sí existe
        listaEnlazada.eliminarPorPosicion(2);

        // Recupero un dato de la lista, devuelve un nodo, pero con getDato lo muestro
        System.out.println("Dato buscado: " + listaEnlazada.recuperarPorPosicion(4).getDato());

        // Agrego un nuevo dato a la lista
        listaEnlazada.agregarPorPosicion("Nuevo dato", 2);

        System.out.println(listaEnlazada);
    }
}