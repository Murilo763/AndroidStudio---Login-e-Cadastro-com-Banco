package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class Conexao extends android.database.sqlite.SQLiteOpenHelper {

    private static final String name = "banco.db";
    private static final int version = 1;


    public Conexao(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuario(id integer primary key autoincrement, " +
                "nome varchar(50), email varchar(50), senha varchar(50)) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
