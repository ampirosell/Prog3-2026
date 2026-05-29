package Prog3-2026.TP5;

import Prog3-2026.util.Casillero;
import Prog3-2026.util.Laberinto;
import Prog3-2026.util.Posicion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ejercicio2 {

    /* Dado un laberinto consistente en una matriz cuadrada que tiene en cada posición un valor natural y
    * cuatro valores booleanos, indicando estos últimos si desde esa casilla se puede ir al norte, este, sur
    * y oeste, encontrar un camino de longitud mínima entre dos casillas dadas, siendo la longitud de un
    * camino la suma de los valores naturales de las casillas por las que pasa.*/
    int menorSuma;

    public List<Casillero> getCaminoMasCorto(Laberinto laberinto, Casillero origen, Casillero destino) {

        List<Casillero> caminoActual = new ArrayList<>();
        List<Casillero> caminoMasCorto = new ArrayList<>();
        Set<Casillero> visitados = new HashSet<>();

        int sumaActual=origen.getValorNum();
        menorSuma = Integer.MAX_VALUE;

        caminoActual.add(origen);
        visitados.add(origen);

        buscarCaminoMasCorto(laberinto, origen, destino, visitados, caminoActual, sumaActual, caminoMasCorto);

        return caminoMasCorto;
    }

    private void buscarCaminoMasCorto(Laberinto laberinto, Casillero actual,
                                      Casillero destino, Set<Casillero> visitados,
                                      List<Casillero> caminoActual, int sumaActual,
                                      List<Casillero> caminoMasCorto){

        if(sumaActual >= menorSuma){
            return;
        }
        
        if(actual.equals(destino)){
            if(sumaActual<menorSuma){
                caminoMasCorto.clear();
                caminoMasCorto.addAll(caminoActual);
                menorSuma=sumaActual;
            }
        }else{


            Posicion pos = laberinto.getPosicion(actual);


            //NORTE: fila-1, columna

            if(actual.isPuedeIrNorte()){
                if(laberinto.existeCasillero(pos.getFila()-1, pos.getColumna())){
                    Casillero casNorte = laberinto.getCasillero(pos.getFila()-1, pos.getColumna());

                    if(!visitados.contains(casNorte)){

                        int nuevaSuma = sumaActual + casNorte.getValorNum();

                        caminoActual.add(casNorte);
                        visitados.add(casNorte);

                        buscarCaminoMasCorto(laberinto, casNorte, destino,
                                visitados, caminoActual, nuevaSuma,
                                caminoMasCorto);

                        caminoActual.remove(caminoActual.size()-1);
                        visitados.remove(casNorte);
                    }
                }
            }

            // ESTE: fila, columna+1
            if(actual.isPuedeIrEste()){

                if(laberinto.existeCasillero(pos.getFila(), pos.getColumna()+1)){
                    Casillero casEste = laberinto.getCasillero(pos.getFila(), pos.getColumna()+1);

                    if(!visitados.contains(casEste)){

                        int nuevaSuma = sumaActual + casEste.getValorNum();

                        caminoActual.add(casEste);
                        visitados.add(casEste);

                        buscarCaminoMasCorto(laberinto,casEste, destino,
                                visitados, caminoActual, nuevaSuma,
                                caminoMasCorto);

                        caminoActual.remove(caminoActual.size()-1);
                        visitados.remove(casEste);
                    }
                }
            }


            // SUR: fila+1, columna
            if(actual.isPuedeIrSur()){

                if(laberinto.existeCasillero(pos.getFila()+1, pos.getColumna())){
                    Casillero casSur = laberinto.getCasillero(pos.getFila()+1, pos.getColumna());

                    if(!visitados.contains(casSur)){

                        int nuevaSuma = sumaActual + casSur.getValorNum();

                        caminoActual.add(casSur);
                        visitados.add(casSur);

                        buscarCaminoMasCorto(laberinto,casSur, destino,
                                visitados, caminoActual, nuevaSuma,
                                caminoMasCorto);

                        caminoActual.remove(caminoActual.size()-1);
                        visitados.remove(casSur);
                    }
                }
            }


            // OESTE: fila, columna-1
            if(actual.isPuedeIrOeste()){

                if(laberinto.existeCasillero(pos.getFila(), pos.getColumna()-1)){
                    Casillero casOeste = laberinto.getCasillero(pos.getFila(), pos.getColumna()-1);

                    if(!visitados.contains(casOeste)){

                        int nuevaSuma = sumaActual + casOeste.getValorNum();

                        caminoActual.add(casOeste);
                        visitados.add(casOeste);

                        buscarCaminoMasCorto(laberinto,casOeste, destino,
                                visitados, caminoActual, nuevaSuma,
                                caminoMasCorto);

                        caminoActual.remove(caminoActual.size()-1);
                        visitados.remove(casOeste);
                    }
                }
            }
        }
    }
}