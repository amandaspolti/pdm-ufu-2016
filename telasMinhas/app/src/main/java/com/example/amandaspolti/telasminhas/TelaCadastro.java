package com.example.amandaspolti.telasminhas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class TelaCadastro extends AppCompatActivity {

    Button volta;
    Button cadastra;
    EditText usua;
    EditText senha;
    CheckBox termos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        usua = (EditText) findViewById(R.id.et_nome);
        senha = (EditText) findViewById(R.id.et_senha);
        termos = (CheckBox) findViewById(R.id.ckb_termos);
    }
}
