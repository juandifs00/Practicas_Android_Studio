package com.example.apppreguntasfb;

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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public void setOpUno(String opUno) {
        OpUno = opUno;
    }

    public String getOpDos() {
        return OpDos;
    }

    public void setOpDos(String opDos) {
        OpDos = opDos;
    }

    public String getOpTres() {
        return OpTres;
    }

    public void setOpTres(String opTres) {
        OpTres = opTres;
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

    public void setPuntuacion(int puntuacion) {
        Puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "{ " + ID + " , " +
                Pregunta + " , " +
                OpUno + " , " +
                OpDos + " , " +
                OpTres + " , " +
                Acertada + " , " +
                Puntuacion + " }";
    }
}
