package com.example.apppreguntassqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperPutaje extends SQLiteOpenHelper {

    String Nom_Puntajes ="create table Ranking (ID integer primary key autoincrement, nombre_jugador text not null, " +
            "puntaje_jugador integer)";

    public DBHelperPutaje(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Nom_Puntajes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("Drop table Ranking");
        db.execSQL(Nom_Puntajes);
    }
}
