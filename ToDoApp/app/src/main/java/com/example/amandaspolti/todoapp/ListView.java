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

        ItemDAO itemdao = ItemDAO.getInstance(ListView.this);
        lv.setAdapter(new MyListAdaper(this, R.layout.list_item, itemdao.getAll()));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListView.this, "List item was clicked at " + position,
                        Toast.LENGTH_SHORT).show();
                //TODO edittar item
            }
        });

        adcItem = (ImageButton) findViewById(R.id.criaItem);
        adcItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListView.this, TelaCadastroItem.class);
                startActivity(i);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

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
        private Item item;

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
                convertView.setTag(viewHolder);
            }

            final String[] mDadosItem = getItem(position).split("\\|\\|");

            item = new Item(mDadosItem[0], mDadosItem[1], mDadosItem[2], mDadosItem[3],
                    mDadosItem[4]);
            final ItemDAO itemdao = ItemDAO.getInstance(ListView.this);

            mainViewholder = (ViewHolder) convertView.getTag();

            if (item.getNivel() == 1) {
                mainViewholder.thumbnail.setImageResource(R.drawable.easy);
            } else if (item.getNivel() == 2) {
                mainViewholder.thumbnail.setImageResource(R.drawable.medium);
            } else {
                mainViewholder.thumbnail.setImageResource(R.drawable.hard);
            }

            if (item.isDone()) { //TODO fazer funcionar
                mainViewholder.button.setText("Apagar?");
                mainViewholder.button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        itemdao.delete(item);
                    }
                });
                remove(getItem(position));
            } else {
                mainViewholder.button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        item.setDone(1);
                        itemdao.update(item);
                    }
                });
                if (item.isDone())
                    mainViewholder.button.setText("Apagar?");
            }

            mainViewholder.title.setText(item.getText());

            return convertView;
        }
    }

    public class ViewHolder {
        ImageView thumbnail;
        TextView title;
        Button button;
    }
}