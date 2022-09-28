package com.example.a20preguntasplanos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class AddPreguntas extends AppCompatActivity {

    EditText etPegunta, etResp1, etResp2, etResp3, etOpCorrecta;
    Button btnRegistar, btnVolver;
    TextView tvPAgregadas;

    String Pregunta, Resp1, Resp2, Resp3, Opcorr;

    Preguntas objAp = new Preguntas(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_preguntas);
        conexion();
        Mostrar_Preguntas();

        btnRegistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pregunta = etPegunta.getText().toString();
                Resp1 = etResp1.getText().toString();
                Resp2 = etResp2.getText().toString();
                Resp3 = etResp3.getText().toString();
                Opcorr = etOpCorrecta.getText().toString();

                String POrganizada = Pregunta + " ;" + Resp1 + " ;" + Resp2 + " ;" + Resp3 + " ;" + Opcorr + " ;" + "\n";

                try {
                    objAp.Escribir(POrganizada);
                    Toast.makeText(getApplicationContext(), "Preguntas insertadas correctamente", Toast.LENGTH_SHORT).show();
                    Mostrar_Preguntas();
                }
                catch (IOException ex) {
                    ex.getMessage();
                }
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regresar = new Intent(getApplicationContext(), Perfiles.class);
                startActivity(regresar);
            }
        });
    }

    public void Mostrar_Preguntas() {
        String mostrarP = objAp.Leer();
        tvPAgregadas.setText(mostrarP);
    }

    private void conexion() {
        etPegunta = findViewById(R.id.etPegunta);
        etResp1 = findViewById(R.id.etResp1);
        etResp2 = findViewById(R.id.etResp2);
        etResp3 = findViewById(R.id.etResp3);
        etOpCorrecta = findViewById(R.id.etOpCorrecta);

        btnRegistar = findViewById(R.id.btnRegistar);
        btnVolver = findViewById(R.id.btnVolver);

        tvPAgregadas = findViewById(R.id.tvPAgregadas);
    }
}