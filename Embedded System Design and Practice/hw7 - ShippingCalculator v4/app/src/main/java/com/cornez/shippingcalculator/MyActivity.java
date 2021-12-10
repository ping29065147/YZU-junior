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
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;
import java.util.ArrayList;
import java.util.*;
import android.widget.AdapterView;
import android.widget.CheckedTextView;
import android.widget.AdapterView.OnItemClickListener;
import android.util.Log;
import android.widget.Toast;



public class MyActivity extends Activity
{
    // EditText
    private EditText height;
    private EditText weight;
    private EditText activity;
    private EditText kneeLen;
    private EditText age;
    private EditText name;

    // Button
    private Button gender;
    private Button input;
    private Button gotoIntro;
    private Button gotoOutput;

    private int isMale = 1;
    private int isInputHeight = 1;

    private ListView LV;
    private List<ToDo_Item> mylist;
    private List<Boolean> listShow;
    private List<String> list;

    private TextView tmp;
    private DBHelper database;

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
        name = (EditText) findViewById(R.id.editTextTextPersonName6);

        kneeLen.setFocusableInTouchMode(false);
        age.setFocusableInTouchMode(false);

        // Button
        gender = (Button) findViewById((R.id.button));
        input = (Button) findViewById((R.id.button4));
        gotoOutput = (Button) findViewById(R.id.button6);
        gotoIntro = (Button) findViewById(R.id.button5);

        LV = (ListView) findViewById(R.id.lv);
        listShow = new ArrayList<Boolean>();
        list = new ArrayList<String>();
        mylist = new ArrayList<ToDo_Item>();

        tmp = (TextView) findViewById(R.id.textView11);


        database = new DBHelper(this);
        ArrayList<ToDo_Item> taskList = database.getAllTaskItems();

        for (ToDo_Item task : taskList)
        {
            mylist.add(task);
            listShow.add(false);
        }

        ListAdapter adapterItem = new ListAdapter(this, mylist);
        LV.setAdapter(adapterItem);


        LV.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                CheckedTextView chkItem = (CheckedTextView) v.findViewById(R.id.check1);
                chkItem.setChecked(!chkItem.isChecked());
                listShow.set(position, chkItem.isChecked());
            }
        });


        kneeLen.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if (!kneeLen.getText().toString().isEmpty() && !age.getText().toString().isEmpty()) {
                    double h;
                    double NL = Double.parseDouble(kneeLen.getText().toString());
                    double A = Double.parseDouble(age.getText().toString());
                    if (isMale == 1) h = 85.1 + (1.73 * NL) - (0.11 * A);
                    else h = 91.45 + (1.53 * NL) - (0.16 * A);
                    h = Math.round(h*10.0)/10.0;
                    height.setFocusableInTouchMode(true);
                    height.setText("" + h);
                    height.setFocusableInTouchMode(false);
                }
            }
        });

        age.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if (!kneeLen.getText().toString().isEmpty() && !age.getText().toString().isEmpty()) {
                    double h;
                    double NL = Double.parseDouble(kneeLen.getText().toString());
                    double A = Double.parseDouble(age.getText().toString());
                    if (isMale == 1) h = 85.1 + (1.73 * NL) - (0.11 * A);
                    else h = 91.45 + (1.53 * NL) - (0.16 * A);
                    h = Math.round(h*10.0)/10.0;
                    height.setFocusableInTouchMode(true);
                    height.setText("" + h);
                    height.setFocusableInTouchMode(false);
                }
            }
        });

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
                double tmp_d = bd.getDouble("height");
                if (tmp_d == 0) height.setText("");
                else height.setText("" + tmp_d);
                kneeLen.setFocusableInTouchMode(false);
                age.setFocusableInTouchMode(false);
                height.setFocusableInTouchMode(true);
            }
            else
            {
                input.setText("估算身高");
                double tmp_k = bd.getDouble("kneeLen");
                if (tmp_k == 0) kneeLen.setText("");
                else kneeLen.setText("" + tmp_k);
                int tmp_ag = bd.getInt("age");
                if (tmp_ag == 0) age.setText("");
                else age.setText("" + tmp_ag);
                kneeLen.setFocusableInTouchMode(true);
                age.setFocusableInTouchMode(true);
                height.setFocusableInTouchMode(false);
            }

            double tmp_w = bd.getDouble("weight");
            if (tmp_w == 0) weight.setText("");
            else weight.setText("" + tmp_w);

            int tmp_a = bd.getInt("activity");
            if (tmp_a == 0) activity.setText("");
            else activity.setText("" + tmp_a);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) return true;
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

    public void add(View view)
    {
        String str = name.getText().toString();

        if (str.isEmpty()) Toast.makeText(this, "Need to input a name!", Toast.LENGTH_SHORT).show();
        else
        {
            for (ToDo_Item i : mylist) if (str.equals(i.getName())) return;

            int newID = 1;
            if (!mylist.isEmpty()) newID = mylist.get(mylist.size() - 1).getId() + 1;

            //ToDo_Item tmp = new ToDo_Item(newID, str, 1);

            ToDo_Item tmp = new ToDo_Item(newID, str, isMale, isInputHeight);

            if (height.getText().toString().isEmpty()) tmp.setHeight(0);
            else tmp.setHeight(Double.parseDouble(height.getText().toString()));

            if (weight.getText().toString().isEmpty()) tmp.setWeight(0);
            else tmp.setWeight(Double.parseDouble(weight.getText().toString()));

            if (activity.getText().toString().isEmpty()) tmp.setActivity(0);
            else tmp.setActivity(Integer.parseInt(activity.getText().toString()));

            if (kneeLen.getText().toString().isEmpty()) tmp.setKneeLen(0);
            else tmp.setKneeLen(Double.parseDouble(kneeLen.getText().toString()));

            if (age.getText().toString().isEmpty()) tmp.setAge(0);
            else tmp.setAge(Integer.parseInt(age.getText().toString()));

            mylist.add(tmp);
            listShow.add(false);
            database.addToDoItem(tmp);

            ListAdapter adapterItem = new ListAdapter(this, mylist);
            LV.setAdapter(adapterItem);
        }

        /*String taskItemList = "\n";
        ArrayList<ToDo_Item> taskList = database.getAllTaskItems();
        for (ToDo_Item task : taskList)
        {
            taskItemList += task.getDescription() + "\t" + task.getIs_done();
        }
        ListAdapter adapterItem = new ListAdapter(this, mylist);
        LV.setAdapter(adapterItem);
        tmp.setText(taskItemList);*/
    }

    public void load(View view)
    {
        String str = name.getText().toString();
        int cnt = 0;
        int index = 0;

        for (int i = 0; i < listShow.size(); ++i) if(listShow.get(i) == true)
        {
            ++cnt;
            index = i;
        }
        if (cnt != 1)
        {
            Toast.makeText(this, "Could not checked more than 1 object!", Toast.LENGTH_SHORT).show();
            return;
        }

        ToDo_Item l = mylist.get(index);

        name.setText(l.getName());

        isMale = l.getGender();
        if (isMale == 0) gender.setText("女性");
        else gender.setText("男性");

        double tmp_w = l.getWeight();
        if (tmp_w == 0) weight.setText("");
        else weight.setText("" + tmp_w);

        int tmp_a = l.getActivity();
        if (tmp_a == 0) activity.setText("");
        else activity.setText("" + tmp_a);

        isInputHeight = l.getIsinput();

        if (isInputHeight == 1)
        {
            input.setText("自行輸入");

            kneeLen.setFocusableInTouchMode(false);
            age.setFocusableInTouchMode(false);
            height.setFocusableInTouchMode(true);

            kneeLen.getText().clear();
            age.getText().clear();
            double tmp_d = l.getHeight();
            if (tmp_d == 0) height.setText("");
            else height.setText("" + tmp_d);
        }
        else
        {
            input.setText("估算身高");

            kneeLen.setFocusableInTouchMode(true);
            age.setFocusableInTouchMode(true);
            height.setFocusableInTouchMode(false);

            height.getText().clear();
            double tmp_k = l.getKneeLen();
            if (tmp_k == 0) kneeLen.setText("");
            else kneeLen.setText("" + tmp_k);
            int tmp_ag = l.getAge();
            if (tmp_ag == 0) age.setText("");
            else age.setText("" + tmp_ag);
        }
    }

    public void delete(View view)
    {
        int cnt = 0;

        for (int i = 0; i < listShow.size(); ++i)
        {
            if(listShow.get(i) == true)
            {
                database.deleteTaskItem(mylist.get(i));
                mylist.remove(i);
                listShow.remove(i);
                --i;
                ++cnt;
            }
        }

        if (cnt == 0)
        {
            Toast.makeText(this, "Could not delete object without checking!", Toast.LENGTH_SHORT).show();
            return;
        }

        ListAdapter adapterItem = new ListAdapter(this, mylist);
        LV.setAdapter(adapterItem);
    }
}
