package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.app.Activity;
import android.database.Cursor;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Psummary extends AppCompatActivity {

    private Button gotoChoose;
    private TextView ProblemName,Introduction;
    private int choose;
    static Point size;
    static float density;
    private int width;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.problemsummary);

        init();
        setClick();
        dataSet();


        //if(choose==1)ProblemName.setText(R.string.PProblem);


    }

    public void init()
    {
        ProblemName = (TextView) findViewById(R.id.textView2);
        Introduction = (TextView) findViewById(R.id.textView3);
        Typeface mtypeface=Typeface.createFromAsset(getAssets(),"LiberationSerif-Regular.ttf");

        ProblemName.setTypeface(mtypeface);
        Introduction.setTypeface(mtypeface);

        Bundle bd = getIntent().getExtras();
        if(bd!=null)
        {
            choose = bd.getInt("Choose");
        }

        gotoChoose = (Button) findViewById(R.id.button6);
        gotoChoose.setBackgroundColor(gotoChoose.getContext().getResources().getColor(R.color.beige));

    }

    public void setClick()
    {
        gotoChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent _1 = new Intent(Psummary.this, ChoosePorA.class);
                Bundle side = new Bundle();

                side.putInt("Choose",choose);

                _1.putExtras(side);
                startActivity(_1);
            }
        });

    }

    public void dataSet()
    {
        switch (choose)
        {
            case 1:
                ProblemName.setText(R.string.PProblem);
                Introduction.setText(R.string.PProblemIntro);

                break;
            case 2:
                ProblemName.setText(R.string.NPHARDproblem);
                Introduction.setText(R.string.NPHARDProblemIntro);
                break;
            case 3:
                ProblemName.setText(R.string.NPCOMproblem);
                Introduction.setText(R.string.NPCOMProblemIntro);
                break;
            case 4:
                ProblemName.setText(R.string.INTRACTABLEProblem);
                Introduction.setText(R.string.INTRACTABLEProblemIntro);
                break;
            case 5:
                ProblemName.setText(R.string.UnsolvedProblem);
                Introduction.setText(R.string.UnsolvedProblemIntro);
                break;
        }
        ProblemName.setGravity(Gravity.CENTER);
    }
}
