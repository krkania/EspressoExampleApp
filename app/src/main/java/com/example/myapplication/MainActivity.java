package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.view.View;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button uncBtn, dukeBtn, stateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        uncBtn=findViewById(R.id.uncBtn);
        uncBtn.setOnClickListener(new OnClickListener() {

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
                        Intent intent =new Intent(MainActivity.this, UNC.class);
                        String result = response.body().getResult();
                        if(result.equals("yes")){
                            intent.putExtra("result", "yes");
                        } else if(result.equals("no")){
                            intent.putExtra("result", "no");
                        }
                        MainActivity.this.startActivity(intent);
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
        stateBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, State.class);
                MainActivity.this.startActivity(intent);
            }
        });
        dukeBtn=findViewById(R.id.dukeBtn);
        dukeBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, Duke.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}
