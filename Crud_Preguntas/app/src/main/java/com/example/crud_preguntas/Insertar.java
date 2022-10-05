package com.example.crud_preguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Insertar extends AppCompatActivity {

    EditText txtPregunta, txtRespuesta1, txtRespuesta2, txtRespuesta3, txtResCorrecta, txtPuntaje;
    Button btnInsertar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);
        conexion();

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Pregunta, R1, R2, R3, RC;
                int Puntos;

                Pregunta = txtPregunta.getText().toString();
                R1 = txtPregunta.getText().toString();
                R2 = txtPregunta.getText().toString();
                R3 = txtPregunta.getText().toString();
                RC = txtPregunta.getText().toString();
                Puntos = Integer.valueOf(txtPuntaje.getText().toString());

                Insetar_Pregunta(Pregunta, R1, R2, R3, RC, Puntos);
            }
        });
    }

    private void Insetar_Pregunta(String Pregunta, String Respuesta_1, String Respuesta_2, String Respuesta_3, String Res_Correcta, int Puntaje) {
        DBHelper helper = new DBHelper(this, "Preguntas", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();

        try {
            ContentValues CV = new ContentValues();
            CV.put("Pregunta", Pregunta);
            CV.put("Respuesta_1", Respuesta_1);
            CV.put("Respuesta_2", Respuesta_2);
            CV.put("Respuesta_3", Respuesta_3);
            CV.put("Respuesta_Correcta", Res_Correcta);
            CV.put("Puntaje", Puntaje);

            db.insert("Preguntas", null, CV);
            Toast.makeText(this, "Pregunta registrada con exito", Toast.LENGTH_SHORT).show();
            db.close();
        }
        catch (Exception ex){
            Toast.makeText(this, "Error" + ex.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }

    private void conexion() {
        txtPregunta = findViewById(R.id.txtPregunta);
        txtRespuesta1 = findViewById(R.id.txtRespuesta1);
        txtRespuesta2 = findViewById(R.id.txtRespuesta2);
        txtRespuesta3 = findViewById(R.id.txtRespuesta3);
        txtResCorrecta = findViewById(R.id.txtResCorrecta);
        txtPuntaje = findViewById(R.id.txtPuntaje);
        btnInsertar = findViewById(R.id.btnInsertar);
    }
}