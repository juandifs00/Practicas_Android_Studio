package com.example.paso_entre_pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Pantalla3 extends AppCompatActivity {
    Button btnRegresar;
    TextView tvRespuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3);

        btnRegresar = (Button)findViewById(R.id.btnRegresar);
        tvRespuesta = (TextView) findViewById(R.id.tvRespuesta);

        Bundle bundle = getIntent().getExtras();

        String Dato = bundle.getString("Datos");
        tvRespuesta.setText(Dato);
    }
}