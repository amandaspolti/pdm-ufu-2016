package com.example.amandaspolti.trabalhofinal;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class TelaLogin extends AppCompatActivity {
    EditText login;
    EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
    }

    public void irTelaPrincipal(View v) {
        Intent intent = new Intent(this, TelaPrincipal.class);
        startActivity(intent);
    }

    public void sairApp(View v) {
        super.onDestroy();
    }

    public void irTelaCadastro(View v){
        Intent intent = new Intent(this, TelaCadastroUsuario.class);
        startActivity(intent);
    }


}