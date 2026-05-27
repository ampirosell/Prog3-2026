package proyectos.TP5;

public class Ejercicio4{

    public List<List<Integer>> ejercicio5(int[] numeros){
        List<List<Integer>> result = new ArrayList<>();

        int[] posiciones = new int[];

        this.buscarSubconjuntosDisjuntos(numeros, posiciones, 0, 0, 0);

        //result.add??
        return result;
    }


    private void buscarSubconjuntosDisjuntos(int[] numeros, int[] posiciones,
        int suma1, int suma2, int index){
        
        if(index==numeros.size())
            return;

        if(numeros==null)
            return;
        
        if(numeros.length < posiciones.length){
            return;
        }
        if(numeros.length == posiciones.length){
            if(suma1==suma2){
                return posiciones;
            } 
            return;
        }
        for (int i = indice; i < numeros.length; i++) {

            //actual.add(numeros[i]);

            //aca deberia decidir poner distintos valores a posiciones 
            buscarSubconjuntosDisjuntos(
                    numeros,
                    posiciones,
                    suma1, suma2,
                    i + 1);

            // BACKTRACKING
            //actual.remove(actual.size() - 1);
        }


    }