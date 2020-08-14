package com.kh.myweather0812.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kh.myweather0812.MyWeather.MyWeather;
import com.kh.myweather0812.R;

import java.util.ArrayList;

public class WeatherAdapter extends
        RecyclerView.Adapter<WeatherAdapter.ViewHolder>
        implements OnWeatherItemClickListener {

    ArrayList<MyWeather> items = new ArrayList<>();
    OnWeatherItemClickListener listener;

    @NonNull
    @Override
    public WeatherAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.weather_list, parent, false);
        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.ViewHolder holder, int position) {
        MyWeather item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(MyWeather item) {
        items.add(item);
    }

    public MyWeather getItem(int position) {
        return items.get(position);
    }

    public void setOnItemClickListener(OnWeatherItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if (listener != null) {
            listener.onItemClick(holder, view, position);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView timeText, tempText, weatherText;
        ImageView weatherImage;

        public ViewHolder(@NonNull View itemView, final OnWeatherItemClickListener listener) {
            super(itemView);
            timeText = itemView.findViewById(R.id.timeText);
            tempText = itemView.findViewById(R.id.tempText);
            weatherText = itemView.findViewById(R.id.weatherText);
            weatherImage = itemView.findViewById(R.id.weatherImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null) {
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
            });
        }


        public void setItem(MyWeather item) {
            timeText.setText(item.getTime()+"시");
            tempText.setText(item.getTemp());
            weatherText.setText(item.getWeather());
            //날씨마다 아이콘 다르게
            weatherImage.setImageResource(getWeatherImage(item.getWeather()));
        }

        public int getWeatherImage(String wfKor) {
            int image = 0;
            switch (wfKor) {
                case "맑음":
                    image = R.drawable.sun;
                    break;
                case "구름 많음":
                    image = R.drawable.cloudy;
                    break;
                case "흐림":
                    image = R.drawable.dark;
                    break;
                case "눈":
                    image = R.drawable.snow;
                    break;
                case "비":
                    image = R.drawable.rain;
                    break;
                case "구름 조금":
                    image = R.drawable.cloud;
                    break;
            }
            return image;
        }
    }
}
