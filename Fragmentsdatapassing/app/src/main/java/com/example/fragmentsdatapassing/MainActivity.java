package com.example.fragmentsdatapassing;

import android.os.Bundle;
import android.util.Log;
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

        load_fragment(new chats(),0,1);

        btn_chats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                load_fragment(new chats(),1,1);

            }
        });

        btn_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                load_fragment(status.getInstance("SALMAN",11),1,0);

            }
        });

        btn_calls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                load_fragment(new calls(),1,0);

            }
        });

    }

    public void load_fragment(Fragment fragment,int flag,int flag_data){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();

        if (flag_data==1){
//        Send argunments(data)
            Bundle bundle =new Bundle();
            bundle.putString("Arg1","Data passing:(String) SALMAN,(int)");
            bundle.putInt("Arg2",10);

            fragment.setArguments(bundle);
        }

        if (flag==0)
            ft.add(R.id.frag_container,fragment);
        if (flag==1)
            ft.replace(R.id.frag_container,fragment);
        ft.commit();
    }
    public void callFromFragment(){
        Log.d("callFromFragment", "hello the method is called from fragment and the method can contain data");
    }
}