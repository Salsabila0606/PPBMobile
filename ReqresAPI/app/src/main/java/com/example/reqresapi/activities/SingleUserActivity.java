package com.example.reqresapi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reqresapi.R;
import com.example.reqresapi.api.RestClient;
import com.example.reqresapi.model.Data;
import com.example.reqresapi.model.DataItem;
import com.example.reqresapi.model.SingleUserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingleUserActivity extends AppCompatActivity {

    private Data item;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_user);

        textViewResult = findViewById(R.id.textViewResultID2);
        getSingleUser(2);
    }

    private void getSingleUser(int userID){
        RestClient.getService().getSingleUser(2).enqueue((new Callback<SingleUserResponse>() {
            @Override
            public void onResponse(Call<SingleUserResponse> call, Response<SingleUserResponse> response) {
                if(response.isSuccessful()){
                    item = response.body().getData();
                    String content = "";
                    content += "ID: " + item.getId() + "\n";
                    content += "Email: " + item.getEmail() + "\n";
                    content += "First Name: " + item.getFirstName() + "\n";
                    content += "Last Name: " + item.getLastName() + "\n";
                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<SingleUserResponse> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        }));
    }
}