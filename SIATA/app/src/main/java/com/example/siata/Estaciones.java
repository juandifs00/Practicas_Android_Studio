package com.example.siata;

public class Estaciones {
    private String Codigo;
    private String Municipio;
    private double Latitud;
    private double Longitud;
    private int Concentracion;

    public Estaciones(String codigo, String municipio, double latitud, double longitud, int concentracion) {
        Codigo = codigo;
        Municipio = municipio;
        Latitud = latitud;
        Longitud = longitud;
        Concentracion = concentracion;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getMunicipio() {
        return Municipio;
    }

    public void setMunicipio(String municipio) {
        Municipio = municipio;
    }

    public double getLatitud() {
        return Latitud;
    }

    public void setLatitud(double latitud) {
        Latitud = latitud;
    }

    public double getLongitud() {
        return Longitud;
    }

    public void setLongitud(double longitud) {
        Longitud = longitud;
    }

    public int getConcentracion() {
        return Concentracion;
    }

    public void setConcentracion(int concentracion) {
        Concentracion = concentracion;
    }
}
