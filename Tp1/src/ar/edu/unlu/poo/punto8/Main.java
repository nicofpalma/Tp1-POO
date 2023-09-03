package ar.edu.unlu.poo.punto8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int opcion = 1;

        do {
            System.out.println("Menú (Generador de contraseñas):");
            System.out.println("1. Crear nueva colección de contraseñas");
            System.out.println("2. Crear una única contraseña de tamaño 8");
            System.out.println("3. Crear una única contraseña del tamaño elegido por teclado (8 es el tamaño mínimo)");
            System.out.println("4. Crear una contraseña y transformarla a fuerte si se genera una contraseña débil");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            if (sc.hasNextInt()){
                opcion = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Por favor, ingrese un número, no una letra");
                sc.nextLine();
                opcion = 0;
            }

            switch (opcion){
                case 1:
                    System.out.print("Ingrese el tamaño de la colección: ");
                    int collectionLength = sc.nextInt();
                    System.out.print("Ingrese la longitud de las contraseñas: ");
                    int passwordsLength = sc.nextInt();

                    List<PasswordGenerator> passwordList = new ArrayList<>();
                    System.out.println("\nColección de contraseñas generadas:\n");
                    for (int i = 0; i < collectionLength; i++) {
                        passwordList.add(new PasswordGenerator(passwordsLength));
                        System.out.println(passwordList.get(i) + "\n");
                    }
                    System.out.print("Presione enter para continuar");
                    sc.nextLine();
                    sc.nextLine();
                    System.out.println("\n\n");
                    break;
                case 2:
                    PasswordGenerator newPassword = new PasswordGenerator();
                    System.out.println("\nContraseña de tamaño 8:\n" + newPassword + "\n");
                    System.out.println("Presione enter para continuar");
                    sc.nextLine();
                    System.out.println("\n\n");
                    break;
                case 3:
                    System.out.print("Ingrese el tamaño de la contraseña a generar: ");
                    int passLength = sc.nextInt();
                    PasswordGenerator newPasswordWithLength = new PasswordGenerator(passLength);
                    System.out.println("\nContraseña de tamaño " + passLength + ": " + newPasswordWithLength + "\n");
                    System.out.println("Presione enter para continuar");
                    sc.nextLine();
                    sc.nextLine();
                    System.out.println("\n\n");
                    break;

                case 4:
                    System.out.println("Ingrese el tamaño de la contraseña a generar: ");
                    int passLength2 = sc.nextInt();
                    PasswordGenerator newPasswordWithLength2 = new PasswordGenerator(passLength2);
                    System.out.println("\nContraseña de tamaño " + passLength2 + ": " + newPasswordWithLength2 + "\n");
                    if(!newPasswordWithLength2.isStrong()){
                        newPasswordWithLength2.makeStrong();
                        System.out.println("Contraseña débil transformada a contraseña fuerte:\n" + newPasswordWithLength2);
                    } else {
                        System.out.println("La contraseña es fuerte");
                    }
                    System.out.println("Presione enter para continuar");
                    sc.nextLine();
                    sc.nextLine();
                    System.out.println("\n\n");
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 5);
        sc.close();

    }
}
