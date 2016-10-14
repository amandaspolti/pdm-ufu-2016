package com.example.amandaspolti.trabalhofinal;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class TelaProcuraCarona extends AppCompatActivity  {
    EditText data;
    EditText proc_dest, proc_date;
    EditText proc_orig;
    Button btn_proc;
    String date;

    Button btc_volta;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_procura_carona);
//        proc_date = (EditText) findViewById(R.id.proc_date);
//
//        proc_date.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                date = showDatePickerDialog(v);
//                System.out.println(showDatePickerDialog(v));
////                proc_date.setText(date);
//            }
//        });

    }

    public void voltarTelaPrincipal(View v) {
        Intent intent = new Intent(this, TelaPrincipal.class);
        startActivity(intent);

    }

    public void procurarCaronas(View v) {
        Intent intent = new Intent(this, TelaCaronasDisponiveis.class);
        startActivity(intent);
    }

    public /*String*/ void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
//        DatePickerFragment dt  = (DatePickerFragment) newFragment;
//        return dt.dataUser;

    }
}
