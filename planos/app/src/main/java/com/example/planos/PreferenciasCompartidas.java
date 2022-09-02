package com.example.planos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PreferenciasCompartidas extends AppCompatActivity {
    EditText etValor;
    Button btnGuardar;
    TextView tvSalida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias_compartidas);
        conectar();
        //Context ctx = this;
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valor = etValor.getText().toString();
                SharedPreferences sp = getSharedPreferences("Archivo", Context.MODE_PRIVATE);
                String Nombre = sp.getString("ElNombre", valor);
                Toast.makeText(getApplicationContext(), Nombre, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void conectar() {
        etValor = findViewById(R.id.etValor);
        btnGuardar = findViewById(R.id.btnGuardar);
        tvSalida = findViewById(R.id.tvSalida);
    }
}
