package com.example.appfirebasev2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    EditText etID, etNombre, etTelefono, etEdad;
    Button btnInsertar, btnListar, btnActualizar, btnEliminar;
    ListView lvDataAlmacenada;

    DatabaseReference miDB;

    ArrayList<String> ListaContactos = new ArrayList<>();

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conexion();

        miDB = FirebaseDatabase.getInstance().getReference();

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertar();
            }
        });

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Listar();
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actualizar();
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminar();
            }
        });

        lvDataAlmacenada.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String IdActual = String.valueOf(lvDataAlmacenada.getItemIdAtPosition(i));
                //String IdActual = lvDataAlmacenada.getItemIdAtPosition(i).toString();
                String[] datos = IdActual.split("");

                String idn = datos[0];
                etID.setText(idn);

                String nombre = datos[1];
                etNombre.setText(nombre);

                String telefono = datos[2];
                etTelefono.setText(telefono);

                String edad = datos[3];
                etEdad.setText(edad);
            }
        });
    }

    private void insertar() {
        String nId = UUID.randomUUID().toString();
        String Nombre = etNombre.getText().toString();
        String Telefono = etTelefono.getText().toString();
        int Edad = Integer.valueOf(etEdad.getText().toString());

        Contactos C = new Contactos(nId, Nombre, Telefono, Edad);
        Toast.makeText(this, R.string.Insertar_Exito, Toast.LENGTH_SHORT).show();
        miDB.child("Contactos").child(C.getID()).setValue(C);
    }

    private void Listar() {
        miDB.child("Contactos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ListaContactos.clear();
                for (DataSnapshot objsnapshot: snapshot.getChildren()) {
                    String c = objsnapshot.child("id").getValue().toString() +" "+
                            objsnapshot.child("nombre").getValue().toString() +" "+
                            objsnapshot.child("telefono").getValue().toString()+" "+
                            objsnapshot.child("edad").getValue().toString();
                    ListaContactos.add(c);
                }
                adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, ListaContactos);
                lvDataAlmacenada.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void actualizar() {
        Contactos C = new Contactos(etID.getText().toString(), etNombre.getText().toString(),
                etTelefono.getText().toString(), Integer.valueOf(etEdad.getText().toString()));
        miDB.child("Contactos").child(etID.getText().toString()).setValue(C);
        Toast.makeText(this, R.string.Actualizar, Toast.LENGTH_SHORT).show();
    }

    private void eliminar() {
        Contactos C = new Contactos(etID.getText().toString(), etNombre.getText().toString(),
                etTelefono.getText().toString(), Integer.valueOf(etEdad.getText().toString()));
        miDB.child("Contactos").child(etID.getText().toString()).removeValue();
        Toast.makeText(this, R.string.Eliminar, Toast.LENGTH_SHORT).show();
    }

    private void conexion() {
        etID = findViewById(R.id.etID);
        etNombre = findViewById(R.id.etNombre);
        etTelefono = findViewById(R.id.etTelefono);
        etEdad = findViewById(R.id.etEdad);

        btnInsertar = findViewById(R.id.btnInsertar);
        btnListar = findViewById(R.id.btnListar);
        btnActualizar = findViewById(R.id.btnActualizar);
        btnEliminar = findViewById(R.id.btnEliminar);

        lvDataAlmacenada = findViewById(R.id.lvDataAlmacenada);
    }
}