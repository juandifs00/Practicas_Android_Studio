package com.example.planos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnAPLanos, btnPCompartidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectar();
        btnAPLanos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), Planos.class);
                startActivity(I);
            }
        });
        btnPCompartidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), PreferenciasCompartidas.class);
                startActivity(I);
            }
        });

    }

    private void conectar() {
        btnPCompartidas = findViewById(R.id.btnPCompartidas);
        btnAPLanos = findViewById(R.id.btnAPLanos);
    }
}