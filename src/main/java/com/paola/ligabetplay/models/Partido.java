package com.paola.ligabetplay.models;

public class Partido {
    String fecha;
    String equipo1;
    String equipo2;
    int marcador1;
    int marcador2;

    public Partido() {}

    public Partido(String fecha, String equipo1, String equipo2, int marcador1, int marcador2) {
        this.fecha = fecha;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.marcador1 = marcador1;
        this.marcador2 = marcador2;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public int getMarcador1() {
        return marcador1;
    }

    public void setMarcador1(int marcador1) {
        this.marcador1 = marcador1;
    }

    public int getMarcador2() {
        return marcador2;
    }

    public void setMarcador2(int marcador2) {
        this.marcador2 = marcador2;
    }
}