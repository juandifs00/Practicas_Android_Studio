package com.example.apppreguntasfb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Inicio_Sesion extends AppCompatActivity {

    EditText etCorreo, etContraseña;
    Button btnIngresar, btnRegistrarse;
    String correo, contraseña;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_sesion);
        conexion();
        mAuth = FirebaseAuth.getInstance();

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correo = etCorreo.getText().toString();
                contraseña = etContraseña.getText().toString();
                Cargar(correo, contraseña);
            }
        });

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Registro = new Intent(getApplicationContext(), Registrarse.class);
                startActivity(Registro);
            }
        });
    }

    public void Cargar(String correo,  String contraseña){
        mAuth.signInWithEmailAndPassword(correo, contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent I = new Intent(getApplicationContext(), Administrador.class);
                    startActivity(I);
                } else {
                    Toast.makeText(getApplicationContext(), R.string.Error_Contraseña, Toast.LENGTH_SHORT).show();
                }
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