package com.kimjinhwan.android.threadbasicpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    int count = 0;
    String caller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        findViewById(R.id.btn10).setOnClickListener(this);
        findViewById(R.id.btnThread).setOnClickListener(this);
    }

    public void get100(String caller){
        for(int i =0; i < 100; i++){
            Log.i("Thread Test", caller + "Current Number======"+i);
            try {
                LogCount.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    //버튼을 누르면 번갈아가면서 새로운 스레드를 생성함.
    @Override
    public void onClick(View v) {
        LogCount count = new LogCount();
        switch(v.getId()){
            case R.id.btn10:
                caller = "Main Thread";
                count.start();
                break;
            case R.id.btnThread:
                caller = "Sub Thread";
                count.start();
                break;
        }
    }

    class LogCount extends Thread {
        @Override
        public void run() {
            count++;
            get100(caller + count);
        }
    }
}