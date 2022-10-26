package com.example.apppreguntasfb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Administrador extends AppCompatActivity {

    ImageButton btnAgregar, btnBuscar, btnEditar, btnEliminar;
    Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);
        conexion();

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Regresar = new Intent(getApplicationContext(), Inicio_Sesion.class);
                startActivity(Regresar);
            }
        });

    }

    private void conexion() {
        btnAgregar = findViewById(R.id.btnAgregar);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnEditar = findViewById(R.id.btnEditar);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnRegresar = findViewById(R.id.btnRegresar);
    }
}