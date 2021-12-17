package com.cornez.tapbuttoncounter;

class Counter {
    private int mCount;

    public Counter(){
        mCount = 0;
    }

    public void addCount(){
        mCount++;
    }

    public void subCount() { mCount--; }

    public void initCount(int n) { mCount = n; }

    public void checkCount(int a, int b)
    {
        if (mCount > b) mCount = a;
        else if (mCount < a) mCount = b;
    }

    public Integer getCount() {
        return mCount;
    }

}
