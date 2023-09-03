package ar.edu.unlu.poo.punto4;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cola cola = new Cola();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú (COLA):");
            System.out.println("1. Encolar");
            System.out.println("2. Mostrar cola");
            System.out.println("3. Verificar si la cola está vacía");
            System.out.println("4. Desencolar");
            System.out.println("5. Consultar la longitud de la cola");
            System.out.println("6. Salir");
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
                    cola.encolar(dato);
                    System.out.println("Dato encolado: " + dato);
                    separador();
                    System.out.print("Presione enter para continuar");
                    sc.nextLine();
                    sc.nextLine();
                    clearScreen();
                    break;
                case 2:
                    separador();
                    System.out.println("Cola:\n" + cola + "\n");
                    separador();
                    System.out.print("Presione enter para continuar");
                    sc.nextLine();
                    clearScreen();
                    break;
                case 3:
                    separador();
                    if(cola.estaVacia()){
                        System.out.println("La cola está vacía.");
                    } else {
                        System.out.println("La cola no está vacía, contiene " + cola.getLongitud() + " elementos");
                    }
                    separador();
                    System.out.print("Presione enter para continuar");
                    sc.nextLine();
                    clearScreen();
                    break;
                case 4:
                    separador();
                    Object nodoDesencolado = cola.desencolar();
                    if(nodoDesencolado != null){
                        System.out.println("Dato desencolado: " + nodoDesencolado);
                    } else {
                        System.out.println("No se pudo desencolar porque la cola no contiene elementos");
                    }
                    separador();
                    System.out.println("Presione enter para continuar");
                    sc.nextLine();
                    clearScreen();
                    break;
                case 5:
                    separador();
                    System.out.println("La cola contiene " + cola.getLongitud() + " elementos.");
                    separador();
                    System.out.println("Presione enter para continuar");
                    sc.nextLine();
                    clearScreen();
                    break;
                case 6:
                    separador();
                    System.out.println("Saliendo del programa...");
                    separador();
                    break;
                default:
                    clearScreen();
                    System.out.println("Opción inválida");
            }

        } while (opcion != 6);

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
