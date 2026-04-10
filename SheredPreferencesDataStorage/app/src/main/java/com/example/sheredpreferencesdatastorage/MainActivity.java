package com.example.sheredpreferencesdatastorage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences shPref = getSharedPreferences("login",MODE_PRIVATE);
                Boolean check = shPref.getBoolean("flag",false);//false is default that used first time when it do not have any value.

                Intent iNext;
                if (check) { //for true (user is logged in)
                    iNext = new Intent(MainActivity.this,HomeActivity.class);


                }else { //for false (either first time or user is logged out )
                    iNext = new Intent(MainActivity.this, LoginActivity.class);
                }
                startActivity(iNext);
                finish(); //to pop out this activity from stack
            }
        },2500);
    }
}