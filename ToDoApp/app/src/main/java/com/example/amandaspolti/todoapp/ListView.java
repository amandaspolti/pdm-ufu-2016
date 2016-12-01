package com.example.amandaspolti.todoapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListView extends AppCompatActivity {

    private ArrayList<String> data = new ArrayList<String>();
    private ImageButton adcItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_com_tasks);
        android.widget.ListView lv = (android.widget.ListView) findViewById(R.id.listview);
        generateListContent();
        lv.setAdapter(new MyListAdaper(this, R.layout.list_item, data));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListView.this, "List item was clicked at " + position, Toast.LENGTH_SHORT).show();
            }
        });

        adcItem = (ImageButton) findViewById(R.id.criaItem);
        adcItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListView.this, TelaCadastroItem.class);
                startActivity(i);
//                Toast.makeText(ListView.this, "Muda Tela", Toast.LENGTH_LONG).show();

            }
        });


    }

    private void generateListContent() {
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                data.add("Fácil");
            } else {
                if (i == 1) {
                    data.add("Médio");
                } else {
                    data.add("Difícil");
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_preferencias) {
            Intent i = new Intent(ListView.this, TelaConfig.class);
            startActivity(i);
            return true;
        } else if (id == R.id.action_sobre) {
            Intent i = new Intent(ListView.this, TelaSobre.class);
            startActivity(i);
            return true;
        } else if (id == R.id.action_sair) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    private class MyListAdaper extends ArrayAdapter<String> {
        private int layout;
        private List<String> mObjects;

        private MyListAdaper(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
            mObjects = objects;
            layout = resource;

        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder mainViewholder = null;
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout, parent, false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.thumbnail = (ImageView) convertView.findViewById(R.id.list_item_thumbnail);
                viewHolder.title = (TextView) convertView.findViewById(R.id.list_item_text);
                viewHolder.button = (Button) convertView.findViewById(R.id.list_item_btn);
                if (position == 0) {
                    viewHolder.thumbnail.setImageResource(R.drawable.easy);
                } else {
                    if (position == 1) {
                        viewHolder.thumbnail.setImageResource(R.drawable.medium);

                    } else {
                        viewHolder.thumbnail.setImageResource(R.drawable.hard);

                    }
                }

                convertView.setTag(viewHolder);
            }
            mainViewholder = (ViewHolder) convertView.getTag();
            mainViewholder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "Button was clicked for list item " + position, Toast.LENGTH_SHORT).show();
                }
            });
            mainViewholder.title.setText(getItem(position));

            return convertView;
        }
    }

    public class ViewHolder {

        ImageView thumbnail;
        TextView title;
        Button button;
    }
}