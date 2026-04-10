package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edtWeight, edtHightFt, edtHieghIn;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout main;


        edtWeight = findViewById(R.id.edtw);
        edtHightFt = findViewById(R.id.edthft);
        edtHieghIn = findViewById(R.id.edthi);
        btnCalculate = findViewById(R.id.btncalculate);
        txtResult = findViewById(R.id.BMIresult);
        main=findViewById(R.id.main);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int wt=Integer.parseInt(edtWeight.getText().toString());
               int ft=Integer.parseInt(edtHightFt.getText().toString());
               int in=Integer.parseInt(edtHieghIn.getText().toString());

               int totalIn= ft*12+in;/*to convert hight from ft.inch into inches*/

               double totalCm = totalIn*2.53;

               double totalM = totalCm/100;

               double bmi_db = wt/(totalM*totalM);
               int bmi = (int) bmi_db;

               if (bmi>25){
                   txtResult.setText("You are Over weight and your BMI is: "+bmi);
                   main.setBackgroundColor(getResources().getColor(R.color.green));
                   }
               else if (bmi<18) {
                   txtResult.setText("You are under weight and your BMI is: "+bmi);
                   main.setBackgroundColor(getResources().getColor(R.color.brown));
               }
               else {
                   txtResult.setText("You are healty and your BMI is: "+bmi);
                   main.setBackgroundColor(getResources().getColor(R.color.blue));
               }
            }});
        }
}