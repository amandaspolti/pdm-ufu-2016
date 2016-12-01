package com.example.amandaspolti.telasminhas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class activity_tela_cadastro extends AppCompatActivity {

    Button volta;
    Button cadastra;
    EditText usua;
    EditText senha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_tela_cadastro);

        usua = (EditText) findViewById(R.id.et_nome);
        senha = (EditText) findViewById(R.id.et_senha);

    }


}
