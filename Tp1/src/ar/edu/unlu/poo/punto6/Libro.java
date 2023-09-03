package ar.edu.unlu.poo.punto6;

public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private int numPaginas;
    private int numEjemplares;
    private int numEjemplaresPrestados = 0;

    public Libro(String titulo, String autor, String isbn, int numPaginas, int numEjemplares){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.numPaginas = numPaginas;
        this.numEjemplares = numEjemplares;
    }

    public String toString(){
        return
                "El libro " + titulo
                + " creado por el autor " + autor
                + " tiene " + numPaginas + " páginas, quedan "
                + cantidadDeEjemplaresDisponibles() + " disponibles y se prestaron " + numEjemplaresPrestados + ".";
    }

    public void setTitulo(String titulo) {this.titulo = titulo;}
    public String getTitulo(){return titulo;}
    public void setAutor(String autor) {this.autor = autor;}
    public String getAutor(){return autor;}
    public void setISBN(String isbn){this.isbn = isbn;}
    public String getISBN() {return isbn;}
    public void setNumPaginas(int numPaginas){this.numPaginas = numPaginas;}
    public int getNumPaginas() {return numPaginas;}
    public void setNumEjemplares(int numEjemplares) {this.numEjemplares = numEjemplares;}
    public int getNumEjemplares() {return numEjemplares;}
    public void setNumEjemplaresPrestados(int numEjemplaresPrestados) {this.numEjemplaresPrestados = numEjemplaresPrestados;}
    public int getNumEjemplaresPrestados() {return numEjemplaresPrestados;}
    public int cantidadDeEjemplaresDisponibles() {return numEjemplares - numEjemplaresPrestados;}

    public boolean prestarEjemplar(){
        boolean prestado = false;
        if(cantidadDeEjemplaresDisponibles() > 1){
            numEjemplaresPrestados++;
            prestado = true;
        } else {
            System.out.println("\nNo quedan ejemplares disponibles del libro "  + getTitulo() + " para prestar.\n");
        }
        return prestado;
    }

    public boolean devolverEjemplar(){
        boolean devuelto = false;
        if(numEjemplaresPrestados > 0){
            numEjemplaresPrestados--;
            devuelto = true;
        } else {
            System.out.println("\n No hay ejemplares prestados para devolver.\n");
        }
        return devuelto;
    }

}
