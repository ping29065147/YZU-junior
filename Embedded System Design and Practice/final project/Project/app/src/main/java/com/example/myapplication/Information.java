package com.example.myapplication;

import android.graphics.Typeface;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Information extends AppCompatActivity {

    private Button gotoMenu,gotoChoose1,gotoChoose2,gotoChoose3,gotoChoose4,gotoChoose5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chooseproblem);

        init();
        setClick();
    }

    public void init()
    {
        gotoMenu = (Button) findViewById(R.id.button6);
        gotoChoose1 = (Button) findViewById(R.id.button3);
        gotoChoose2 = (Button) findViewById(R.id.Textview1);
        gotoChoose3 = (Button) findViewById(R.id.button5);
        gotoChoose4 = (Button) findViewById(R.id.button);
        gotoChoose5 = (Button) findViewById(R.id.button2);

        Typeface mtypeface=Typeface.createFromAsset(getAssets(),"LiberationSerif-Regular.ttf");

        gotoChoose1.setTypeface(mtypeface);
        gotoChoose2.setTypeface(mtypeface);
        gotoChoose3.setTypeface(mtypeface);
        gotoChoose4.setTypeface(mtypeface);
        gotoChoose5.setTypeface(mtypeface);
    }

    public void setClick()
    {
        gotoMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent _1 = new Intent(Information.this, MainActivity.class);
                Bundle side = new Bundle();

                int choose=1;
                side.putInt("Choose",choose);

                _1.putExtras(side);
                startActivity(_1);
            }
        });

        gotoChoose1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent _1 = new Intent(Information.this, ChoosePorA.class);
                Bundle side = new Bundle();

                int choose=1;
                side.putInt("Choose",choose);

                _1.putExtras(side);
                startActivity(_1);
            }
        });

        gotoChoose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent _2 = new Intent(Information.this, ChoosePorA.class);
                Bundle side = new Bundle();

                int choose=2;
                side.putInt("Choose",choose);

                _2.putExtras(side);
                startActivity(_2);
            }
        });

        gotoChoose3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent _3 = new Intent(Information.this, ChoosePorA.class);
                Bundle side = new Bundle();

                int choose=3;
                side.putInt("Choose",choose);

                _3.putExtras(side);
                startActivity(_3);
            }
        });

        gotoChoose4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent _4 = new Intent(Information.this, ChoosePorA.class);
                Bundle side = new Bundle();

                int choose=4;
                side.putInt("Choose",choose);

                _4.putExtras(side);
                startActivity(_4);
            }
        });

        gotoChoose5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent _5 = new Intent(Information.this, ChoosePorA.class);
                Bundle side = new Bundle();

                int choose=5;
                side.putInt("Choose",choose);

                _5.putExtras(side);
                startActivity(_5);
            }
        });
    }
}
