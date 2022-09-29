package com.example.a20preguntasplanos;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class PAPLanos {
    String Archivo = "preguntas.txt";
    Context ctx;
    FileOutputStream fos;
    FileInputStream fis;

    public PAPLanos(Context ctx) {this.ctx = ctx;}

    public void Escribir (String txtPreguntas) throws IOException {
        try {
            fos = ctx.openFileOutput(Archivo, Context.MODE_APPEND);
            fos.write(txtPreguntas.getBytes());
            fos.close();
        }
        catch (FileNotFoundException e) {
            Log.e("", e.getMessage());
        }
        catch (IOException ex) {
            Log.e("", ex.getMessage());
        }
    }

    public ArrayList<Preguntas> Leer() {
        ArrayList<String> Aux = new ArrayList<String>();
        ArrayList<Preguntas> tempo = new ArrayList<Preguntas>();

        String Lectura = "";
        try
        {
            fis = ctx.openFileInput(Archivo);
            int i ;
            char caracter = 'a';
            do {
                i = fis.read();
                if(i != '\n')
                {
                    caracter = (char)i;
                    Lectura += caracter;
                }
                if (i == ';') {
                    Aux.add(Lectura.substring(0,Lectura.length() - 1));
                    Lectura = "";
                }
                if (caracter == '/') {
                    Aux.add(Lectura.substring(0,Lectura.length() - 1));
                    tempo.add(new Preguntas(Aux.get(0),Aux.get(1),Aux.get(2), Aux.get(3), Aux.get(4),Integer.parseInt(Aux.get(5))));
                    Aux.clear();
                    Lectura = "";
                }
            }while (i > 0);
            Lectura += '\n';
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return tempo;
    }
}
