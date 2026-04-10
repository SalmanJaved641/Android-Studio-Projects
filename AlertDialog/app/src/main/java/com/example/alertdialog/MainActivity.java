package com.example.alertdialog;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
Button txt_btn,txt_btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_btn = findViewById(R.id.txt_btn);
        txt_btn2 = findViewById(R.id.txt_btn2);

        txt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Terms and Conditions");
                alertDialog.setIcon(R.drawable.baseline_info_24);
                alertDialog.setMessage("Are you read all Terms and Conditions");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes I have read", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "You read terms and conditions", Toast.LENGTH_SHORT).show();
                    }
                });
            alertDialog.show();


            }

        });

        txt_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertDialog_Buildrer = new AlertDialog.Builder(MainActivity.this);

                alertDialog_Buildrer.setTitle("Delete");
                alertDialog_Buildrer.setIcon(R.drawable.baseline_delete_24);
                alertDialog_Buildrer.setMessage("Are you sure to delete the file: ");

                alertDialog_Buildrer.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "File deleted", Toast.LENGTH_SHORT).show();
                    }
                });

                alertDialog_Buildrer.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "File not Deleted", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog_Buildrer.show();
            }
        });

    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {

        AlertDialog.Builder exitDialog = new AlertDialog.Builder(MainActivity.this);
        exitDialog.setIcon(R.drawable.baseline_exit_to_app_24);
        exitDialog.setTitle("On Super back Pressed");
        exitDialog.setMessage("Are you sure to exit");
        exitDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.super.onBackPressed();

            }
        });

        exitDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Welcome Back", Toast.LENGTH_SHORT).show();

            }
        });

        exitDialog.setNeutralButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Operation Cancle", Toast.LENGTH_SHORT).show();
            }
        });

        exitDialog.show();
    }
}