package com.example.amandaspolti.telasminhas;

import android.content.Context;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListView extends AppCompatActivity {


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
                Toast.makeText(ListView.this, "List item was clicked at " + position, Toast.LENGTH_SHORT).show();
                //TODO editar item
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
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
                convertView.setTag(viewHolder);
            }

            final String[] mDadosItem = getItem(position).split("\\|\\|");


            mainViewholder = (ViewHolder) convertView.getTag();

            String nivel = mDadosItem[2];
            if (nivel.equals("1")) {
                mainViewholder.thumbnail.setImageResource(R.drawable.facil);
            } else if (nivel.equals("2")) {
                mainViewholder.thumbnail.setImageResource(R.drawable.media);
            } else {
                mainViewholder.thumbnail.setImageResource(R.drawable.hard);
            }

            if(mDadosItem[mDadosItem.length-1].equals("1")){
                mainViewholder.button.setText("Apagar?");

            }

            mainViewholder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "Button was clicked for list item " + mDadosItem[0],
                            Toast.LENGTH_SHORT).show();
                    //TODO funcao de update no banco
                }
            });

            mainViewholder.title.setText(mDadosItem[1]);

            return convertView;
        }
    }

    public class ViewHolder {

        ImageView thumbnail;
        TextView title;
        Button button;
    }
}