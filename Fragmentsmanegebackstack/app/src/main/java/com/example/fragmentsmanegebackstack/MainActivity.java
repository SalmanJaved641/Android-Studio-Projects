package com.example.fragmentsmanegebackstack;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private static final String ROOT_FRAGMENT_TAG = null;
    Button btn_chats, btn_status, btn_calls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_chats = findViewById(R.id.btn_chats);
        btn_status = findViewById(R.id.btn_status);
        btn_calls = findViewById(R.id.btn_calls);

//        add by default fragment
        load_fragment(new chats(),0);

        btn_chats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                load_fragment(new chats(),0);

            }
        });

        btn_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                load_fragment(new status(),1);

            }
        });

        btn_calls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                load_fragment(new calls(),1);

            }
        });
    }
    public void load_fragment(Fragment fragment,int flag) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();

        if (flag==0){
            ft.add(R.id.frag_container, fragment);
            fragmentManager.popBackStack(ROOT_FRAGMENT_TAG,FragmentManager.POP_BACK_STACK_INCLUSIVE);
            ft.addToBackStack(ROOT_FRAGMENT_TAG);
        }
        else {
            ft.replace(R.id.frag_container, fragment);
            ft.addToBackStack(null);
        }
        ft.commit();
    }
}