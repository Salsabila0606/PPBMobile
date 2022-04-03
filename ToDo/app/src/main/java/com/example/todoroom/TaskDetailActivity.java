package com.example.todoroom;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class TaskDetailActivity extends AppCompatActivity {

    EditText tTitle, tDate, tTime;
    String vTitle, vDate, vTime;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_detail);
        tTitle = findViewById(R.id.titleDetail);
        tDate = findViewById(R.id.dateDetail);
        tTime = findViewById(R.id.timeDetail);

        Intent item = getIntent();
        vTitle = item.getStringExtra("titlename");
        vDate = item.getStringExtra("datename");
        vTime = item.getStringExtra("timename");

        tTitle.setText(vTitle);
        tDate.setText(vDate);
        tTime.setText(vTime);
    }
}
