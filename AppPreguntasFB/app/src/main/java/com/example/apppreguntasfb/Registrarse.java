package com.example.apppreguntasfb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registrarse extends AppCompatActivity {

    EditText etNombre, etCorreo, etContraseña;
    Button btnCRegistro, btnRegresar;
    String id, nombre, correo, contraseña;
    Boolean Rol;
    RadioGroup opType;
    RadioButton radio_Jugador, radio_Admin;

    DBUsuarios objDB = new DBUsuarios(this);

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        conexion();

        mAuth = FirebaseAuth.getInstance();

        btnCRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = etNombre.getText().toString();
                correo = etCorreo.getText().toString();
                contraseña = etContraseña.getText().toString();

                if (radio_Jugador.isChecked() == true) {
                    Rol = false;
                }

                if (radio_Admin.isChecked() == true) {
                    Rol = true;
                }

                CrearCuenta(correo, contraseña);
                Toast.makeText(getApplicationContext(), R.string.User_Creado, Toast.LENGTH_SHORT).show();

                etNombre.setText("");
                etCorreo.setText("");
                etContraseña.setText("");
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Regresar = new Intent(getApplicationContext(), Inicio_Sesion.class);
                startActivity(Regresar);
            }
        });

    }

    public void CrearCuenta(String email,  String password){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    id = mAuth.getCurrentUser().getUid();
                    objDB.CrearUsuario(id, nombre, correo, contraseña, Rol);
                } else {
                    Toast.makeText(getApplicationContext(), R.string.Error_Crear, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void conexion() {
        etNombre = findViewById(R.id.etNombre);
        etCorreo = findViewById(R.id.etCorreo);
        etContraseña = findViewById(R.id.etContraseña);
        btnCRegistro = findViewById(R.id.btnCRegistro);
        btnRegresar = findViewById(R.id.btnRegresar);

        radio_Admin = findViewById(R.id.radio_Admin);
        radio_Jugador = findViewById(R.id.radio_Jugador);

        opType = findViewById(R.id.opType);
    }
}