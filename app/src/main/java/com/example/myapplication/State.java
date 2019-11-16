package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                Intent intent =new Intent(State.this, UNC.class);
                State.this.startActivity(intent);
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
