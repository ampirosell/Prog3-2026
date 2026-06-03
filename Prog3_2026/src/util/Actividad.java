package Prog3_2026.util;

import java.Timestamp;

public class Actividad {

    int id;
    Timestamp fechaInicio;
    Timestamp fechaFin;

    public  Actividad(int id, Timestamp fechaInicio, Timestamp fechaFin) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Timestamp getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Timestamp getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(Timestamp fechaFin) {
        this.fechaFin = fechaFin;
    }

}