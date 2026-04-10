package com.example.intentdel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        Intent i = getIntent();
        String name = i.getStringExtra("name");
        String address = i.getStringExtra("address");
        int roll_no = i.getIntExtra("Roll no",0);

        TextView stInfo = findViewById(R.id.stInfo);
        stInfo.setText("Roll no: "+roll_no+" Name: "+name+" Address: "+address);
//      getActionBar().setTitle("name"); /*error*/
//      /*action bar wala topic bad ma karan ga*/
    }
}