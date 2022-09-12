package com.example.a20preguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnP1, btnP2, btnP3, btnP4, btnP5, btnP6, btnP7,
            btnP8, btnP9, btnP10, btnP11, btnP12, btnP13, btnP14,
            btnP15, btnP16, btnP17, btnP18, btnP19, btnP20, btnR1, btnR2, btnR3;

    TextView tvPuntaje, tvPreguntas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conexion();
    }

    private void conexion() {
        btnP1 = findViewById(R.id.btnP1);
        btnP2 = findViewById(R.id.btnP2);
        btnP3 = findViewById(R.id.btnP3);
        btnP4 = findViewById(R.id.btnP4);
        btnP5 = findViewById(R.id.btnP5);
        btnP6 = findViewById(R.id.btnP6);
        btnP7 = findViewById(R.id.btnP7);
        btnP8 = findViewById(R.id.btnP8);
        btnP9 = findViewById(R.id.btnP9);
        btnP10 = findViewById(R.id.btnP10);
        btnP11 = findViewById(R.id.btnP11);
        btnP12 = findViewById(R.id.btnP12);
        btnP13 = findViewById(R.id.btnP13);
        btnP14 = findViewById(R.id.btnP14);
        btnP15 = findViewById(R.id.btnP15);
        btnP16 = findViewById(R.id.btnP16);
        btnP17 = findViewById(R.id.btnP17);
        btnP18 = findViewById(R.id.btnP18);
        btnP19 = findViewById(R.id.btnP19);
        btnP20 = findViewById(R.id.btnP20);
        
        btnR1 = findViewById(R.id.btnR1);
        btnR2 = findViewById(R.id.btnR2);
        btnR3 = findViewById(R.id.btnR3);

        tvPuntaje = findViewById(R.id.tvPuntaje);
        tvPreguntas = findViewById(R.id.tvPreguntas);
    }
}