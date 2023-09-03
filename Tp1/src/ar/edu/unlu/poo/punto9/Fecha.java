package ar.edu.unlu.poo.punto9;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fecha {
    private LocalDate fecha;

    private String formato;

    public Fecha(String fecha){
        this.fecha = formatearFecha(fecha);
    }

    public String getFecha(){
        DateTimeFormatter formateada = DateTimeFormatter.ofPattern(formato);
        return fecha.format(formateada);
    }

    public boolean estaEntre(String minima, String maxima){
        return esMayorQue(minima) && esMenorQue(maxima);
    }

    public boolean esMayorQue(String fecha){
        LocalDate fechaParametro = formatearFecha(fecha);

        return this.fecha.isAfter(fechaParametro);
    }

    public boolean esMenorQue(String fecha){
        LocalDate fechaParametro = formatearFecha(fecha);

        return this.fecha.isBefore(fechaParametro);
    }

    private LocalDate formatearFecha(String fecha){
        String patron1 = "dd-MM-yyyy";
        String patron2 = "MM-dd-yyyy";
        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern(patron1);
        DateTimeFormatter formato2 = DateTimeFormatter.ofPattern(patron2);
        LocalDate fechaFormateada = null;
        try {
            fechaFormateada = LocalDate.parse(fecha, formato1);
            formato = patron1;
        } catch (DateTimeException ex1){
            try {
                fechaFormateada = LocalDate.parse(fecha, formato2);
                formato = patron2;
            } catch (DateTimeException ex2){
                System.out.println("El formato de fecha que has escrito es incorrecto. Solo se permite [dd-MM-yyyy] y [MM-dd-yyyy].");
            }
        }
        return fechaFormateada;
    }
}
