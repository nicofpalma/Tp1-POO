package ar.edu.unlu.poo.punto6;

public class Main {
    public static void main(String[] args) {
        Libro libroRelatividad = new Libro("Teoría de la relatividad", "Albert Einstein", "978-980-14-2517-5", 3245, 10);
        Libro libroInfantil = new Libro("Juegos para niños", "Maria Lopez", "157-545-45-7645-1", 150, 1);

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.agregarLibro(libroRelatividad);
        biblioteca.agregarLibro(libroInfantil);

        System.out.println("-----\nPrestando libro: Teoría de la relatividad");
        biblioteca.prestarLibroPorTitulo("Teoría de la relatividad");
        System.out.println("-----");

        System.out.println("-----\nPrestando libro por autor: Maria Lopez");
        biblioteca.prestarLibroPorAutor("Maria Lopez");
        System.out.println("-----");

        System.out.println(biblioteca);

        System.out.println("\nEl libro que tiene más páginas es " + biblioteca.getLibroConMasPaginas(libroInfantil, libroRelatividad) + ".");

        System.out.println("Cantidad de préstamos en total: " +biblioteca.getCantidadPrestamos());


    }
}
