package com.example.apppreguntassqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
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

public class AñadirPreguntas extends AppCompatActivity {

    EditText etPegunta, etResp1, etResp2, etResp3, etOpCorrecta, etPuntuacion;
    Button btnRegistar, btnVolver;
    ListView lvPreguntas;

    ArrayList<String> ListaPreguntas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpreguntas);
        conexion();

        ListaPreguntas = leerRegistros();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, ListaPreguntas);
        lvPreguntas.setAdapter(adapter);

        btnRegistar.setOnClickListener(new View.OnClickListener() {

            String Pregunta, Resp1, Resp2, Resp3, Opcorr;
            int Puntuacion;

            @Override
            public void onClick(View view) {
                Pregunta = etPegunta.getText().toString();
                Resp1 = etResp1.getText().toString();
                Resp2 = etResp2.getText().toString();
                Resp3 = etResp3.getText().toString();
                Opcorr = etOpCorrecta.getText().toString();
                Puntuacion = Integer.valueOf(etPuntuacion.getText().toString());

                Agregar(Pregunta, Resp1, Resp2, Resp3, Opcorr, Puntuacion);

                ListaPreguntas = leerRegistros();
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, ListaPreguntas);
                lvPreguntas.setAdapter(adapter);
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regresar = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(regresar);
            }
        });
    }

    public void Agregar(String Pregunta, String Resp1, String Resp2, String Resp3, String RespCor, int Puntuacion) {
        DBHelper helper = new DBHelper(this, "Preguntas", null, 1);
        SQLiteDatabase DB = helper.getWritableDatabase();

        try {
            ContentValues cv = new ContentValues();
            cv.put("pregunta", Pregunta);
            cv.put("respuesta1", Resp1);
            cv.put("respuesta2", Resp2);
            cv.put("respuesta3", Resp3);
            cv.put("respuestacorrecta", RespCor);
            cv.put("Puntaje", Puntuacion);

            DB.insert("Preguntas", null, cv);
            DB.close();
            Toast.makeText(getApplicationContext(), "Pregunta registrada con exito", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex) {
            Toast.makeText(this, "Preguntas no insertadas" + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

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
        etPegunta = findViewById(R.id.etPegunta);
        etResp1 = findViewById(R.id.etResp1);
        etResp2 = findViewById(R.id.etResp2);
        etResp3 = findViewById(R.id.etResp3);
        etOpCorrecta = findViewById(R.id.etOpCorrecta);
        etPuntuacion = findViewById(R.id.etPuntuacion);

        btnRegistar = findViewById(R.id.btnRegistar);
        btnVolver = findViewById(R.id.btnVolver);

        lvPreguntas = findViewById(R.id.lvPreguntas);
    }
}