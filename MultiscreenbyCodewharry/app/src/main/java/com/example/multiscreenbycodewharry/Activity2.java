package com.example.multiscreenbycodewharry;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Activity2 extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.STR_KEY);
        textView = findViewById(R.id.textView);
        textView.setText("Your name is: "+name);



    }
}