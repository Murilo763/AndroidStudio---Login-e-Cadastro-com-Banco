package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private TextView text_tela_cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();
        IniciarComponentes();

        text_tela_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Cadastro.class);
                startActivity(intent);
            }
        });

        final EditText edit_Email = (EditText) findViewById(R.id.edit_Email);
        final EditText edit_Senha = (EditText) findViewById(R.id.edit_Senha);
        Button botao_entrar = (Button) findViewById(R.id.botao_entrar);

        botao_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = edit_Email.getText().toString();
                String senha = edit_Senha.getText().toString();

                if(TextUtils.isEmpty(edit_Email.getText())){
                    edit_Email.setError("Email é necessário para continuar");
                }
                else if(TextUtils.isEmpty(edit_Senha.getText())){
                    edit_Senha.setError("Senha é necessária para continuar");
                }
                else {
                    Intent Principal = new Intent(Login.this, com.example.myapplication.Principal.class);
                    startActivity(Principal);
                }
            }
        });
    }

    private void IniciarComponentes()
    {
        text_tela_cadastro = findViewById(R.id.text_tela_de_cadastro);
    }
}