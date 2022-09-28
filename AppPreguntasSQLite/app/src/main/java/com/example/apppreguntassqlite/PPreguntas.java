package com.example.apppreguntassqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PPreguntas extends AppCompatActivity {

    EditText etPegunta, etResp1, etResp2, etResp3, etOpCorrecta;
    Button btnRegistar, btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppreguntas);
        conexion();

        btnRegistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pregunta, respuesta1, respuesta2, respuesta3, respuestacorrecta;
                pregunta = etPegunta.getText().toString();
                respuesta1 = etResp1.getText().toString();
                respuesta2 = etResp2.getText().toString();
                respuesta3 = etResp3.getText().toString();
                respuestacorrecta = etOpCorrecta.getText().toString();

                Agregar(pregunta, respuesta1, respuesta2, respuesta3, respuestacorrecta);
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

    public void Agregar(String Pregunta, String Resp1, String Resp2, String Resp3, String RespCor) {
        DBHelper helper = new DBHelper(this, "LasPreguntas", null, 1);
        SQLiteDatabase DB = helper.getWritableDatabase();

        try {
            ContentValues cv = new ContentValues();
            cv.put("Pregunta", Pregunta);
            cv.put("Respuesta 1", Resp1);
            cv.put("Respuesta 2", Resp2);
            cv.put("Respuesta 3", Resp3);
            cv.put("Respuesta correcta", RespCor);

            DB.insert("Preguntas", null, cv);
            DB.close();
            Toast.makeText(getApplicationContext(), "Pregunta registrada con exito", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex) {
            Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void conexion() {
        etPegunta = findViewById(R.id.etPegunta);
        etResp1 = findViewById(R.id.etResp1);
        etResp2 = findViewById(R.id.etResp2);
        etResp3 = findViewById(R.id.etResp3);
        etOpCorrecta = findViewById(R.id.etOpCorrecta);

        btnRegistar = findViewById(R.id.btnRegistar);
        btnVolver = findViewById(R.id.btnVolver);
    }
}