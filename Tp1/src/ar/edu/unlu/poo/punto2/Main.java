package ar.edu.unlu.poo.punto2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaEnlazadaDoble listaEnlazadaDoble = new ListaEnlazadaDoble();
        Scanner sc = new Scanner(System.in);
        int opcion;
        String aceptar;

        do {
            System.out.println("Menú (LISTA ENLAZADA DOBLE):");
            System.out.println("1. Agregar un nodo al final");
            System.out.println("2. Mostrar la lista");
            System.out.println("3. Verificar si la lista está vacía");
            System.out.println("4. Eliminar por posición");
            System.out.println("5. Agregar por posición");
            System.out.println("6. Recuperar dato por posición");
            System.out.println("7. Consultar la longitud de la lista");
            System.out.println("8. Salir");
            System.out.print("Elija una opción: ");

            // Verificar si la entrada es un número entero
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Por favor, ingrese un número, no una letra.");
                sc.nextLine();
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el dato a agregar: ");
                    String dato = sc.next();
                    separador();
                    listaEnlazadaDoble.agregarAlFinal(dato);
                    System.out.println("Dato agregado al final de la lista: " + dato);
                    separador();
                    System.out.print("Presione enter para continuar");
                    sc.nextLine();
                    sc.nextLine();
                    clearScreen();
                    break;
                case 2:
                    separador();
                    System.out.println("Lista:\n" + listaEnlazadaDoble + "\n");
                    separador();
                    System.out.print("Presione enter para continuar");
                    sc.nextLine();
                    clearScreen();
                    break;
                case 3:
                    separador();
                    if(listaEnlazadaDoble.estaVacia()){
                        System.out.println("La lista está vacía.");
                    } else {
                        System.out.println("La lista no está vacía, contiene " + listaEnlazadaDoble.getLongitud() + " elementos");
                    }
                    separador();
                    System.out.print("Presione enter para continuar");
                    sc.nextLine();
                    clearScreen();
                    break;
                case 4:
                    separador();
                    System.out.print("Ingrese la posición a eliminar: ");
                    int posicionEliminar = sc.nextInt();
                    if(listaEnlazadaDoble.eliminarPorPosicion(posicionEliminar)){
                        System.out.println("Elemento en la posición " + posicionEliminar + " eliminado con éxito de la lista.");
                    } else {
                        System.out.println("El elemento en la posición " + posicionEliminar + " no se pudo eliminar de la lista porque no existe");
                    }
                    separador();
                    System.out.println("Presione enter para continuar");
                    sc.nextLine();
                    sc.nextLine();
                    clearScreen();
                    break;
                case 5:
                    separador();
                    System.out.print("Ingrese la posición: ");
                    int posicionAgregar = sc.nextInt();
                    System.out.print("Ingrese el dato a agregar: ");
                    String datoNuevo = sc.next();
                    if(listaEnlazadaDoble.agregarPorPosicion(datoNuevo, posicionAgregar)){
                        System.out.println("Dato [" + datoNuevo + "] agregado con éxito en la posición " + posicionAgregar);
                    } else {
                        System.out.println("No se pudo agregar el dato en esa posición, ya que la lista posee una longitud de " + listaEnlazadaDoble.getLongitud() + ". Intente con otra posición.");
                    }
                    separador();
                    System.out.println("Presione enter para continuar");
                    sc.nextLine();
                    sc.nextLine();
                    clearScreen();
                    break;
                case 6:
                    separador();
                    System.out.print("Ingrese la posición para recuperar el dato: ");
                    int posicionRecuperar = sc.nextInt();
                    Nodo nodoRecuperado = listaEnlazadaDoble.recuperarPorPosicion(posicionRecuperar);
                    if (nodoRecuperado != null) {
                        System.out.println("Dato encontrado [ " + nodoRecuperado.getDato() + " ]") ;
                    } else {
                        System.out.println("El nodo buscado no existe en la lista");
                    }
                    separador();
                    System.out.println("Presione enter para continuar");
                    sc.nextLine();
                    sc.nextLine();
                    clearScreen();
                    break;
                case 7:
                    separador();
                    System.out.println("Longitud de la lista: " + listaEnlazadaDoble.getLongitud());
                    separador();
                    System.out.println("Presione enter para continuar");
                    sc.nextLine();
                    clearScreen();
                    break;
                case 8:
                    separador();
                    System.out.println("Saliendo del programa...");
                    separador();
                    break;
                default:
                    clearScreen();
                    System.out.println("Opción inválida");
            }

        } while (opcion != 8);

        sc.close();
    }

    public static void separador()
    {
        System.out.println("-----------------------------------" + "\n");
    }

    public static void clearScreen(){
        for (int i = 0; i < 50; ++i) {
            System.out.println();
        }
    }
}
