package ar.edu.unlu.poo.punto11;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        List<String> palabras = new ArrayList<>();
        palabras.add("Hola");
        palabras.add("Chau");
        palabras.add("Koala");
        palabras.add("Caza");
        palabras.add("Zorro");
        palabras.add("Xilófono");
        palabras.add("Exacto");
        palabras.add("Yo");
        palabras.add("Hay");
        palabras.add("Hambre");
        palabras.add("Karate");
        palabras.add("Yoga");
        palabras.add("Whisky");
        palabras.add("Química");
        palabras.add("Constitución");

        Diccionario diccionario = new Diccionario(palabras);

        Jugador jugador1 = new Jugador("Nicolás");
        Jugador jugador2 = new Jugador("Carlos");

        jugador1.jugarPalabra("Zorro");
        jugador2.jugarPalabra("Whisky");

        jugador1.jugarPalabra("Constitución");
        jugador2.jugarPalabra("Yoga");

        jugador1.jugarPalabra("Xilófono");
        jugador2.jugarPalabra("Química");

        jugador1.jugarPalabra("Casa");
        jugador2.jugarPalabra("Hermano");

        jugador2.jugarPalabra("Hola");
        jugador1.jugarPalabra("Chau");

        JuegoPalabras nuevoJuego = new JuegoPalabras(jugador1, jugador2, diccionario);
        System.out.println(nuevoJuego.jugar());
    }

}
