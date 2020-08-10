package com.example.activity0810_3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    static final int USER_FORM_REQ = 1000;
    TextView userinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("회원가입폼 v1.0");

        Button userbtn = (Button) findViewById(R.id.userbtn);
        userinfo = (TextView) findViewById(R.id.userInfo);
        userbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UserForm.class);
                startActivityForResult(intent, USER_FORM_REQ);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == USER_FORM_REQ) {
            if (resultCode == RESULT_OK) {
                String id = data.getStringExtra("ID");
                String pwd = data.getStringExtra("PWD");
                String email = data.getStringExtra("EMAIL");
                String phone = data.getStringExtra("PHONE");
                String hobby = data.getStringExtra("HOBBY");
                String userData = String.format(""
                                + "ID: %s\n" + "PASSWORD: %s\n"
                                + "PHONE: %s\n" + "EMAIL: %s\n" + "HOBBY: %s"
                        , id, pwd, email, phone, hobby);
                userinfo.setText(userData);

            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "회원가입을 취소", Toast.LENGTH_SHORT).show();
            }
        }
    }
}