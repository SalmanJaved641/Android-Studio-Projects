package com.example.customtoolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

//    @SuppressLint("RestrictedApi")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
if (getSupportActionBar()!=null){/*to reduce null exception error*/
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        toolbar.setTitle("My Toolbar");
        toolbar.setSubtitle("Sub Title");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        new MenuInflater(MainActivity.this).inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Overridess
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();

        if (itemId==R.id.new_folder)
            Toast.makeText(this, "New File Created", Toast.LENGTH_SHORT).show();
        if (itemId==R.id.open)
            Toast.makeText(this, "File Open", Toast.LENGTH_SHORT).show();
        if (itemId==R.id.save)
            Toast.makeText(this, "File Save", Toast.LENGTH_SHORT).show();
        if (itemId==android.R.id.home)
            super.onBackPressed();

        return super.onOptionsItemSelected(item);
    }
}