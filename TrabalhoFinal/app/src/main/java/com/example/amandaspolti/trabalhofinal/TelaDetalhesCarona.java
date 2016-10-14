package com.example.amandaspolti.trabalhofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class TelaDetalhesCarona extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_detalhes_carona);
    }

    public void confirmarCarona(View v){
        Toast.makeText(this, "Motorista notificado!!", Toast.LENGTH_SHORT).show();
    }

    public void procurarCaronas(View v){
        Intent intent = new Intent(this, TelaCaronasDisponiveis.class);
        startActivity(intent);
    }
}
