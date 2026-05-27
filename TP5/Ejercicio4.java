package proyectos.TP5;

import java.util.Arrays;


public class Ejercicio4{

/*
Partición de conjunto. Dado un conjunto de n enteros se desea encontrar, si existe, una partición en‬
‭ dos subconjuntos disjuntos, tal que la suma de sus elementos sea la mism
*/

    public int[] particionConjuntos(int[] numeros) {

        int[] posiciones = new int[numeros.length];

        boolean existe = buscarSubconjuntosDisjuntos(
                numeros,
                posiciones,
                0,
                0,
                0);

        if (existe) {
            return posiciones;
        }

        return null;
    }

    private boolean buscarSubconjuntosDisjuntos(
            int[] numeros,
            int[] posiciones,
            int index,
            int suma1,
            int suma2) {

        
        if (index == numeros.length) {
            return suma1 == suma2;
        }

        int actual = numeros[index];

        //camino uno en este caso va al subconjunto 1
        posiciones[index] = 1;

        if (buscarSubconjuntosDisjuntos(
                numeros,
                posiciones,
                index + 1,
                suma1 + actual,
                suma2)) {

            return true;
        }

        // pongo en subconjunto 2
        posiciones[index] = 2;

        if (buscarSubconjuntosDisjuntos(
                numeros,
                posiciones,
                index + 1,
                suma1,
                suma2 + actual)) {

            return true;
        }

        // backtracking
        posiciones[index] = 0;

        return false;
    }


}