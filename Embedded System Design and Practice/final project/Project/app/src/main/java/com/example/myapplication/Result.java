package com.example.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {

    private Button gotoMain,gotoReview;
    private TextView GradeT;
    private int grade;
    private int User[] = new int[10],Knack[] = new int[10];

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        init();
        setClick();
    }

    public void init()
    {
        gotoMain = (Button) findViewById(R.id.button5);
        gotoReview = (Button) findViewById(R.id.button6);
        GradeT = (TextView) findViewById(R.id.Textview1);

        Bundle bd = getIntent().getExtras();
        if(bd!=null)
        {
            grade = bd.getInt("Grade");
            User = bd.getIntArray("User");
            Knack = bd.getIntArray("Knack");
        }

        GradeT.setText(""+grade);
        GradeT.setGravity(Gravity.CENTER);

        Typeface mtypeface=Typeface.createFromAsset(getAssets(),"LiberationSerif-Regular.ttf");

        GradeT.setTypeface(mtypeface);
    }

    public void setClick()
    {
        gotoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //ToastUtil.cancel();
                Intent _1 = new Intent(Result.this, MainActivity.class);

                startActivity(_1);

            }
        });

        gotoReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //ToastUtil.cancel();
                Intent _1 = new Intent(Result.this, Review.class);

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
