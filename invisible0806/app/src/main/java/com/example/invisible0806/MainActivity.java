package com.example.invisible0806;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox startCb;
    TextView textview1;
    RadioGroup rGroup;
    Button doneBtn;
    ImageView imageview1;
    RadioButton crb, jsprb, jsrb, javarb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startCb = findViewById(R.id.startCb);
        textview1 = findViewById(R.id.textview1);
        rGroup = findViewById(R.id.rGroup);
        doneBtn = findViewById(R.id.doneBtn);
        imageview1 = findViewById(R.id.imageview1);
        crb = findViewById(R.id.cRb);
        jsprb = findViewById(R.id.jspRb);
        jsrb = findViewById(R.id.jsRb);
        javarb = findViewById(R.id.javaRb);

        startCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (startCb.isChecked()) {
                    textview1.setVisibility(View.VISIBLE);
                    rGroup.setVisibility(View.VISIBLE);
                    doneBtn.setVisibility(View.VISIBLE);
                    imageview1.setVisibility(View.VISIBLE);
                } else {
                    textview1.setVisibility(View.INVISIBLE);
                    rGroup.setVisibility(View.INVISIBLE);
                    doneBtn.setVisibility(View.INVISIBLE);
                    imageview1.setVisibility(View.INVISIBLE);
                }
            }
        });
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rGroup.getCheckedRadioButtonId()) {
                    case R.id.cRb:
                        imageview1.setImageResource(R.drawable.c);
                        break;
                    case R.id.jspRb:
                        imageview1.setImageResource(R.drawable.jsp);
                        break;
                    case R.id.javaRb:
                        imageview1.setImageResource(R.drawable.java);
                        break;
                    case R.id.jsRb:
                        imageview1.setImageResource(R.drawable.javascript);
                        break;
                }
            }
        });
    }
}