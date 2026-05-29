package Prog3-2026.TP5;

import java.util.ArrayList;
import java.util.HashMap;

public class Ejercicio5{

/*  Ejercicio 5
Asignación de tareas a procesadores. Se tienen m procesadores (procesadorId) idénticos y n tareas (tareaName) con un tiempo
de ejecución dado. Se requiere encontrar una asignación de tareas a procesadores de manera de
minimizar el tiempo de ejecución del total de tareas.
*/
    private int mejorTiempo;
    private int[] mejorAsignacion;

    public int[] asignarTareas(
            int[] tareas,
            int cantidadProcesadores) {

        int[] cargas = new int[cantidadProcesadores];

        int[] asignacionActual = new int[tareas.length];

        mejorTiempo = Integer.MAX_VALUE;

        mejorAsignacion =
                new int[tareas.length];

        asignarProcesos(
                tareas,
                0,
                cargas,
                asignacionActual);

        return mejorAsignacion;
    }


    private void asignarProcesos(int[] tareas, int index, int[] cargas,
                                 int[] asignacionActual) {
        // caso base
        if (index == tareas.length) {

            int tiempoTotal = obtenerMaximo(cargas);

            if (tiempoTotal < mejorTiempo) {

                mejorTiempo = tiempoTotal;

                mejorAsignacion = Arrays.copyOf(asignacionActual,
                                asignacionActual.length);
            }

            return;
        }

        // probar cada procesador
        for (int p = 0; p < cargas.length; p++) {

            // asignar tarea al procesador p
            cargas[p] += tareas[index];

            if(cargas[p] < mejorTiempo) {

                asignacionActual[index] = p;

                asignarProcesos(
                        tareas,
                        index + 1,
                        cargas,
                        asignacionActual);

                // BACKTRACKING
                cargas[p] -= tareas[index];
            }

        }
    }

    private int obtenerMaximo(int[] cargas) {

        int max = cargas[0];

        for (int c : cargas) {

            if (c > max) {
                max = c;
            }
        }

        return max;
    }

}