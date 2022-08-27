package com.example.quiz_puntajes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tvGenEnteros;
    Button btnGenerador, sIntentos, sPuntos, btnReiniciar;

    int Intentos = 9;
    int puntaje = 0;
    int canNumeros = 5;

    ArrayList <Integer> numeros = new ArrayList();
    ArrayList <Integer> aux = new ArrayList();

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
                generarAletorios();
                tvGenEnteros.setText(numeros.toString());
                puntuacion();
                sPuntos.setText(puntaje+ "");
                numeros.clear();
            }
        });

        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intentos = 9;
                tvGenEnteros.setText("Generador de enteros");
                puntaje = 0;
                btnGenerador.setText("GENERAR");
                btnGenerador.setEnabled(true);
                sIntentos.setText("");
                sPuntos.setText("");
                sIntentos.setBackgroundColor(Color.WHITE);
                sPuntos.setBackgroundColor(Color.WHITE);
            }
        });
    }

    public void generarAletorios() {
        for (int i=0;i<canNumeros;i++){
            numeros.add(new Random().nextInt(900) + 100);
        }
    }

    public void puntuacion() {
        int auxiliar;
        int P_auxiliar = 0;
        for (int i = 0; i < numeros.size(); i++) {
            auxiliar = numeros.get(i);

            while (auxiliar > 0) {
                aux.add(new Integer(auxiliar % 10));
                auxiliar = auxiliar/10;
            }

            if (aux.get(0) == aux.get(aux.size() - 1)) {
                puntaje += 3;
            }

            for (int j = 0; j < aux.size(); j++) {
                if (aux.get(j) == 5) {
                    puntaje +=  1;
                }
                P_auxiliar += (aux.get(j));
            }

            if (P_auxiliar > 12) {
                puntaje += 5;
            }
        }
        aux.clear();
        if (puntaje >= 180) {
            btnGenerador.setEnabled(false);
            Toast.makeText(getApplicationContext(), "GANASTE", Toast.LENGTH_LONG).show();
            sPuntos.setBackgroundColor(Color.GREEN);
            sIntentos.setBackgroundColor(Color.GREEN);
        }
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
        btnReiniciar = findViewById(R.id.btnReiniciar);
    }
}