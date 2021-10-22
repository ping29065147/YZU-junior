package com.cornez.tapbuttoncounter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    private double c1 = -8.78469475556;
    private double c2 = 1.61139411;
    private double c3 = 2.33854883889;
    private double c4 = -0.14611605;
    private double c5 = -0.012308094;
    private double c6 = -0.0164248277778;
    private double c7 = 0.002211732;
    private double c8 = 0.00072546;
    private double c9 = -0.000003582;

    //MODEL
    private Counter count;
    private Counter cnt1;
    private Counter cnt2;

    //VIEW
    private TextView display;
    private TextView display2;
    private TextView display3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        count = new Counter();
        cnt1 = new Counter();
        cnt2 = new Counter();
        cnt1.initCount(28);
        cnt2.initCount(50);

        display = (TextView) findViewById(R.id.textView);
        display2 = (TextView) findViewById(R.id.textView3);
        display3 = (TextView) findViewById(R.id.textView5);
    }

    public void countTap(View view){
        count.addCount();
        display.setText(count.getCount().toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu;
        // this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btn1(View view) {
        cnt1.addCount();
        cnt1.checkCount(15, 50);
        display.setText(cnt1.getCount().toString());
    }

    public void bnt2(View view) {
        cnt1.subCount();
        cnt1.checkCount(15, 50);
        display.setText(cnt1.getCount().toString());
    }

    public void btn3(View view) {
        cnt2.addCount();
        cnt2.checkCount(40, 90);
        display2.setText(cnt2.getCount().toString());
    }

    public void btn4(View view) {
        cnt2.subCount();
        cnt2.checkCount(40, 90);
        display2.setText(cnt2.getCount().toString());
    }

    public void cmp(View view) {
        int T = cnt1.getCount();
        int R = cnt2.getCount();
        Double HI = c1 + c2*T + c3*R + c4*T*R + c5*T*T + c6*R*R + c7*T*T*R + c8*T*R*R + c9*T*T*R*R;
        HI = Math.round(HI*10.0)/10.0;
        display3.setText("HI : " + HI);
    }

    public void reset(View view) {
        cnt1.initCount(28);
        cnt2.initCount(50);
        display.setText(cnt1.getCount().toString());
        display2.setText(cnt2.getCount().toString());
        display3.setText("");
    }
}
