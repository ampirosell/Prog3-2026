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
        
        if(numeros.size()<=posiciones.size()){
            return;
        }
        



    }