package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button hapBtn, bbaBtn, gopBtn, naBtn, btn0, btn1, btn2,
            btn3, btn4, btn5, btn6, btn7, btn8, btn9, backBtn, runBtn;
    EditText num;
    String str = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hapBtn = findViewById(R.id.btnHap);
        bbaBtn = findViewById(R.id.btnBBa);
        gopBtn = findViewById(R.id.btnGop);
        naBtn = findViewById(R.id.btnNa);
        backBtn = findViewById(R.id.btnBack);
        runBtn = findViewById(R.id.btnRun);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        num = findViewById(R.id.num);

        this.setListener();
    }

    public void setListener() {

        View.OnClickListener Listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn0:
                        str = num.getText().toString() + "0";
                        num.setText(str);
                        break;
                    case R.id.btn1:
                        str = num.getText().toString() + "1";
                        num.setText(str);
                        break;
                    case R.id.btn2:
                        str = num.getText().toString() + "2";
                        num.setText(str);
                        break;
                    case R.id.btn3:
                        str = num.getText().toString() + "3";
                        num.setText(str);
                        break;
                    case R.id.btn4:
                        str = num.getText().toString() + "4";
                        num.setText(str);
                        break;
                    case R.id.btn5:
                        str = num.getText().toString() + "5";
                        num.setText(str);
                        break;
                    case R.id.btn6:
                        str = num.getText().toString() + "6";
                        num.setText(str);
                        break;
                    case R.id.btn7:
                        str = num.getText().toString() + "7";
                        num.setText(str);
                        break;
                    case R.id.btn8:
                        str = num.getText().toString() + "8";
                        num.setText(str);
                        break;
                    case R.id.btn9:
                        str = num.getText().toString() + "9";
                        num.setText(str);
                        break;
                    case R.id.btnHap:
                        str = num.getText().toString() + "+";
                        num.setText(str);
                        break;
                    case R.id.btnBBa:
                        str = num.getText().toString() + "-";
                        num.setText(str);
                        break;
                    case R.id.btnGop:
                        str = num.getText().toString() + "*";
                        num.setText(str);
                        break;
                    case R.id.btnNa:
                        str = num.getText().toString() + "/";
                        num.setText(str);
                        break;
                    case R.id.btnBack:
                        str=num.getText().toString();
                        str=str.substring(0,str.length()-1);
                        num.setText(str);
                        break;
                    case R.id.btnRun:
                        break;


                }
            }
        };

        btn0.setOnClickListener(Listener);
        btn1.setOnClickListener(Listener);
        btn2.setOnClickListener(Listener);
        btn3.setOnClickListener(Listener);
        btn4.setOnClickListener(Listener);
        btn5.setOnClickListener(Listener);
        btn6.setOnClickListener(Listener);
        btn7.setOnClickListener(Listener);
        btn8.setOnClickListener(Listener);
        btn9.setOnClickListener(Listener);
        hapBtn.setOnClickListener(Listener);
        bbaBtn.setOnClickListener(Listener);
        gopBtn.setOnClickListener(Listener);
        naBtn.setOnClickListener(Listener);
        backBtn.setOnClickListener(Listener);
        runBtn.setOnClickListener(Listener);
    }
}