package com.example.reqresapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.reqresapi.activities.ListUserActivity;

public class MainActivity extends AppCompatActivity {

    Button btnListUser, btnSingleUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnListUser = findViewById(R.id.btnListUser);
        btnSingleUser = findViewById(R.id.btnSingleUser);

        View.OnClickListener onButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                switch(view.getId()){
                    case R.id.btnListUser:
                        intent = new Intent(MainActivity.this, ListUserActivity.class);
                        break;
//                    case R.id.btnSingleUser:
//                        intent = new Intent(MainActivity.this, SingleUserActivity.class);
//                        break;
                }
                startActivity(intent);
            }
        };
        btnListUser.setOnClickListener(onButtonClickListener);
        btnSingleUser.setOnClickListener(onButtonClickListener);
    }
}