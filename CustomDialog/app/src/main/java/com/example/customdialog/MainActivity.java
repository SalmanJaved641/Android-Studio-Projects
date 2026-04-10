package com.example.customdialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Dialog  dialog = new Dialog(MainActivity.this);
        Button btn_1;
        btn_1 = findViewById(R.id.dialog_1);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.setContentView(R.layout.dialog_layout);
                dialog.setCancelable(false);

                Button btn_ok;
                btn_ok = dialog.findViewById(R.id.btn_ok);
                btn_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();

                    }
                });
                dialog.show();
            }
        });
    }
}