package com.example.apppreguntassqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Actualizar extends AppCompatActivity implements AdapterView.OnItemClickListener {

    EditText etPegunta, etResp1, etResp2, etResp3, etOpCorrecta, etPuntuacion;
    Button btnRegistar, btnVolver;
    ListView lvPreguntas;

    ArrayList<CPreguntas> ListaPreguntas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);
        conexion();

        ListaPreguntas = leerRegistros();
        ArrayAdapter<CPreguntas> adapter = new ArrayAdapter<CPreguntas>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, ListaPreguntas);
        lvPreguntas.setAdapter(adapter);

        btnRegistar.setOnClickListener(new View.OnClickListener() {

            String Pregunta, Resp1, Resp2, Resp3, Opcorr;
            int Puntuacion, ID;

            @Override
            public void onClick(View view) {
                //ID = Integer.parseInt(etPuntuacion.getText().toString());
                Pregunta = etPegunta.getText().toString();
                Resp1 = etResp1.getText().toString();
                Resp2 = etResp2.getText().toString();
                Resp3 = etResp3.getText().toString();
                Opcorr = etOpCorrecta.getText().toString();
                Puntuacion = Integer.parseInt(etPuntuacion.getText().toString());

                AgregarNueva(ID, Pregunta, Resp1, Resp2, Resp3, Opcorr, Puntuacion);
                Toast.makeText(getApplicationContext(), "Pregunta actualizada correctamente", Toast.LENGTH_LONG).show();

                ListaPreguntas = leerRegistros();
                ArrayAdapter<CPreguntas> adapter = new ArrayAdapter<CPreguntas>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, ListaPreguntas);
                lvPreguntas.setAdapter(adapter);
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regresar = new Intent(getApplicationContext(), Menu.class);
                startActivity(regresar);
            }
        });
    }

    public void AgregarNueva(int ID, String Pregunta, String Resp1, String Resp2, String Resp3, String RespCor, int Puntuacion) {
        DBHelper helper = new DBHelper(this, "Preguntas", null, 1);
        SQLiteDatabase DB = helper.getWritableDatabase();
        String SQL = "update Preguntas set pregunta = '" + Pregunta + "'" +
                ", respuesta1 = '" + Resp1 + "'" +
                ", respuesta2 = '" + Resp2 + "'" +
                ", respuesta3 = '" + Resp3 + "'" +
                ", respuestacorrecta = '" + RespCor + "'" +
                ", Puntaje = '" + Puntuacion + "'" +
                " where Id = '" + ID + "'";
        DB.execSQL(SQL);
        DB.close();
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

    private void conexion() {
        etPegunta = findViewById(R.id.etPegunta);
        etResp1 = findViewById(R.id.etResp1);
        etResp2 = findViewById(R.id.etResp2);
        etResp3 = findViewById(R.id.etResp3);
        etOpCorrecta = findViewById(R.id.etOpCorrecta);
        etPuntuacion = findViewById(R.id.etPuntuacion);

        btnRegistar = findViewById(R.id.btnRegistar);
        btnVolver = findViewById(R.id.btnVolver);

        lvPreguntas = findViewById(R.id.lvPreguntas);
        lvPreguntas.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        etPegunta.setText(ListaPreguntas.get(i).getPregunta());
        etResp1.setText(ListaPreguntas.get(i).getOpUno());
        etResp2.setText(ListaPreguntas.get(i).getOpDos());
        etResp3.setText(ListaPreguntas.get(i).getOpTres());
        etOpCorrecta.setText(ListaPreguntas.get(i).getAcertada());
        etPuntuacion.setText(String.valueOf(ListaPreguntas.get(i).getPuntuacion()));
    }
}