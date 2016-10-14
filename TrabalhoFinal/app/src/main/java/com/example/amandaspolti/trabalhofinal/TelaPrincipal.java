package com.example.amandaspolti.trabalhofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.MenuItem;
import android.widget.Toast;

public class TelaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

    }

    ///////////////////////////// BUTOES
    public void irTelaProcuraCarona(View v) {
        Intent intent = new Intent(this, TelaProcuraCarona.class);
        startActivity(intent);
    }

    public void oferecerCarona(View w) {
        Intent intent = new Intent(this, TelaOferecerCarona.class);
        startActivity(intent);
    }

    public void sairApp(View v) {
        super.onDestroy();
    }

    //////////////////////////////////////// MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_sair:
                return true;
            case R.id.menu_preferencias:
                Toast.makeText(this, "SUB MENU DE PREFERENCIAS",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_sobre:
                Toast.makeText(this, "Amanda, Cecilia, Jackson, Vinicius",
                        Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
