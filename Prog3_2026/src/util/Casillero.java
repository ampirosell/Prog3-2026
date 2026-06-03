package Prog3_2026.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Casillero {

    private int valorNum;

    private boolean puedeIrNorte;
    private boolean puedeIrEste;
    private boolean puedeIrSur;
    private boolean puedeIrOeste;

    public Casillero(int valorNum,
                     boolean norte,
                     boolean este,
                     boolean sur,
                     boolean oeste) {

        this.valorNum = valorNum;

        this.puedeIrNorte = norte;
        this.puedeIrEste = este;
        this.puedeIrSur = sur;
        this.puedeIrOeste = oeste;
    }

    public List<Boolean> getDirecciones() {

        List<Boolean> direcciones = new ArrayList<>();

        direcciones.add(puedeIrNorte);
        direcciones.add(puedeIrEste);
        direcciones.add(puedeIrSur);
        direcciones.add(puedeIrOeste);

        return direcciones;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Casillero c2 = (Casillero) obj;

        return valorNum == c2.valorNum
                && puedeIrNorte == c2.puedeIrNorte
                && puedeIrEste == c2.puedeIrEste
                && puedeIrSur == c2.puedeIrSur
                && puedeIrOeste == c2.puedeIrOeste;
    }

    @Override
    public int hashCode() {

        return Objects.hash(
                valorNum,
                puedeIrNorte,
                puedeIrEste,
                puedeIrSur,
                puedeIrOeste);
    }

    public int getValorNum() {
        return valorNum;
    }

    public void setValorNum(int valorNum) {
        this.valorNum = valorNum;
    }

    public boolean isPuedeIrNorte() {
        return puedeIrNorte;
    }

    public void setPuedeIrNorte(boolean puedeIrNorte) {
        this.puedeIrNorte = puedeIrNorte;
    }

    public boolean isPuedeIrEste() {
        return puedeIrEste;
    }

    public void setPuedeIrEste(boolean puedeIrEste) {
        this.puedeIrEste = puedeIrEste;
    }

    public boolean isPuedeIrSur() {
        return puedeIrSur;
    }

    public void setPuedeIrSur(boolean puedeIrSur) {
        this.puedeIrSur = puedeIrSur;
    }

    public boolean isPuedeIrOeste() {
        return puedeIrOeste;
    }

    public void setPuedeIrOeste(boolean puedeIrOeste) {
        this.puedeIrOeste = puedeIrOeste;
    }
}