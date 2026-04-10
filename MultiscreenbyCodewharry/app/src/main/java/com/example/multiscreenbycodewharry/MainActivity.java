package com.example.multiscreenbycodewharry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
Button button;
EditText edtName;
public static final String STR_KEY = "key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        edtName =findViewById(R.id.edtName);

    }
    public void newActivity(View view){
        Intent intent = new Intent(this, Activity2.class);
        String name = edtName.getText().toString();
        intent.putExtra(STR_KEY,name);
        startActivity(intent);
    }
}