package com.example.hosein.m12;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String s, f, t1;
    EditText editTextgetname, editTextgetfamil, editTextgettel;
    Button buttonadd;
    ListView lv;
    ArrayList<Student> list1;
    Student student;
    myadbter myadbter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        student = new Student(s, f, t1);
        setContentView(R.layout.activity_main);
        editTextgetname = (EditText) findViewById(R.id.getname);
        editTextgetfamil = (EditText) findViewById(R.id.getfamil);
        editTextgettel = (EditText) findViewById(R.id.gettel);
        buttonadd = (Button) findViewById(R.id.btnadd);
        lv = (ListView) findViewById(R.id.listphon);
        list1 = new ArrayList<>();
    myadbter1= new myadbter(list1);
        buttonadd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                s = editTextgetname.getText().toString();
                f = editTextgetfamil.getText().toString();
                t1 = editTextgettel.getText().toString();
                list1.add(new Student(s, f, t1));


                myadbter1.notifyDataSetChanged();

            }
        });

        lv.setAdapter(myadbter1);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this,list1.get(position).name,Toast.LENGTH_SHORT).show();

                
            }
        });


        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {


                return true;
            }
        });


    }

    public class myadbter extends BaseAdapter {
        ArrayList<Student> lista;



        public myadbter(ArrayList<Student> listb) {

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
            TextView textView1 = (TextView) v.findViewById(R.id.textlist);
            TextView textView2 = (TextView) v.findViewById(R.id.textlist1);
            TextView textView3 = (TextView) v.findViewById(R.id.textlist2);

textView1.setText(lista.get(position).name);
            textView2.setText(lista.get(position).family);
            textView3.setText(lista.get(position).telnumber);


            return v;
        }



    }


}
