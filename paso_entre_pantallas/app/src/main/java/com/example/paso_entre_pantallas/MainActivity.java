package com.example.paso_entre_pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnP1, btnP2, btnP3, btnEnviar;
    EditText etNombre, etTelefono, etCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectar();
        String Mistery = "Despues del ultimo no hay nadie";

        etNombre = (EditText)findViewById(R.id.etNombre);
        etTelefono = (EditText)findViewById(R.id.etTelefono);
        etCorreo = (EditText)findViewById(R.id.etCorreo);

        //Implementación Intent
        btnP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent P1 = new Intent(getApplicationContext(), MainActivity.class);
                P1.putExtra("Mi_Variable", Mistery);
                startActivity(P1);
            }
        });

        btnP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent P2 = new Intent(getApplicationContext(), Pantalla2.class);
                startActivity(P2);
            }
        });

        btnP3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent P3 = new Intent(getApplicationContext(), Pantalla3.class);
                startActivity(P3);
            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Pantalla3.class);
                intent.putExtra("Datos", etNombre.getText().toString());
                intent.putExtra("Datos", etTelefono.getText().toString());
                intent.putExtra("Datos", etCorreo.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void conectar() {
        btnP1 = findViewById(R.id.btnP1);
        btnP2 = findViewById(R.id.btnP2);
        btnP3 = findViewById(R.id.btnP3);
    }
}