package com.example.apppreguntassqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MostrarPreguntas extends AppCompatActivity {

    ListView lvPreguntasBD;
    Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_preguntas);
        conectar();

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regresar = new Intent(getApplicationContext(), Perfiles.class);
                startActivity(regresar);
            }
        });
    }

    private void conectar() {
        lvPreguntasBD = findViewById(R.id.lvPreguntasBD);
        btnRegresar = findViewById(R.id.btnRegresar);
    }
}