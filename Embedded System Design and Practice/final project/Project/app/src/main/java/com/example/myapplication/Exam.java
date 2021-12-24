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


public class Exam extends AppCompatActivity {

    private Button chooseA,chooseB,chooseC,chooseD;
    private int level, questionNumber, grade;
    private knapsack K;
    private problem_database DB;
    private static List<Integer> result;
    private TextView Questioin;
    private int answer;
    private int Knack[] = new int[10],User[] = new int[10];

    private RelativeLayout relative1, relative2, relative;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam);

        init();
        setClick();

        Questioin.setText(DB.getDescription(result.get(questionNumber)));
        chooseA.setText(DB.getOption1(result.get(questionNumber)));
        chooseB.setText(DB.getOption2(result.get(questionNumber)));
        chooseC.setText(DB.getOption3(result.get(questionNumber)));
        chooseD.setText(DB.getOption4(result.get(questionNumber)));
        answer = DB.getAnswer(result.get(questionNumber));
        Knack[questionNumber] = result.get(questionNumber);

    }

    public void init()
    {
        Questioin = (TextView) findViewById(R.id.textView5);

        chooseA = (Button) findViewById(R.id.Textview1);
        chooseB = (Button) findViewById(R.id.button5);
        chooseC = (Button) findViewById(R.id.button);
        chooseD = (Button) findViewById(R.id.button2);

        relative = (RelativeLayout) findViewById(R.id.RL);
        relative1 = (RelativeLayout) findViewById(R.id.rl1);
        relative2 = (RelativeLayout) findViewById(R.id.rl2);

        chooseA.setBackgroundColor(chooseA.getContext().getResources().getColor(R.color.beige));
        chooseB.setBackgroundColor(chooseB.getContext().getResources().getColor(R.color.beige));
        chooseC.setBackgroundColor(chooseC.getContext().getResources().getColor(R.color.beige));
        chooseD.setBackgroundColor(chooseD.getContext().getResources().getColor(R.color.beige));

        Bundle bd = getIntent().getExtras();
        questionNumber = 0;
        grade = 0;

        if(bd!=null)
        {
            level = bd.getInt("Hard");
        }

        K = new knapsack(level);
        DB = new problem_database();
        result = new ArrayList<Integer>();
        result = K.getResult();
    }

    public void setClick()
    {
        chooseA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                User[questionNumber] = 1;
                if(answer == 1)
                {
                    grade += 10;
                    //ToastUtil.toast(Exam.this, "你答對了");
                }
                //else ToastUtil.toast(Exam.this, "你答錯了");
                questionNumber++;
                if(questionNumber==10)
                {

                    Intent _1 = new Intent(Exam.this, Result.class);

                    Bundle side = new Bundle();

                    side.putInt("Grade", grade);
                    side.putIntArray("User",User);
                    side.putIntArray("Knack",Knack);
                    //side.putIntegerArrayList("Knack",result);
                    _1.putExtras(side);

                    startActivity(_1);
                }
                else
                {
                    //relative1.startAnimation(AnimationUtils.loadAnimation(Exam.this,R.anim.btoa));
                    //relative2.startAnimation(AnimationUtils.loadAnimation(Exam.this,R.anim.btoa));

                    Questioin.setText(DB.getDescription(result.get(questionNumber)));
                    chooseA.setText(DB.getOption1(result.get(questionNumber)));
                    chooseB.setText(DB.getOption2(result.get(questionNumber)));
                    chooseC.setText(DB.getOption3(result.get(questionNumber)));
                    chooseD.setText(DB.getOption4(result.get(questionNumber)));
                    answer = DB.getAnswer(result.get(questionNumber));
                    Knack[questionNumber] = result.get(questionNumber);
                }
            }
        });

        chooseB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                User[questionNumber] = 2;
                questionNumber++;
                if(answer == 2)
                {
                    grade += 10;
                    //ToastUtil.toast(Exam.this, "你答對了");
                }
                //else ToastUtil.toast(Exam.this, "你答錯了");
                if(questionNumber==10)
                {
                    Intent _1 = new Intent(Exam.this, Result.class);

                    Bundle side = new Bundle();

                    side.putInt("Grade", grade);
                    side.putIntArray("User",User);
                    side.putIntArray("Knack",Knack);
                    _1.putExtras(side);

                    startActivity(_1);
                }
                else
                {
                    Questioin.setText(DB.getDescription(result.get(questionNumber)));
                    chooseA.setText(DB.getOption1(result.get(questionNumber)));
                    chooseB.setText(DB.getOption2(result.get(questionNumber)));
                    chooseC.setText(DB.getOption3(result.get(questionNumber)));
                    chooseD.setText(DB.getOption4(result.get(questionNumber)));
                    answer = DB.getAnswer(result.get(questionNumber));
                    Knack[questionNumber] = result.get(questionNumber);
                }
            }
        });

        chooseC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                User[questionNumber] = 3;
                questionNumber++;
                if(answer == 3)
                {
                    grade += 10;
                    //ToastUtil.toast(Exam.this, "你答對了");
                }
               // else ToastUtil.toast(Exam.this, "你答錯了");
                if(questionNumber==10)
                {
                    Intent _1 = new Intent(Exam.this, Result.class);

                    Bundle side = new Bundle();

                    side.putInt("Grade", grade);
                    side.putIntArray("User",User);
                    side.putIntArray("Knack",Knack);
                    _1.putExtras(side);

                    startActivity(_1);
                }
                else
                {
                    Questioin.setText(DB.getDescription(result.get(questionNumber)));
                    chooseA.setText(DB.getOption1(result.get(questionNumber)));
                    chooseB.setText(DB.getOption2(result.get(questionNumber)));
                    chooseC.setText(DB.getOption3(result.get(questionNumber)));
                    chooseD.setText(DB.getOption4(result.get(questionNumber)));
                    answer = DB.getAnswer(result.get(questionNumber));
                    Knack[questionNumber] = result.get(questionNumber);
                }
            }
        });

        chooseD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                User[questionNumber] = 4;
                questionNumber++;
                if(answer == 4)
                {
                    grade += 10;
                    //ToastUtil.toast(Exam.this, "你答對了");
                }
                //else ToastUtil.toast(Exam.this, "你答錯了");
                if(questionNumber==10)
                {
                    Intent _1 = new Intent(Exam.this, Result.class);

                    Bundle side = new Bundle();

                    side.putInt("Grade", grade);
                    side.putIntArray("User",User);
                    side.putIntArray("Knack",Knack);
                    _1.putExtras(side);

                    startActivity(_1);
                }
                else
                {
                    Questioin.setText(DB.getDescription(result.get(questionNumber)));
                    chooseA.setText(DB.getOption1(result.get(questionNumber)));
                    chooseB.setText(DB.getOption2(result.get(questionNumber)));
                    chooseC.setText(DB.getOption3(result.get(questionNumber)));
                    chooseD.setText(DB.getOption4(result.get(questionNumber)));
                    answer = DB.getAnswer(result.get(questionNumber));
                    Knack[questionNumber] = result.get(questionNumber);
                }
            }
        });
    }
}
