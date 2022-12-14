package com.example.game_random;

import static android.graphics.Color.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText etNumeroIngresado;
    Button btnGenerar, btnOportunidades;
    TextView tvPuntos;

    Random Ganadores = new Random();

    int ganador;
    int oportunidades = 10;
    int puntaje_actual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conexion();

        btnGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int aletorio = Ganadores.nextInt(90)+10;
                ganador = aletorio;
                btnGenerar.setText(ganador + "");
                Integer nuevo_puntaje = comprobar_diferencia();
                tvPuntos.setText(nuevo_puntaje+"");
            }
        });

        btnOportunidades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnOportunidades.setText(oportunidades + "");
                reducirOportunidades();
            }
        });
    }

    public void reducirOportunidades() {
        if (btnOportunidades.hasOnClickListeners()) {
            if (oportunidades > 0) {
                oportunidades--;
                btnGenerar.setText("Generar Número aletorio");
            }
            if (oportunidades == 0) {
                btnGenerar.setBackgroundColor(RED);
                btnOportunidades.setBackgroundColor(RED);
            }
        }
    }

    public int comprobar_diferencia() {
        Integer numero = Integer.parseInt(etNumeroIngresado.getText().toString());
        Integer dato_aleatorio = Integer.parseInt(btnGenerar.getText().toString());

        int distancia;

        distancia = Math.abs(dato_aleatorio - numero);

        if (numero.equals(distancia)) {
            puntaje_actual += 50;
        } else {
            if (distancia > 5 && distancia <= 10) {
                puntaje_actual += 5;
            } else {
                if (distancia > 1 && distancia <= 5) {
                    puntaje_actual += 10;
                } else {
                    if (distancia == 1) {
                        puntaje_actual += 15;
                    }
                }
            }
        }
        return distancia;
    }

    private void comprobar_vacio() {
        Integer numero = Integer.parseInt(etNumeroIngresado.getText().toString());
        if (numero.equals(null)) {
            Toast.makeText(getApplicationContext(), "No ingresó ningún número", Toast.LENGTH_LONG).show();
        }
    }

    private void conexion() {
        etNumeroIngresado = findViewById(R.id.etNumeroIngresado);
        btnGenerar = findViewById(R.id.btnGenerar);
        tvPuntos = findViewById(R.id.tvPuntos);
        btnOportunidades = findViewById(R.id.btnOportunidades);
    }
}