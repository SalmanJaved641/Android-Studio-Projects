package com.example.listviewtypes;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;


public class textV extends AppCompatActivity {

    ListView listView;
    int[] arrNo = new int[]{1,2,3,4,5};
    ArrayList<String> ArrayNmaes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_v);
        listView = findViewById(R.id.txtV);

        ArrayNmaes.add("MUHAMMAD");
        ArrayNmaes.add("FAHAD");
        ArrayNmaes.add("SALMAN");
        ArrayNmaes.add("JAVED");
        ArrayNmaes.add("IQBAL");
        ArrayNmaes.add("NAVEED");
        ArrayNmaes.add("AHSAN");
        ArrayNmaes.add("MUHAMMAD");
        ArrayNmaes.add("FAHAD");
        ArrayNmaes.add("SALMAN");
        ArrayNmaes.add("JAVED");
        ArrayNmaes.add("IQBAL");
        ArrayNmaes.add("NAVEED");
        ArrayNmaes.add("AHSAN");
        ArrayNmaes.add("MUHAMMAD");
        ArrayNmaes.add("FAHAD");
        ArrayNmaes.add("SALMAN");
        ArrayNmaes.add("JAVED");
        ArrayNmaes.add("IQBAL");
        ArrayNmaes.add("NAVEED");
        ArrayNmaes.add("AHSAN");
        ArrayNmaes.add("MUHAMMAD");
        ArrayNmaes.add("FAHAD");
        ArrayNmaes.add("SALMAN");
        ArrayNmaes.add("JAVED");
        ArrayNmaes.add("IQBAL");
        ArrayNmaes.add("NAVEED");
        ArrayNmaes.add("AHSAN");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(textV.this, android.R.layout.simple_list_item_1, ArrayNmaes);

        listView.setAdapter(adapter);
    }

    }