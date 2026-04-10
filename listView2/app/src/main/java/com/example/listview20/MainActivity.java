package com.example.listview20;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ListView listView;
    int[] arrNo = new int[]{1,2,3,4,5};
    ArrayList<String> ArrayNmaes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listV);

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

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, ArrayNmaes);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position==0){
                    Toast.makeText(MainActivity.this, "You clicked on first item", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "You don't clicked on first item", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}