package com.example.apppreguntasfb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Menucito extends AppCompatActivity {

    TextView tvWelcom;
    Button btnPuntaje, btnJugar, btnAdmin;
    LinearLayout llUno, llDos;

    ArrayList<Usuarios> Usuarios = new ArrayList<>();

    String Nombre, Rol;

    FirebaseAuth mAuth;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menucito);
        conectar();

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), Administrador.class);
                startActivity(I);
            }
        });

        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), Juego.class);
                I.putExtra("Name", Nombre);
                startActivity(I);
            }
        });

        btnPuntaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), MejoresJugadores.class);
                startActivity(I);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Usuario();
    }

    private void Usuario(){
        final FirebaseUser user = mAuth.getCurrentUser();
        if(user != null){
            DatabaseReference myRef = database.getReference().child("Users").child(user.getUid());
            myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    DataSnapshot objsnapshot = snapshot;
                    Usuarios.add(new Usuarios(objsnapshot.child("id").getValue().toString(),
                            objsnapshot.child("nombre").getValue().toString(),
                            objsnapshot.child("correo").getValue().toString(),
                            objsnapshot.child("contraseña").getValue().toString(),
                            Boolean.valueOf(objsnapshot.child("tipo").getValue().toString())));

                    if (Usuarios != null){
                        Nombre = Usuarios.get(0).getNombre()+"";
                        tvWelcom.setText("Bienvenido " + Nombre);

                        if(Usuarios.get(0).getTipo() == true){
                            llUno.setVisibility(View.VISIBLE);
                        }else {
                            llDos.setVisibility(View.VISIBLE);
                        }

                    }else {
                        return;
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });

        } else {
            Intent i = new Intent(getApplicationContext(), Inicio_Sesion.class);
            startActivity(i);
        }
    }

    private void conectar() {
        btnPuntaje = findViewById(R.id.btnPuntaje);
        btnJugar = findViewById(R.id.btnJugar);
        btnAdmin = findViewById(R.id.btnAdmin);
        tvWelcom = findViewById(R.id.tvWelcom);
        llUno = findViewById(R.id.llUno);
        llDos = findViewById(R.id.llDos);
    }
}