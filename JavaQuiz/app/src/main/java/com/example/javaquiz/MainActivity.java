package com.example.javaquiz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
TextView questions;
Button yes;
Button no;
String[] questionsArray = {"Java was introduced in 1947?","Is me Salman developer of java language?","Is Java a low level language?",
        "This code is written in java?","Is java a person","Is java introduced by Salman from Pakistan"};
String[] answersArray = {"no","yes","no","yes","no","no"};
int score = 0;
int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questions = findViewById(R.id.questions);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        questions.setText(questionsArray[index]);


        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index<=questionsArray.length-1){
                    if (answersArray[index].equals("yes")){
                        ++score;
                    }
                    index++;
                    if (index<=questionsArray.length-1) {
                        questions.setText(questionsArray[index]);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Your score is: "+score+"/"+questionsArray.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "To try Again Restart the app", Toast.LENGTH_SHORT).show();
                }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index<=questionsArray.length-1){
                    if (answersArray[index].equals("no")){
                        ++score;
                    }
                    index++;
                    if (index<=questionsArray.length-1) {
                        questions.setText(questionsArray[index]);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Your score is: "+score+"/"+questionsArray.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "To try Again Restart the app", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}