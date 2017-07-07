package com.example.esicc.a20170704click;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    int counter_time = 10;
    Button start;
    Button click;
    Timer times=new Timer(true);
    Intent task2 = new Intent();
    String answer,counter_str;
    TextView counter;
    boolean check = false;

    View.OnClickListener onClickListenerstart;
    View.OnClickListener onClickListenerclick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click = (Button)findViewById(R.id.button);
        start = (Button)findViewById(R.id.button2);
        counter = (TextView)findViewById(R.id.textView5);
        times = new Timer();

        counter_str = Integer.toString(counter_time);
        counter.setText(counter_str);
        click.setEnabled(false);

        onClickListenerstart = new View.OnClickListener(){  //開始
            @Override
            public void onClick(View v) {
                count = 0;
                check = true;
                counter_time = 10;
                start.setEnabled(false);
                click.setEnabled(true);

                new CountDownTimer(3000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        counter_time--;
                        counter_str = Integer.toString(counter_time);
                        counter.setText(counter_str);
                    }

                    public void onFinish() {
                        answer = Integer.toString(count);
                        task2.putExtra("count",answer);
                        task2.setClass(MainActivity.this,Main2Activity.class);
                        startActivity(task2);
                    }
                }.start();
            }
        };
        start.setOnClickListener(onClickListenerstart);

        onClickListenerclick = new View.OnClickListener() { //點擊次數
            @Override
            public void onClick(View v) {
                if (check)
                {
                    count++;
                }
            }
        };
        click.setOnClickListener(onClickListenerclick);
    }
}
