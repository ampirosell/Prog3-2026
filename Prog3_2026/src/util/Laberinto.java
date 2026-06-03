package util;

import java.util.HashMap;

public class Laberinto {

    // fila -> (columna -> casillero)
    private HashMap<Integer,
            HashMap<Integer, Casillero>>
            casilleroXFilaXColumna;

    public Laberinto() {

        this.casilleroXFilaXColumna =
                new HashMap<>();
    }


    public void agregarCasillero(
            int fila,
            int columna,
            Casillero casillero) {

        if (!casilleroXFilaXColumna.containsKey(fila)) {

            casilleroXFilaXColumna.put(
                    fila,
                    new HashMap<>());
        }

        casilleroXFilaXColumna
                .get(fila)
                .put(columna, casillero);
    }




    public Casillero getCasillero(
            int fila,
            int columna) {

        if (!casilleroXFilaXColumna.containsKey(fila))
            return null;

        return casilleroXFilaXColumna
                .get(fila)
                .get(columna);
    }





    public Prog3_2026.util.Posicion getPosicion(Casillero buscado) {

        for (Integer fila :
                casilleroXFilaXColumna.keySet()) {

            HashMap<Integer, Casillero> columnas =
                    casilleroXFilaXColumna.get(fila);

            for (Integer columna : columnas.keySet()) {

                Casillero actual =
                        columnas.get(columna);

                if (actual.equals(buscado)) {

                    return new Prog3_2026.util.Posicion(
                            fila,
                            columna);
                }
            }
        }

        return null;
    }




    public boolean existeCasillero(
            int fila,
            int columna) {

        return casilleroXFilaXColumna.containsKey(fila)
                &&
                casilleroXFilaXColumna
                        .get(fila)
                        .containsKey(columna);
    }
}