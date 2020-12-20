package com.mistive.bottomnavi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentTransaction ft;
    private fragment1 fg1 = new fragment1();
    private fragment2 fg2 = new fragment2();
    private fragment3 fg3 = new fragment3();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                ft = getSupportFragmentManager().beginTransaction();
                switch(menuItem.getItemId()){
                    case R.id.action_call:
                        ft.replace(R.id.frame, fg1).commit();
                        return true;
                    case R.id.action_chat:
                        ft.replace(R.id.frame, fg2).commit();
                        return true;
                    case R.id.action_contacts:
                        ft.replace(R.id.frame, fg3).commit();
                        return true;
                }
                return true;
            }
        });
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame, fg1).commit();
    }


}