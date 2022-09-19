package com.example.a20preguntas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnP1, btnP2, btnP3, btnP4, btnP5, btnP6, btnP7,
            btnP8, btnP9, btnP10, btnP11, btnP12, btnP13, btnP14,
            btnP15, btnP16, btnP17, btnP18, btnP19, btnP20, btnR1, btnR2, btnR3;

    TextView tvPuntaje, tvPreguntas, tvAciertos;

    ArrayList<Preguntas> XPreguntas = new ArrayList<>();
    Random random = new Random();

    int PuntajePregunta, PAcertadas, PuntosTotal;
    String Acertada;
    Button btnTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conexion();
        AñadirPreguntas();
        PuntosTotal = 0;
        PuntajePregunta = 0;

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
    }

    public void MostrarPregunta(Button NP) {
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

    public void AñadirPreguntas() {
        XPreguntas.add(new Preguntas("¿Cuanto es un lustro?", "5 años", "10 años", "2 siglos", "5 años", 10));
        XPreguntas.add(new Preguntas("¿Cuanto es 20 * 50?", "500", "250", "100", "100", 10));
        XPreguntas.add(new Preguntas("¿HTML es un lenguaje de programacion?", "Si", "No", "No sé", "No", 10));
        XPreguntas.add(new Preguntas("¿El RGB da más FPS?", "No", "Obvio pa", "Jamás", "Obvio pa", 15));
        XPreguntas.add(new Preguntas("¿Que pesa más, 1Kg de acero o 1Kg de algodón?", "Pesan lo mismo", "El acero", "El algodón", "Pesan lo mismo", 10));
        XPreguntas.add(new Preguntas("¿Fórmula química del ácido clorhídrico?", "ACH", "DCH", "HCI", "HCI", 10));
        XPreguntas.add(new Preguntas("16 en hexadecimal", "1B", "0G", "10", "10", 10));
        XPreguntas.add(new Preguntas("¿Cuánto midió el hombre más alto del mundo?", "199cm", "235cm", "272cm", "272cm", 10));
        XPreguntas.add(new Preguntas("¿Qué dedo de la mano sólo tiene dos falanges?", "El pulgar", "El indice", "Ninguno", "El pulgar", 10));
        XPreguntas.add(new Preguntas("20 + 100 + 420", "580", "460", "540", "540", 10));
        XPreguntas.add(new Preguntas("¿Qué es el C02?", "Monoxido de carbono", "Dioxido de carbono", "Mugre", "Dioxido de carbono", 10));
        XPreguntas.add(new Preguntas("¿Qué significan las siglas www?", "World Wide Web", "3W", "World Trade Center", "World Wide Web", 10));
        XPreguntas.add(new Preguntas("¿Qué es el caracol?", "Molusco", "Babosa", "Invertebrado", "Molusco", 10));
        XPreguntas.add(new Preguntas("¿Cuál es la distribución de Linux más usada?", "Kali", "Windows 7", "Ubuntu", "Ubuntu", 10));
        XPreguntas.add(new Preguntas("¿Cuántos grados Kelvin son 0 grados Celcius?", "273,15", "0", "180", "273,15", 10));
        XPreguntas.add(new Preguntas("¿Cuál es el salto más alto en caballo?", "90", "120", "45", "120", 10));
        XPreguntas.add(new Preguntas("¿En qué año se fundó el FC Barcelona?", "1899", "1910", "2001", "1899", 10));
        XPreguntas.add(new Preguntas("¿Quién es el cancerbero de un equipo?", "Delantero", "Portero", "Lateral izquierdo", "Portero", 10));
        XPreguntas.add(new Preguntas("¿En qué programa sale Sheldon Cooper?", "The Big Bang Theory", "Friends", "How I Meet Your Mother", "The Big Bang Theory", 10));
        XPreguntas.add(new Preguntas("¿En qué año nació Michael Jackson?", "1958", "1980", "2012", "1958", 10));
    }

    public void Comprobar(Button Pregunta) {
        if(Pregunta.getText() == Acertada) {
            PuntosTotal += PuntajePregunta;
            PAcertadas +=1;
            tvPuntaje.setText(PuntosTotal + "");
            tvAciertos.setText(PAcertadas + "");
            Pregunta.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            btnTemp.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            btnTemp.setEnabled(false);
        } else {
            Pregunta.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            btnTemp.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            btnTemp.setEnabled(false);
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
        tvAciertos = findViewById(R.id.tvAciertos);
    }
}