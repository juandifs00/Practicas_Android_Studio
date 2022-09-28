package com.example.a20preguntasplanos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MejoresJugadores extends AppCompatActivity {

    Button btnVolver;
    ListView lvMJugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mejores_jugadores);
        conexion();

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regresar = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(regresar);
            }
        });
    }

    private void conexion() {
        btnVolver = findViewById(R.id.btnVolver);
        lvMJugadores = findViewById(R.id.lvMJugadores);
    }
}