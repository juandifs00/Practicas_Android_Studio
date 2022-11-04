package com.example.tarea_asincrona;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAumento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAumento   = findViewById(R.id.btnAumento);
        TareaAsincrona tarea = new TareaAsincrona();
        tarea.execute(30);
    }

    public class TareaAsincrona extends AsyncTask<Integer, Integer, String> {

        @Override
        protected String doInBackground(Integer... integers) {
            int tope = integers[0];
            for (int i = 1; i <= tope; i++) {
                try {
                    Thread.sleep(500);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
                publishProgress(i);
            }
            return "fin del crecimiento";
        }

        @Override
        protected void onPostExecute(String s) {
            //super.onPostExecute(s);
            btnAumento.append(s);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            int cont = values[0];
            String texto = "Contador" + cont;
            btnAumento.setText(texto);
            btnAumento.setTextSize(cont);
            super.onProgressUpdate(values);
        }
    }
}