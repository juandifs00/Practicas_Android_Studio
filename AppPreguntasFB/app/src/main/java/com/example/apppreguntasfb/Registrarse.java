package com.example.apppreguntasfb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registrarse extends AppCompatActivity {

    EditText etNombre, etCorreo, etContraseña;
    Button btnCRegistro, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
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
        etNombre = findViewById(R.id.etNombre);
        etCorreo = findViewById(R.id.etCorreo);
        etContraseña = findViewById(R.id.etContraseña);
        btnCRegistro = findViewById(R.id.btnCRegistro);
        btnRegresar = findViewById(R.id.btnRegresar);
    }
}