package com.example.roomlidrarydatabase;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
EditText edtTitle,edtAmount;
Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTitle=findViewById(R.id.editTitle);
        edtAmount=findViewById(R.id.editAmount);
        btnAdd=findViewById(R.id.btnAdd);


        DatabaseHelper databaseHelper =DatabaseHelper.getdb(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title=edtTitle.getText().toString();
                String amount=edtAmount.getText().toString();

                if (title.equals("")||amount.equals("")) {
                    Toast.makeText(MainActivity.this, "Please enter both Title and amount", Toast.LENGTH_SHORT).show();
                    return;
                }

//                add new data
                databaseHelper.expenseDao().addTx(new Expense(title,amount));

//                to fetch all data
                ArrayList<Expense> arrExpences = (ArrayList<Expense>) databaseHelper.expenseDao().getAllExpense();
//                to log data
                for (int i = 0; i < arrExpences.size(); i++) {
                    Log.d("Data", "Title: "+arrExpences.get(i).getTitle() + ", Amount:" + arrExpences.get(i).getAmount());
                }
            }
        });


    }
}