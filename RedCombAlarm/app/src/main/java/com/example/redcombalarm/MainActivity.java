package com.example.redcombalarm;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView nav = findViewById(R.id.bottom_navigation);
        nav.setOnItemSelectedListener(item -> {
            Fragment selected = new com.example.redcombalarm.AlarmFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_fragment, selected)
                    .commit();
            return true;
        });
        // default
        nav.setSelectedItemId(R.id.nav_alarm);
    }
}
