package com.example.paso_entre_pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {
    TextView tvInformacion;
    String Mistery2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        tvInformacion = findViewById(R.id.tvInformacion);
        Bundle paqueteInfo = getIntent().getExtras();
        if (paqueteInfo != null) {
            Mistery2 = paqueteInfo.getString("Mi_Variable");
            tvInformacion.setText(Mistery2);
        }
    }
}