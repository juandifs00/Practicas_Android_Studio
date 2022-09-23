package com.example.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtNombre, txtTelefono;
    Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectar();
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n,t;
                n = txtNombre.getText().toString();
                t = txtTelefono.getText().toString();
                Insertar(n, t);
            }
        });
    }

    private void conectar() {
        txtNombre = findViewById(R.id.txtNombre);
        txtTelefono = findViewById(R.id.txtTelefono);
        btnAgregar = findViewById(R.id.btnAgregar);
    }

    public void Insertar(String Nombre, String Telefono){
        DbHelper helper = new DbHelper(this, "MisContactos",null, 1);
        SQLiteDatabase db = helper.getReadableDatabase();

        try {
            ContentValues cv = new ContentValues();
            cv.put("Nombre", Nombre);
            cv.put("Telefono", Telefono);

            db.insert("Contactos", null, cv);
            db.close();
            Toast.makeText(getApplicationContext(), "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }
        catch (Exception ex) {
            Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}