package com.example.myapplication;

import com.google.gson.GsonBuilder;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {
    private static RetrofitApi instance;
    public static final String BASE_URL = "https://sanity-scale-api.herokuapp.com/";

    private IApiCall apiService;
    public static RetrofitApi getInstance() {
        if (instance == null) {
            instance = new RetrofitApi();
        }

        return instance;
    }

    private RetrofitApi() {
        buildRetrofit(BASE_URL);
    }

    private void buildRetrofit(String url) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(
                        new GsonBuilder().setPrettyPrinting().create()))
                .build();

        apiService=retrofit.create(IApiCall.class);
    }

    public IApiCall getApiService() {
        return apiService;
    }

}
