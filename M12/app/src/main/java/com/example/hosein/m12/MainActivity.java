package com.example.hosein.m12;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   EditText editTextgetname;
    Button buttonadd;
    ListView lv;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    editTextgetname = (EditText) findViewById(R.id.getname);
        buttonadd= (Button) findViewById(R.id.btnadd);
        lv= (ListView) findViewById(R.id.listphon);
        list= new  ArrayList<String>();
        

    }
}
