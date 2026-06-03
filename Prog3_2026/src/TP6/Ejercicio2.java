package TP6;

import util.ObjetoMochila;

import java.util.Arrays;

public class Ejercicio2 {

    /*Problema de la mochila: Se tienen n objetos y una mochila. Para i = 1,2,..n, el objeto i tiene un peso
positivo pi y un valor positivo vi. La mochila puede llevar un peso que no sobrepase P. El objetivo es
llenar la mochila de tal manera que se maximice el valor de los objetos transportados, respetando la
limitación de capacidad impuesta. Los objetos pueden ser fraccionados, si una fracción xi (0 ≤ xi ≤ 1)
del objeto i es ubicada en la mochila contribuye en xipi al peso total de la mochila y en xivi al valor
de la carga.*/

    public double[] getCantidadPorObjeto(ObjetoMochila[] objetos, double pesoDisponible){
        if(pesoDisponible<=0){
            return null;
        }

        double[] cantidadObjetos = new double[objetos.length];
        //aca deberia ser un map donde indique nombre objeto y su fraccion

        //primero ordenar los objetos por valorPorKg...

        Arrays.sort(objetos,
                (o1, o2) -> Double.compare(
                        o2.getValor()/o2.getPesoKG(), //valorPorKilogramo
                        o1.getValor()/o1.getPesoKG()
                )); //restriccion para pesos negativos, o evitar en la creacion (constructor objeto mochila)
        //luego...

        for(int i=0;i<cantidadObjetos.length;i++){

            ObjetoMochila objeto = objetos[i];

            if(objeto.getPesoKG()>0){

                if(objeto.getPesoKG() <= pesoDisponible){
                    cantidadObjetos[i]=1.0;
                    pesoDisponible-=objeto.getPesoKG();
                }else {
                    cantidadObjetos[i] =
                            pesoDisponible / objeto.getPesoKG();
                    break;
                }


            }

        }

        return cantidadObjetos;
    }


    
}