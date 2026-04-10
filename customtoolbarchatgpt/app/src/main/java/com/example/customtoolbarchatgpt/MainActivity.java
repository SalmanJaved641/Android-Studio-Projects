package com.example.customtoolbarchatgpt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set the title and subtitle for the toolbar
        getSupportActionBar().setTitle("My Title");
        getSupportActionBar().setSubtitle("My Subtitle");

        // Enable the Up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.new_folder) {
            Toast.makeText(this, "New Folder Created", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.new_file) {
            Toast.makeText(this, "New File Created", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.save_file) {
            Toast.makeText(this, "File Saved", Toast.LENGTH_SHORT).show();
        } else if (itemId == android.R.id.home) {
            super.onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
