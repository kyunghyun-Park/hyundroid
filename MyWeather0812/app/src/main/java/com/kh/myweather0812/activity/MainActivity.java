package com.kh.myweather0812.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kh.myweather0812.R;
import com.kh.myweather0812.fregment.BusanFregment;
import com.kh.myweather0812.fregment.WeatherFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnv;
    WeatherFragment weatherFragment;
    BusanFregment busanFregment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherFragment = new WeatherFragment();
        busanFregment = new BusanFregment();

        bnv = findViewById(R.id.nav_view);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.tab1:
                        Toast.makeText(MainActivity.this, "홈 메뉴", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, weatherFragment).commit();
                        return true;

                    case R.id.tab2:
                        Toast.makeText(MainActivity.this, "설정 메뉴", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, busanFregment).commit();
                        return true;

                    case R.id.tab3:
                        Toast.makeText(MainActivity.this, "날씨 메뉴", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), WeatherActivity.class);
                        startActivity(intent);
                        return true;
                }
                return false;
            }
        });
    }
}