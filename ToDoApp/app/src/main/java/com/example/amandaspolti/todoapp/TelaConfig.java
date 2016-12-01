package com.example.amandaspolti.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaConfig extends AppCompatActivity {

    private Button volta;
    private Button salva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_config);

        volta = (Button) findViewById(R.id.volta_conf);
        volta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaConfig.this, ListView.class);
                startActivity(i);
            }
        });


        salva = (Button) findViewById(R.id.salva_conf);
        salva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(TelaConfig.this, ListView.class);
//                startActivity(i);
            }
        });
    }
}
