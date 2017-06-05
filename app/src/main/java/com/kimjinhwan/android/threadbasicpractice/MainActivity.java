package com.kimjinhwan.android.threadbasicpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.concurrent.RunnableFuture;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       findViewById(R.id.btnBasic).setOnClickListener(this);
        findViewById(R.id.btnTest).setOnClickListener(this);
        findViewById(R.id.btnRain).setOnClickListener(this);
}

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch(v.getId()){
            case R.id.btnBasic :
                intent = new Intent(getBaseContext(), ThreadBasicActivity.class);
                break;
            case R.id.btnTest :
                intent = new Intent(getBaseContext(), TestActivity.class);
                break;
            case R.id.btnRain :
                intent = new Intent(getBaseContext(), RainActivity.class);
                break;
        }
        startActivity(intent);
    }
}