package Prog3-2026.TP6;

public class Ejercicio1 {

    /*Cambio de monedas: Dado un conjunto C de N tipos de monedas con un número ilimitado de
ejemplares de cada tipo, se requiere formar, si se puede, una cantidad M empleando el mínimo
número de ellas.*/


    //Asumo que el array recibido de importes está ordenado de mayor a menor
    public int[] getCantidadMonedas(int[] importesOrdenados, int M){
        int[] cantidadMonedas = new int[importesOrdenados.length];

        if(M<importesOrdenados[importesOrdenados.length-1]){
            System.out.println("No hay cambio disponible ya que el valor dado es menor al menor importe de monedas. " +
                    "Valor dado: "+M+", menor cambio: "+importesOrdenados[importesOrdenados.length-1]);
            return cantidadMonedas;
        }

        for(int i=0; i<importesOrdenados.length; i++){
            cantidadMonedas[i] = M/importesOrdenados[i];
            M = M % importesOrdenados[i];
        }

        if(M!=0){
            return null;
        }

        return cantidadMonedas;
    }
/* me volé a backtracking...
    private boolean getCantidadMonedas(int[] importesOrdenados,
                                       int sumaObjetivo,
                                       int sumaActual,
                                       int index,
                                       int[] cantidadMonedas){

        //poda
        if(sumaActual > sumaObjetivo){
            return false;
        }


        if(index>=importesOrdenados.length){
            return sumaActual == sumaObjetivo;
        }

        //obtengo importe de moneda actual
        int importeActual = importesOrdenados[index];

        //lo que me falta cubrir es menor al importe de la moneda

        if(sumaObjetivo-sumaActual<importeActual){
            //no va este importe, sigo recursividad
            cantidadMonedas[index] = 0;
            if(getCantidadMonedas(importesOrdenados,
                    sumaObjetivo,
                    sumaActual,
                    index+1,
                    cantidadMonedas)){
                return true;
            }
        }else if(sumaObjetivo-sumaActual == importeActual){
            //lo que me falta cubrir es igual al importe actual
            //seteo en 1 y corto
            cantidadMonedas[index] = 1;
            return true;
            //reveer como hacer con multiplos del importe actual...
            // (k * importe actual == M-sumaActual) -> cantidadMonedas[index] = k;

        }else{
            //valor a cubrir es mayor al importe actual... seteo en 1 y recursividad?
            cantidadMonedas[index] = 1;
            if(getCantidadMonedas(importesOrdenados,
                    sumaObjetivo,
                    sumaActual+importeActual,
                    index+1,
                    cantidadMonedas)){
                return true;
            }
        }


        cantidadMonedas[index] = 0;

        return false;

    }
*/

}