package com.example.hosein.m12;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String s;
    EditText editTextgetname;
    Button buttonadd;
    ListView lv;
    ArrayList<String> list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextgetname = (EditText) findViewById(R.id.getname);
        buttonadd = (Button) findViewById(R.id.btnadd);
        lv = (ListView) findViewById(R.id.listphon);
        list1 = new ArrayList<>();
        final myadbter myadbter1 = new myadbter(list1);
        buttonadd.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {
                s = editTextgetname.getText().toString();

               list1.add(s);


               myadbter1.notifyDataSetChanged();

           }
       });

        lv.setAdapter(myadbter1);

    }

    public class myadbter extends BaseAdapter {
        ArrayList<String> lista;

        public myadbter(ArrayList<String> listb) {

            lista = listb;


        }

        @Override
        public int getCount() {
            return lista.size();
        }

        @Override
        public Object getItem(int position) {
            return lista.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = getLayoutInflater();
            View v = inflater.inflate(R.layout.listraw, parent, false);
            TextView textView111 = (TextView) v.findViewById(R.id.textlist);
            textView111.setText(lista.get(position));
            return v;
        }
    }
}
