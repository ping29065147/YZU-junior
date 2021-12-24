package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import android.view.animation.AnimationUtils;


public class Review extends AppCompatActivity {

    private Button b1,b2,b3,b4;
    private Button LL,RR,goBack;
    private int User[] = new int[10],Knack[] = new int[10];
    private int grade,questionNumber;
    private TextView Questioin;
    private int answer;
    private problem_database DB;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review);

        init();
        setClick();
        set();
    }

    public void init()
    {
        b1 = (Button) findViewById(R.id.Textview1);
        b2 = (Button) findViewById(R.id.button5);
        b3 = (Button) findViewById(R.id.button);
        b4 = (Button) findViewById(R.id.button2);
        LL = (Button) findViewById(R.id.button4);
        RR = (Button) findViewById(R.id.button3);
        goBack = (Button) findViewById(R.id.button10);

        b1.setClickable(false);
        b2.setClickable(false);
        b3.setClickable(false);
        b4.setClickable(false);


        Questioin = (TextView) findViewById(R.id.textView5);

        questionNumber = 0;

        DB = new problem_database();

        Bundle bd = getIntent().getExtras();
        if(bd!=null)
        {
            grade = bd.getInt("Grade");
            User = bd.getIntArray("User");
            Knack = bd.getIntArray("Knack");
        }

        LL.setBackgroundColor(LL.getContext().getResources().getColor(R.color.beige));
        RR.setBackgroundColor(RR.getContext().getResources().getColor(R.color.beige));
        //LL.setText("L");
        //RR.setText("R");
    }

    public void set()
    {
        if(questionNumber==0)
        {
            LL.setText("");
            LL.setVisibility(View.INVISIBLE);
            RR.setText(""+(questionNumber+2));
            RR.setVisibility(View.VISIBLE);
        }
        else if(questionNumber == 9)
        {
            LL.setText(""+(questionNumber));
            LL.setVisibility(View.VISIBLE);
            RR.setText("");
            RR.setVisibility(View.INVISIBLE);
        }
        else
        {
            LL.setText(""+questionNumber);
            LL.setVisibility(View.VISIBLE);
            RR.setText(""+(questionNumber+2));
            RR.setVisibility(View.VISIBLE);
        }

        b1.setBackgroundColor(b1.getContext().getResources().getColor(R.color.beige));
        b2.setBackgroundColor(b1.getContext().getResources().getColor(R.color.beige));
        b3.setBackgroundColor(b1.getContext().getResources().getColor(R.color.beige));
        b4.setBackgroundColor(b1.getContext().getResources().getColor(R.color.beige));

        Questioin.setText(DB.getDescription(Knack[questionNumber]));
        b1.setText(DB.getOption1(Knack[questionNumber]));
        b2.setText(DB.getOption2(Knack[questionNumber]));
        b3.setText(DB.getOption3(Knack[questionNumber]));
        b4.setText(DB.getOption4(Knack[questionNumber]));
        answer = DB.getAnswer(Knack[questionNumber]);

        if(User[questionNumber]!=answer)
        {
            switch (User[questionNumber]){
                case 1:
                    b1.setBackgroundColor(b1.getContext().getResources().getColor(R.color.red));
                    break;
                case 2:
                    b2.setBackgroundColor(b1.getContext().getResources().getColor(R.color.red));
                    break;
                case 3:
                    b3.setBackgroundColor(b1.getContext().getResources().getColor(R.color.red));
                    break;
                case 4:
                    b4.setBackgroundColor(b1.getContext().getResources().getColor(R.color.red));
                    break;
            }
            switch (answer){
                case 1:
                    b1.setBackgroundColor(b1.getContext().getResources().getColor(R.color.green));
                    break;
                case 2:
                    b2.setBackgroundColor(b1.getContext().getResources().getColor(R.color.green));
                    break;
                case 3:
                    b3.setBackgroundColor(b1.getContext().getResources().getColor(R.color.green));
                    break;
                case 4:
                    b4.setBackgroundColor(b1.getContext().getResources().getColor(R.color.green));
                    break;
            }
        }
        else
        {
            switch (User[questionNumber]){
                case 1:
                    b1.setBackgroundColor(b1.getContext().getResources().getColor(R.color.green));
                    break;
                case 2:
                    b2.setBackgroundColor(b1.getContext().getResources().getColor(R.color.green));
                    break;
                case 3:
                    b3.setBackgroundColor(b1.getContext().getResources().getColor(R.color.green));
                    break;
                case 4:
                    b4.setBackgroundColor(b1.getContext().getResources().getColor(R.color.green));
                    break;
            }
        }
    }

    public void setClick()
    {
        LL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(questionNumber>0)
                {
                    questionNumber--;
                    set();
                }

            }
        });

        RR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(questionNumber<9)
                {
                    questionNumber++;
                    set();
                }
            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent _1 = new Intent(Review.this, Result.class);

                Bundle side = new Bundle();

                side.putInt("Grade", grade);
                side.putIntArray("User",User);
                side.putIntArray("Knack",Knack);

                _1.putExtras(side);
                startActivity(_1);
            }
        });
    }
}
