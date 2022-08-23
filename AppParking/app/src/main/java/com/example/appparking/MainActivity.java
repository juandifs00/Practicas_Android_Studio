package com.example.appparking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RadioGroup rgVehiculos, rgPersonalizaciones;
    CheckBox chkRines, chkPolarizado, chkAudio, chkBlindaje, chkAlarma;
    Button btnFactura;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectar();
        btnFactura.setOnClickListener(this);
    }

    private void conectar() {        chkRines = findViewById(R.id.chkRines);
        chkPolarizado = findViewById(R.id.chkPolarizado);
        chkAudio = findViewById(R.id.chkAudio);
        chkBlindaje = findViewById(R.id.chkBlindaje);
        chkAlarma = findViewById(R.id.chkAlarma);

        rgVehiculos = findViewById(R.id.rgVehiculos);
        rgPersonalizaciones = findViewById(R.id.rgPersonalizaciones);

        btnFactura = findViewById(R.id.btnFactura);
    }

    @Override
    public void onClick(View view) {

    }
}