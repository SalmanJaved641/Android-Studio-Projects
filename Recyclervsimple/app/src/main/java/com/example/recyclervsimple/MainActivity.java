package com.example.recyclervsimple;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
//import com.example.recyclerview.R;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ContectModel> arrayContect = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycleContects);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrayContect.add(new ContectModel(R.drawable.a,"Salman","0347 0619641"));
        arrayContect.add(new ContectModel(R.drawable.b,"hamza","0343 0987461"));
        arrayContect.add(new ContectModel(R.drawable.c,"ali","0347 8739461"));
        arrayContect.add(new ContectModel(R.drawable.a,"abdullah","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.e,"M Ali","0347 0092361"));
        arrayContect.add(new ContectModel(R.drawable.f,"fahad","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.d,"APS","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.c,"javed","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.h,"iqbal","0347 0619461"));
        RecyclerContectAdapter adapter = new RecyclerContectAdapter(this,arrayContect);

        recyclerView.setAdapter(adapter);


    }
}