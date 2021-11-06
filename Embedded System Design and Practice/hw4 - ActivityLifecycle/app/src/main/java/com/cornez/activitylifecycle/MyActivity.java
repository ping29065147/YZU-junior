package com.cornez.activitylifecycle;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.*;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


public class MyActivity extends Activity {

    private String createMsg;
    private String startMsg;
    private String resumeMsg;
    private String pauseMsg;
    private String stopMsg;
    private String restartMsg;

    private TextView msg;
    private TextView[][] textViewArray = new TextView[8][8];
    private int num, cur_x, cur_y, new_x, new_y;
    private int[][] step = new int[8][8];
    private int[][] jump = new int[][]{ {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1} };
    private boolean isEnd;

    private Button btn1;
    private Button btn2;
    private Button btn3;

    Handler mHandler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            next();
            mHandler.postDelayed(this,500);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        msg = (TextView) findViewById(R.id.textView);

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

        btn1 = (Button) findViewById((R.id.button));
        btn2 = (Button) findViewById((R.id.button2));
        btn3 = (Button) findViewById((R.id.button3));

        num = (int)(Math.random() * 64);
        cur_x = num / 8;
        cur_y = num % 8;
        textViewArray[cur_x][cur_y].setText("@");
        for (int i = 0; i < 8 ;++i) for (int j = 0; j < 8; ++j) textViewArray[i][j].setTextColor(Color.parseColor("#ff0000"));

        for (int i = 0; i < 8 ;++i) for (int j = 0; j < 8; ++j) step[i][j] = 0;
        step[cur_x][cur_y] = 1;

        isEnd = false;
    }

    public void init(View view)
    {
        for (int i = 0; i < 8 ;++i) for (int j = 0; j < 8; ++j) textViewArray[i][j].setText("");
        num = (int)(Math.random() * 64);
        cur_x = num / 8;
        cur_y = num % 8;
        textViewArray[cur_x][cur_y].setText("@");

        for (int i = 0; i < 8 ;++i) for (int j = 0; j < 8; ++j) step[i][j] = 0;
        step[cur_x][cur_y] = 1;

        isEnd = false;

        for (int i = 0; i < 8; ++i) for (int j = 0; j < 8; ++j)
        {
            if ((i + j) % 2 == 0) textViewArray[i][j].setBackgroundResource(R.drawable.black);
            else textViewArray[i][j].setBackgroundResource(R.drawable.white);
        }

        msg.setText("");

        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        mHandler.removeCallbacksAndMessages(null);
        mHandler.removeCallbacksAndMessages(0);
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
                btn1.setEnabled(true);
                btn2.setEnabled(true);
                btn3.setEnabled(true);
                return;
            }
        }

        textViewArray[new_x][new_y].setText("@");
        textViewArray[cur_x][cur_y].setText("");
        textViewArray[cur_x][cur_y].setBackgroundResource(R.drawable.red);
        step[new_x][new_y] = 1;
        cur_x = new_x;
        cur_y = new_y;

        z = 1;
        for (int i = 0; i < 8 ;++i) for (int j = 0; j < 8; ++j) z &= step[i][j];
        if (z == 1)
        {
            isEnd = true;
            msg.setText("Great!!!!!!!!");
            btn1.setEnabled(true);
            btn2.setEnabled(true);
            btn3.setEnabled(true);
        }
    }

    public void next(View view)
    {
        next();
    }

    public void finish(View view)
    {
        if (isEnd == true) return;

        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);

        mHandler.postDelayed(runnable,500);
    }

    private void initializeMessages(){
        createMsg = (String) getResources().getText(R.string.create_message);
        startMsg = (String) getResources().getText(R.string.start_message);
        resumeMsg = (String) getResources().getText(R.string.resume_message);
        pauseMsg = (String) getResources().getText(R.string.pause_message);
        stopMsg = (String) getResources().getText(R.string.stop_message);
        restartMsg = (String) getResources().getText(R.string.restart_message);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(this, startMsg, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this, resumeMsg, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(this, pauseMsg, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(this, stopMsg, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Toast.makeText(this, restartMsg, Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


