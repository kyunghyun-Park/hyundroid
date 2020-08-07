package com.example.quiz0807;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class QuizStep1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_step1);

        Button oBtn = findViewById(R.id.oBtn);
        Button xBtn = findViewById(R.id.xBtn);
        Button homeBtn = findViewById(R.id.homeBtn);
        final Button nextquizBtn = findViewById(R.id.nextquizBtn);

        nextquizBtn.setEnabled(false);

        oBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "정답입니다.\n다음 퀴즈로 진행합니다.", Toast.LENGTH_SHORT).show();
                nextquizBtn.setEnabled(true);
            }
        });

        xBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "오답입니다.", Toast.LENGTH_SHORT).show();
            }
        });

        nextquizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //퀴즈2 로 이동


            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}