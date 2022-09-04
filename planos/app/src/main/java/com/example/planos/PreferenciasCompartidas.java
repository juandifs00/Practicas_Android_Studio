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
    EditText etValor, etEntero, etBooleano;
    Button btnGuardar;
    TextView tvSalida, tvSalidaEntero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias_compartidas);
        conectar();

        //Context ctx = this;
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("Archivo", Context.MODE_PRIVATE);
                String valor = etValor.getText().toString();
                int datoentero = Integer.parseInt(etEntero.getText().toString());
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("N", valor).apply();
                editor.putInt("E", datoentero).apply();
                String Nombre = sp.getString("N", valor);
                int Nombre2 = sp.getInt("E", datoentero);
                Toast.makeText(getApplicationContext(), Nombre, Toast.LENGTH_LONG).show();
                tvSalida.setText(Nombre);
                tvSalidaEntero.setText(Nombre2);
            }
        });
    }

    private void conectar() {
        etValor = findViewById(R.id.etValor);
        btnGuardar = findViewById(R.id.btnGuardar);
        tvSalida = findViewById(R.id.tvSalida);
    }
}
