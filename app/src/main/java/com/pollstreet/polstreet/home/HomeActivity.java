package com.pollstreet.polstreet.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.pollstreet.polstreet.R;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
        drawer= findViewById(R.id.drawerLayout);


        //Side navigation
        NavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.option_home:
                    drawer.closeDrawer(GravityCompat.START);
                    bottomNavigationView.setSelectedItemId(R.id.home);
                    return true;


            }
            drawer.closeDrawer(GravityCompat.START);
            return true;
        });

    }


    //Bottom Navigation
    HomeFragment homeFragment = new HomeFragment();
    ResearchAndAnalysisFragment researchAndAnalysisFragment = new ResearchAndAnalysisFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, homeFragment).commit();
                return true;

            case R.id.RAndA:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, researchAndAnalysisFragment).commit();
                return true;

            case R.id.menu:
                drawer.open();
                return true;

        }
        return false;
    }
}