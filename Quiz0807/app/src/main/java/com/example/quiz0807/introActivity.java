package com.example.quiz0807;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class introActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
       // startLoading();
    }

//    private void startLoading() {
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                finish();
//            }
//        }, 2000);
//    }

    @Override
    public void onBackPressed() {
        //플래시 화면에서 뒤로가기 버튼 못누르게 함
        //super.onBackPressed();
    }
}