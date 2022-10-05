package com.example.crud_preguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Eliminar extends AppCompatActivity {

    Button btnEliminar;
    EditText txtId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);
        conexion();

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.valueOf(txtId.getText().toString());
                Eliminar(id);
            }
        });

    }

    private void Eliminar(int id) {
        DBHelper helper = new DBHelper(this, "DB", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "Delete from Preguntas where ID_Pregunta '" + id + "'";
        db.execSQL(SQL);
        db.close();
        Toast.makeText(this, "Pregunta eliminada", Toast.LENGTH_SHORT).show();
    }

    private void conexion() {
        btnEliminar = findViewById(R.id.btnEliminar);
        txtId = findViewById(R.id.txtId);
    }
}