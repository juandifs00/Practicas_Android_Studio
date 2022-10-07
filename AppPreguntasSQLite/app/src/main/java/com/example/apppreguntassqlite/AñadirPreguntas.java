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

public class AñadirPreguntas extends AppCompatActivity {

    EditText etPegunta, etResp1, etResp2, etResp3, etOpCorrecta, etPuntuacion;
    Button btnRegistar, btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpreguntas);
        conexion();

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
        DBHelper helper = new DBHelper(this, "LasPreguntas", null, 1);
        SQLiteDatabase DB = helper.getWritableDatabase();

        try {
            ContentValues cv = new ContentValues();
            cv.put("Pregunta", Pregunta);
            cv.put("Respuesta 1", Resp1);
            cv.put("Respuesta 2", Resp2);
            cv.put("Respuesta 3", Resp3);
            cv.put("Respuesta correcta", RespCor);
            cv.put("Puntaje", Puntuacion);

            DB.insert("Preguntas", null, cv);
            DB.close();
            Toast.makeText(getApplicationContext(), "Pregunta registrada con exito", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex) {
            Toast.makeText(this, "Preguntas no insertadas" + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
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
    }
}