package com.example.quiz_puntajes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tvGenEnteros;
    Button btnGenerador, sIntentos, sPuntos, btnReinicio;

    int Intentos = 9;
    int puntaje = 0;
    int canNumeros = 5;
    String datoAleatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectar();

        btnGenerador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sIntentos.setText(Intentos + "");
                reducirOportunidades();
                String numeros = generarAletorios();
                tvGenEnteros.setText(numeros + "");
            }
        });
    }

    public String generarAletorios() {

        Integer [] vector = new Integer[canNumeros];

        for (int i=0;i<vector.length;i++){
            vector[i] = new Random().nextInt((1000) - 100) + 100;
        }

        datoAleatorio = "";
        for (int i=0;i<vector.length;i++) {
            datoAleatorio += vector[i].toString() + ", ";
        };
        return datoAleatorio;
    }

    public void reducirOportunidades() {
        if (btnGenerador.hasOnClickListeners()) {
            if (Intentos >= 0) {
                Intentos--;
            }
            if(btnGenerador.isEnabled()) {
                if (Intentos < 0) {
                    btnGenerador.setEnabled(false);
                    sIntentos.setBackgroundColor(Color.RED);
                }
            }
        }
    }

    private void conectar() {
        tvGenEnteros = findViewById(R.id.tvGenEnteros);
        btnGenerador = findViewById(R.id.btnGenerador);
        sIntentos = findViewById(R.id.sIntentos);
        sPuntos = findViewById(R.id.sPuntos);
    }
}