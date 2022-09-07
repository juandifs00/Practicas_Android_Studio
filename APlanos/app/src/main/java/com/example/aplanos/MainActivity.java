package com.example.aplanos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText etEscribe;
    Button btnOprimir;
    TextView tvResultado;
    String Texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conexion();
        Planos objAp = new Planos(this);
        btnOprimir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Texto = etEscribe.getText().toString();
                try {
                    tvResultado.setText("");
                    objAp.Escribir(Texto);
                    tvResultado.setText(objAp.Leer());
                }
                catch (IOException ex)
                {
                    ex.getMessage();
                }
            }
        });
    }

    private void conexion() {
        etEscribe = findViewById(R.id.etEscribe);
        btnOprimir = findViewById(R.id.btnOprimir);
        tvResultado = findViewById(R.id.tvResultado);
    }
}