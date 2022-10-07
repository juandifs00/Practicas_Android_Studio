package com.example.apppreguntassqlite;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class DataMJugadores {
    String Archivo = "ranking.txt";
    Context ctx;
    FileOutputStream fos;
    FileInputStream fis;

    public DataMJugadores(Context ctx) {this.ctx = ctx;}

    public void EscribirRanking (String txtRanking) throws IOException {
        try {
            fos = ctx.openFileOutput(Archivo, Context.MODE_APPEND);
            fos.write(txtRanking.getBytes());
            fos.close();
        }
        catch (FileNotFoundException e) {
            Log.e("", e.getMessage());
        }
        catch (IOException ex) {
            Log.e("", ex.getMessage());
        }
    }

    public ArrayList<CPuntaje> LeerRanking() {
        ArrayList<String> Aux = new ArrayList<String>();
        ArrayList<CPuntaje> tempo = new ArrayList<CPuntaje>();

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
                    tempo.add(new CPuntaje(Aux.get(0), Integer.parseInt(Aux.get(1))));
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
