package com.example.apppreguntassqlite;

public class CPuntaje {
    private int ID;
    private String Nombre;
    private int PuntosT;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setPuntosT(int puntosT) {
        PuntosT = puntosT;
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getPuntosT() {
        return PuntosT;
    }

    @Override
    public String toString() {
        return "CPuntaje{" +
                "ID=" + ID +
                ", Nombre='" + Nombre + '\'' +
                ", PuntosT=" + PuntosT +
                '}';
    }
}
