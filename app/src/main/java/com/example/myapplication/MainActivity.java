package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.view.View;

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
                Intent intent =new Intent(MainActivity.this, UNC.class);
                MainActivity.this.startActivity(intent);
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
