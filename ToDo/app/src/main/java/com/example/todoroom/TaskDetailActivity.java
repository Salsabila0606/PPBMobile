package com.example.todoroom;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

class TaskDetailActivity extends AppCompatActivity {

    EditText tTitle, tDate, tTime;
    String title, date, time;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_detail);
        tTitle = findViewById(R.id.titleDetail);
        tDate = findViewById(R.id.dateDetail);
        tTime = findViewById(R.id.timeDetail);

        Intent item = getIntent();
        title = item.getStringExtra("titlename");
        date = item.getStringExtra("datename");
        time = item.getStringExtra("timename");

        tTitle.setText(title);
        tDate.setText(date);
        tTime.setText(time);
    }
}
