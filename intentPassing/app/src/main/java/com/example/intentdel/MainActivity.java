package com.example.intentdel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1;
        b1=findViewById(R.id.b1);
        Intent i;
        i = new Intent(MainActivity.this,SecondActivity.class);
        i.putExtra("name","Salman");
        i.putExtra("address","chak no 641");
        i.putExtra("Roll no",12);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i);
            }
        });





    }
}