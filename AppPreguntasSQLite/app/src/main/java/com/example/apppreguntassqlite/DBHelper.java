package com.example.apppreguntassqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    String Tabla = "Create table Preguntas (Id integer primary key autoincrement, pregunta text not null, respuesta1 text not null, respuesta2 text not null, respuesta3 text not null, respuestacorrecta text not null, Puntaje integer not null)";

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL(Tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("Drop Table Preguntas");
    }
}
