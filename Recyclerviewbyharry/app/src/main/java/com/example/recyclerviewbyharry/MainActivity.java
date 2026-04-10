package com.example.recyclerviewbyharry;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    String[] arr = {"item 1","item 2","item 3","item 4","item 5","item 6","item 7","item 8","item 9","item 10","item 11","item 12"
            ,"item 13","item 14","item 15","item 1","item 2","item 3","item 4","item 5","item 6","item 7","item 8","item 9","item 10"
            ,"item 11","item 12","item 13","item 14","item 15","item 1","item 2","item 3","item 4","item 5","item 6","item 7","item 8"
            ,"item 9","item 10","item 11","item 12","item 13","item 14","item 15"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CustomAdapter c = new CustomAdapter(arr);
        recyclerView.setAdapter(c);
    }
}