package com.kh.myweather0812;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnv = findViewById(R.id.nav_view);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.tab1:
                        Toast.makeText(MainActivity.this, "홈 메뉴", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.tab2:
                        Toast.makeText(MainActivity.this, "설정 메뉴", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.tab3:
                        Toast.makeText(MainActivity.this, "지도 메뉴", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });
    }
}