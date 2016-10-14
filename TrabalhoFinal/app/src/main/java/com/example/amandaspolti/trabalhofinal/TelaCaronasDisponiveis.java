package com.example.amandaspolti.trabalhofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TelaCaronasDisponiveis extends AppCompatActivity {
    ListView lst;

    final String OPS[] = new String[]{"Origem / Destino / Data / Preco",
            "Origem / Destino / Data / Preco",
            "Origem / Destino / Data / Preco"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_caronas_disponiveis);

        lst = (ListView) findViewById(R.id.listView);

        lst.setAdapter(new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item, OPS));

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    confirmarCarona(TelaDetalhesCarona.class, position);
                }

            }
        });

    }

    public void voltarTelaProcura(View v) {
        Intent intent = new Intent(this, TelaProcuraCarona.class);
        startActivity(intent);
    }

    public void confirmarCarona(Class tela, int id) {
        Intent intent = new Intent(this, tela);
        startActivity(intent);
    }


}
