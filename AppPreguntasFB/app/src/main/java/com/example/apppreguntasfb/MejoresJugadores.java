package com.example.apppreguntasfb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MejoresJugadores extends AppCompatActivity {

    Button btnRegresar;
    ListView lvMJugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mejores_jugadores);
        conexion();

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regresar = new Intent(getApplicationContext(), Juego.class);
                startActivity(regresar);
            }
        });
    }

    private void conexion() {
        btnRegresar = findViewById(R.id.btnRegresar);
        lvMJugadores = findViewById(R.id.lvMJugadores);
    }
}