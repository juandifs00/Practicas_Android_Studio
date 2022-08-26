package com.example.quiz_puntajes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tvGenEnteros;
    Button btnGenerador, sIntentos, sPuntos;

    int Intentos = 10;
    int puntaje = 0;

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

                //btnGenerador.setText();
            }
        });
    }

    public int[] generarAletorios() {
        int size = 5;
            int[] vector = new int[size];

            for(int i=0;i<vector.length;i++){
                vector[i] = new Random().nextInt(40);
            }
            return vector;
    }

    public void reducirOportunidades() {
        if (btnGenerador.hasOnClickListeners()) {
            if (Intentos > 0) {
                Intentos--;
            }
            if(btnGenerador.isEnabled()) {
                if (Intentos == 0) {
                    btnGenerador.setEnabled(false);
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