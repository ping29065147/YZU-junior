package com.example.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Asummary extends AppCompatActivity {

    private Button gotoChooseA;
    private int choose,Achoose;
    private TextView Algorithm,AlgorithmSummary;
    private String[] nowAlgorithm,nowAlgorithmSummary;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.algorithmsummary);

        init();
        setClick();
        dataset();

    }

    public void init()
    {
        gotoChooseA = (Button) findViewById(R.id.button6);
        gotoChooseA.setBackgroundColor(gotoChooseA.getContext().getResources().getColor(R.color.beige));
        Algorithm = (TextView) findViewById(R.id.textView5);
        AlgorithmSummary = (TextView) findViewById(R.id.textView3);

        Bundle bd = getIntent().getExtras();
        if(bd!=null)
        {
            choose = bd.getInt("Choose");
            Achoose = bd.getInt("Achoose");
        }
    }

    public void setClick()
    {
        gotoChooseA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent _1 = new Intent(Asummary.this, ChooseA.class);

                Bundle side = new Bundle();

                side.putInt("Choose",choose);
                side.putInt("Achoose",Achoose);

                _1.putExtras(side);

                startActivity(_1);
            }
        });
    }

    public void dataset()
    {
        switch (choose)
        {
            case 1:
                nowAlgorithm = getResources().getStringArray(R.array.PProblem_array);
                nowAlgorithmSummary = getResources().getStringArray(R.array.PProblemSummary_array);
                break;
            case 2:
                nowAlgorithm = getResources().getStringArray(R.array.NPHARDproblem_array);
                nowAlgorithmSummary = getResources().getStringArray(R.array.NPHARDproblemSummary_array);
                break;
            case 3:
                nowAlgorithm = getResources().getStringArray(R.array.NPCOMproblem_array);
                nowAlgorithmSummary = getResources().getStringArray(R.array.NPCOMproblemSummary_array);
                break;
            case 4:
                nowAlgorithm = getResources().getStringArray(R.array.INTRACTABLEProblem_array);
                nowAlgorithmSummary = getResources().getStringArray(R.array.INTRACTABLEProblemSummary_array);
                break;
            case 5:
                nowAlgorithm = getResources().getStringArray(R.array.UnsolvedProblem_array);
                nowAlgorithmSummary = getResources().getStringArray(R.array.UnsolvedProblemSummary_array);
                break;
        }

        Algorithm.setText(nowAlgorithm[Achoose]);
        AlgorithmSummary.setText(nowAlgorithmSummary[Achoose]);

        Typeface mtypeface=Typeface.createFromAsset(getAssets(),"LiberationSerif-Regular.ttf");
        AlgorithmSummary.setTypeface(mtypeface);
        Algorithm.setTypeface(mtypeface);
    }
}
