package TP5;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio3 {
    /*Dados n números positivos distintos, se desea encontrar todas las
    * combinaciones de esos números tal que la suma sea igual a M.*/

    public List<List<Integer>> getCombinacionesQueSumen(Integer M, int[] numeros){

        List<List<Integer>> resultadosList = new ArrayList<>();
        List<Integer> actual = new ArrayList<>();

        buscarCombinaciones(M, numeros,0,0, resultadosList, actual);
        return resultadosList;

    }

    private void buscarCombinaciones (Integer objetivo, int[] numeros, int indice, int sumaActual,
                                      List<List<Integer>> resultadosList, List<Integer> actual){

        if(sumaActual==objetivo){
            resultadosList.add(actual);
            return;
        }

        if(sumaActual>objetivo){
            return;
        }

        for (int i = indice; i < numeros.length; i++) {

            actual.add(numeros[i]);

            buscarCombinaciones(
                    objetivo,
                    numeros,
                    i + 1,
                    sumaActual + numeros[i],
                    resultadosList,
                    actual);

            // BACKTRACKING
            actual.removeLast();
        }
    }

}