package com.example.a20preguntasplanos;

public class CRanking {
    private String Nombre;
    private int PuntosT;

    public CRanking(String nombre, int PTotal){
        Nombre = nombre;
        PuntosT = PTotal;
    }

    public String getNombre() { return Nombre;}

    public void setNombre(String nombre) {Nombre = nombre;}

    public int getPuntosT() {return PuntosT;}

    public void setPuntosT(int PTotal) {PuntosT = PTotal;}

    @Override
    public String toString() {
        return "CRanking{" +
                "Nombre='" + Nombre + '\'' +
                ", PuntosT=" + PuntosT +
                '}';
    }
}
