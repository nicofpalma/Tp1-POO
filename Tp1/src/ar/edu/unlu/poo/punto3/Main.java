package ar.edu.unlu.poo.punto3;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pila pila = new Pila();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú (PILA):");
            System.out.println("1. Apilar");
            System.out.println("2. Mostrar pila");
            System.out.println("3. Verificar si la pila está vacía");
            System.out.println("4. Desapilar");
            System.out.println("5. Consultar la longitud de la pila");
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
                    pila.apilar(dato);
                    System.out.println("Dato apilado: " + dato);
                    separador();
                    System.out.print("Presione enter para continuar");
                    sc.nextLine();
                    sc.nextLine();
                    clearScreen();
                    break;
                case 2:
                    separador();
                    System.out.println("Pila:\n" + pila + "\n");
                    separador();
                    System.out.print("Presione enter para continuar");
                    sc.nextLine();
                    clearScreen();
                    break;
                case 3:
                    separador();
                    if(pila.estaVacia()){
                        System.out.println("La pila está vacía.");
                    } else {
                        System.out.println("La pila no está vacía, contiene " + pila.getLongitud() + " elementos");
                    }
                    separador();
                    System.out.print("Presione enter para continuar");
                    sc.nextLine();
                    clearScreen();
                    break;
                case 4:
                    separador();
                    Object nodoDesapilado = pila.desapilar();
                    if(nodoDesapilado != null){
                        System.out.println("Dato desapilado: " + nodoDesapilado);
                    } else {
                        System.out.println("No se pudo desapilar porque la pila no contiene elementos");
                    }
                    separador();
                    System.out.println("Presione enter para continuar");
                    sc.nextLine();
                    clearScreen();
                    break;
                case 5:
                    separador();
                    System.out.println("La pila contiene " + pila.getLongitud() + " elementos.");
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
