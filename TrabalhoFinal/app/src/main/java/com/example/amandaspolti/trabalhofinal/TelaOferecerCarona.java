package com.example.amandaspolti.trabalhofinal;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class TelaOferecerCarona extends AppCompatActivity {
    Spinner origem, destino;
    final String[] cidades = new String[]{"Irai de Minas", "Patrocinio", "Romaria", "Coromandel",
            "Uberlandia", "Monte Carmelo", "Araguari", "Estrela do Sul", "Abadia dos Dourados"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_oferecer_carona);
        origem = (Spinner) findViewById(R.id.origem);
        destino = (Spinner) findViewById(R.id.destino);

        ArrayAdapter<String> ad = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, cidades);

        origem.setAdapter(ad);
        destino.setAdapter(ad);

    }

    public void voltarTelaPrincipal(View v) {
        Intent intent = new Intent(this, TelaPrincipal.class);
        startActivity(intent);
    }

    public void cadastroCarona(View v) {
        Toast.makeText(TelaOferecerCarona.this, "CARONA CADASTRADA", Toast.LENGTH_SHORT).show();
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

}
