package com.example.esicc.a20170704click;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class Main3Activity extends AppCompatActivity {

    Button play;
    Button ranking;
    View.OnClickListener onClickListenerplay;
    Intent play_link = new Intent();
    View.OnClickListener onClickListenerranking;
    Intent ranking_link = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        play = (Button)findViewById(R.id.button3);
        ranking = (Button)findViewById(R.id.button4);

        onClickListenerplay = new View.OnClickListener() { //開始遊戲
            @Override
            public void onClick(View v) {
                play_link.setClass(Main3Activity.this,MainActivity.class);
                startActivity(play_link);
            }
        };
        play.setOnClickListener(onClickListenerplay);

        onClickListenerranking = new View.OnClickListener() { //看排行榜
            @Override
            public void onClick(View v) {
                ranking_link.setClass(Main3Activity.this,Main4Activity.class);
                startActivity(ranking_link);
            }
        };
        ranking.setOnClickListener(onClickListenerranking);
    }
}
