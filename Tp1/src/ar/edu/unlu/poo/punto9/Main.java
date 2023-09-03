package ar.edu.unlu.poo.punto9;

public class Main {
    public static void main (String[] args){
        Fecha f1 = new Fecha("06-22-2019");
        System.out.println(f1.getFecha());

        System.out.println(f1.estaEntre("06-15-2019", "07-20-2019"));
        System.out.println(f1.esMayorQue("03-29-1996"));
        System.out.println(f1.esMenorQue("07-20-2023"));
    }
}
