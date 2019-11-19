package com.example.myapplication;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IApiCall {
    @GET("techtalk")
    Call<ApiResponse> getResult(@Query("school") String school);
}
