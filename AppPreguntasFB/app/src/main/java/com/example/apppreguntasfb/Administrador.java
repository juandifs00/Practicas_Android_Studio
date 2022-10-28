package com.example.apppreguntasfb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Administrador extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ImageButton btnAgregar, btnBuscar, btnEditar, btnEliminar;
    Button btnRegresar;
    EditText etPregunta, etResp1, etResp2, etResp3, etRespCorrecta, etPuntuacion;
    ListView lvPreguntasDB;

    DatabaseReference DBPreg_Almacenadas;


    private List<CPreguntas> ListaPreguntas = new ArrayList<CPreguntas>();
    ArrayAdapter<CPreguntas> arrayAdapterCPreguntas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);
        conexion();

        DBPreg_Almacenadas = FirebaseDatabase.getInstance().getReference();

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //validacion();
                Insertar();
                limpiarCajas();
            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Preguntas_Almacenadas();
            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Actualizar_Preguntas();
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Regresar = new Intent(getApplicationContext(), Inicio_Sesion.class);
                startActivity(Regresar);
            }
        });

        lvPreguntasDB.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String IdActual = String.valueOf(lvPreguntasDB.getItemAtPosition(i));
                String[] datos = IdActual.split("");

                String Pregunta = datos[1];
                etPregunta.setText(Pregunta);

                String Respu1 = datos[2];
                etResp1.setText(Respu1);

                String Respu2 = datos[3];
                etResp2.setText(Respu2);

                String Respu3 = datos[4];
                etResp3.setText(Respu3);

                String RespuCorrecta = datos[5];
                etRespCorrecta.setText(RespuCorrecta);

                int Puntuacion = Integer.parseInt(datos[6]);
                etPuntuacion.setText(Puntuacion);
            }
        });

        lvPreguntasDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), CPreguntas.class);
                I.putExtra("ID", )
            }
        });

    }

    private void Preguntas_Almacenadas() {
        DBPreg_Almacenadas.child("DBPreguntas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot objSnaptshot: snapshot.getChildren()) {
                    ListaPreguntas.add(new CPreguntas(objSnaptshot.child("id").getValue().toString(),
                            objSnaptshot.child("pregunta").getValue().toString(),
                            objSnaptshot.child("opUno").getValue().toString(),
                            objSnaptshot.child("opDos").getValue().toString(),
                            objSnaptshot.child("opTres").getValue().toString(),
                            objSnaptshot.child("acertada").getValue().toString(),
                            Integer.parseInt(objSnaptshot.child("puntuacion").getValue().toString())));
                }
                arrayAdapterCPreguntas = new ArrayAdapter<CPreguntas>(Administrador.this, android.R.layout.simple_expandable_list_item_1, ListaPreguntas);
                lvPreguntasDB.setAdapter(arrayAdapterCPreguntas);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void Actualizar_Preguntas(String ID, String pregunta, String opUno, String opDos, String opTres, String acertada, int puntuacion) {
        DBPreg_Almacenadas = FirebaseDatabase.getInstance().getReference();
        CPreguntas C = new CPreguntas(ID, pregunta, opUno, opDos, opTres, acertada, puntuacion);
        DBPreg_Almacenadas.child("DBPreguntas").child(ID).setValue(C);
        Toast.makeText(this, R.string.Actualizar, Toast.LENGTH_SHORT).show();
    }


    private void Eliminar_Pregunta(String ID) {
        DBPreg_Almacenadas = FirebaseDatabase.getInstance().getReference();
        DBPreg_Almacenadas.child("DBPreguntas").child(ID).removeValue();
    }

    private void Insertar() {
        String nId = UUID.randomUUID().toString();
        String Pregunta = etPregunta.getText().toString();
        String Respu1 = etResp1.getText().toString();
        String Respu2 = etResp2.getText().toString();
        String Respu3 = etResp3.getText().toString();
        String RespuCorr = etRespCorrecta.getText().toString();
        int Puntuacion = Integer .valueOf(etPuntuacion.getText().toString());

        CPreguntas C = new CPreguntas(nId, Pregunta, Respu1, Respu2, Respu3, RespuCorr, Puntuacion);
        Toast.makeText(this, R.string.Insertar_Exito, Toast.LENGTH_SHORT).show();
        DBPreg_Almacenadas.child("DBPreguntas").child(C.getID()).setValue(C);
    }

    /*
    private void validacion() {
        String pregunta = etPregunta.getText().toString();
        String respu1 = etResp1.getText().toString();
        String respu2 = etResp2.getText().toString();
        String respu3 = etResp3.getText().toString();
        String respucorr = etRespCorrecta.getText().toString();
        int puntaje = Integer.parseInt(etPuntuacion.getText().toString());

        if (pregunta.equals("")){
            etPregunta.setError("Required");
        }
        else if (respu1.equals("")){
            etResp1.setError("Required");
        }
        else if (respu2.equals("")){
            etResp2.setError("Required");
        }
        else if (respu3.equals("")){
            etResp3.setError("Required");
        }
        else if (respucorr.equals("")){
            etRespCorrecta.setError("Required");
        }
        /*
        else if (puntaje.equals("")){
            etPuntuacion.setError("Required");
        }
    }
     */


    private void limpiarCajas() {
        etPregunta.setText("");
        etResp1.setText("");
        etResp2.setText("");
        etResp3.setText("");
        etRespCorrecta.setText("");
        etPuntuacion.setText("");
    }

    private void conexion() {
        btnAgregar = findViewById(R.id.btnAgregar);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnEditar = findViewById(R.id.btnEditar);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnRegresar = findViewById(R.id.btnRegresar);

        etPregunta = findViewById(R.id.etPregunta);
        etResp1 = findViewById(R.id.etResp1);
        etResp2 = findViewById(R.id.etResp2);
        etResp3 = findViewById(R.id.etResp3);
        etRespCorrecta = findViewById(R.id.etRespCorrecta);
        etPuntuacion = findViewById(R.id.etPuntuacion);

        lvPreguntasDB = findViewById(R.id.lvPreguntasBD);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        etPregunta.setText(ListaPreguntas.get(i).getPregunta());
        etResp1.setText(ListaPreguntas.get(i).getOpUno());
        etResp2.setText(ListaPreguntas.get(i).getOpDos());
        etResp3.setText(ListaPreguntas.get(i).getOpTres());
        etRespCorrecta.setText(ListaPreguntas.get(i).getAcertada());
        etPuntuacion.setText(String.valueOf(ListaPreguntas.get(i).getPuntuacion()));
    }
}