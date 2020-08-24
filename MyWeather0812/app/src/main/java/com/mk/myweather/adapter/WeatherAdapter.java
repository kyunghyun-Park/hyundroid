package com.mk.myweather.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.mk.myweather.model.MyWeather;
import java.util.ArrayList;
import com.mk.myweather.R;

public class WeatherAdapter extends
        RecyclerView.Adapter<WeatherAdapter.ViewHolder>
        implements OnWeatherItemClickListener {
    ArrayList<MyWeather> items = new ArrayList<>();
    OnWeatherItemClickListener listener;

    @NonNull
    @Override
    public WeatherAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =
                LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.weather_list,
                parent, false);
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

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if (listener != null) {
            listener.onItemClick(holder, view, position);
        }
    }

    public void setOnItemClickListener(OnWeatherItemClickListener listener) {
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView date, time, weather;
        ImageView weather_img;

        public ViewHolder(@NonNull View itemView,
                          final OnWeatherItemClickListener listener) {
            super(itemView);
            date = itemView.findViewById(R.id.wh_date);
            time = itemView.findViewById(R.id.wh_time);
            weather = itemView.findViewById(R.id.wh_wather);
            weather_img = itemView.findViewById(R.id.wh_icon);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null) {
                        listener.onItemClick(ViewHolder.this,
                                view, position);
                    }
                }
            });
        }

        public void setItem(MyWeather item) {
            date.setText(item.getDate());
            time.setText(item.getTime() + "시");
            weather.setText(item.getWeather());
            weather_img.setImageResource(
                    getWeatherImage(item.getWeather()));
        }

        public int getWeatherImage(String wfKor) {
            int image = 0;
            switch(wfKor) {
                case "맑음":
                    image = R.drawable.sun;
                    break;
                case "구름 조금":
                    image = R.drawable.cloud;
                    break;
                case "구름 많음":
                    image = R.drawable.cloudy;
                    break;
                case "흐림":
                    image = R.drawable.dark;
                    break;
                case "눈/비":
                    image = R.drawable.snow_rain;
                    break;
                case "눈":
                    image = R.drawable.snow;
                    break;
                case "비":
                    image = R.drawable.rain;
                    break;
            }
            return image;
        }
    }
}
