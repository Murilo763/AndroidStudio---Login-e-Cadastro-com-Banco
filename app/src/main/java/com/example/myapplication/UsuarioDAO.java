package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UsuarioDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public UsuarioDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Usuario usuario){
        ContentValues values =  new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("email", usuario.getEmail());
        values.put("senha", usuario.getSenha());
        return banco.insert("usuario", null, values);
    }

    public boolean select(String email, String senha)
    {

        Usuario usuario = null;

        Cursor cursor = null;

        String sql = "SELECT * FROM usuario WHERE email == ? AND senha == ?;";

        cursor = banco.rawQuery(sql, new String[]{email,senha});

        if(cursor.moveToFirst())
        {
            return true;
        }else{
            return false;
        }
    }
}
