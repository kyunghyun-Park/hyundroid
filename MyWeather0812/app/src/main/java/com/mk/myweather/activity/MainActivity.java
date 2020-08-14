package com.mk.myweather.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mk.myweather.R;
import com.mk.myweather.fragment.WeatherFragment;
import com.mk.myweather.fragment.WeatherFragment2;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnView;
    Fragment weatherFragment;
    Fragment weatherFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("PMK 날씨정보 v1.0");

        weatherFragment = new WeatherFragment();
        weatherFragment2 = new WeatherFragment2();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, weatherFragment)
                .commit();

        bnView = findViewById(R.id.bottom_navigation);
        bnView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.tab1:
                        Toast.makeText(MainActivity.this,
                                "홈 메뉴", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, weatherFragment)
                                .commit();
                        return true;
                    case R.id.tab2:
                        Toast.makeText(MainActivity.this,
                                "설정 메뉴", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, weatherFragment2)
                                .commit();
                        return true;
                    case R.id.tab3:
                        Toast.makeText(MainActivity.this,
                                "날씨 메뉴", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),
                                WeatherActivity.class);
                        startActivity(intent);
                        return true;
                }
                return false;
            }
        });
    }
}