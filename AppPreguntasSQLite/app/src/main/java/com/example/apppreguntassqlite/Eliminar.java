package com.example.apppreguntassqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Currency;

public class Eliminar extends AppCompatActivity {

    EditText etNPregunta;
    Button btnEliminar, btnRegresar;
    ListView lvPreguntasExistentes;

    ArrayList<String> ListaPreguntas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);
        conexion();

        ListaPreguntas = leerRegistros();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, ListaPreguntas);
        lvPreguntasExistentes.setAdapter(adapter);

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(etNPregunta.getText().toString());
                Eliminar(id);

                ListaPreguntas = leerRegistros();
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, ListaPreguntas);
                lvPreguntasExistentes.setAdapter(adapter);
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

    private void Eliminar(int id) {
        DBHelper helper = new DBHelper(this, "Preguntas", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "Delete from Preguntas where Id = '" + id + "'";
        db.execSQL(SQL);
        db.close();
        Toast.makeText(this, "Pregunta eliminada", Toast.LENGTH_SHORT).show();
    }

    /*
    private void Eliminar (int id) {
        DBHelper helper = new DBHelper(this, "Preguntas", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQLC = "Select * from Preguntas where Id = '" + id + "'";

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
     */

    private ArrayList<String> leerRegistros() {
        ArrayList<String> preguntas = new ArrayList<>();

        DBHelper helper= new DBHelper(this, "Preguntas", null, 1);
        SQLiteDatabase db= helper.getWritableDatabase();
        String SQL = "select * from Preguntas";

        Cursor c = db.rawQuery(SQL, null);
        if (c.moveToFirst()) {
            do {
                String registro = c.getInt(0) + " " +c.getString(1) + " " + c.getString(2) + " " + c.getString(3) + " " + c.getString(4) + " " + c.getString(5) + " " + c.getInt(6);
                preguntas.add(registro);

            }while (c.moveToNext());
        }
        db.close();
        return preguntas;
    }

    private void conexion() {
        etNPregunta = findViewById(R.id.etNPregunta);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnRegresar = findViewById(R.id.btnRegresar);
        lvPreguntasExistentes = findViewById(R.id.lvPreguntasExistentes);
    }
}