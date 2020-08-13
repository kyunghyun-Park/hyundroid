package com.kh.myweather0812.MyWeather;

import java.io.Serializable;

public class MyWeather implements Serializable {
    private String time;
    private String temp;
    private String weather;

    public MyWeather( String time, String temp, String weather) {
        this.time = time;
        this.temp = temp;
        this.weather = weather;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}
