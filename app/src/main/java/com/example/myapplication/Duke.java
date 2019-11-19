package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import java.io.Console;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Duke extends AppCompatActivity {
    Button uncBtn, dukeBtn, stateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duke);

        uncBtn=findViewById(R.id.uncBtn);
        uncBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EspressoIdlingResource.increment();
                IApiCall apiCall = RetrofitApi.getInstance().getApiService();
                Call<ApiResponse> uncCall = apiCall.getResult("unc");
                uncCall.enqueue(new Callback<ApiResponse>() {
                    @Override
                    public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                        if (!response.isSuccessful()) {
                            //should do something for the error handlign
                            Log.d("onResponseFail", "inside if in onResponse");
                            EspressoIdlingResource.decrement();
                            return;

                        }
                        Intent intent =new Intent(Duke.this, UNC.class);
                        String result = response.body().getResult();
                        if(result.equals("yes")){
                            intent.putExtra("result", "yes");
                        } else if(result.equals("no")){
                            intent.putExtra("result", "no");
                        }
                        Duke.this.startActivity(intent);
                        EspressoIdlingResource.decrement();
                    }

                    @Override
                    public void onFailure(Call<ApiResponse> call, Throwable t) {
                        Log.d("onFailure", "inside onFailure");
                        EspressoIdlingResource.decrement();

                    }
                });
            }
        });

        stateBtn=findViewById(R.id.stateBtn);
        stateBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Duke.this, State.class);
                Duke.this.startActivity(intent);
            }
        });
        dukeBtn=findViewById(R.id.dukeBtn);
        dukeBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Duke.this, Duke.class);
                Duke.this.startActivity(intent);
            }
        });
    }
}
