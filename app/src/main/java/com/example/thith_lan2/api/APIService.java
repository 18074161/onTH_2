package com.example.thith_lan2.api;

import com.example.thith_lan2.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIService {
    // https://60aafdfc66f1d0001777356d.mockapi.io/api/users/user2
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    APIService apiService = new Retrofit.Builder()
            .baseUrl("https://60aafdfc66f1d0001777356d.mockapi.io/api/users/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService.class);

    @GET("user2")
    Call<List<User>> findAll();

    @POST("user2")
    Call<User> addUser(@Body User user);

    @DELETE("user2/{id}")
    Call<User> deleteUser(@Path("id") String id);

    @PUT("user2/{id}")
    Call<User> updateUser(@Path("id") String id,
                          @Body User user);

}
