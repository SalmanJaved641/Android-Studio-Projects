package com.example.databasesqlite;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DB_Helper dbHelper = new DB_Helper(MainActivity.this);
        ArrayList<Contect_Model> arrayList;

//        Add new Contect:
//               run first time
               /*dbHelper.add_contects("Salman", "0347 0619641");
                dbHelper.add_contects("javed", "0342 4174230");
                dbHelper.add_contects("Iqbal", "0349 4849990");
                dbHelper.add_contects("Haris", "**** *******");*/

//        execute every time when run application and add new contect in contect list
                  dbHelper.add_contects("new contect", "...");

// Update Contects:
                Contect_Model updateM = new Contect_Model();
                updateM.id=4;
                updateM.phone_no="03** *******";
                DB_Helper.updateContent(getApplicationContext(),updateM);
//Delete contects:
            DB_Helper.DeleteContect(getApplicationContext(),5);


// fetch and log :
    arrayList = dbHelper.fetch_contects();
    for (int i = 0; i < arrayList.size(); i++) {
        Log.d("Updated Contacts Info", arrayList.get(i).id + " Name: " + arrayList.get(i).name +
            ", Phone no: " + arrayList.get(i).phone_no);
        }
    }
}