package com.cornez.activitylifecycle;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.os.*;
import android.content.Intent;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class set extends Activity
{
    private Button start;
    private Button con;
    private SeekBar sb;
    private  TextView t1;

    private int[][] step = new int[8][8];
    private int level = 2, cur_x = 0, cur_y = 0;
    private double Hit = 0;
    private double Miss = 0;
    private double red = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set);

        start = (Button) findViewById(R.id.button4);
        con = (Button) findViewById(R.id.button5);
        sb = (SeekBar) findViewById(R.id.seekBar);
        t1 = (TextView) findViewById(R.id.textView3);

        for (int i = 0; i < 8; ++i) for (int j = 0; j < 8; ++j) step[i][j] = 0;

        Bundle bd = getIntent().getExtras();
        if (bd != null)
        {
            con.setEnabled(true);

            level = bd.getInt("level");
            sb.setProgress(level);
            t1.setText("Level : " + level);
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
        }
        else con.setEnabled(false);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                level = progress;
                t1.setText("Level : " + level);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent _2 = new Intent(set.this, MyActivity.class);
                Bundle side = new Bundle();

                if (level == 1) side.putInt("level", 2000);
                else if (level == 2) side.putInt("level", 1000);
                else side.putInt("level", 500);
                side.putDouble("hit", 0);
                side.putDouble("miss", 0);
                side.putDouble("red", 1);
                side.putInt("x", cur_x);
                side.putInt("y", cur_y);
                for (int i = 0; i < 8; ++i) for (int j = 0; j < 8; ++j) step[i][j] = 0;
                side.putIntArray("step0", step[0]);
                side.putIntArray("step1", step[1]);
                side.putIntArray("step2", step[2]);
                side.putIntArray("step3", step[3]);
                side.putIntArray("step4", step[4]);
                side.putIntArray("step5", step[5]);
                side.putIntArray("step6", step[6]);
                side.putIntArray("step7", step[7]);

                _2.putExtras(side);
                startActivity(_2);
            }
        });

        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent _2 = new Intent(set.this, MyActivity.class);
                Bundle side = new Bundle();

                if (level == 1) side.putInt("level", 2000);
                else if (level == 2) side.putInt("level", 1000);
                else side.putInt("level", 500);
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

                _2.putExtras(side);
                startActivity(_2);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) return true;
        return super.onOptionsItemSelected(item);
    }

    public void new_game(View view)
    {

    }

    public void quit(View view)
    {
        finishAffinity();
    }
}
