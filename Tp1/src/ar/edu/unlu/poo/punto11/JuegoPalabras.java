package ar.edu.unlu.poo.punto11;

import java.util.ArrayList;

public class JuegoPalabras {
    private String ganador;

    private Jugador jugador1;

    private Jugador jugador2;

    private Diccionario diccionario;

    public JuegoPalabras(Jugador jugador1, Jugador jugador2, Diccionario diccionario){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.diccionario = diccionario;
    }

    public String getGanador(){
        return ganador;
    }

    public String jugar(){
        ArrayList<String> palabrasJugador1 = jugador1.getPalabras();
        ArrayList<String> palabrasJugador2 = jugador2.getPalabras();

        int puntajeJugador1 = 0;
        int puntajeJugador2 = 0;
        for (int i = 0; i < palabrasJugador1.size(); i++) {
            if(diccionario.palabraValida(palabrasJugador1.get(i))){
                puntajeJugador1 += diccionario.getPuntajePalabra(palabrasJugador1.get(i));
            }
        }

        jugador1.sumarPuntaje(puntajeJugador1);

        for (int i = 0; i < palabrasJugador2.size(); i++) {
            if(diccionario.palabraValida(palabrasJugador2.get(i))){
                puntajeJugador2 += diccionario.getPuntajePalabra(palabrasJugador2.get(i));
            }
        }

        jugador2.sumarPuntaje(puntajeJugador2);

        String resultado = "\nPuntaje " + jugador1.getNombre() + ": " + jugador1.getPuntaje()
                + "\nPuntaje " + jugador2.getNombre() + ": " + jugador2.getPuntaje();

        if(jugador1.getPuntaje() > jugador2.getPuntaje()){
            resultado += "\nEl jugador " + jugador1.getNombre() + " es el ganador. Felicitaciones!";
            ganador = jugador1.getNombre();
        } else {
            if(jugador2.getPuntaje() > jugador1.getPuntaje()){
                resultado += "\nEl jugador " + jugador2.getNombre() + " es el ganador. Felicitaciones!";
                ganador = jugador2.getNombre();
            } else {
                resultado += "\nEl juego resultó en empate.";
                ganador = "Empate";
            }
        }


        return resultado;
    }

}
