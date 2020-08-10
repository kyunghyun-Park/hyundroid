package com.example.activity0810_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class UserForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_form);

        final EditText id = (EditText) findViewById(R.id.idEdit);
        final EditText pwd = (EditText) findViewById(R.id.pwdEdit);
        final EditText email = (EditText) findViewById(R.id.emailEdit);
        final EditText phone = (EditText) findViewById(R.id.phoneEdit);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Button okBtn = (Button) findViewById(R.id.okBtn);
        Button cancleBtn = (Button) findViewById(R.id.cancelBtn);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("게임");
        arrayList.add("잠자기");
        arrayList.add("술마시기");
        arrayList.add("수영");
        arrayList.add("등산");

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<>(getApplication(),
                        android.R.layout.simple_spinner_dropdown_item, arrayList);
        spinner.setAdapter(arrayAdapter);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("ID", id.getText().toString());
                intent.putExtra("PWD", pwd.getText().toString());
                intent.putExtra("EMAIL", email.getText().toString());
                intent.putExtra("PHONE", phone.getText().toString());
                intent.putExtra("HOBBY", spinner.getSelectedItem().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        cancleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
            }
        });
    }
}