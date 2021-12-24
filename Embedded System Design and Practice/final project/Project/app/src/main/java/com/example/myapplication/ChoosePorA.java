package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ChoosePorA extends AppCompatActivity {

    private Button gotoInfor,gotoPsummary,gotoChooseA;
    private int choose;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choosepora);

        init();
        setClick();

        //gotoInfor.setText(""+choose);

    }

    public void init()
    {
        gotoInfor = (Button) findViewById(R.id.button6);
        gotoPsummary = (Button) findViewById(R.id.button3);
        gotoChooseA = (Button) findViewById(R.id.Textview1);

        Bundle bd = getIntent().getExtras();
        if(bd!=null)
        {
            choose = bd.getInt("Choose");
        }
    }

    public void setClick()
    {
        gotoInfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent _1 = new Intent(ChoosePorA.this, Information.class);
                /*Bundle side = new Bundle();

                _1.putExtras(side);*/
                startActivity(_1);
            }
        });

        gotoPsummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent _2 = new Intent(ChoosePorA.this, Psummary.class);
                Bundle side = new Bundle();

                side.putInt("Choose",choose);

                _2.putExtras(side);
                startActivity(_2);
            }
        });

        gotoChooseA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent _3 = new Intent(ChoosePorA.this, ChooseA.class);
                Bundle side = new Bundle();

                side.putInt("Choose",choose);

                _3.putExtras(side);
                startActivity(_3);
            }
        });
    }
}
