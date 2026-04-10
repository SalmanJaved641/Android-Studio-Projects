package com.example.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
Button btn_chats, btn_status, btn_calls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_chats = findViewById(R.id.btn_chats);
        btn_status = findViewById(R.id.btn_status);
        btn_calls = findViewById(R.id.btn_calls);

//        add by default fragment

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frag_container,new chats());
        fragmentTransaction.commit();

        btn_chats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) 
            {
                replace_fragment(new chats());

            }
        });

        btn_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                replace_fragment(new status());

            }
        });

        btn_calls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                replace_fragment(new calls());

            }
        });

    }

    public void replace_fragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frag_container,fragment);
        fragmentTransaction.commit();
    }
}