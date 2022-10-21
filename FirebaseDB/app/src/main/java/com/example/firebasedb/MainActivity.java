package com.example.firebasedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText etNombre, etApellido, etTelefono;
    Button btnRegistrar;

    DatabaseReference miDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conexion();

        miDB = FirebaseDatabase.getInstance().getReference();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Crear_Contacto();
            }
        });
    }

    private void Crear_Contacto() {
        String Id = miDB.push().getKey();
        Contacto C = new Contacto(Id, "Nombre", "Apellido", "123456");
        miDB.child("Contactos").child(Id).setPriority(C);
    }

    private void conexion() {
        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etTelefono = findViewById(R.id.etTelefono);

        btnRegistrar = findViewById(R.id.btnRegistrar);
    }
}