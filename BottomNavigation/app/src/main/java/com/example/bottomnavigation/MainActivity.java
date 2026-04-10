package com.example.bottomnavigation;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
BottomNavigationView BN_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BN_view = findViewById(R.id.BN_view);

        BN_view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id =item.getItemId();
                        if (id==R.id.Home){
                            load_fragment(new home(),true);
                        } else if (id==R.id.search) {
                            load_fragment(new search(),false);
                        } else if (id==R.id.setting) {
                            load_fragment(new setting(),false);
                        } else if (id==R.id.contectus) {
                            load_fragment(new contact(),false);
                        } else if (id==R.id.profile) {
                            load_fragment(new profile(),false);
                        }else {
                            //nothing
                        }

                return true;// change it to true to show effect on item when item selected
            }
        });

        BN_view.setSelectedItemId(R.id.Home);//when app start automaticaly home fragment selected
    }

public void load_fragment(Fragment fragment,Boolean flag){
    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    if (flag) {
        ft.add(R.id.frameLayout, fragment);
    }
    else {
        ft.replace(R.id.frameLayout,fragment);
    }
    ft.commit();
}

}