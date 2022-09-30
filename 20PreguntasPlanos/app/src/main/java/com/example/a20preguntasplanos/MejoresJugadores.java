package com.example.a20preguntasplanos;

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

    ArrayList<CRanking> Rankings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mejores_jugadores);
        conexion();
        MostrarMejores();
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
        MJugadores MJ = new MJugadores(this);
        Rankings = MJ.LeerRanking();

        Collections.sort(Rankings, new Comparator<CRanking>() {
            @Override
            public int compare(CRanking S1, CRanking S2) {
                return new Integer(S2.getPuntosT()).compareTo(new Integer(S1.getPuntosT()));
            }
        });
        adapter = new ArrayAdapter<CRanking>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, Rankings);
        lvMJugadores.setAdapter(adapter);
    }

    public void MostrarMejores() {
        MJugadores MJ = new MJugadores(this);
        Rankings = MJ.LeerRanking();
    }

    private void conexion() {
        btnVolver = findViewById(R.id.btnVolver);
        lvMJugadores = findViewById(R.id.lvMJugadores);
    }
}