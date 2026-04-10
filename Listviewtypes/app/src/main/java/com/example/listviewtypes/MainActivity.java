package com.example.listviewtypes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnTxt = findViewById(R.id.text_view);
    Button btnSpinner = findViewById(R.id.spinner);
    Button btnAutoComplete = findViewById(R.id.auto_complete);
    Intent text = new Intent(MainActivity.this, textV.class);
    Intent spinner = new Intent(MainActivity.this,spinnerV.class);
    Intent autoComplete = new Intent(MainActivity.this,autoCompleteV.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(text);
            }
        });
        btnSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(spinner);
            }
        });
        btnAutoComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(autoComplete);
            }
        });

    }
}