package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseA extends AppCompatActivity {

    private Button gotoChoosePorA,gotoA;
    private Spinner ChooseSpinner;
    private int choose;
    private int sPos,sInfo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choosealgorithm);

        init();
        dataSet();
        setClick();

    }

    public void init()
    {
        gotoChoosePorA = (Button) findViewById(R.id.button6);
        ChooseSpinner = (Spinner) findViewById(R.id.spinner);
        gotoA = (Button) findViewById(R.id.button7);

        sPos = 0;

        Bundle bd = getIntent().getExtras();
        if(bd!=null)
        {
            choose = bd.getInt("Choose");
        }

    }

    public void dataSet()
    {
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.PProblem_array, android.R.layout.simple_spinner_item);;
        switch (choose)
        {
            case 1:
                adapter = ArrayAdapter.createFromResource(this, R.array.PProblem_array, android.R.layout.simple_spinner_item);
                break;
            case 2:
                adapter = ArrayAdapter.createFromResource(this, R.array.NPHARDproblem_array, android.R.layout.simple_spinner_item);
                break;
            case 3:
                adapter = ArrayAdapter.createFromResource(this, R.array.NPCOMproblem_array, android.R.layout.simple_spinner_item);
                break;
            case 4:
                adapter = ArrayAdapter.createFromResource(this, R.array.INTRACTABLEProblem_array, android.R.layout.simple_spinner_item);
                break;
            case 5:
                adapter = ArrayAdapter.createFromResource(this, R.array.UnsolvedProblem_array, android.R.layout.simple_spinner_item);
                break;
        }

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ChooseSpinner.setAdapter(adapter);
        ChooseSpinner.setOnItemSelectedListener(spnOnItemSelected);

    }

    public void setClick()
    {
        gotoChoosePorA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent _1 = new Intent(ChooseA.this, ChoosePorA.class);
                Bundle side = new Bundle();

                side.putInt("Choose",choose);

                _1.putExtras(side);
                startActivity(_1);
            }
        });

        gotoA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent _2 = new Intent(ChooseA.this, Asummary.class);
                Bundle side = new Bundle();

                side.putInt("Choose",choose);
                side.putInt("Achoose",sPos);
                _2.putExtras(side);
                startActivity(_2);
            }
        });

    }

    private AdapterView.OnItemSelectedListener spnOnItemSelected
            = new AdapterView.OnItemSelectedListener() {
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            //sPos=String.valueOf(pos);
            sPos = pos;
            //sInfo=parent.getItemAtPosition(pos).toString();

            //String sInfo=parent.getSelectedItem().toString();
            //gotoA.setText("選項"+sPos+":"+sInfo);
        }
        public void onNothingSelected(AdapterView<?> parent) {
            //
        }
    };
}
