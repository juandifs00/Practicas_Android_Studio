package com.example.appfirebase;

import androidx.annotation.AttrRes;
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

public class MainActivity extends AppCompatActivity {

    EditText etCorreo, etContraseña;
    Button btnIngreso, btnCrearCuenta;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        conexion();

        btnCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CrearCuenta(etCorreo.getText().toString(), etContraseña.getText().toString());
            }
        });

        btnIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login(etCorreo.getText().toString(), etContraseña.getText().toString());
            }
        });
    }

    private void CrearCuenta(String Correo, String Contraseña) {
        mAuth.createUserWithEmailAndPassword(Correo, Contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent P2 = new Intent(getApplicationContext(), MainActivity2.class);
                    startActivity(P2);
                }
                else {
                    Toast.makeText(MainActivity.this, "No se pudo crear cuenta", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Login(String Correo, String Contraseña) {
        mAuth.signInWithEmailAndPassword(Correo, Contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent P2 = new Intent(getApplicationContext(), MainActivity2.class);
                    startActivity(P2);
                }
                else {
                    Toast.makeText(getApplicationContext(), "No se pudo ingresar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void conexion() {
        etCorreo = findViewById(R.id.etCorreo);
        etContraseña = findViewById(R.id.etContraseña);
        btnIngreso = findViewById(R.id.btnIngreso);
        btnCrearCuenta = findViewById(R.id.btnCrearCuenta);
    }
}