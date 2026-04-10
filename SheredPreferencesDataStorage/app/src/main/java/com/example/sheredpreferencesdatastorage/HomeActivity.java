package com.example.sheredpreferencesdatastorage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
Button btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnLogout = findViewById(R.id.logout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences shPref = getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor editor = shPref.edit();

                editor.putBoolean("flag",false); //editor is used to insert value in sharedPreference
                editor.apply();

                Intent iNext = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(iNext);
                finish(); //to pop out this activity from stack
            }
        });



    }
}