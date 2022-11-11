package com.example.apppreguntasfb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class Juego extends AppCompatActivity {
    Button btnP1, btnP2, btnP3, btnP4, btnP5, btnP6, btnP7,
            btnP8, btnP9, btnP10, btnP11, btnP12, btnP13, btnP14,
            btnP15, btnP16, btnP17, btnP18, btnP19, btnP20, btnR1, btnR2, btnR3, btnMJugadores;

    Button btnTemp;

    TextView tvPuntaje, tvPreguntas, tvTiempo, TvNombre;

    ArrayList<CPreguntas> XPreguntas = new ArrayList<>();
    Random random = new Random();

    int PuntajePregunta, PAcertadas, PuntosTotal;
    String Acertada;

    CountDownTimer StarStop;
    public long tiempo;
    private boolean corre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        conexion();
        //XPreguntas = leerRegistros();
        PuntosTotal = 0;
        PuntajePregunta = 0;
        TvNombre.setText(Nombre());

        btnP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintPreguntas(btnP1);
            }
        });

        btnP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintPreguntas(btnP2);
            }
        });

        btnP3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintPreguntas(btnP3);
            }
        });

        btnP4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintPreguntas(btnP4);
            }
        });

        btnP5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintPreguntas(btnP5);
            }
        });

        btnP6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintPreguntas(btnP6);
            }
        });

        btnP7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintPreguntas(btnP7);
            }
        });

        btnP8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintPreguntas(btnP8);
            }
        });

        btnP9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintPreguntas(btnP9);
            }
        });

        btnP10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintPreguntas(btnP10);
            }
        });

        btnP11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintPreguntas(btnP11);
            }
        });

        btnP12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintPreguntas(btnP12);
            }
        });

        btnP13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintPreguntas(btnP13);
            }
        });

        btnP14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintPreguntas(btnP14);
            }
        });

        btnP15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintPreguntas(btnP15);
            }
        });

        btnP16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintPreguntas(btnP16);
            }
        });

        btnP17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintPreguntas(btnP17);
            }
        });

        btnP18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintPreguntas(btnP18);
            }
        });

        btnP19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintPreguntas(btnP19);
            }
        });

        btnP20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintPreguntas(btnP20);
            }
        });

        btnR1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Comprobar(btnR1);
                Habilitar(false);
            }
        });

        btnR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Comprobar(btnR2);
                Habilitar(false);
            }
        });

        btnR3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Comprobar(btnR3);
                Habilitar(false);
            }
        });

        btnMJugadores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Ranking = new Intent(getApplicationContext(), MejoresJugadores.class);
                startActivity(Ranking);
            }
        });
    }

    private void iniciaPausa(){
        if(corre);
        else
            iniciarTimer();
    }

    public void iniciarTimer(){
        StarStop = new CountDownTimer(tiempo, 1000) {
            @Override
            public void onTick(long l) {
                tiempo=l;
                actualizarTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();
        corre = true;
    }

    public void pausaTimer(){
        StarStop.cancel();
        corre=false;
    }

    public void actualizarTimer(){
        int segundos = (int) tiempo % 60000 / 1000;
        int Aux = segundos - 1;
        String tiempoRestante = Aux+"";
        tvTiempo.setText(tiempoRestante);
        if(Aux >= 0 ){
            Toast.makeText(getApplicationContext(), R.string.Sin_tiempo, Toast.LENGTH_LONG).show();
            tvTiempo.setText(R.string.Sin_tiempo);
        }
    }

    public String Nombre(){
        String Aux;
        Bundle pInfo = getIntent().getExtras();
        if(pInfo != null){
            Aux = pInfo.getString("Name");
        } else {
            Aux = "Anonymous";
        }
        return  Aux;
    }

    public void MostrarPregunta(Button NP) {
        tiempo = 21000;
        iniciaPausa();

        btnTemp = NP;

        ArrayList<String> SeleccionR = new ArrayList<>();

        int intR = random.nextInt(XPreguntas.size());

        SeleccionR.add(XPreguntas.get(intR).getOpUno());
        SeleccionR.add(XPreguntas.get(intR).getOpDos());
        SeleccionR.add(XPreguntas.get(intR).getOpTres());

        tvPreguntas.setText(XPreguntas.get(intR).getPregunta());

        btnR1.setText(XPreguntas.get(intR).getOpUno());
        btnR2.setText(XPreguntas.get(intR).getOpDos());
        btnR3.setText(XPreguntas.get(intR).getOpTres());

        Acertada = XPreguntas.get(intR).getAcertada();

        PuntajePregunta = XPreguntas.get(intR).getPuntuacion();

        XPreguntas.remove(intR);
    }

    public void Comprobar(Button Pregunta) {
        pausaTimer();

        int Tiempo = Integer.parseInt(tvTiempo.getText().toString());

        if (Integer.parseInt(Pregunta.getText().toString()) == Integer.parseInt(Acertada)) {

            if (Tiempo >= 16) {
                PuntosTotal += 5;
            } else if ((Tiempo <= 15) && (Tiempo >= 11)) {
                PuntosTotal += 3;
            } else if ((Tiempo <= 10) && (Tiempo >= 1)) {
                PuntosTotal += 1;
            }

            PuntosTotal += PuntajePregunta;
            PAcertadas += 1;

            tvPuntaje.setText(PuntosTotal + "");
            Pregunta.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            btnTemp.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            btnTemp.setEnabled(false);
        } else {
            Pregunta.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            btnTemp.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            btnTemp.setEnabled(false);
        }
        if ((PAcertadas + XPreguntas.size()) < 20){
            Intent Final = new Intent(getApplicationContext(), FinJuego.class);
            startActivity(Final);
        }else if (PAcertadas == 20){
            Intent Final = new Intent(getApplicationContext(), FinJuego.class);
            startActivity(Final);
        }
    }

    public void Habilitar(Boolean Deshabilitar) {
        btnR1.setEnabled(Deshabilitar);
        btnR2.setEnabled(Deshabilitar);
        btnR3.setEnabled(Deshabilitar);
    }

    public void ReinicioRespuestas() {
        btnR1.setBackgroundColor(Color.parseColor("#CC6600"));
        btnR2.setBackgroundColor(Color.parseColor("#CC3300"));
        btnR3.setBackgroundColor(Color.parseColor("#000066"));
    }

    public void PintPreguntas(Button NP) {
        MostrarPregunta(NP);
        Habilitar(true);
        ReinicioRespuestas();
    }

    private void conexion() {
        btnP1 = findViewById(R.id.btnP1);
        btnP2 = findViewById(R.id.btnP2);
        btnP3 = findViewById(R.id.btnP3);
        btnP4 = findViewById(R.id.btnP4);
        btnP5 = findViewById(R.id.btnP5);
        btnP6 = findViewById(R.id.btnP6);
        btnP7 = findViewById(R.id.btnP7);
        btnP8 = findViewById(R.id.btnP8);
        btnP9 = findViewById(R.id.btnP9);
        btnP10 = findViewById(R.id.btnP10);
        btnP11 = findViewById(R.id.btnP11);
        btnP12 = findViewById(R.id.btnP12);
        btnP13 = findViewById(R.id.btnP13);
        btnP14 = findViewById(R.id.btnP14);
        btnP15 = findViewById(R.id.btnP15);
        btnP16 = findViewById(R.id.btnP16);
        btnP17 = findViewById(R.id.btnP17);
        btnP18 = findViewById(R.id.btnP18);
        btnP19 = findViewById(R.id.btnP19);
        btnP20 = findViewById(R.id.btnP20);

        btnR1 = findViewById(R.id.btnR1);
        btnR2 = findViewById(R.id.btnR2);
        btnR3 = findViewById(R.id.btnR3);

        tvPuntaje = findViewById(R.id.tvPuntaje);
        tvPreguntas = findViewById(R.id.tvPreguntas);
        tvTiempo = findViewById(R.id.tvTiempo);
        TvNombre = findViewById(R.id.TvNombre);

        btnMJugadores = findViewById(R.id.btnMJugadores);
    }
}