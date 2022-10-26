package com.example.apppreguntasfb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Inicio_Sesion extends AppCompatActivity {

    EditText etCorreo, etContraseña;
    Button btnIngresar, btnRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_sesion);
        conexion();

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Registro = new Intent(getApplicationContext(), Registrarse.class);
                startActivity(Registro);
            }
        });

    }



    private void conexion() {
        etCorreo = findViewById(R.id.etCorreo);
        etContraseña = findViewById(R.id.etContraseña);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnRegistrarse = findViewById(R.id.btnRegistrarse);
    }
}