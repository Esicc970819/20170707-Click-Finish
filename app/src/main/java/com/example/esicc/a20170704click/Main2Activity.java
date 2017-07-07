package com.example.esicc.a20170704click;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class Main2Activity extends AppCompatActivity {

    Intent task2;
    String count;
    TextView ans;
    TextView x1;
    TextView x2;
    Button back;
    Button updata;
    Intent beck_link = new Intent();

    String input_name;
    Intent name = new Intent();

    String[ ] array_name = new String[6];
    String[ ] array_score = new String[6];
    String reg_name,reg_score;
    View.OnClickListener onClickListenerback;
    View.OnClickListener onClickListenerupdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        x1 = (TextView) findViewById(R.id.textView2);
        x2 = (TextView) findViewById(R.id.textView4);
        back = (Button) findViewById(R.id.button5);
        updata = (Button) findViewById(R.id.button6);
        ans = (TextView) findViewById(R.id.textView3);
        task2 = getIntent();
        count = task2.getStringExtra("count");
        ans.setText(count);

        onClickListenerback = new View.OnClickListener() { //返回首頁
            @Override
            public void onClick(View v) {
                beck_link.setClass(Main2Activity.this, Main3Activity.class);
                startActivity(beck_link);
            }
        };
        back.setOnClickListener(onClickListenerback);

        onClickListenerupdata = new View.OnClickListener() {// 上傳並輸入玩家資料
            @Override
            public void onClick(View v) {
                customDialog();
            }

            private void customDialog() {
                final View item = LayoutInflater.from(Main2Activity.this).inflate(R.layout.layout, null);
                new AlertDialog.Builder(Main2Activity.this)
                        .setTitle(R.string.input_ur_name)
                        .setView(item)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                EditText editText = (EditText) item.findViewById(R.id.editText);
                                input_name = editText.getText().toString();

                                SharedPreferences name_data = getSharedPreferences("id_name",MODE_PRIVATE);  //初始化
                                SharedPreferences score_data = getSharedPreferences("id_score",MODE_PRIVATE);
                                SharedPreferences name_data2 = getSharedPreferences("id_name2",MODE_PRIVATE);
                                SharedPreferences score_data2 = getSharedPreferences("id_score2",MODE_PRIVATE);
                                SharedPreferences name_data3 = getSharedPreferences("id_name3",MODE_PRIVATE);
                                SharedPreferences score_data3 = getSharedPreferences("id_score3",MODE_PRIVATE);
                                SharedPreferences name_data4 = getSharedPreferences("id_name4",MODE_PRIVATE);
                                SharedPreferences score_data4 = getSharedPreferences("id_score4",MODE_PRIVATE);
                                SharedPreferences name_data5 = getSharedPreferences("id_name5",MODE_PRIVATE);
                                SharedPreferences score_data5 = getSharedPreferences("id_score5",MODE_PRIVATE);

                                if (score_data.getString("id_score","") == "") { //第一名沒資料
                                    array_name[0] = input_name;
                                    array_score[0] = count;

                                    name_data.edit().putString("id_name",array_name[0]).apply();
                                    score_data.edit().putString("id_score",array_score[0]).apply();
                                }
                                else if (score_data2.getString("id_score2","") == "") { //第二名沒資料
                                    array_name[0] = name_data.getString("id_name","");
                                    array_score[0] = score_data.getString("id_score","");
                                    array_name[1] = input_name;
                                    array_score[1] = count;

                                    for (int i=0;i<2;i++){ //排序
                                        for (int j=i+1;j<2;j++){
                                            if ( parseInt(array_score[i]) < parseInt(array_score[j]) ){
                                                reg_name = array_name[j];
                                                reg_score = array_score[j];

                                                array_name[j] = array_name[i];
                                                array_score[j] = array_score[i];

                                                array_name[i] = reg_name;
                                                array_score[i] = reg_score;
                                            }
                                        }
                                    }

                                    name_data.edit().putString("id_name",array_name[0]).apply();
                                    score_data.edit().putString("id_score",array_score[0]).apply();
                                    name_data2.edit().putString("id_name2",array_name[1]).apply();
                                    score_data2.edit().putString("id_score2",array_score[1]).apply();
                                }
                                else if (score_data3.getString("id_score3","") == "") { //第三名沒資料
                                    array_name[0] = name_data.getString("id_name","");
                                    array_score[0] = score_data.getString("id_score","");
                                    array_name[1] = name_data2.getString("id_name2","");
                                    array_score[1] = score_data2.getString("id_score2","");
                                    array_name[2] = input_name;
                                    array_score[2] = count;

                                    for (int i=0;i<3;i++){ //排序
                                        for (int j=i+1;j<3;j++){
                                            if ( parseInt(array_score[i]) < parseInt(array_score[j]) ){
                                                reg_name = array_name[j];
                                                reg_score = array_score[j];

                                                array_name[j] = array_name[i];
                                                array_score[j] = array_score[i];

                                                array_name[i] = reg_name;
                                                array_score[i] = reg_score;
                                            }
                                        }
                                    }

                                    name_data.edit().putString("id_name",array_name[0]).apply();
                                    score_data.edit().putString("id_score",array_score[0]).apply();
                                    name_data2.edit().putString("id_name2",array_name[1]).apply();
                                    score_data2.edit().putString("id_score2",array_score[1]).apply();
                                    name_data3.edit().putString("id_name3",array_name[2]).apply();
                                    score_data3.edit().putString("id_score3",array_score[2]).apply();
                                }
                                else if (score_data4.getString("id_score4","") == "") { //第四名沒資料
                                    array_name[0] = name_data.getString("id_name","");
                                    array_score[0] = score_data.getString("id_score","");
                                    array_name[1] = name_data2.getString("id_name2","");
                                    array_score[1] = score_data2.getString("id_score2","");
                                    array_name[2] = name_data3.getString("id_name3","");
                                    array_score[2] = score_data3.getString("id_score3","");
                                    array_name[3] = input_name;
                                    array_score[3] = count;

                                    for (int i=0;i<4;i++){ //排序
                                        for (int j=i+1;j<4;j++){
                                            if ( parseInt(array_score[i]) < parseInt(array_score[j]) ){
                                                reg_name = array_name[j];
                                                reg_score = array_score[j];

                                                array_name[j] = array_name[i];
                                                array_score[j] = array_score[i];

                                                array_name[i] = reg_name;
                                                array_score[i] = reg_score;
                                            }
                                        }
                                    }

                                    name_data.edit().putString("id_name",array_name[0]).apply();
                                    score_data.edit().putString("id_score",array_score[0]).apply();
                                    name_data2.edit().putString("id_name2",array_name[1]).apply();
                                    score_data2.edit().putString("id_score2",array_score[1]).apply();
                                    name_data3.edit().putString("id_name3",array_name[2]).apply();
                                    score_data3.edit().putString("id_score3",array_score[2]).apply();
                                    name_data4.edit().putString("id_name4",array_name[3]).apply();
                                    score_data4.edit().putString("id_score4",array_score[3]).apply();
                                }
                                else if (score_data5.getString("id_score5","") == "") { //第五名沒資料
                                    array_name[0] = name_data.getString("id_name","");
                                    array_score[0] = score_data.getString("id_score","");
                                    array_name[1] = name_data2.getString("id_name2","");
                                    array_score[1] = score_data2.getString("id_score2","");
                                    array_name[2] = name_data3.getString("id_name3","");
                                    array_score[2] = score_data3.getString("id_score3","");
                                    array_name[3] = name_data4.getString("id_name4","");
                                    array_score[3] = score_data4.getString("id_score4","");
                                    array_name[4] = input_name;
                                    array_score[4] = count;

                                    for (int i=0;i<5;i++){ //排序
                                        for (int j=i+1;j<5;j++){
                                            if ( parseInt(array_score[i]) < parseInt(array_score[j]) ){
                                                reg_name = array_name[j];
                                                reg_score = array_score[j];

                                                array_name[j] = array_name[i];
                                                array_score[j] = array_score[i];

                                                array_name[i] = reg_name;
                                                array_score[i] = reg_score;
                                            }
                                        }
                                    }

                                    name_data.edit().putString("id_name",array_name[0]).apply();
                                    score_data.edit().putString("id_score",array_score[0]).apply();
                                    name_data2.edit().putString("id_name2",array_name[1]).apply();
                                    score_data2.edit().putString("id_score2",array_score[1]).apply();
                                    name_data3.edit().putString("id_name3",array_name[2]).apply();
                                    score_data3.edit().putString("id_score3",array_score[2]).apply();
                                    name_data4.edit().putString("id_name4",array_name[3]).apply();
                                    score_data4.edit().putString("id_score4",array_score[3]).apply();
                                    name_data5.edit().putString("id_name5",array_name[4]).apply();
                                    score_data5.edit().putString("id_score5",array_score[4]).apply();
                                }
                                else{ //第六筆資料進來
                                    array_name[0] = name_data.getString("id_name","");
                                    array_score[0] = score_data.getString("id_score","");
                                    array_name[1] = name_data2.getString("id_name2","");
                                    array_score[1] = score_data2.getString("id_score2","");
                                    array_name[2] = name_data3.getString("id_name3","");
                                    array_score[2] = score_data3.getString("id_score3","");
                                    array_name[3] = name_data4.getString("id_name4","");
                                    array_score[3] = score_data4.getString("id_score4","");
                                    array_name[4] = name_data5.getString("id_name5","");
                                    array_score[4] = score_data5.getString("id_score5","");
                                    array_name[5] = input_name;
                                    array_score[5] = count;
//
                                    for (int i=0;i<6;i++){ //排序
                                        for (int j=i+1;j<6;j++){
                                            if ( parseInt(array_score[i]) < parseInt(array_score[j]) ){
                                                reg_name = array_name[j];
                                                reg_score = array_score[j];

                                                array_name[j] = array_name[i];
                                                array_score[j] = array_score[i];

                                                array_name[i] = reg_name;
                                                array_score[i] = reg_score;
                                            }
                                        }
                                    }

                                    name_data.edit().putString("id_name",array_name[0]).apply();
                                    score_data.edit().putString("id_score",array_score[0]).apply();
                                    name_data2.edit().putString("id_name2",array_name[1]).apply();
                                    score_data2.edit().putString("id_score2",array_score[1]).apply();
                                    name_data3.edit().putString("id_name3",array_name[2]).apply();
                                    score_data3.edit().putString("id_score3",array_score[2]).apply();
                                    name_data4.edit().putString("id_name4",array_name[3]).apply();
                                    score_data4.edit().putString("id_score4",array_score[3]).apply();
                                    name_data5.edit().putString("id_name5",array_name[4]).apply();
                                    score_data5.edit().putString("id_score5",array_score[4]).apply();
                                }

                                //將陣列資料存入SharedPreferences
//
//                                Log.e("string" , array_name[0] + " " + array_name[1] + " " + array_name[2] + " " + array_name[3] + " " + array_name[4] + " " + array_name [5]);
//                                Log.e("string" , array_score[0] + " " + array_score[1] + " " + array_score[2] + " " + array_score[3] + " " + array_score[4] + " " + array_score [5]);

                                name.setClass(Main2Activity.this, Main4Activity.class);
                                startActivity(name);

                                Toast.makeText(getApplicationContext(), getString(R.string.hi) , Toast.LENGTH_SHORT).show();

                            }
                        })
                        .show();
            }
        };
        updata.setOnClickListener(onClickListenerupdata);

    }
}