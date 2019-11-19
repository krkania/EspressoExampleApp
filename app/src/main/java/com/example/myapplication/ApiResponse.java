package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class ApiResponse {

    @SerializedName("result")
    private String result;

    public ApiResponse(String result){
        this.result=result;
    }

    public String getResult(){
        return result;
    }


}
