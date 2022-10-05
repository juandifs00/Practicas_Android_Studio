package com.example.crud_preguntas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    String CrearTabla = "Create table Preguntas (ID_Pregunta Integer primary key Autoincrement, " +
            "Pregunta text, Respuesta_1 text, Respuesta_2 text, Respuesta_3 text, Respuesta_Correcta text, " +
            "Puntaje integer)";

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CrearTabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("Drop table Preguntas");
        db.execSQL(CrearTabla);
    }
}
