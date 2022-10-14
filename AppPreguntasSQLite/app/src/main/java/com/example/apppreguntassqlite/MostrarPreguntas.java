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

public class MostrarPreguntas extends AppCompatActivity {

    ListView lvPreguntasBD;
    Button btnRegresar;

    ArrayList<CPreguntas> ListaPreguntas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_preguntas);
        conectar();

        ListaPreguntas = leerRegistros();
        ArrayAdapter<CPreguntas> adapter = new ArrayAdapter<CPreguntas>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, ListaPreguntas);
        lvPreguntasBD.setAdapter(adapter);

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regresar = new Intent(getApplicationContext(), Menu.class);
                startActivity(regresar);
            }
        });
    }

    private ArrayList<CPreguntas> leerRegistros() {
        ArrayList<CPreguntas> preguntas = new ArrayList<>();

        DBHelper helper= new DBHelper(this, "Preguntas", null, 1);
        SQLiteDatabase db= helper.getWritableDatabase();
        String SQL = "select * from Preguntas";

        Cursor c = db.rawQuery(SQL, null);
        if (c.moveToFirst()) {
            do {
                preguntas.add(new CPreguntas(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5), c.getInt(6)));
            }while (c.moveToNext());
        }
        db.close();
        return preguntas;
    }

    private void conectar() {
        lvPreguntasBD = findViewById(R.id.lvPreguntasBD);
        btnRegresar = findViewById(R.id.btnRegresar);
    }
}