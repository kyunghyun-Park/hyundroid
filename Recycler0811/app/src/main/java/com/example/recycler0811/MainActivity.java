package com.example.recycler0811;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    PersonAdapter adapter;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerList);
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false );
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PersonAdapter();
        Person person = new Person(R.drawable.batman,"홍길동","010-1234-1234","gkkgk@naver.com",R.drawable.map,"대구광역시");
        Person person2 = new Person(R.drawable.santa,"박경현","010-1234-1234","aaa@naver.com",R.drawable.map,"크리스마스");
        Person person3 = new Person(R.drawable.girl,"홍동국","010-1234-1234","bbb@naver.com",R.drawable.map2,"진주시");

        adapter.addItem(person);
        adapter.addItem(person2);
        adapter.addItem(person3);
        recyclerView.setAdapter(adapter);
    }
}