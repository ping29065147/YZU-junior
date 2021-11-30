package com.cornez.activitylifecycle;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.os.*;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


public class MyActivity extends Activity
{
    private TextView msg;
    private TextView[][] textViewArray = new TextView[8][8];
    private TextView location, hit, score, miss;
    private int num, cur_x, cur_y, new_x, new_y;
    private int[][] step = new int[8][8];
    private int[][] jump = new int[][]{ {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1} };
    private boolean isEnd;

    private Button con;
    private Button btn2;
    private Button btn3;

    private int level = 0;
    private double Hit = 0;
    private double Miss = 0;
    private double red = 1;

    Handler mHandler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            next();
            mHandler.postDelayed(this,level);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        msg = (TextView) findViewById(R.id.textView);
        location = (TextView) findViewById(R.id.textView4);
        hit = (TextView) findViewById(R.id.textView6);
        score = (TextView) findViewById(R.id.textView5);
        miss = (TextView) findViewById(R.id.textView7);

        textViewArray[0][0] = (TextView) findViewById(R.id.textView00);
        textViewArray[0][1] = (TextView) findViewById(R.id.textView01);
        textViewArray[0][2] = (TextView) findViewById(R.id.textView02);
        textViewArray[0][3] = (TextView) findViewById(R.id.textView03);
        textViewArray[0][4] = (TextView) findViewById(R.id.textView04);
        textViewArray[0][5] = (TextView) findViewById(R.id.textView05);
        textViewArray[0][6] = (TextView) findViewById(R.id.textView06);
        textViewArray[0][7] = (TextView) findViewById(R.id.textView07);

        textViewArray[1][0] = (TextView) findViewById(R.id.textView10);
        textViewArray[1][1] = (TextView) findViewById(R.id.textView11);
        textViewArray[1][2] = (TextView) findViewById(R.id.textView12);
        textViewArray[1][3] = (TextView) findViewById(R.id.textView13);
        textViewArray[1][4] = (TextView) findViewById(R.id.textView14);
        textViewArray[1][5] = (TextView) findViewById(R.id.textView15);
        textViewArray[1][6] = (TextView) findViewById(R.id.textView16);
        textViewArray[1][7] = (TextView) findViewById(R.id.textView17);

        textViewArray[2][0] = (TextView) findViewById(R.id.textView20);
        textViewArray[2][1] = (TextView) findViewById(R.id.textView21);
        textViewArray[2][2] = (TextView) findViewById(R.id.textView22);
        textViewArray[2][3] = (TextView) findViewById(R.id.textView23);
        textViewArray[2][4] = (TextView) findViewById(R.id.textView24);
        textViewArray[2][5] = (TextView) findViewById(R.id.textView25);
        textViewArray[2][6] = (TextView) findViewById(R.id.textView26);
        textViewArray[2][7] = (TextView) findViewById(R.id.textView27);

        textViewArray[3][0] = (TextView) findViewById(R.id.textView30);
        textViewArray[3][1] = (TextView) findViewById(R.id.textView31);
        textViewArray[3][2] = (TextView) findViewById(R.id.textView32);
        textViewArray[3][3] = (TextView) findViewById(R.id.textView33);
        textViewArray[3][4] = (TextView) findViewById(R.id.textView34);
        textViewArray[3][5] = (TextView) findViewById(R.id.textView35);
        textViewArray[3][6] = (TextView) findViewById(R.id.textView36);
        textViewArray[3][7] = (TextView) findViewById(R.id.textView37);

        textViewArray[4][0] = (TextView) findViewById(R.id.textView40);
        textViewArray[4][1] = (TextView) findViewById(R.id.textView41);
        textViewArray[4][2] = (TextView) findViewById(R.id.textView42);
        textViewArray[4][3] = (TextView) findViewById(R.id.textView43);
        textViewArray[4][4] = (TextView) findViewById(R.id.textView44);
        textViewArray[4][5] = (TextView) findViewById(R.id.textView45);
        textViewArray[4][6] = (TextView) findViewById(R.id.textView46);
        textViewArray[4][7] = (TextView) findViewById(R.id.textView47);

        textViewArray[5][0] = (TextView) findViewById(R.id.textView50);
        textViewArray[5][1] = (TextView) findViewById(R.id.textView51);
        textViewArray[5][2] = (TextView) findViewById(R.id.textView52);
        textViewArray[5][3] = (TextView) findViewById(R.id.textView53);
        textViewArray[5][4] = (TextView) findViewById(R.id.textView54);
        textViewArray[5][5] = (TextView) findViewById(R.id.textView55);
        textViewArray[5][6] = (TextView) findViewById(R.id.textView56);
        textViewArray[5][7] = (TextView) findViewById(R.id.textView57);

        textViewArray[6][0] = (TextView) findViewById(R.id.textView60);
        textViewArray[6][1] = (TextView) findViewById(R.id.textView61);
        textViewArray[6][2] = (TextView) findViewById(R.id.textView62);
        textViewArray[6][3] = (TextView) findViewById(R.id.textView63);
        textViewArray[6][4] = (TextView) findViewById(R.id.textView64);
        textViewArray[6][5] = (TextView) findViewById(R.id.textView65);
        textViewArray[6][6] = (TextView) findViewById(R.id.textView66);
        textViewArray[6][7] = (TextView) findViewById(R.id.textView67);

        textViewArray[7][0] = (TextView) findViewById(R.id.textView70);
        textViewArray[7][1] = (TextView) findViewById(R.id.textView71);
        textViewArray[7][2] = (TextView) findViewById(R.id.textView72);
        textViewArray[7][3] = (TextView) findViewById(R.id.textView73);
        textViewArray[7][4] = (TextView) findViewById(R.id.textView74);
        textViewArray[7][5] = (TextView) findViewById(R.id.textView75);
        textViewArray[7][6] = (TextView) findViewById(R.id.textView76);
        textViewArray[7][7] = (TextView) findViewById(R.id.textView77);

        btn2 = (Button) findViewById((R.id.button2));
        btn3 = (Button) findViewById((R.id.button3));
        con = (Button) findViewById((R.id.button5));

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent _1 = new Intent(MyActivity.this, set.class);
                Bundle side = new Bundle();

                if (level == 2000) side.putInt("level", 1);
                else if (level == 1000) side.putInt("level", 2);
                else side.putInt("level", 3);
                side.putDouble("hit", Hit);
                side.putDouble("miss", Miss);
                side.putDouble("red", red);
                side.putInt("x", cur_x);
                side.putInt("y", cur_y);
                side.putIntArray("step0", step[0]);
                side.putIntArray("step1", step[1]);
                side.putIntArray("step2", step[2]);
                side.putIntArray("step3", step[3]);
                side.putIntArray("step4", step[4]);
                side.putIntArray("step5", step[5]);
                side.putIntArray("step6", step[6]);
                side.putIntArray("step7", step[7]);

                _1.putExtras(side);
                startActivity(_1);
            }
        });

        Bundle bd = getIntent().getExtras();

        level = bd.getInt("level");
        Hit = bd.getDouble("hit");
        Miss = bd.getDouble("miss");
        red = bd.getDouble("red");
        cur_x = bd.getInt("x");
        cur_y = bd.getInt("y");
        step[0] = bd.getIntArray("step0");
        step[1] = bd.getIntArray("step1");
        step[2] = bd.getIntArray("step2");
        step[3] = bd.getIntArray("step3");
        step[4] = bd.getIntArray("step4");
        step[5] = bd.getIntArray("step5");
        step[6] = bd.getIntArray("step6");
        step[7] = bd.getIntArray("step7");

        score.setText("Score : " + Math.round(Math.max((Hit / red) * 100 - Miss, 0) * 100.0) / 100.0);
        hit.setText("Hit: " + Hit);
        miss.setText("Miss : " + Miss);

        for (int i = 0; i < 8; ++i) for (int j = 0; j < 8; ++j)
            if (step[i][j] > 0) textViewArray[i][j].setBackgroundResource(R.drawable.red);

        if (red == 1)
        {
            num = (int)(Math.random() * 64);
            cur_x = num / 8;
            cur_y = num % 8;
            textViewArray[cur_x][cur_y].setText("@");

            for (int i = 0; i < 8 ;++i) for (int j = 0; j < 8; ++j) step[i][j] = 0;
            ++step[cur_x][cur_y];
            location.setText("位置 : ( " + cur_y + ", " + cur_x + " )");
        }

        for (int i = 0; i < 8 ;++i) for (int j = 0; j < 8; ++j) textViewArray[i][j].setTextColor(Color.parseColor("#ff0000"));
        isEnd = false;


        if (isEnd == true) return;
        mHandler.postDelayed(runnable, level);
    }

    public void next()
    {
        if (isEnd == true) return;

        int tmp;
        int check[] = new int[8];
        int z;

        while(true){
            tmp = (int)(Math.random() * 8);
            new_x = cur_x + jump[tmp][0];
            new_y = cur_y + jump[tmp][1];

            if (check[tmp] == 0 && new_x >= 0 && new_x < 8 && new_y >= 0 && new_y < 8 && step[new_x][new_y] == 0) break;

            check[tmp] = 1;
            z = 1;
            for (int i = 0; i< 8; ++i) z &= check[i];
            if (z == 1)
            {
                isEnd = true;
                msg.setText("Oops!!!!!!!!");
                return;
            }
        }

        ++red;
        textViewArray[new_x][new_y].setText("@");
        textViewArray[cur_x][cur_y].setText("");
        textViewArray[cur_x][cur_y].setBackgroundResource(R.drawable.red);
        ++step[new_x][new_y];
        cur_x = new_x;
        cur_y = new_y;
        location.setText("位置 : ( " + cur_y + ", " + cur_x + " )");

        z = 1;
        for (int i = 0; i < 8 ;++i) for (int j = 0; j < 8; ++j) z &= step[i][j];
        if (z == 1)
        {
            isEnd = true;
            msg.setText("Great!!!!!!!!");
        }

        score.setText("Score : " + Math.round(Math.max((Hit / red) * 100 - Miss, 0) * 100.0) / 100.0);
        hit.setText("Hit: " + Hit);
        miss.setText("Miss : " + Miss);
    }

    public void finish(View view)
    {
        Hit = 0;
        Miss = 0;
        red = 1;

        for (int i = 0; i < 8 ;++i) for (int j = 0; j < 8; ++j) textViewArray[i][j].setText("");
        num = (int)(Math.random() * 64);
        cur_x = num / 8;
        cur_y = num % 8;
        textViewArray[cur_x][cur_y].setText("@");

        for (int i = 0; i < 8 ;++i) for (int j = 0; j < 8; ++j) step[i][j] = 0;
        ++step[cur_x][cur_y];
        location.setText("位置 : ( " + cur_y + ", " + cur_x + " )");
        isEnd = false;

        for (int i = 0; i < 8; ++i) for (int j = 0; j < 8; ++j)
        {
            if ((i + j) % 2 == 0) textViewArray[i][j].setBackgroundResource(R.drawable.black);
            else textViewArray[i][j].setBackgroundResource(R.drawable.white);
        }

        msg.setText("");
        mHandler.removeCallbacksAndMessages(null);
        mHandler.removeCallbacksAndMessages(0);

        if (isEnd == true) return;
        mHandler.postDelayed(runnable, level);
    }

    public void onClick(View v)
    {
        if (++step[cur_x][cur_y] > 2) return;

        if (v.getId() == textViewArray[cur_x][cur_y].getId()) ++Hit;
        else ++Miss;

        score.setText("Score : " + Math.round(Math.max((Hit / red) * 100 - Miss, 0) * 100.0) / 100.0);
        hit.setText("Hit: " + Hit);
        miss.setText("Miss : " + Miss);
    }
}


