package com.example.mytoggle0806;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvText, airText, lightText;
    Button  onBtn2, offBtn2, onBtn3, offBtn3;
    ImageView tvImage, airImage, lightImage;
    ToggleButton onBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onBtn = findViewById(R.id.onBtn);
        onBtn2 = findViewById(R.id.onBtn2);
        offBtn2 = findViewById(R.id.offbtn2);
        onBtn3 = findViewById(R.id.onBtn3);
        offBtn3 = findViewById(R.id.offbtn3);
        tvImage = findViewById(R.id.tvImage);
        airImage = findViewById(R.id.airImage);
        lightImage = findViewById(R.id.lightImage);
        tvText = findViewById(R.id.tvText);
        airText = findViewById(R.id.airText);
        lightText = findViewById(R.id.lightText);

        onBtn.setOnClickListener(this);
        onBtn2.setOnClickListener(this);
        offBtn2.setOnClickListener(this);
        onBtn3.setOnClickListener(this);
        offBtn3.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        if(onBtn.isChecked()){
            onBtn.setBackgroundResource(R.drawable.poweroff);
            tvImage.setImageResource(R.drawable.tvicon);
            tvText.setBackgroundColor(Color.parseColor("#FFBB00"));
        }else{
            onBtn.setBackgroundResource(R.drawable.poweron);
            tvImage.setImageResource(R.drawable.tv);
            tvText.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        switch (view.getId()) {
            case R.id.onBtn2:
                airImage.setVisibility(View.VISIBLE);
                airText.setBackgroundColor(Color.parseColor("#BCE55C"));
                break;
            case R.id.offbtn2:
                airImage.setVisibility(View.INVISIBLE);
                airText.setBackgroundColor(Color.parseColor("#FFFFFF"));
                break;
            case R.id.onBtn3:
                lightImage.setVisibility(View.VISIBLE);
                lightText.setBackgroundColor(Color.parseColor("#5CD1E5"));
                break;
            case R.id.offbtn3:
                lightImage.setVisibility(View.INVISIBLE);
                lightText.setBackgroundColor(Color.parseColor("#FFFFFF"));
                break;
        }
    }
}