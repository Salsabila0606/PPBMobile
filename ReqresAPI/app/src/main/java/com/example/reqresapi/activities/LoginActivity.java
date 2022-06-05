package com.example.reqresapi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.reqresapi.MainActivity;
import com.example.reqresapi.R;
import com.example.reqresapi.api.RestClient;
import com.example.reqresapi.model.BodyLogin;
import com.example.reqresapi.model.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText edtEmail;
    EditText edtPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.tvUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    BodyLogin bodyLogin = new BodyLogin();
                    bodyLogin.setEmail(edtEmail.getText().toString());
                    bodyLogin.setPassword(edtPassword.getText().toString());

                    RestClient.getService().postLogin(bodyLogin).enqueue(new Callback<LoginResponse>() {
                        // TODO method dibawah otomatis pada saat new Callback
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                            if (response.isSuccessful()){
                                //success
                                Toast.makeText(LoginActivity.this, response.body().getToken(), Toast.LENGTH_SHORT).show();
                                Log.i("Response", response.message());
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                finish();
                            } else {
                                //fail
                                Toast.makeText(LoginActivity.this, "Message: " + response.message() + " | Code :" + response.code(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {

                        }
                    });
                }
            });
    }
}