package com.example.amandaspolti.trabalhofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class TelaCadastroUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_usuario);
    }

    public void cadastrarUsuario(View v){
        Toast.makeText(this, "CADASTRADO COM SUCESSO", Toast.LENGTH_SHORT).show();
        voltarTelaLogin(v);
    }

    public void voltarTelaLogin(View v){
        Intent intent = new Intent(this, TelaLogin.class);
        startActivity(intent);
    }
}
