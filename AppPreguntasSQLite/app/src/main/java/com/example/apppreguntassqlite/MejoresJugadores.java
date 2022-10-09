package com.example.apppreguntassqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MejoresJugadores extends AppCompatActivity {

    Button btnVolver;
    ListView lvMJugadores;
    ArrayAdapter adapter;

    ArrayList<CPuntaje> Rankings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mejores_jugadores);
        conexion();
        //MostrarMejores();
        adaptar();

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regresar = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(regresar);
            }
        });
    }

    public void adaptar(){
        Collections.sort(Rankings, new Comparator<CPuntaje>() {
            @Override
            public int compare(CPuntaje S1, CPuntaje S2) {
                return new Integer(S2.getPuntosT()).compareTo(new Integer(S1.getPuntosT()));
            }
        });
        adapter = new ArrayAdapter<CPuntaje>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, Rankings);
        lvMJugadores.setAdapter(adapter);
    }

    public void MostrarMejores() {
    }

    private void conexion() {
        btnVolver = findViewById(R.id.btnVolver);
        lvMJugadores = findViewById(R.id.lvMJugadores);
    }
}