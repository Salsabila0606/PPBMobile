package com.example.reqresapi.api;

import com.example.reqresapi.model.BodyLogin;
import com.example.reqresapi.model.ListUserResponse;
import com.example.reqresapi.model.LoginResponse;
import com.example.reqresapi.model.SingleUserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MainInterface {

    // TODO Memasukkan Endpoint
    @POST("api/login")
    Call<LoginResponse> postLogin(@Body BodyLogin bodyLogin);

    @GET("api/users?page=2")
    Call<ListUserResponse> getList();

    @GET("api/users/2")
    Call<SingleUserResponse> getSingleUser(int i);
}
