package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastro extends AppCompatActivity {

    private UsuarioDAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        getSupportActionBar().hide();

        final EditText nome = (EditText) findViewById(R.id.nome_cadastro);
        final EditText senha = (EditText) findViewById(R.id.senha_cadastro);
        final EditText email = (EditText) findViewById(R.id.email_cadastro);
        Button botao_cadastro = (Button) findViewById(R.id.botao_cadastro);
        dao = new UsuarioDAO(this);

        botao_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(nome.getText())){
                    nome.setError("Nome é necessário para cadastrar.");
                }
                else if(TextUtils.isEmpty(email.getText())){
                    email.setError("Email é necessário para cadastrar.");
                }
                else if(TextUtils.isEmpty(senha.getText())){
                    senha.setError("Senha é necessário para cadastrar.");
                }
                else {
                    Usuario a = new Usuario();
                    a.setNome(nome.getText().toString());
                    a.setEmail(email.getText().toString());
                    a.setEmail(senha.getText().toString());
                    long id = dao.inserir(a);
                    Toast.makeText(Cadastro.this, "Usuario " + nome.getText() + "inserido.", Toast.LENGTH_SHORT).show();

                    Intent Login = new Intent(Cadastro.this, com.example.myapplication.Login.class);
                    startActivity(Login);
                }
            }
        });
    }
}