package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Button btn_holis;
    TextView tv_hols;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectar();
        btn_holis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_hols.setText("Buenas buenas los señores");
                Toast.makeText(getApplicationContext(),"Hola a la gente", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void conectar() {
        btn_holis = (Button) findViewById(R.id.btn_holis);
        tv_hols = (TextView) findViewById(R.id.tv_hols);
    }
}