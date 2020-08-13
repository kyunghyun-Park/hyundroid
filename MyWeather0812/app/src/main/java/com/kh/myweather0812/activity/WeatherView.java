package com.kh.myweather0812.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.kh.myweather0812.MyWeather.MyWeather;
import com.kh.myweather0812.R;

import java.io.Serializable;
import java.util.ArrayList;

public class WeatherView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_view);
        ArrayList<MyWeather> weatherArrayList = (ArrayList<MyWeather>) getIntent().getSerializableExtra("MyWeather");

        for (int i = 0; i < weatherArrayList.size(); i++) {
            Log.d("WeatherView", "날짜: " + weatherArrayList.get(i).getTime());
            Log.d("WeatherView", "온도: " + weatherArrayList.get(i).getTemp());
            Log.d("WeatherView", "날씨: " + weatherArrayList.get(i).getWeather());
            Log.d("WeatherView", "-----------------------------------");
        }
    }
}