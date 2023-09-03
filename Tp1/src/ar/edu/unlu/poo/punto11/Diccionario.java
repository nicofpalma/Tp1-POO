package ar.edu.unlu.poo.punto11;

import java.util.ArrayList;
import java.util.List;

public class Diccionario {
    private ArrayList<String> palabrasValidas;

    public Diccionario(List<String> palabras){
        palabrasValidas = new ArrayList<>();
        agregarPalabras(palabras);
    }

    public void agregarPalabras(List<String> palabras){
        palabrasValidas.addAll(palabras);
    }

    public boolean palabraValida(String palabra){
        for (int i = 0; i < palabrasValidas.size(); i++) {
            if(palabra.toLowerCase().equals(palabrasValidas.get(i).toLowerCase())){
                return true;
            }
        }
        return false;
    }

    public int getPuntajePalabra(String palabra){
        int puntaje = palabra.length();
        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            if(letra == 'k' || letra == 'z' || letra == 'x' || letra == 'y' || letra == 'w' || letra == 'q'){
                puntaje += 1;
            }
        }
        return puntaje;
    }
}
