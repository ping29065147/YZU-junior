package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button gotoChooseP,gotoExit,gotoChooseHard;
    private TextView Main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        init();
        setClick();

    }

    public void init()
    {
        gotoChooseP = (Button) findViewById(R.id.button3);
        gotoExit = (Button) findViewById(R.id.button5);
        gotoChooseHard = (Button) findViewById(R.id.Textview1);
        Main = (TextView) findViewById(R.id.textView);

        Typeface mtypeface=Typeface.createFromAsset(getAssets(),"LiberationSerif-Regular.ttf");
        Main.setTypeface(mtypeface);
        gotoChooseHard.setTypeface(mtypeface);
        gotoExit.setTypeface(mtypeface);
        gotoChooseP.setTypeface(mtypeface);
        //Main.setText("11");
    }

    public void setClick()
    {
        gotoChooseP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent _1 = new Intent(MainActivity.this, Information.class);
                /*Bundle side = new Bundle();

                _1.putExtras(side);*/
                startActivity(_1);
            }
        });

        gotoChooseHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent _1 = new Intent(MainActivity.this, ChooseHard.class);
                startActivity(_1);
            }
        });

        gotoExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                finishAffinity();
            }
        });
    }

}