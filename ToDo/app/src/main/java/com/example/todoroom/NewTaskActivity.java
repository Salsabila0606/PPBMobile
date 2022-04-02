package com.example.todoroom;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewTaskActivity extends AppCompatActivity {

    private EditText ntitle;
    private EditText ndate;
    private EditText ntime;
    Button btn;

    @SuppressLint("WrongViewCast")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_task);
        ntitle = findViewById(R.id.title);
        ndate = findViewById(R.id.date);
        ntime = findViewById(R.id.time);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if(TextUtils.isEmpty(ntitle.getText())){
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String title = ntitle.getText().toString();
                String date = ndate.getText().toString();
                String time = ntime.getText().toString();
                replyIntent.putExtra("title", title);
                replyIntent.putExtra("date", date);
                replyIntent.putExtra("time", time);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}
