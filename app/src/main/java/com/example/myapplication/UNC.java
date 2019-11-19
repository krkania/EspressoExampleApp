package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UNC extends AppCompatActivity {
    Button uncBtn, dukeBtn, stateBtn;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unc);

        result = getIntent().getExtras().getString("result");
        TextView uncResult = findViewById(R.id.UNCanswer);
        if(result.equals("yes")){
            uncResult.append("YES!");
        } else {
            uncResult.append("No :'(");
        }
        uncBtn=findViewById(R.id.uncBtn);
        uncBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent =new Intent(UNC.this, UNC.class);
                intent.putExtra("result", result);
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
