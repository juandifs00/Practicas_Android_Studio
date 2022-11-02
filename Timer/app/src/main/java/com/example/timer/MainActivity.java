package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView tvTimer, tvTimer1;
    Button btnIniciar, btnp2;
    CountDownTimer cdTimer;

    /*
    private static final long tiempo = 20000;
    private long mTimeLeftInMillis = tiempo;
     */

    private static final long START_TIME_IN_MILLIS = 20000;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    private boolean corre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conectar();

        btnp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent P2 = new Intent(getApplicationContext(), Timer2.class);
                startActivity(P2);
            }
        });

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CuentaRegre();
            }
        });
    }

    private void CuentaRegre() {
        cdTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                corre = false;
                btnIniciar.setText("Start");
                Toast.makeText(getApplicationContext(), "Sin tiempo", Toast.LENGTH_SHORT).show();

            }
        }.start();

        corre = true;
    }

    private void pauseTimer() {
        cdTimer.cancel();
        corre = false;
    }

    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        btnIniciar.setVisibility(View.VISIBLE);
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        tvTimer.setText(timeLeftFormatted);
    }

    /*
    private void CuentaRegre() {
        new CountDownTimer(tiempo, 1000) {
            public void onTick(long millisUntilFinished) {
                // Used for formatting digit to be in 2 digits only
                NumberFormat f = new DecimalFormat("00");
                long hour = (millisUntilFinished / 3600000) % 24;
                long min = (millisUntilFinished / 60000) % 60;
                long sec = (millisUntilFinished / 1000) % 60;
                tvTimer.setText(f.format(sec));
            }
            // When the task is over it will print 00:00:00 there
            public void onFinish() {
                tvTimer1.setText("SIN TIEMPO");
                //tvTimer1.setTextColor(Color.RED);
                //tvTimer1.setTextColor(Color.parseColor("#990000"));
                tvTimer1.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.eliminar));
                Toast.makeText(getApplicationContext(), "Pulse Count Completed :)", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }
     */

    /*
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
     */

    private void conectar() {
        tvTimer = findViewById(R.id.tvTimer);
        tvTimer1 = findViewById(R.id.tvTimer);
        btnIniciar = findViewById(R.id.btnIniciar);
        btnp2 = findViewById(R.id.btnp2);
    }
}