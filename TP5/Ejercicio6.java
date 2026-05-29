package Prog3_2026.TP5;

import Prog3-2026.util.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ejercicio6 {

    /*
    Caballo de Atila.

    Encontrar el recorrido cerrado realizado por el caballo:
    - se mueve horizontal/vertical
    - no repite casillas
    - vuelve al origen
    - debe recorrer todas las casillas pisadas
    */

    public List<Casillero> getCasillerosPisadosPorAtila(
            Laberinto laberinto,
            Casillero origen,
            int totalCasillasPisadas) {

        List<Casillero> caminoActual =
                new ArrayList<>();

        List<Casillero> caminoDeAtila =
                new ArrayList<>();

        Set<Casillero> visitados =
                new HashSet<>();

        caminoActual.add(origen);
        visitados.add(origen);

        buscarCaminoDeAtila(
                laberinto,
                origen,
                origen,
                visitados,
                caminoActual,
                caminoDeAtila,
                totalCasillasPisadas);

        return caminoDeAtila;
    }


    private void buscarCaminoDeAtila(
            Laberinto laberinto,
            Casillero actual,
            Casillero origen,
            Set<Casillero> visitados,
            List<Casillero> caminoActual,
            List<Casillero> caminoDeAtila,
            int totalCasillasPisadas) {

        // CASO SOLUCIÓN:
        // volvió al origen
        // recorrió todas las casillas pisadas

        if (actual.equals(origen)
                && caminoActual.size() > 1
                && visitados.size() == totalCasillasPisadas) {

            caminoDeAtila.clear();
            caminoDeAtila.addAll(caminoActual);

            return;
        }

        Posicion pos = laberinto.getPosicion(actual);

        // NORTE
        mover(
                laberinto,
                pos.getFila() - 1,
                pos.getColumna(),
                origen,
                visitados,
                caminoActual,
                caminoDeAtila,
                totalCasillasPisadas);

        // ESTE
        mover(
                laberinto,
                pos.getFila(),
                pos.getColumna() + 1,
                origen,
                visitados,
                caminoActual,
                caminoDeAtila,
                totalCasillasPisadas);

        // SUR
        mover(
                laberinto,
                pos.getFila() + 1,
                pos.getColumna(),
                origen,
                visitados,
                caminoActual,
                caminoDeAtila,
                totalCasillasPisadas);

        // OESTE
        mover(
                laberinto,
                pos.getFila(),
                pos.getColumna() - 1,
                origen,
                visitados,
                caminoActual,
                caminoDeAtila,
                totalCasillasPisadas);
    }


    private void mover(
            Laberinto laberinto,
            int fila,
            int columna,
            Casillero origen,
            Set<Casillero> visitados,
            List<Casillero> caminoActual,
            List<Casillero> caminoDeAtila,
            int totalCasillasPisadas) {

        // verificar existencia
        if (!laberinto.existeCasillero(fila, columna)) {
            return;
        }

        Casillero siguiente =
                laberinto.getCasillero(fila, columna);

        // puedo volver al origen SOLO
        // si recorrí todas las casillas
        if (siguiente.equals(origen)
                && visitados.size() == totalCasillasPisadas) {

            caminoActual.add(siguiente);

            caminoDeAtila.clear();
            caminoDeAtila.addAll(caminoActual);

            caminoActual.remove(caminoActual.size() - 1);

            return;
        }

        // evitar revisitas
        if (!visitados.contains(siguiente)) {

            caminoActual.add(siguiente);
            visitados.add(siguiente);

            buscarCaminoDeAtila(
                    laberinto,
                    siguiente,
                    origen,
                    visitados,
                    caminoActual,
                    caminoDeAtila,
                    totalCasillasPisadas);

            // BACKTRACKING
            caminoActual.remove(caminoActual.size() - 1);
            visitados.remove(siguiente);
        }
    }
}