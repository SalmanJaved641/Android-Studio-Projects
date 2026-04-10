package com.example.toastcustom_t;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button Toast_btn1,Toast_btn2,Toast_btn3;
    Toast toast3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast_btn1 = findViewById(R.id.toast_btn);
        Toast_btn2 = findViewById(R.id.LongToast_btn);
        Toast_btn3 = findViewById(R.id.custom_toast);


        Toast_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hey! I'm short Toast", Toast.LENGTH_SHORT).show();
            }
        });
        Toast_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hey! I'm long Toast", Toast.LENGTH_LONG).show();
            }
        });



        Toast_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                toast3 = new Toast(MainActivity.this);
                View toastView = getLayoutInflater().inflate(R.layout.custom_toast_layout, (ViewGroup) findViewById(R.id.toast_view_container));
                toast3.setView(toastView);
                TextView txt_msg = toastView.findViewById(R.id.Toast_text);
                txt_msg.setText("massage dpwnload");
                toast3.setDuration(Toast.LENGTH_SHORT);
                toast3.setGravity(Gravity.CENTER,95,300);
                toast3.show();

            }
        });


    }
}