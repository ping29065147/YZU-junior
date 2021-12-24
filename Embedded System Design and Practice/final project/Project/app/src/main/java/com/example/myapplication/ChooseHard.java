package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseHard extends AppCompatActivity {

    private Button gotoMain,gotoExam;
    private int choose,level;
    private SeekBar Hard;
    private TextView HardText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choosehard);

        init();
        setClick();

    }

    public void init()
    {
        gotoMain = (Button) findViewById(R.id.button6);
        gotoExam = (Button) findViewById(R.id.button7);
        Hard = (SeekBar) findViewById(R.id.seekBar);
        HardText = (TextView) findViewById(R.id.textView4);
        level = 2;
        HardText.setText("難度: 中");
    }

    public void setClick()
    {
        gotoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent _1 = new Intent(ChooseHard.this, MainActivity.class);
                startActivity(_1);
            }
        });

        gotoExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent _1 = new Intent(ChooseHard.this, Exam.class);

                Bundle side = new Bundle();

                side.putInt("Hard", level);

                _1.putExtras(side);

                startActivity(_1);
            }
        });

        Hard.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                level = progress;
                switch (level)
                {
                    case 1:
                        HardText.setText("難度: 低");
                        break;
                    case 2:
                        HardText.setText("難度: 中");
                        break;
                    case 3:
                        HardText.setText("難度: 高");
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                HardText.setText("難度: 中");
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }
}
