package com.example.apppreguntasfb;

import android.content.Context;
import android.service.autofill.AutofillService;
import android.service.autofill.UserData;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.snapshot.StringNode;

public class DBUsuarios {
    public Context ctx;
    DatabaseReference misUsuarios;

    public DBUsuarios(Context ctx) {this.ctx =ctx;}

    public void CrearUsuario(String Id, String Nombre, String Correo, String Contraseña, Boolean TipoU) {
        misUsuarios = FirebaseDatabase.getInstance().getReference();
        Usuarios U = new Usuarios(Id, Nombre, Correo, Contraseña, TipoU);
        misUsuarios.child("Usuarios").child(Id).setValue(U);
    }
}
