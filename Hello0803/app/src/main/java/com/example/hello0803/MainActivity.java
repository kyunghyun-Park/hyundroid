package com.example.hello0803;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button sendBtn;
    TextView showMsg;
    EditText infoMsg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendBtn = findViewById(R.id.sendBtn);
        showMsg = findViewById(R.id.showMsg);
        infoMsg = findViewById(R.id.infoMsg);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = infoMsg.getText().toString();
                Log.d("MainActivity_onCreate","data: "+data);
                showMsg.setText(data);
            }
        });
    }
}