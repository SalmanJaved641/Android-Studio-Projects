package com.example.navigationdrawer;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    drawerLayout = findViewById(R.id.drawerLayout);
    navigationView = findViewById(R.id.NavigationView);
    toolbar = findViewById(R.id.toolbar);

//    set toolbar
    setSupportActionBar(toolbar);

//  toggling between on and off if we use back button or touch screen
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this,drawerLayout,toolbar,R.string.OpenDrawer,R.string.CloseDrawer);

    drawerLayout.addDrawerListener(toggle);
//    to sync state of toggle at run time
    toggle.syncState();

    loadFragmant(new home(),0);

    navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();

            if (id==R.id.home){
                loadFragmant(new home(),1);
            } else if (id==R.id.setting) {
                loadFragmant(new setting(),1);
            } else if (id==R.id.bundles) {
                loadFragmant(new Bundles(),1);
            }else /*log out*/{
                loadFragmant(new logout(),1);
            }
//            Auto clos drawer when user click any option
            drawerLayout.closeDrawer(GravityCompat.START);

            return true;
        }
    });

    }
    public void loadFragmant(Fragment fragment,int flag) {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (flag==0)
            ft.add(R.id.Container,fragment);
        if (flag==1)
            ft.replace(R.id.Container,fragment);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }
}