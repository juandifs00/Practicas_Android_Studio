package com.example.apppreguntassqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Currency;

public class Eliminar extends AppCompatActivity {

    EditText etNPregunta;
    Button btnEliminar, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);
        conexion();

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.valueOf(etNPregunta.getText().toString());
                Eliminar(id);
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regresar = new Intent(getApplicationContext(), Perfiles.class);
                startActivity(regresar);
            }
        });

    }

    private void Eliminar (int id) {
        DBHelper helper = new DBHelper(this, "Preguntas", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQLC = "Select * from Preguntas where Id '" + id + "'";

        Cursor eliminar = db.rawQuery(SQLC,null);

        if (eliminar.moveToNext()) {
            String SQLE = "Delete from Preguntas where Id '" + id + "'";
            db.execSQL(SQLE);
            db.close();
            Toast.makeText(this, "Pregunta eliminada exitosamente", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "La pregunta no existe", Toast.LENGTH_SHORT).show();
            db.close();
        }
    }

    private void conexion() {
        etNPregunta = findViewById(R.id.etNPregunta);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnRegresar = findViewById(R.id.btnRegresar);
    }
}