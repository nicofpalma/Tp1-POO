package ar.edu.unlu.poo.punto7;

public class Main {
    public static void main(String[] args) {
        EcuacionSegundoGrado ecuacionUnicaRaiz = new EcuacionSegundoGrado(1, -6, 9);
        System.out.println("Ejemplo con una única raíz real: \n" + ecuacionUnicaRaiz);

        EcuacionSegundoGrado ecuacionDosRaices = new EcuacionSegundoGrado(1, -4, 3);
        System.out.println("Ejemplo con dos raíces reales: \n" + ecuacionDosRaices);

        EcuacionSegundoGrado ecuacionConRaicesNoReales = new EcuacionSegundoGrado(1, 2, 5);
        System.out.println("Ejemplo con raices no reales: \n" + ecuacionConRaicesNoReales);

        EcuacionSegundoGrado ecuacionConValorDeX = new EcuacionSegundoGrado(1, -4, 3, 5);
        System.out.println("Ejemplo de ecuación pasándole el valor de X: \n" + ecuacionConValorDeX.getY());
    }

}
