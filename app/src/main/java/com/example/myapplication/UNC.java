package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UNC extends AppCompatActivity {
    Button uncBtn, dukeBtn, stateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unc);
        uncBtn=findViewById(R.id.uncBtn);
        uncBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent =new Intent(UNC.this, UNC.class);
                UNC.this.startActivity(intent);
            }
        });

        stateBtn=findViewById(R.id.stateBtn);
        stateBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent =new Intent(UNC.this, State.class);
                UNC.this.startActivity(intent);
            }
        });
        dukeBtn=findViewById(R.id.dukeBtn);
        dukeBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent =new Intent(UNC.this, Duke.class);
                UNC.this.startActivity(intent);
            }
        });
    }
}
