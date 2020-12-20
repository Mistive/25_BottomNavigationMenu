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
    private fragment1 fragment_1;
    private fragment2 fragment_2;
    private fragment3 fragment_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.action_call:
                        setFragment(0);
                        Log.e("TEST", "1");
                        break;
                    case R.id.action_chat:
                        setFragment(1);
                        Log.e("TEST", "2");
                        break;
                    case R.id.action_contacts:
                        setFragment(2);
                        Log.e("TEST", "3");
                        break;
                }
                return true;
            }
        });

        fragment_1 = new fragment1();
        fragment_2 = new fragment2();
        fragment_3 = new fragment3();
        setFragment(0); //첫 프래그먼트 지정

    }

//    프래그먼트 교체가 발생하는 실행문
    private void setFragment(int n) {
        ft = getSupportFragmentManager().beginTransaction();
        switch(n){
            case 0:
                ft.replace(R.id.frame, new fragment1());
                ft.commit();
                break;

            case 1:
                ft.replace(R.id.frame, new fragment2());
                ft.commit();
                break;

            case 2:
                ft.replace(R.id.frame, new fragment3());
                ft.commit();
                break;
        }
    }
}