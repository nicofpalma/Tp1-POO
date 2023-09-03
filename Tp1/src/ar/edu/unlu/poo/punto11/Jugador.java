package ar.edu.unlu.poo.punto11;

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private int puntaje = 0;
    private ArrayList<String> palabras;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.palabras = new ArrayList<>();
    }
    public void jugarPalabra(String palabra){
        palabras.add(palabra);
    }

    public void sumarPuntaje(int puntaje){
        this.puntaje += puntaje;
    }

    public int getPuntaje(){
        return puntaje;
    }

    public ArrayList<String> getPalabras(){
        return palabras;
    }

    public String getNombre(){
        return nombre;
    }
}
