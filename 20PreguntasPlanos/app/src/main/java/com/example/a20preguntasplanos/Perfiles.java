package com.example.a20preguntasplanos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Perfiles extends AppCompatActivity {

    Button btnJugador, btnAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfiles);
        conectar();

        btnJugador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Jugador = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(Jugador);
            }
        });

        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Admin = new Intent(getApplicationContext(), AddPreguntas.class);
                startActivity(Admin);
            }
        });

    }

    private void conectar() {
        btnAdmin = findViewById(R.id.btnAdmin);
        btnJugador = findViewById(R.id.btnJugador);
    }
}