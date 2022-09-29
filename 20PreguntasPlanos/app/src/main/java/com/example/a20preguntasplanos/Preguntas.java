package com.example.a20preguntasplanos;

public class Preguntas {
    private String Pregunta;
    private String OpUno;
    private String OpDos;
    private String OpTres;
    private String Acertada;
    private int Puntuacion;

    public Preguntas(String pregunta, String opUno, String opDos, String opTres, String acertada, int puntuacion) {
        Pregunta = pregunta;
        OpUno = opUno;
        OpDos = opDos;
        OpTres = opTres;
        Acertada = acertada;
        Puntuacion = puntuacion;
    }

    public String getPregunta() {
        return Pregunta;
    }

    public void setPregunta(String pregunta) {
        Pregunta = pregunta;
    }

    public String getOpUno() {
        return OpUno;
    }

    public void setOpUno(String opcionUno) {
        OpUno = opcionUno;
    }

    public String getOpDos() {
        return OpDos;
    }

    public void setOpDos(String opcionDos) {
        OpDos = opcionDos;
    }

    public String getOpTres() {
        return OpTres;
    }

    public void setOpTres(String opcionTres) {
        OpTres = opcionTres;
    }

    public String getAcertada() {
        return Acertada;
    }

    public void setAcertada(String acertada) {
        Acertada = acertada;
    }

    public int getPuntuacion() {
        return Puntuacion;
    }

    public void setPuntucion(int puntuacion) {
        Puntuacion = puntuacion;
    }
}
