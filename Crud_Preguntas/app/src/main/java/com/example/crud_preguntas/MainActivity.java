package com.example.crud_preguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnAgregar, btnElminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conexion();

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Add = new Intent(getApplicationContext(), Insertar.class);
                startActivity(Add);
            }
        });

        btnElminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Eliminar = new Intent(getApplicationContext(), Eliminar.class);
                startActivity(Eliminar);
            }
        });
    }

    private void conexion() {
        btnAgregar = findViewById(R.id.btnAgregar);
        btnElminar = findViewById(R.id.btnElminar);
    }
}