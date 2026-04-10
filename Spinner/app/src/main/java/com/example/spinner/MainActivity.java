package com.example.spinner;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    ArrayList<String>arrids = new ArrayList<>();
    AutoCompleteTextView autoCTV;
    ArrayList<String> arrLanguages=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=findViewById(R.id.spinner);
        autoCTV = findViewById(R.id.autoCTV);

        arrids.add("1");
        arrids.add("2");
        arrids.add("3");
        arrids.add("4");
        arrids.add("5");

        ArrayAdapter<String> adapterIds = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,arrids);
        spinner.setAdapter(adapterIds);


        arrLanguages.add("English");
        arrLanguages.add("Urdu");
        arrLanguages.add("Arabic");
        arrLanguages.add("Latin");
        arrLanguages.add("C#");
        arrLanguages.add("C++");
        arrLanguages.add("C");

        ArrayAdapter<String> adapterLanguages = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrLanguages);
        autoCTV.setAdapter(adapterLanguages);
        autoCTV.setThreshold(1);/*set the value after which search item will show*/



    }
}