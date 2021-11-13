package com.cornez.shippingcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;


public class MyActivity extends Activity
{
    // EditText
    private EditText height;
    private EditText weight;
    private EditText activity;
    private EditText kneeLen;
    private EditText age;

    // Button
    private Button gender;
    private Button input;
    private Button gotoIntro;
    private Button gotoOutput;

    private int isMale = 1;
    private int isInputHeight = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_2);

        // EditText
        height = (EditText) findViewById(R.id.editTextTextPersonName);
        weight = (EditText) findViewById(R.id.editTextTextPersonName2);
        activity = (EditText) findViewById(R.id.editTextTextPersonName3);
        kneeLen = (EditText) findViewById(R.id.editTextTextPersonName5);
        age = (EditText) findViewById(R.id.editTextTextPersonName4);

        kneeLen.setFocusableInTouchMode(false);
        age.setFocusableInTouchMode(false);

        // Button
        gender = (Button) findViewById((R.id.button));
        input = (Button) findViewById((R.id.button4));
        gotoOutput = (Button) findViewById(R.id.button6);
        gotoIntro = (Button) findViewById(R.id.button5);

        gotoOutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent output1 = new Intent(MyActivity.this, output.class);
                Bundle side = new Bundle();

                if (height.getText().toString().isEmpty()) side.putDouble("height", 0);
                else side.putDouble("height", Double.parseDouble(height.getText().toString()));

                if (weight.getText().toString().isEmpty()) side.putDouble("weight", 0);
                else side.putDouble("weight", Double.parseDouble(weight.getText().toString()));

                if (activity.getText().toString().isEmpty()) side.putInt("activity", 0);
                else side.putInt("activity", Integer.parseInt(activity.getText().toString()));

                if (kneeLen.getText().toString().isEmpty()) side.putDouble("kneeLen", 0);
                else side.putDouble("kneeLen", Double.parseDouble(kneeLen.getText().toString()));

                if (age.getText().toString().isEmpty()) side.putInt("age", 0);
                else side.putInt("age", Integer.parseInt(age.getText().toString()));

                side.putInt("app", 1);
                side.putInt("isMale", isMale);
                side.putInt("isInputHeight", isInputHeight);

                output1.putExtras(side);
                startActivity(output1);
            }
        });

        gotoIntro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                Intent intro1 = new Intent(MyActivity.this, intro.class);
                Bundle side = new Bundle();

                if (height.getText().toString().isEmpty()) side.putDouble("height", 0);
                else side.putDouble("height", Double.parseDouble(height.getText().toString()));

                if (weight.getText().toString().isEmpty()) side.putDouble("weight", 0);
                else side.putDouble("weight", Double.parseDouble(weight.getText().toString()));

                if (activity.getText().toString().isEmpty()) side.putInt("activity", 0);
                else side.putInt("activity", Integer.parseInt(activity.getText().toString()));

                if (kneeLen.getText().toString().isEmpty()) side.putDouble("kneeLen", 0);
                else side.putDouble("kneeLen", Double.parseDouble(kneeLen.getText().toString()));

                if (age.getText().toString().isEmpty()) side.putInt("age", 0);
                else side.putInt("age", Integer.parseInt(age.getText().toString()));

                side.putInt("app", 1);
                side.putInt("isMale", isMale);
                side.putInt("isInputHeight", isInputHeight);

                intro1.putExtras(side);
                startActivity(intro1);
            }
        });
    }

    @Override
    protected void onStart()
    {
        super.onStart();

        if (getIntent().getBooleanExtra("EXIT", false)) finishAffinity();

        Bundle bd = getIntent().getExtras();
        if (bd != null)
        {
            if (bd.getInt("app") == 3) overridePendingTransition(R.anim.atob, R.anim.btoa);
            else overridePendingTransition(R.anim.btoc, R.anim.ctob);

            isInputHeight = bd.getInt("isInputHeight");
            isMale = bd.getInt("isMale");

            if (isMale == 0) gender.setText("女性");
            else gender.setText("男性");
            if (isInputHeight == 1)
            {
                input.setText("自行輸入");
                height.setText("" + bd.getDouble("height"));
                kneeLen.setFocusableInTouchMode(false);
                age.setFocusableInTouchMode(false);
                height.setFocusableInTouchMode(true);
            }
            else
            {
                input.setText("估算身高");
                kneeLen.setText("" + bd.getDouble("kneeLen"));
                age.setText("" + bd.getInt("age"));
                kneeLen.setFocusableInTouchMode(true);
                age.setFocusableInTouchMode(true);
                height.setFocusableInTouchMode(false);
            }
            weight.setText("" + bd.getDouble("weight"));
            activity.setText("" + bd.getInt("activity"));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void gender(View view)
    {
        isMale ^= 1;
        if (isMale == 0) gender.setText("女性");
        else gender.setText("男性");
    }

    public void reset(View view)
    {
        gender.setText("男性");
        input.setText("自行輸入");

        height.getText().clear();
        weight.getText().clear();
        activity.getText().clear();
        kneeLen.getText().clear();
        age.getText().clear();

        isMale = 1;
        isInputHeight = 1;

        kneeLen.setFocusableInTouchMode(false);
        age.setFocusableInTouchMode(false);
        height.setFocusableInTouchMode(true);
    }

    public void input(View view)
    {
        isInputHeight ^= 1;

        if (isInputHeight == 1)
        {
            input.setText("自行輸入");

            kneeLen.setFocusableInTouchMode(false);
            age.setFocusableInTouchMode(false);
            height.setFocusableInTouchMode(true);

            kneeLen.getText().clear();
            age.getText().clear();
        }
        else
        {
            input.setText("估算身高");

            kneeLen.setFocusableInTouchMode(true);
            age.setFocusableInTouchMode(true);
            height.setFocusableInTouchMode(false);

            height.getText().clear();
        }
    }
}
