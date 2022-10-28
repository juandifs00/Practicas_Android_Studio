package com.example.apppreguntasfb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Inicio_Sesion extends AppCompatActivity {

    EditText etCorreo, etContraseña;
    Button btnIngresar, btnRegistrarse, btnJugador, btnAdmin;

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

        btnJugador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Jugador = new Intent(getApplicationContext(), Juego.class);
                startActivity(Jugador);
            }
        });

        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Admin = new Intent(getApplicationContext(), Administrador.class);
                startActivity(Admin);
            }
        });
    }



    private void conexion() {
        etCorreo = findViewById(R.id.etCorreo);
        etContraseña = findViewById(R.id.etContraseña);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnRegistrarse = findViewById(R.id.btnRegistrarse);
        btnJugador = findViewById(R.id.btnJugador);
        btnAdmin = findViewById(R.id.btnAdmin);
    }
}