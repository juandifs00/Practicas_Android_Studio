package com.example.a20preguntasplanos;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Preguntas {
    String Preguntas = "preguntas.txt";
    Context ctx;
    FileOutputStream fos;
    FileInputStream fis;

    public Preguntas(Context ctx) {this.ctx = ctx;}

    public void Escribir (String txtPreguntas) throws IOException {
        try {
            fos = ctx.openFileOutput(Preguntas, Context.MODE_APPEND);
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

    public String Leer() {
        String Lectura = "";
        try
        {
            fis = ctx.openFileInput(Preguntas);
            int i ;
            char caracter = 'a';
            do {
                i = fis.read();
                if(i != '\n')
                {
                    caracter = (char)i;
                    Lectura += caracter;
                }
                if (caracter == '.')
                    Lectura += '\n';
            }while (i > 0);
            Lectura += '\n';
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return Lectura;
    }
}
