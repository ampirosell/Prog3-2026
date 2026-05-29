package Prog3-2026.TP5;

import java.util.*;

public class Ejercicio1<T> {

    public List<T> devolverCaminoMasLargo(
            GrafoDirigido<T> grafo,
            T entrada,
            T salida) {

        List<T> caminoMasLargo = new ArrayList<>();
        List<T> caminoActual = new ArrayList<>();

        Set<T> visitados = new HashSet<>();

        caminoActual.add(entrada);
        visitados.add(entrada);

        buscarCaminoMayorLongitud(
                grafo,
                entrada,
                salida,
                visitados,
                caminoActual,
                caminoMasLargo);

        return caminoMasLargo;
    }

    private void buscarCaminoMayorLongitud(
            GrafoDirigido<T> grafo,
            T actual,
            T salida,
            Set<T> visitados,
            List<T> caminoActual,
            List<T> caminoMasLargo) {

        if (actual.equals(salida)) {

            if (caminoActual.size() > caminoMasLargo.size()) {

                caminoMasLargo.clear();
                caminoMasLargo.addAll(caminoActual);
            }
        }
        else {

            Iterator<T> adyacentes =
                    grafo.obtenerAdyacentes(actual);

            while (adyacentes.hasNext()) {

                T siguiente = adyacentes.next();

                if (!visitados.contains(siguiente)) {

                    visitados.add(siguiente);
                    caminoActual.add(siguiente);

                    buscarCaminoMayorLongitud(
                            grafo,
                            siguiente,
                            salida,
                            visitados,
                            caminoActual,
                            caminoMasLargo);

                    // BACKTRACKING
                    visitados.remove(siguiente);
                    caminoActual.remove(caminoActual.size() - 1);
                }
            }
        }
    }
}