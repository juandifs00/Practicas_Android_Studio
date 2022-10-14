package com.example.apppreguntassqlite;

public class CPreguntas {
    private int ID;
    private String Pregunta;
    private String OpUno;
    private String OpDos;
    private String OpTres;
    private String Acertada;
    private int Puntuacion;

    public CPreguntas(int ID, String pregunta, String opUno, String opDos, String opTres, String acertada, int puntuacion) {
        this.ID = ID;
        Pregunta = pregunta;
        OpUno = opUno;
        OpDos = opDos;
        OpTres = opTres;
        Acertada = acertada;
        Puntuacion = puntuacion;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPregunta(String pregunta) {
        Pregunta = pregunta;
    }

    public void setOpUno(String opUno) {
        OpUno = opUno;
    }

    public void setOpDos(String opDos) {
        OpDos = opDos;
    }

    public void setOpTres(String opTres) {
        OpTres = opTres;
    }

    public void setAcertada(String acertada) {
        Acertada = acertada;
    }

    public void setPuntuacion(int puntuacion) {
        Puntuacion = puntuacion;
    }

    public int getID() {
        return ID;
    }

    public String getPregunta() {
        return Pregunta;
    }

    public String getOpUno() {
        return OpUno;
    }

    public String getOpDos() {
        return OpDos;
    }

    public String getOpTres() {
        return OpTres;
    }

    public String getAcertada() {
        return Acertada;
    }

    public int getPuntuacion() {
        return Puntuacion;
    }

    @Override
    public String toString() {
        return ID + " , " +
                Pregunta + " , " +
                OpUno + " , " +
                OpDos + " , " +
                OpTres + " , " +
                Acertada + " , " +
                Puntuacion;
    }
}
