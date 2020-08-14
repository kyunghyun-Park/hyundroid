package com.kh.myweather0812.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.kh.myweather0812.MyWeather.MyWeather;
import com.kh.myweather0812.R;
import com.kh.myweather0812.adapter.OnWeatherItemClickListener;
import com.kh.myweather0812.adapter.WeatherAdapter;

import java.io.Serializable;
import java.util.ArrayList;

public class WeatherView extends AppCompatActivity {
    WeatherAdapter weatherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_view);
        ArrayList<MyWeather> weatherArrayList = (ArrayList<MyWeather>) getIntent().getSerializableExtra("MyWeather");

        for (int i = 0; i < weatherArrayList.size(); i++) {
            Log.d("WeatherView", "시간: " + weatherArrayList.get(i).getTime());
            Log.d("WeatherView", "온도: " + weatherArrayList.get(i).getTemp());
            Log.d("WeatherView", "날씨: " + weatherArrayList.get(i).getWeather());
            Log.d("WeatherView", "-----------------------------------");
        }
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        weatherAdapter = new WeatherAdapter();

        for (int i = 0; i < weatherArrayList.size(); i++) {
            weatherAdapter.addItem(weatherArrayList.get(i));
        }

        recyclerView.setAdapter(weatherAdapter);
        weatherAdapter.setOnItemClickListener(new OnWeatherItemClickListener() {
            @Override
            public void onItemClick(WeatherAdapter.ViewHolder holder, View view, int position) {
                MyWeather item = weatherAdapter.getItem(position);
                Log.d("WeatherView", "시간: " + item.getTime());
                Log.d("WeatherView", "온도: " + item.getTemp());
                Log.d("WeatherView", "날씨: " + item.getWeather());

            }
        });
    }
}