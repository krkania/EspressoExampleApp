package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class State extends AppCompatActivity {
    Button uncBtn, dukeBtn, stateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);

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
                            Log.d("UserController", "inside if in onResponse");
                            EspressoIdlingResource.decrement();
                            return;

                        }
                        Log.d("UserController", "outside if in onResponse");
                        Intent intent =new Intent(State.this, UNC.class);
                        EspressoIdlingResource.decrement();
                        String result = response.body().getResult();
                        if(result.equals("yes")){
                            intent.putExtra("result", "yes");
                        } else if(result.equals("no")){
                            intent.putExtra("result", "no");
                        }
                        State.this.startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<ApiResponse> call, Throwable t) {
                        Log.d("UserController", "inside onFailure");

                    }
                });
//                Intent intent =new Intent(State.this, UNC.class);
//                State.this.startActivity(intent);
            }
        });

        stateBtn=findViewById(R.id.stateBtn);
        stateBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent =new Intent(State.this, State.class);
               State.this.startActivity(intent);
            }
        });
        dukeBtn=findViewById(R.id.dukeBtn);
        dukeBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent =new Intent(State.this, Duke.class);
                State.this.startActivity(intent);
            }
        });
    }
}
