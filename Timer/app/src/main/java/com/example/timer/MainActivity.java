package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTimer;
    Button btnIniciar;
    CountDownTimer cdTimer;

    private long tiempo = 10000;
    private boolean corre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectar();

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IniciarPausa();
            }
        });
        ActualizarTimer();
    }

    private void IniciarPausa() {
        if (corre)
            PausarTimer();
        else
            IniciarTimer();
    }

    private void IniciarTimer() {
        cdTimer = new CountDownTimer(tiempo, 1000) {
            @Override
            public void onTick(long l) {
                tiempo = l;
                ActualizarTimer();
            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(), "Se acacbó el tiempo", Toast.LENGTH_SHORT).show();
            }
        }.start();
        btnIniciar.setText("PAUSA");
        corre = true;
    }

    private void PausarTimer() {
        cdTimer.cancel();
        btnIniciar.setText("INICIAR");
        corre = false;
    }

    private void ActualizarTimer() {
        int minutos = (int) tiempo / 60000;
        int segundos = (int) tiempo % 60000 / 1000;

        String TiempoRestante = "" + minutos;
        TiempoRestante += ":";
        if (segundos < 100) {
            TiempoRestante += "0";
            TiempoRestante += segundos;
            tvTimer.setText(TiempoRestante);
        }
    }

    private void conectar() {
        tvTimer = findViewById(R.id.tvTimer);
        btnIniciar = findViewById(R.id.btnIniciar);
    }
}