package com.example.apppreguntassqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MejoresJugadores extends AppCompatActivity {

    Button btnVolver;
    ListView lvMJugadores;

    ArrayList<String> Rankings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mejores_jugadores);
        conexion();

        Rankings = leerRegistros();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, Rankings);
        lvMJugadores.setAdapter(adapter);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regresar = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(regresar);
            }
        });
    }

    private ArrayList<String> leerRegistros() {
        ArrayList<String> MPuntos = new ArrayList<>();

        DBHelperPutaje helper= new DBHelperPutaje(this, "Nom_Puntajes", null, 1);
        SQLiteDatabase db= helper.getWritableDatabase();
        String SQL = "select * from Ranking Order By puntaje_jugador ASC";

        Cursor c = db.rawQuery(SQL, null);
        if (c.moveToFirst()) {
            do {
                String registro = c.getInt(0) + " " +c.getString(1) + " " + c.getInt(2);
                MPuntos.add(registro);

            }while (c.moveToNext());
        }
        db.close();
        return MPuntos;
    }

    private void conexion() {
        btnVolver = findViewById(R.id.btnVolver);
        lvMJugadores = findViewById(R.id.lvMJugadores);
    }
}